package com.group13.roombookingsystem.service;

import com.group13.roombookingsystem.model.booking.Booking;
import com.group13.roombookingsystem.model.payment.PaymentStrategy;
import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.repository.BookingRepository;
import com.group13.roombookingsystem.service.observer.Observer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    private BookingRepository bookingRepository;
    private BookingService bookingService;
    private TestObserver observer;

    @BeforeEach
    void setUp() throws Exception {
        bookingRepository = mock(BookingRepository.class);
        bookingService = instantiateService();
        observer = new TestObserver();
        bookingService.subscribe(observer);
    }

    @AfterEach
    void resetSingleton() throws Exception {
        Field instanceField = BookingService.class.getDeclaredField("instance");
        instanceField.setAccessible(true);
        instanceField.set(null, null);
    }

    @Test
    void getInstanceReturnsSingleton() throws Exception {
        resetSingleton();
        BookingService first = BookingService.getInstance();
        BookingService second = BookingService.getInstance();
        assertSame(first, second);
    }

    @Test
    void createBookingAddsBookingAndNotifies() throws SQLException, ReflectiveOperationException {
        User user = buildUser(1);
        Room room = buildRoom(10);
        LocalDate date = LocalDate.now().plusDays(1);
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(11, 0);
        PaymentStrategy paymentStrategy = mock(PaymentStrategy.class);

        when(bookingRepository.create(any(Booking.class))).thenAnswer(invocation -> {
            Booking booking = invocation.getArgument(0);
            booking.setBookingId(100);
            return booking;
        });

        Booking booking = bookingService.createBooking(user, room, date, start, end, paymentStrategy);

        assertEquals(1, user.getBookings().size());
        assertEquals(1, getBookingsList().size());
        assertEquals(user, booking.getBooker());
        assertEquals(room, booking.getRoomBooked());
        assertEquals(1, observer.notifications);
        verify(bookingRepository).create(booking);
    }

    @Test
    void modifyBookingUpdatesFieldsAndPersistsWhenIdPresent() {
        Booking booking = new Booking(1, 2, LocalDate.now().plusDays(1), LocalTime.of(10, 0), LocalTime.of(12, 0));
        booking.setBookingId(77);
        LocalDate newDate = booking.getBookingDate().plusDays(1);
        LocalTime newStart = booking.getStartTime().minusHours(1);
        LocalTime newEnd = booking.getEndTime().plusHours(1);

        when(bookingRepository.updateTimes(eq(booking.getBookingID()), eq(newDate), eq(newStart), eq(newEnd)))
                .thenReturn(booking);

        Booking updated = bookingService.modifyBooking(booking, newDate, newStart, newEnd);

        assertEquals(newDate, updated.getBookingDate());
        assertEquals(newStart, updated.getStartTime());
        assertEquals(newEnd, updated.getEndTime());
        verify(bookingRepository).updateTimes(booking.getBookingID(), newDate, newStart, newEnd);
        assertEquals(1, observer.notifications);
    }

    @Test
    void modifyBookingSkipsRepositoryForTransientBooking() {
        Booking booking = new Booking(1, 2, LocalDate.now().plusDays(1), LocalTime.of(10, 0), LocalTime.of(12, 0));
        LocalDate newDate = booking.getBookingDate().plusDays(1);
        LocalTime newStart = booking.getStartTime().minusHours(1);

        bookingService.modifyBooking(booking, newDate, newStart, null);

        assertEquals(newDate, booking.getBookingDate());
        assertEquals(newStart, booking.getStartTime());
        verify(bookingRepository, never()).updateTimes(anyInt(), any(), any(), any());
        assertEquals(1, observer.notifications);
    }

    @Test
    void extendBookingUpdatesEndTimeAndPersistsWhenIdExists() {
        Booking booking = new Booking(1, 2, LocalDate.now().plusDays(2), LocalTime.of(9, 0), LocalTime.of(10, 0));
        booking.setBookingId(50);
        LocalTime newEnd = LocalTime.of(11, 0);

        when(bookingRepository.updateTimes(
                booking.getBookingID(),
                booking.getBookingDate(),
                booking.getStartTime(),
                newEnd)).thenReturn(booking);

        Booking result = bookingService.extendBooking(booking, newEnd);

        assertEquals(newEnd, result.getEndTime());
        verify(bookingRepository).updateTimes(booking.getBookingID(), booking.getBookingDate(), booking.getStartTime(), newEnd);
        assertEquals(1, observer.notifications);
    }

    @Test
    void extendBookingSkipsRepositoryWhenBookingIsTransient() {
        Booking booking = new Booking(1, 2, LocalDate.now().plusDays(2), LocalTime.of(9, 0), LocalTime.of(10, 0));
        LocalTime newEnd = LocalTime.of(11, 0);

        bookingService.extendBooking(booking, newEnd);

        assertEquals(newEnd, booking.getEndTime());
        verify(bookingRepository, never()).updateTimes(anyInt(), any(), any(), any());
        assertEquals(1, observer.notifications);
    }

    @Test
    void getBookingsForDelegatesToRepository() {
        User user = buildUser(5);
        List<Booking> expected = List.of(new Booking(user.getId(), 10, LocalDate.now().plusDays(1),
                LocalTime.of(10, 0), LocalTime.of(11, 0)));
        when(bookingRepository.findByUser(user.getId())).thenReturn(expected);

        List<Booking> bookings = bookingService.getBookingsFor(user);

        assertEquals(expected, bookings);
        verify(bookingRepository).findByUser(user.getId());
    }

    @Test
    void cancelBookingRemovesBookingFromUserAndCache() throws ReflectiveOperationException {
        User user = buildUser(3);
        Booking booking = new Booking(user.getId(), 1, LocalDate.now().plusDays(1), LocalTime.of(8, 0), LocalTime.of(9, 0));
        booking.setBooker(user);
        user.addBooking(booking);
        List<Booking> cache = getBookingsList();
        cache.add(booking);

        bookingService.cancelBooking(booking);

        assertTrue(user.getBookings().isEmpty());
        assertTrue(cache.isEmpty());
        assertEquals(1, observer.notifications);
        verifyNoInteractions(bookingRepository);
    }

    @Test
    void cancelBookingHandlesNullBooker() {
        Booking booking = new Booking(1, 2, LocalDate.now().plusDays(1), LocalTime.of(10, 0), LocalTime.of(11, 0));

        bookingService.cancelBooking(booking);

        assertEquals(1, observer.notifications);
    }

    private BookingService instantiateService() throws Exception {
        Constructor<BookingService> constructor = BookingService.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BookingService service = constructor.newInstance();
        setField(service, "bookingRepository", bookingRepository);
        setField(service, "bookings", new ArrayList<>());
        return service;
    }

    private void setField(BookingService target, String fieldName, Object value) throws Exception {
        Field field = BookingService.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    @SuppressWarnings("unchecked")
    private List<Booking> getBookingsList() throws ReflectiveOperationException {
        Field field = BookingService.class.getDeclaredField("bookings");
        field.setAccessible(true);
        return (List<Booking>) field.get(bookingService);
    }

    private User buildUser(int id) {
        User user = new User("user" + id + "@example.com", "pwd", id, "USER", true);
        user.setId(id);
        return user;
    }

    private Room buildRoom(int id) {
        Room room = new Room();
        room.setRoomId(id);
        return room;
    }

    private static final class TestObserver implements Observer {
        private int notifications;

        @Override
        public void onUpdate() {
            notifications++;
        }
    }
}


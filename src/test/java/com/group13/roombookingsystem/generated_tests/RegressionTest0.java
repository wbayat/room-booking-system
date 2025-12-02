package com.group13.roombookingsystem.generated_tests;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    public void assertBooleanArrayEquals(boolean[] expectedArray, boolean[] actualArray) {
        if (expectedArray.length != actualArray.length) {
            throw new AssertionError("Array lengths differ: " + expectedArray.length + " != " + actualArray.length);
        }
        for (int i = 0; i < expectedArray.length; i++) {
            if (expectedArray[i] != actualArray[i]) {
                throw new AssertionError("Arrays differ at index " + i + ": " + expectedArray[i] + " != " + actualArray[i]);
            }
        }
    }

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test001");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        java.time.LocalDate localDate6 = null;
        java.time.LocalTime localTime7 = null;
        java.time.LocalTime localTime8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = booking5.overlaps(localDate6, localTime7, localTime8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.equals(Object)\" because \"this.bookingDate\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        boolean boolean10 = booking5.hasCheckedIn();
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        int int9 = booking5.getUserId();
        java.lang.Class<?> wildcardClass10 = booking5.getClass();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        booking6.setBookingId((int) (short) 100);
        java.time.LocalDate localDate9 = null;
        java.time.LocalTime localTime10 = null;
        java.time.LocalTime localTime11 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean12 = booking6.overlaps(localDate9, localTime10, localTime11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.equals(Object)\" because \"this.bookingDate\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        booking5.setDepositAmount(35);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        java.time.LocalDate localDate10 = null;
        java.time.LocalTime localTime11 = null;
        java.time.LocalTime localTime12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = booking5.overlaps(localDate10, localTime11, localTime12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.equals(Object)\" because \"this.bookingDate\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getBookingID();
        java.time.LocalDate localDate9 = null;
        java.time.LocalTime localTime10 = null;
        java.time.LocalTime localTime11 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean12 = booking5.overlaps(localDate9, localTime10, localTime11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.equals(Object)\" because \"this.bookingDate\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.room.Room room6 = booking5.getRoomBooked();
        boolean boolean7 = booking5.hasCheckedIn();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy8 = null;
        booking5.setPaymentStrategy(paymentStrategy8);
        org.junit.Assert.assertNull(room6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getUserId();
        booking5.setBookingId((int) (short) 10);
        int int15 = booking5.getDepositAmount();
        int int16 = booking5.getDepositAmount();
        java.lang.Class<?> wildcardClass17 = booking5.getClass();
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 0 + "'", int16 == 0);
        org.junit.Assert.assertNotNull(wildcardClass17);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        java.lang.Object obj0 = new java.lang.Object();
        java.lang.Class<?> wildcardClass1 = obj0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        int int9 = booking5.getUserId();
        com.group13.roombookingsystem.model.room.Room room10 = booking5.getRoomBooked();
        com.group13.roombookingsystem.model.room.Room room11 = null;
        booking5.setRoomBooked(room11);
        com.group13.roombookingsystem.model.room.Room room13 = null;
        booking5.setRoomBooked(room13);
        booking5.setBookingId((int) (short) 100);
        booking5.setId((java.lang.Integer) (-1));
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
        org.junit.Assert.assertNull(room10);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(10, (int) (short) 10, localDate2, localTime3, localTime4);
        booking5.setDepositAmount((int) (byte) -1);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        booking5.setBookingId(1);
        java.time.LocalDate localDate10 = null;
        booking5.setDate(localDate10);
        java.time.LocalDate localDate12 = null;
        java.time.LocalTime localTime13 = null;
        java.time.LocalTime localTime14 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean15 = booking5.overlaps(localDate12, localTime13, localTime14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.equals(Object)\" because \"this.bookingDate\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        java.lang.String str7 = booking6.toString();
        java.lang.Class<?> wildcardClass8 = booking6.getClass();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Booking{id=1, bookerId=0, roomId=0, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str7, "Booking{id=1, bookerId=0, roomId=0, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        booking6.setBookingId((int) (short) 100);
        java.lang.Integer int9 = booking6.getId();
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 100 + "'", int9 == 100);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        int int9 = booking5.getUserId();
        com.group13.roombookingsystem.model.room.Room room10 = booking5.getRoomBooked();
        com.group13.roombookingsystem.model.room.Room room11 = null;
        booking5.setRoomBooked(room11);
        java.time.LocalDate localDate13 = null;
        booking5.setBookingDate(localDate13);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
        org.junit.Assert.assertNull(room10);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        java.time.LocalTime localTime9 = booking5.getStartTime();
        java.time.LocalDate localDate10 = null;
        booking5.setDate(localDate10);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertNull(localTime9);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        java.time.LocalTime localTime9 = booking5.getStartTime();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Class<?> wildcardClass10 = localTime9.getClass();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"Object.getClass()\" because \"o\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertNull(localTime9);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) 'a', 1, localDate2, localTime3, localTime4);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (short) 0, (int) (short) 0, localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        java.time.LocalTime localTime8 = null;
        booking5.setStartTime(localTime8);
        java.lang.Class<?> wildcardClass10 = booking5.getClass();
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        java.time.LocalTime localTime9 = booking5.getStartTime();
        boolean boolean10 = booking5.hasCheckedIn();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertNull(localTime9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        booking5.setBookingId((int) '#');
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getRoomId();
        java.lang.Class<?> wildcardClass13 = booking5.getClass();
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 35 + "'", int12 == 35);
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        booking5.checkIn();
        com.group13.roombookingsystem.model.room.Room room9 = null;
        booking5.setRoomBooked(room9);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, (int) (short) 0, (int) (byte) 1, localDate3, localTime4, localTime5);
        java.time.LocalDate localDate7 = null;
        booking6.setBookingDate(localDate7);
        java.time.LocalTime localTime9 = null;
        booking6.setEndTime(localTime9);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        java.time.LocalTime localTime9 = booking5.getStartTime();
        boolean boolean11 = booking5.pay((double) 0);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertNull(localTime9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        java.time.LocalDate localDate12 = null;
        booking5.setDate(localDate12);
        com.group13.roombookingsystem.model.user.User user14 = null;
        booking5.setBooker(user14);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy7 = null;
        booking6.setPaymentStrategy(paymentStrategy7);
        com.group13.roombookingsystem.model.room.Room room9 = null;
        booking6.setRoomBooked(room9);
        int int11 = booking6.getUserId();
        int int12 = booking6.getUserId();
        java.time.LocalTime localTime13 = booking6.getStartTime();
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNull(localTime13);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy7 = null;
        booking6.setPaymentStrategy(paymentStrategy7);
        com.group13.roombookingsystem.model.room.Room room9 = null;
        booking6.setRoomBooked(room9);
        java.time.LocalTime localTime11 = null;
        booking6.setEndTime(localTime11);
        java.time.LocalDate localDate13 = booking6.getBookingDate();
        booking6.setBookingId((int) ' ');
        org.junit.Assert.assertNull(localDate13);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        com.group13.roombookingsystem.model.user.User user9 = booking5.getBooker();
        com.group13.roombookingsystem.model.user.User user10 = null;
        booking5.setBooker(user10);
        boolean boolean13 = booking5.pay((double) 'a');
        int int14 = booking5.getDepositAmount();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNull(user9);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.room.Room room6 = booking5.getRoomBooked();
        boolean boolean7 = booking5.hasCheckedIn();
        com.group13.roombookingsystem.model.user.User user8 = booking5.getBooker();
        org.junit.Assert.assertNull(room6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(user8);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        java.time.LocalDate localDate12 = null;
        booking5.setDate(localDate12);
        boolean boolean15 = booking5.pay((double) 'a');
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        booking5.setDepositAmount(0);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        java.time.LocalDate localDate12 = null;
        booking5.setBookingDate(localDate12);
        int int14 = booking5.getBookingID();
        java.time.LocalDate localDate15 = booking5.getBookingDate();
        java.time.LocalDate localDate16 = null;
        booking5.setBookingDate(localDate16);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + (-1) + "'", int14 == (-1));
        org.junit.Assert.assertNull(localDate15);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        java.time.LocalDate localDate9 = null;
        booking5.setDate(localDate9);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        booking5.setDepositAmount((int) (short) 0);
        java.time.LocalDate localDate8 = null;
        booking5.setBookingDate(localDate8);
        booking5.setDepositAmount(1);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (short) 1, (int) '#', localDate2, localTime3, localTime4);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (short) 0, (int) (short) 0, localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy8 = booking5.getPaymentStrategy();
        int int9 = booking5.getDepositAmount();
        org.junit.Assert.assertNull(paymentStrategy8);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getUserId();
        booking5.setBookingId((int) (short) 10);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy15 = booking5.getPaymentStrategy();
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertNull(paymentStrategy15);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        java.time.LocalTime localTime9 = booking5.getStartTime();
        int int10 = booking5.getDepositAmount();
        com.group13.roombookingsystem.model.user.User user11 = null;
        booking5.setBooker(user11);
        java.time.LocalTime localTime13 = null;
        booking5.setEndTime(localTime13);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertNull(localTime9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) (-1), (int) (short) 10, 10, localDate3, localTime4, localTime5);
        int int7 = booking6.getRoomId();
        int int8 = booking6.getBookingID();
        java.lang.String str9 = booking6.toString();
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 10 + "'", int7 == 10);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Booking{id=-1, bookerId=10, roomId=10, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str9, "Booking{id=-1, bookerId=10, roomId=10, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        booking5.setBookingId(1);
        java.time.LocalDate localDate10 = null;
        booking5.setDate(localDate10);
        java.time.LocalDate localDate15 = null;
        java.time.LocalTime localTime16 = null;
        java.time.LocalTime localTime17 = null;
        com.group13.roombookingsystem.model.booking.Booking booking18 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) (-1), (int) (short) 100, (int) (short) 1, localDate15, localTime16, localTime17);
        boolean boolean19 = booking5.equals((java.lang.Object) (short) 100);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        booking5.setBookingId(35);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, (int) (short) 0, (int) (byte) 1, localDate3, localTime4, localTime5);
        java.time.LocalDate localDate7 = null;
        booking6.setBookingDate(localDate7);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy9 = null;
        booking6.setPaymentStrategy(paymentStrategy9);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) 10, (int) (short) -1, localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.room.Room room6 = booking5.getRoomBooked();
        org.junit.Assert.assertNull(room6);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, (int) (short) 0, (int) (byte) 1, localDate3, localTime4, localTime5);
        java.time.LocalTime localTime7 = booking6.getEndTime();
        java.time.LocalTime localTime8 = booking6.getEndTime();
        org.junit.Assert.assertNull(localTime7);
        org.junit.Assert.assertNull(localTime8);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) 1, (int) 'a', localDate2, localTime3, localTime4);
        java.time.LocalDate localDate6 = null;
        java.time.LocalTime localTime7 = null;
        java.time.LocalTime localTime8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = booking5.overlaps(localDate6, localTime7, localTime8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.equals(Object)\" because \"this.bookingDate\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        int int9 = booking5.getUserId();
        java.time.LocalTime localTime10 = null;
        booking5.setStartTime(localTime10);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, (int) (short) 0, (int) (byte) 1, localDate3, localTime4, localTime5);
        java.lang.Class<?> wildcardClass7 = booking6.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        java.time.LocalDate localDate11 = null;
        java.time.LocalTime localTime12 = null;
        java.time.LocalTime localTime13 = null;
        com.group13.roombookingsystem.model.booking.Booking booking14 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate11, localTime12, localTime13);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy15 = null;
        booking14.setPaymentStrategy(paymentStrategy15);
        com.group13.roombookingsystem.model.user.User user17 = null;
        booking14.setBooker(user17);
        com.group13.roombookingsystem.model.room.Room room19 = null;
        booking14.setRoomBooked(room19);
        booking14.setDepositAmount((int) (byte) 10);
        boolean boolean23 = booking5.equals((java.lang.Object) (byte) 10);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        booking6.setBookingId((int) (short) 100);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy9 = null;
        booking6.setPaymentStrategy(paymentStrategy9);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        booking6.setBookingId((int) (short) 100);
        booking6.setDepositAmount((int) (byte) 0);
        java.time.LocalDate localDate11 = null;
        java.time.LocalTime localTime12 = null;
        java.time.LocalTime localTime13 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean14 = booking6.overlaps(localDate11, localTime12, localTime13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.equals(Object)\" because \"this.bookingDate\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        booking5.setBookingId((int) '#');
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getRoomId();
        java.time.LocalTime localTime13 = booking5.getStartTime();
        int int14 = booking5.getDepositAmount();
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 35 + "'", int12 == 35);
        org.junit.Assert.assertNull(localTime13);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        com.group13.roombookingsystem.model.user.User user9 = booking5.getBooker();
        java.time.LocalTime localTime10 = null;
        booking5.setEndTime(localTime10);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNull(user9);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        booking5.setBookingId((int) '#');
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setBookingId((int) (byte) 0);
        com.group13.roombookingsystem.model.room.Room room14 = booking5.getRoomBooked();
        org.junit.Assert.assertNull(room14);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        int int7 = booking6.getDepositAmount();
        java.time.LocalDate localDate10 = null;
        java.time.LocalTime localTime11 = null;
        java.time.LocalTime localTime12 = null;
        com.group13.roombookingsystem.model.booking.Booking booking13 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate10, localTime11, localTime12);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy14 = null;
        booking13.setPaymentStrategy(paymentStrategy14);
        int int16 = booking13.getUserId();
        int int17 = booking13.getUserId();
        com.group13.roombookingsystem.model.room.Room room18 = booking13.getRoomBooked();
        com.group13.roombookingsystem.model.room.Room room19 = null;
        booking13.setRoomBooked(room19);
        booking13.setBookingId((int) (short) -1);
        booking13.setDepositAmount(1);
        boolean boolean25 = booking6.equals((java.lang.Object) 1);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + (-1) + "'", int17 == (-1));
        org.junit.Assert.assertNull(room18);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 100, 10, (int) (byte) 100, localDate3, localTime4, localTime5);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getBookingID();
        java.lang.String str9 = booking5.toString();
        java.time.LocalTime localTime10 = booking5.getStartTime();
        java.lang.Integer int11 = booking5.getId();
        java.time.LocalTime localTime12 = booking5.getStartTime();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str9, "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
        org.junit.Assert.assertNull(localTime10);
        org.junit.Assert.assertNull(int11);
        org.junit.Assert.assertNull(localTime12);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) (-1), (int) (short) 100, (int) (short) 1, localDate3, localTime4, localTime5);
        boolean boolean8 = booking6.equals((java.lang.Object) (byte) 1);
        java.time.LocalTime localTime9 = booking6.getEndTime();
        java.lang.Class<?> wildcardClass10 = booking6.getClass();
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNull(localTime9);
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        java.time.LocalTime localTime7 = booking6.getEndTime();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy8 = null;
        booking6.setPaymentStrategy(paymentStrategy8);
        com.group13.roombookingsystem.model.room.Room room10 = booking6.getRoomBooked();
        org.junit.Assert.assertNull(localTime7);
        org.junit.Assert.assertNull(room10);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(35, (int) (byte) 10, localDate2, localTime3, localTime4);
        int int6 = booking5.getDepositAmount();
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy7 = null;
        booking6.setPaymentStrategy(paymentStrategy7);
        com.group13.roombookingsystem.model.room.Room room9 = null;
        booking6.setRoomBooked(room9);
        java.time.LocalTime localTime11 = null;
        booking6.setEndTime(localTime11);
        com.group13.roombookingsystem.model.room.Room room13 = null;
        booking6.setRoomBooked(room13);
        int int15 = booking6.getDepositAmount();
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        booking5.setBookingId(1);
        java.time.LocalDate localDate10 = null;
        booking5.setBookingDate(localDate10);
        java.time.LocalDate localDate12 = booking5.getBookingDate();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy13 = booking5.getPaymentStrategy();
        com.group13.roombookingsystem.model.room.Room room14 = null;
        booking5.setRoomBooked(room14);
        org.junit.Assert.assertNull(localDate12);
        org.junit.Assert.assertNull(paymentStrategy13);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(35, (int) (byte) 10, localDate2, localTime3, localTime4);
        booking5.setId((java.lang.Integer) (-1));
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setDepositAmount((int) (byte) 10);
        java.lang.String str14 = booking5.toString();
        int int15 = booking5.getRoomId();
        int int16 = booking5.getUserId();
        java.time.LocalDate localDate17 = booking5.getDate();
        java.time.LocalTime localTime18 = null;
        booking5.setStartTime(localTime18);
        java.time.LocalTime localTime20 = null;
        booking5.setStartTime(localTime20);
        boolean boolean22 = booking5.hasCheckedIn();
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=10, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str14, "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=10, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 35 + "'", int15 == 35);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
        org.junit.Assert.assertNull(localDate17);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) ' ', (int) (byte) 0, localDate2, localTime3, localTime4);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        booking5.setBookingId(1);
        java.time.LocalDate localDate10 = null;
        booking5.setBookingDate(localDate10);
        java.lang.Integer int12 = booking5.getId();
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 1 + "'", int12 == 1);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        com.group13.roombookingsystem.model.user.User user9 = booking5.getBooker();
        com.group13.roombookingsystem.model.user.User user10 = null;
        booking5.setBooker(user10);
        boolean boolean13 = booking5.pay((double) 'a');
        java.time.LocalDate localDate14 = booking5.getBookingDate();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNull(user9);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNull(localDate14);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        int int9 = booking5.getDepositAmount();
        booking5.setBookingId((int) (byte) -1);
        boolean boolean12 = booking5.hasCheckedIn();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        int int9 = booking5.getUserId();
        com.group13.roombookingsystem.model.room.Room room10 = booking5.getRoomBooked();
        com.group13.roombookingsystem.model.room.Room room11 = null;
        booking5.setRoomBooked(room11);
        booking5.setBookingId((int) (short) -1);
        booking5.setDepositAmount((int) (byte) 10);
        int int17 = booking5.getUserId();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
        org.junit.Assert.assertNull(room10);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + (-1) + "'", int17 == (-1));
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, (int) (byte) 100, (int) (short) 10, localDate3, localTime4, localTime5);
        java.time.LocalDate localDate7 = null;
        booking6.setBookingDate(localDate7);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(100, (int) (byte) 10, localDate2, localTime3, localTime4);
        java.time.LocalTime localTime6 = null;
        booking5.setStartTime(localTime6);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        java.lang.Integer int9 = booking5.getId();
        boolean boolean11 = booking5.equals((java.lang.Object) 10.0d);
        com.group13.roombookingsystem.model.room.Room room12 = null;
        booking5.setRoomBooked(room12);
        java.time.LocalTime localTime14 = booking5.getStartTime();
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertNull(int9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNull(localTime14);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setDepositAmount((int) (byte) 10);
        java.lang.Class<?> wildcardClass14 = booking5.getClass();
        org.junit.Assert.assertNotNull(wildcardClass14);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 100, (int) (short) 0, (int) (short) 0, localDate3, localTime4, localTime5);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getUserId();
        java.lang.Integer int13 = booking5.getId();
        java.time.LocalDate localDate14 = null;
        booking5.setBookingDate(localDate14);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertNull(int13);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        int int7 = booking6.getDepositAmount();
        java.time.LocalTime localTime8 = null;
        booking6.setEndTime(localTime8);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        int int9 = booking5.getDepositAmount();
        booking5.setBookingId((int) (byte) -1);
        booking5.setDepositAmount((int) (byte) 100);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(35, (int) (byte) 10, localDate2, localTime3, localTime4);
        java.time.LocalDate localDate6 = null;
        booking5.setBookingDate(localDate6);
        java.time.LocalDate localDate8 = booking5.getDate();
        java.time.LocalTime localTime9 = booking5.getStartTime();
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertNull(localTime9);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setDepositAmount((int) (byte) 10);
        java.time.LocalDate localDate14 = null;
        booking5.setBookingDate(localDate14);
        com.group13.roombookingsystem.model.user.User user16 = null;
        booking5.setBooker(user16);
        booking5.checkIn();
        int int19 = booking5.getBookingID();
        java.time.LocalTime localTime20 = booking5.getStartTime();
        booking5.checkIn();
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + (-1) + "'", int19 == (-1));
        org.junit.Assert.assertNull(localTime20);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        java.time.LocalTime localTime8 = booking5.getEndTime();
        org.junit.Assert.assertNull(localTime8);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        java.time.LocalDate localDate11 = null;
        java.time.LocalTime localTime12 = null;
        java.time.LocalTime localTime13 = null;
        com.group13.roombookingsystem.model.booking.Booking booking14 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate11, localTime12, localTime13);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy15 = null;
        booking14.setPaymentStrategy(paymentStrategy15);
        int int17 = booking14.getUserId();
        boolean boolean18 = booking5.equals((java.lang.Object) int17);
        boolean boolean20 = booking5.pay((double) 0.0f);
        java.time.LocalDate localDate21 = null;
        booking5.setBookingDate(localDate21);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + (-1) + "'", int17 == (-1));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        int int9 = booking5.getUserId();
        com.group13.roombookingsystem.model.room.Room room10 = booking5.getRoomBooked();
        com.group13.roombookingsystem.model.room.Room room11 = null;
        booking5.setRoomBooked(room11);
        booking5.setBookingId((int) (short) -1);
        booking5.setDepositAmount((int) (byte) 10);
        com.group13.roombookingsystem.model.room.Room room17 = null;
        booking5.setRoomBooked(room17);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
        org.junit.Assert.assertNull(room10);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        java.lang.Integer int9 = booking5.getId();
        boolean boolean11 = booking5.equals((java.lang.Object) 10.0d);
        int int12 = booking5.getBookingID();
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertNull(int9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 10, 35, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.room.Room room7 = null;
        booking6.setRoomBooked(room7);
        com.group13.roombookingsystem.model.user.User user9 = booking6.getBooker();
        org.junit.Assert.assertNull(user9);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getUserId();
        booking5.setBookingId((int) (short) 10);
        java.time.LocalTime localTime15 = null;
        booking5.setStartTime(localTime15);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        java.lang.String str7 = booking6.toString();
        java.time.LocalDate localDate8 = null;
        java.time.LocalTime localTime9 = null;
        java.time.LocalTime localTime10 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean11 = booking6.overlaps(localDate8, localTime9, localTime10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.equals(Object)\" because \"this.bookingDate\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Booking{id=1, bookerId=0, roomId=0, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str7, "Booking{id=1, bookerId=0, roomId=0, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, (int) (byte) 100, (int) (short) 10, localDate3, localTime4, localTime5);
        int int7 = booking6.getBookingID();
        java.time.LocalDate localDate8 = booking6.getDate();
        java.lang.String str9 = booking6.toString();
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Booking{id=1, bookerId=100, roomId=10, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str9, "Booking{id=1, bookerId=100, roomId=10, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        booking5.setBookingId((int) '#');
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getRoomId();
        java.lang.Integer int13 = booking5.getId();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy14 = booking5.getPaymentStrategy();
        java.time.LocalTime localTime15 = booking5.getStartTime();
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 35 + "'", int12 == 35);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 35 + "'", int13 == 35);
        org.junit.Assert.assertNull(paymentStrategy14);
        org.junit.Assert.assertNull(localTime15);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        int int9 = booking5.getDepositAmount();
        booking5.setBookingId((int) (byte) -1);
        java.time.LocalDate localDate12 = booking5.getBookingDate();
        booking5.setBookingId(35);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy15 = null;
        booking5.setPaymentStrategy(paymentStrategy15);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNull(localDate12);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) '#', 35, localDate2, localTime3, localTime4);
        java.time.LocalDate localDate6 = booking5.getDate();
        booking5.setDepositAmount(1);
        booking5.checkIn();
        int int10 = booking5.getDepositAmount();
        org.junit.Assert.assertNull(localDate6);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 1 + "'", int10 == 1);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (short) 1, (int) (byte) 0, localDate2, localTime3, localTime4);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        int int9 = booking5.getRoomId();
        java.time.LocalTime localTime10 = null;
        booking5.setStartTime(localTime10);
        java.time.LocalDate localDate12 = null;
        booking5.setDate(localDate12);
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 35 + "'", int9 == 35);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        booking5.setBookingId((int) '#');
        java.lang.Object obj10 = null;
        boolean boolean11 = booking5.equals(obj10);
        com.group13.roombookingsystem.model.room.Room room12 = null;
        booking5.setRoomBooked(room12);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) ' ', (int) '4', localDate2, localTime3, localTime4);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        booking5.checkIn();
        java.time.LocalTime localTime9 = null;
        booking5.setEndTime(localTime9);
        com.group13.roombookingsystem.model.room.Room room11 = booking5.getRoomBooked();
        org.junit.Assert.assertNull(room11);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        com.group13.roombookingsystem.model.user.User user9 = booking5.getBooker();
        boolean boolean10 = booking5.hasCheckedIn();
        java.time.LocalDate localDate11 = booking5.getDate();
        java.time.LocalDate localDate12 = null;
        booking5.setBookingDate(localDate12);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNull(user9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNull(localDate11);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (short) 0, (int) (short) 0, localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        java.time.LocalTime localTime8 = null;
        booking5.setStartTime(localTime8);
        java.time.LocalDate localDate12 = null;
        java.time.LocalTime localTime13 = null;
        java.time.LocalTime localTime14 = null;
        com.group13.roombookingsystem.model.booking.Booking booking15 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate12, localTime13, localTime14);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy16 = null;
        booking15.setPaymentStrategy(paymentStrategy16);
        int int18 = booking15.getDepositAmount();
        boolean boolean19 = booking5.equals((java.lang.Object) int18);
        java.time.LocalTime localTime20 = null;
        booking5.setEndTime(localTime20);
        int int22 = booking5.getRoomId();
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) (-1), (-1), (int) (byte) 100, localDate3, localTime4, localTime5);
        booking6.setBookingId((int) (short) 10);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        booking6.setBookingId((int) (short) 100);
        java.time.LocalTime localTime9 = null;
        booking6.setStartTime(localTime9);
        java.time.LocalTime localTime11 = booking6.getStartTime();
        org.junit.Assert.assertNull(localTime11);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setDepositAmount((int) (byte) 10);
        java.time.LocalDate localDate14 = null;
        booking5.setBookingDate(localDate14);
        com.group13.roombookingsystem.model.room.Room room16 = booking5.getRoomBooked();
        boolean boolean18 = booking5.pay((double) '4');
        org.junit.Assert.assertNull(room16);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getBookingID();
        java.lang.String str9 = booking5.toString();
        java.time.LocalDate localDate10 = null;
        booking5.setDate(localDate10);
        com.group13.roombookingsystem.model.room.Room room12 = booking5.getRoomBooked();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str9, "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
        org.junit.Assert.assertNull(room12);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setDepositAmount((int) (byte) 10);
        java.lang.String str14 = booking5.toString();
        int int15 = booking5.getRoomId();
        com.group13.roombookingsystem.model.user.User user16 = booking5.getBooker();
        booking5.setDepositAmount((int) (short) 0);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=10, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str14, "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=10, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 35 + "'", int15 == 35);
        org.junit.Assert.assertNull(user16);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        int int7 = booking6.getDepositAmount();
        boolean boolean9 = booking6.pay((double) '#');
        boolean boolean11 = booking6.pay((-1.0d));
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (short) 0, 35, localDate2, localTime3, localTime4);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(100, (int) (byte) 10, localDate2, localTime3, localTime4);
        int int6 = booking5.getRoomId();
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (short) 0, (int) (short) 0, localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = null;
        java.time.LocalTime localTime9 = null;
        java.time.LocalTime localTime10 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean11 = booking5.overlaps(localDate8, localTime9, localTime10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.equals(Object)\" because \"this.bookingDate\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.room.Room room6 = booking5.getRoomBooked();
        java.time.LocalDate localDate7 = booking5.getBookingDate();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy8 = null;
        booking5.setPaymentStrategy(paymentStrategy8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        org.junit.Assert.assertNull(room6);
        org.junit.Assert.assertNull(localDate7);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        booking5.setBookingId(1);
        java.time.LocalDate localDate10 = null;
        booking5.setBookingDate(localDate10);
        java.time.LocalTime localTime12 = booking5.getEndTime();
        org.junit.Assert.assertNull(localTime12);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        java.time.LocalDate localDate12 = null;
        booking5.setBookingDate(localDate12);
        int int14 = booking5.getBookingID();
        booking5.setId((java.lang.Integer) 10);
        com.group13.roombookingsystem.model.room.Room room17 = null;
        booking5.setRoomBooked(room17);
        boolean boolean20 = booking5.pay((double) (short) 10);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + (-1) + "'", int14 == (-1));
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        int int9 = booking5.getDepositAmount();
        java.lang.String str10 = booking5.toString();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str10, "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        booking5.setBookingId((int) '#');
        int int10 = booking5.getUserId();
        booking5.setDepositAmount(0);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + (-1) + "'", int10 == (-1));
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        int int9 = booking5.getUserId();
        com.group13.roombookingsystem.model.room.Room room10 = booking5.getRoomBooked();
        com.group13.roombookingsystem.model.room.Room room11 = null;
        booking5.setRoomBooked(room11);
        booking5.setBookingId((int) (short) -1);
        int int15 = booking5.getUserId();
        int int16 = booking5.getRoomId();
        java.time.LocalDate localDate17 = booking5.getDate();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
        org.junit.Assert.assertNull(room10);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + (-1) + "'", int15 == (-1));
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 35 + "'", int16 == 35);
        org.junit.Assert.assertNull(localDate17);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        booking5.setDepositAmount((int) (short) 0);
        java.time.LocalTime localTime8 = null;
        booking5.setStartTime(localTime8);
        boolean boolean10 = booking5.hasCheckedIn();
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        com.group13.roombookingsystem.model.room.Room room12 = booking5.getRoomBooked();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy13 = null;
        booking5.setPaymentStrategy(paymentStrategy13);
        org.junit.Assert.assertNull(room12);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) (-1), (int) (short) 10, 10, localDate3, localTime4, localTime5);
        int int7 = booking6.getRoomId();
        int int8 = booking6.getBookingID();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy9 = null;
        booking6.setPaymentStrategy(paymentStrategy9);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 10 + "'", int7 == 10);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 35, (int) (short) 1, 0, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.room.Room room7 = null;
        booking6.setRoomBooked(room7);
        java.lang.Class<?> wildcardClass9 = booking6.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = booking5.getPaymentStrategy();
        java.time.LocalTime localTime7 = null;
        booking5.setStartTime(localTime7);
        int int9 = booking5.getBookingID();
        org.junit.Assert.assertNull(paymentStrategy6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getUserId();
        java.lang.Integer int13 = booking5.getId();
        java.time.LocalTime localTime14 = booking5.getEndTime();
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertNull(int13);
        org.junit.Assert.assertNull(localTime14);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        java.time.LocalDate localDate12 = null;
        booking5.setBookingDate(localDate12);
        java.time.LocalDate localDate14 = null;
        booking5.setBookingDate(localDate14);
        java.lang.String str16 = booking5.toString();
        booking5.setId((java.lang.Integer) 10);
        int int19 = booking5.getUserId();
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str16, "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + (-1) + "'", int19 == (-1));
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        int int7 = booking6.getDepositAmount();
        boolean boolean9 = booking6.pay((double) '#');
        booking6.setDepositAmount((int) (short) 10);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        java.time.LocalDate localDate12 = null;
        booking5.setBookingDate(localDate12);
        java.time.LocalDate localDate14 = null;
        booking5.setBookingDate(localDate14);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy16 = booking5.getPaymentStrategy();
        org.junit.Assert.assertNull(paymentStrategy16);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        java.time.LocalTime localTime7 = booking6.getEndTime();
        boolean boolean8 = booking6.hasCheckedIn();
        org.junit.Assert.assertNull(localTime7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        java.time.LocalTime localTime9 = booking5.getStartTime();
        java.time.LocalTime localTime10 = booking5.getEndTime();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertNull(localTime9);
        org.junit.Assert.assertNull(localTime10);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        java.lang.Integer int9 = booking5.getId();
        int int10 = booking5.getUserId();
        java.time.LocalTime localTime11 = booking5.getStartTime();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy12 = null;
        booking5.setPaymentStrategy(paymentStrategy12);
        java.time.LocalTime localTime14 = null;
        booking5.setStartTime(localTime14);
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertNull(int9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + (-1) + "'", int10 == (-1));
        org.junit.Assert.assertNull(localTime11);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getUserId();
        booking5.setBookingId((int) (short) 10);
        int int15 = booking5.getBookingID();
        java.lang.Class<?> wildcardClass16 = booking5.getClass();
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 10 + "'", int15 == 10);
        org.junit.Assert.assertNotNull(wildcardClass16);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) '#', 35, localDate2, localTime3, localTime4);
        int int6 = booking5.getDepositAmount();
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        java.lang.Integer int9 = booking5.getId();
        boolean boolean11 = booking5.equals((java.lang.Object) 10.0d);
        com.group13.roombookingsystem.model.room.Room room12 = null;
        booking5.setRoomBooked(room12);
        booking5.setId((java.lang.Integer) 10);
        booking5.setDepositAmount((int) (short) 10);
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertNull(int9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        int int9 = booking5.getDepositAmount();
        booking5.setBookingId((int) (byte) -1);
        java.time.LocalDate localDate12 = booking5.getBookingDate();
        booking5.setBookingId(35);
        java.lang.Integer int15 = booking5.getId();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNull(localDate12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 35 + "'", int15 == 35);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        java.time.LocalTime localTime7 = booking6.getEndTime();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Class<?> wildcardClass8 = localTime7.getClass();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"Object.getClass()\" because \"o\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(localTime7);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        java.lang.Integer int9 = booking5.getId();
        int int10 = booking5.getUserId();
        java.time.LocalTime localTime11 = booking5.getStartTime();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy12 = null;
        booking5.setPaymentStrategy(paymentStrategy12);
        com.group13.roombookingsystem.model.room.Room room14 = booking5.getRoomBooked();
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertNull(int9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + (-1) + "'", int10 == (-1));
        org.junit.Assert.assertNull(localTime11);
        org.junit.Assert.assertNull(room14);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        booking5.setDepositAmount(0);
        booking5.checkIn();
        java.time.LocalTime localTime12 = booking5.getStartTime();
        booking5.setBookingId((int) (byte) 0);
        java.time.LocalDate localDate15 = booking5.getDate();
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertNull(localTime12);
        org.junit.Assert.assertNull(localDate15);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setDepositAmount((int) (byte) 10);
        java.time.LocalDate localDate14 = null;
        booking5.setBookingDate(localDate14);
        com.group13.roombookingsystem.model.user.User user16 = null;
        booking5.setBooker(user16);
        booking5.checkIn();
        java.time.LocalDate localDate21 = null;
        java.time.LocalTime localTime22 = null;
        java.time.LocalTime localTime23 = null;
        com.group13.roombookingsystem.model.booking.Booking booking24 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate21, localTime22, localTime23);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy25 = null;
        booking24.setPaymentStrategy(paymentStrategy25);
        int int27 = booking24.getBookingID();
        java.lang.String str28 = booking24.toString();
        java.time.LocalTime localTime29 = booking24.getStartTime();
        java.lang.Integer int30 = booking24.getId();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy31 = booking24.getPaymentStrategy();
        boolean boolean32 = booking5.equals((java.lang.Object) paymentStrategy31);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + (-1) + "'", int27 == (-1));
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str28, "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
        org.junit.Assert.assertNull(localTime29);
        org.junit.Assert.assertNull(int30);
        org.junit.Assert.assertNull(paymentStrategy31);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        booking5.setDepositAmount((int) (short) 0);
        java.time.LocalDate localDate8 = null;
        booking5.setBookingDate(localDate8);
        boolean boolean10 = booking5.hasCheckedIn();
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        java.lang.Integer int9 = booking5.getId();
        java.time.LocalDate localDate10 = null;
        booking5.setBookingDate(localDate10);
        java.lang.Integer int12 = booking5.getId();
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertNull(int9);
        org.junit.Assert.assertNull(int12);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 100, (int) '4', (int) (short) 10, localDate3, localTime4, localTime5);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        com.group13.roombookingsystem.model.user.User user9 = booking5.getBooker();
        boolean boolean10 = booking5.hasCheckedIn();
        com.group13.roombookingsystem.model.user.User user11 = booking5.getBooker();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNull(user9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNull(user11);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 35, 1, 1, localDate3, localTime4, localTime5);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        booking5.setBookingId((int) '#');
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setBookingId((int) (byte) 0);
        java.time.LocalTime localTime14 = booking5.getEndTime();
        org.junit.Assert.assertNull(localTime14);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        booking5.setDepositAmount((int) (short) 0);
        java.time.LocalDate localDate8 = null;
        booking5.setBookingDate(localDate8);
        booking5.checkIn();
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = null;
        java.time.LocalTime localTime9 = null;
        java.time.LocalTime localTime10 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean11 = booking5.overlaps(localDate8, localTime9, localTime10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.equals(Object)\" because \"this.bookingDate\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        booking6.setBookingId((int) (short) 100);
        com.group13.roombookingsystem.model.user.User user9 = null;
        booking6.setBooker(user9);
        com.group13.roombookingsystem.model.user.User user11 = null;
        booking6.setBooker(user11);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setDepositAmount((int) (byte) 10);
        java.time.LocalDate localDate14 = null;
        booking5.setBookingDate(localDate14);
        com.group13.roombookingsystem.model.user.User user16 = null;
        booking5.setBooker(user16);
        booking5.checkIn();
        com.group13.roombookingsystem.model.user.User user19 = booking5.getBooker();
        org.junit.Assert.assertNull(user19);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        booking5.setDepositAmount((int) (short) 0);
        com.group13.roombookingsystem.model.user.User user8 = booking5.getBooker();
        org.junit.Assert.assertNull(user8);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        int int9 = booking5.getUserId();
        com.group13.roombookingsystem.model.room.Room room10 = booking5.getRoomBooked();
        com.group13.roombookingsystem.model.room.Room room11 = null;
        booking5.setRoomBooked(room11);
        com.group13.roombookingsystem.model.room.Room room13 = null;
        booking5.setRoomBooked(room13);
        com.group13.roombookingsystem.model.room.Room room15 = null;
        booking5.setRoomBooked(room15);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
        org.junit.Assert.assertNull(room10);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        int int9 = booking5.getUserId();
        com.group13.roombookingsystem.model.room.Room room10 = booking5.getRoomBooked();
        com.group13.roombookingsystem.model.room.Room room11 = null;
        booking5.setRoomBooked(room11);
        booking5.setBookingId((int) (short) -1);
        int int15 = booking5.getUserId();
        java.time.LocalDate localDate18 = null;
        java.time.LocalTime localTime19 = null;
        java.time.LocalTime localTime20 = null;
        com.group13.roombookingsystem.model.booking.Booking booking21 = new com.group13.roombookingsystem.model.booking.Booking(10, (int) (short) 10, localDate18, localTime19, localTime20);
        booking21.checkIn();
        boolean boolean23 = booking5.equals((java.lang.Object) booking21);
        java.time.LocalTime localTime24 = booking5.getEndTime();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
        org.junit.Assert.assertNull(room10);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + (-1) + "'", int15 == (-1));
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(localTime24);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        booking6.setBookingId((int) (short) 100);
        com.group13.roombookingsystem.model.user.User user9 = null;
        booking6.setBooker(user9);
        com.group13.roombookingsystem.model.room.Room room11 = booking6.getRoomBooked();
        int int12 = booking6.getDepositAmount();
        com.group13.roombookingsystem.model.room.Room room13 = null;
        booking6.setRoomBooked(room13);
        org.junit.Assert.assertNull(room11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((-1), (int) (short) 0, localDate2, localTime3, localTime4);
        boolean boolean7 = booking5.pay((double) (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        booking5.setBookingId(1);
        java.time.LocalDate localDate10 = null;
        booking5.setBookingDate(localDate10);
        java.time.LocalDate localDate12 = booking5.getBookingDate();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy13 = booking5.getPaymentStrategy();
        booking5.setId((java.lang.Integer) 35);
        org.junit.Assert.assertNull(localDate12);
        org.junit.Assert.assertNull(paymentStrategy13);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(35, (int) (byte) -1, localDate2, localTime3, localTime4);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        java.lang.Integer int9 = booking5.getId();
        int int10 = booking5.getUserId();
        java.time.LocalTime localTime11 = booking5.getStartTime();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy12 = null;
        booking5.setPaymentStrategy(paymentStrategy12);
        java.time.LocalTime localTime14 = null;
        booking5.setEndTime(localTime14);
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertNull(int9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + (-1) + "'", int10 == (-1));
        org.junit.Assert.assertNull(localTime11);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(35, (int) (byte) 10, localDate2, localTime3, localTime4);
        boolean boolean7 = booking5.pay((double) 10L);
        int int8 = booking5.getRoomId();
        java.lang.Class<?> wildcardClass9 = booking5.getClass();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 10 + "'", int8 == 10);
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 10, 35, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.user.User user7 = null;
        booking6.setBooker(user7);
        int int9 = booking6.getDepositAmount();
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(0, (int) (byte) -1, localDate2, localTime3, localTime4);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        java.lang.Integer int9 = booking5.getId();
        booking5.setDepositAmount((int) 'a');
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertNull(int9);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getUserId();
        booking5.setBookingId((int) (short) 10);
        int int15 = booking5.getDepositAmount();
        java.time.LocalTime localTime16 = booking5.getStartTime();
        boolean boolean17 = booking5.hasCheckedIn();
        java.time.LocalDate localDate18 = null;
        java.time.LocalTime localTime19 = null;
        java.time.LocalTime localTime20 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean21 = booking5.overlaps(localDate18, localTime19, localTime20);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.equals(Object)\" because \"this.bookingDate\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNull(localTime16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) (-1), (int) (byte) 10, 35, localDate3, localTime4, localTime5);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        booking6.setBookingId((int) (short) 100);
        com.group13.roombookingsystem.model.user.User user9 = null;
        booking6.setBooker(user9);
        java.time.LocalDate localDate11 = null;
        booking6.setBookingDate(localDate11);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        booking5.setDepositAmount(0);
        java.time.LocalTime localTime11 = booking5.getStartTime();
        int int12 = booking5.getRoomId();
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertNull(localTime11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 35 + "'", int12 == 35);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        java.lang.Integer int9 = booking5.getId();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNull(int9);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) 1, (int) 'a', localDate2, localTime3, localTime4);
        java.time.LocalDate localDate9 = null;
        java.time.LocalTime localTime10 = null;
        java.time.LocalTime localTime11 = null;
        com.group13.roombookingsystem.model.booking.Booking booking12 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate9, localTime10, localTime11);
        booking12.setBookingId((int) (short) 100);
        com.group13.roombookingsystem.model.room.Room room15 = booking12.getRoomBooked();
        boolean boolean16 = booking5.equals((java.lang.Object) room15);
        org.junit.Assert.assertNull(room15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getUserId();
        booking5.setBookingId((int) (short) 10);
        int int15 = booking5.getDepositAmount();
        java.time.LocalTime localTime16 = booking5.getStartTime();
        boolean boolean17 = booking5.hasCheckedIn();
        com.group13.roombookingsystem.model.user.User user18 = booking5.getBooker();
        com.group13.roombookingsystem.model.user.User user19 = null;
        booking5.setBooker(user19);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNull(localTime16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNull(user18);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 0, 0, (int) '4', localDate3, localTime4, localTime5);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getUserId();
        java.lang.Integer int13 = booking5.getId();
        com.group13.roombookingsystem.model.user.User user14 = booking5.getBooker();
        java.lang.Integer int15 = booking5.getId();
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertNull(int13);
        org.junit.Assert.assertNull(user14);
        org.junit.Assert.assertNull(int15);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        booking5.setId((java.lang.Integer) 100);
        booking5.setId((java.lang.Integer) (-1));
        java.time.LocalDate localDate12 = null;
        booking5.setBookingDate(localDate12);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        java.lang.String str7 = booking6.toString();
        booking6.checkIn();
        booking6.setId((java.lang.Integer) 100);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Booking{id=1, bookerId=0, roomId=0, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str7, "Booking{id=1, bookerId=0, roomId=0, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getUserId();
        java.lang.String str13 = booking5.toString();
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str13, "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getBookingID();
        int int9 = booking5.getDepositAmount();
        java.time.LocalDate localDate10 = null;
        booking5.setBookingDate(localDate10);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(0, 0, localDate2, localTime3, localTime4);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        booking5.setBookingId((int) '#');
        com.group13.roombookingsystem.model.room.Room room10 = booking5.getRoomBooked();
        org.junit.Assert.assertNull(room10);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setDepositAmount((int) (byte) 10);
        java.lang.String str14 = booking5.toString();
        int int15 = booking5.getRoomId();
        int int16 = booking5.getUserId();
        java.time.LocalTime localTime17 = null;
        booking5.setEndTime(localTime17);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=10, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str14, "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=10, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 35 + "'", int15 == 35);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        com.group13.roombookingsystem.model.user.User user9 = booking5.getBooker();
        boolean boolean10 = booking5.hasCheckedIn();
        java.time.LocalTime localTime11 = null;
        booking5.setEndTime(localTime11);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNull(user9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        booking5.checkIn();
        int int9 = booking5.getRoomId();
        boolean boolean11 = booking5.pay(100.0d);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 35 + "'", int9 == 35);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getUserId();
        booking5.setBookingId((int) (short) 10);
        int int15 = booking5.getDepositAmount();
        java.time.LocalTime localTime16 = null;
        booking5.setStartTime(localTime16);
        java.time.LocalTime localTime18 = null;
        booking5.setStartTime(localTime18);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setBookingId((int) (byte) 0);
        java.time.LocalDate localDate14 = null;
        booking5.setBookingDate(localDate14);
        booking5.setBookingId(1);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) '#', 35, localDate2, localTime3, localTime4);
        java.time.LocalDate localDate6 = null;
        booking5.setBookingDate(localDate6);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        booking5.setDepositAmount((int) (short) 0);
        java.time.LocalTime localTime8 = null;
        booking5.setStartTime(localTime8);
        java.time.LocalTime localTime10 = null;
        booking5.setEndTime(localTime10);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        booking5.setBookingId(1);
        java.time.LocalDate localDate10 = null;
        booking5.setBookingDate(localDate10);
        java.time.LocalDate localDate12 = booking5.getBookingDate();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy13 = booking5.getPaymentStrategy();
        booking5.setId((java.lang.Integer) 0);
        org.junit.Assert.assertNull(localDate12);
        org.junit.Assert.assertNull(paymentStrategy13);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getUserId();
        booking5.setBookingId((int) (short) 10);
        int int15 = booking5.getDepositAmount();
        java.time.LocalTime localTime16 = booking5.getStartTime();
        boolean boolean17 = booking5.hasCheckedIn();
        com.group13.roombookingsystem.model.user.User user18 = booking5.getBooker();
        booking5.setBookingId(0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNull(localTime16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNull(user18);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        java.time.LocalDate localDate7 = null;
        booking6.setDate(localDate7);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy9 = null;
        booking6.setPaymentStrategy(paymentStrategy9);
        java.time.LocalDate localDate11 = null;
        booking6.setBookingDate(localDate11);
        java.lang.String str13 = booking6.toString();
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "Booking{id=1, bookerId=0, roomId=0, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str13, "Booking{id=1, bookerId=0, roomId=0, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (short) 0, (int) (short) 0, localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        java.time.LocalTime localTime8 = null;
        booking5.setStartTime(localTime8);
        java.time.LocalDate localDate12 = null;
        java.time.LocalTime localTime13 = null;
        java.time.LocalTime localTime14 = null;
        com.group13.roombookingsystem.model.booking.Booking booking15 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate12, localTime13, localTime14);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy16 = null;
        booking15.setPaymentStrategy(paymentStrategy16);
        int int18 = booking15.getDepositAmount();
        boolean boolean19 = booking5.equals((java.lang.Object) int18);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy20 = null;
        booking5.setPaymentStrategy(paymentStrategy20);
        com.group13.roombookingsystem.model.user.User user22 = null;
        booking5.setBooker(user22);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy7 = null;
        booking6.setPaymentStrategy(paymentStrategy7);
        booking6.checkIn();
        java.time.LocalDate localDate10 = booking6.getBookingDate();
        org.junit.Assert.assertNull(localDate10);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getUserId();
        com.group13.roombookingsystem.model.room.Room room13 = null;
        booking5.setRoomBooked(room13);
        com.group13.roombookingsystem.model.room.Room room15 = booking5.getRoomBooked();
        java.time.LocalDate localDate16 = null;
        booking5.setDate(localDate16);
        int int18 = booking5.getDepositAmount();
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertNull(room15);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) 1, 100, localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.room.Room room6 = booking5.getRoomBooked();
        org.junit.Assert.assertNull(room6);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setBookingId((int) (byte) 0);
        java.time.LocalDate localDate14 = null;
        booking5.setBookingDate(localDate14);
        java.time.LocalDate localDate16 = booking5.getBookingDate();
        boolean boolean18 = booking5.pay((double) 0.0f);
        org.junit.Assert.assertNull(localDate16);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(10, (int) (short) 10, localDate2, localTime3, localTime4);
        booking5.checkIn();
        com.group13.roombookingsystem.model.user.User user7 = booking5.getBooker();
        org.junit.Assert.assertNull(user7);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        booking5.setDepositAmount(0);
        booking5.checkIn();
        java.time.LocalDate localDate14 = null;
        java.time.LocalTime localTime15 = null;
        java.time.LocalTime localTime16 = null;
        com.group13.roombookingsystem.model.booking.Booking booking17 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate14, localTime15, localTime16);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy18 = null;
        booking17.setPaymentStrategy(paymentStrategy18);
        com.group13.roombookingsystem.model.user.User user20 = null;
        booking17.setBooker(user20);
        com.group13.roombookingsystem.model.room.Room room22 = null;
        booking17.setRoomBooked(room22);
        java.time.LocalDate localDate24 = null;
        booking17.setBookingDate(localDate24);
        int int26 = booking17.getBookingID();
        boolean boolean27 = booking5.equals((java.lang.Object) booking17);
        java.time.LocalDate localDate30 = null;
        java.time.LocalTime localTime31 = null;
        java.time.LocalTime localTime32 = null;
        com.group13.roombookingsystem.model.booking.Booking booking33 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate30, localTime31, localTime32);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy34 = null;
        booking33.setPaymentStrategy(paymentStrategy34);
        java.time.LocalDate localDate36 = booking33.getDate();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy37 = null;
        booking33.setPaymentStrategy(paymentStrategy37);
        boolean boolean39 = booking5.equals((java.lang.Object) paymentStrategy37);
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + (-1) + "'", int26 == (-1));
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
        org.junit.Assert.assertNull(localDate36);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getBookingID();
        java.lang.String str9 = booking5.toString();
        java.time.LocalTime localTime10 = booking5.getStartTime();
        booking5.setId((java.lang.Integer) (-1));
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str9, "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
        org.junit.Assert.assertNull(localTime10);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy7 = null;
        booking6.setPaymentStrategy(paymentStrategy7);
        java.time.LocalDate localDate9 = booking6.getBookingDate();
        int int10 = booking6.getDepositAmount();
        org.junit.Assert.assertNull(localDate9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        com.group13.roombookingsystem.model.user.User user9 = booking5.getBooker();
        boolean boolean10 = booking5.hasCheckedIn();
        boolean boolean12 = booking5.pay((double) 0);
        java.lang.Integer int13 = booking5.getId();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNull(user9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNull(int13);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        java.time.LocalDate localDate12 = null;
        booking5.setBookingDate(localDate12);
        int int14 = booking5.getBookingID();
        booking5.setId((java.lang.Integer) 10);
        com.group13.roombookingsystem.model.room.Room room17 = null;
        booking5.setRoomBooked(room17);
        java.time.LocalDate localDate19 = null;
        java.time.LocalTime localTime20 = null;
        java.time.LocalTime localTime21 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean22 = booking5.overlaps(localDate19, localTime20, localTime21);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.equals(Object)\" because \"this.bookingDate\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + (-1) + "'", int14 == (-1));
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy7 = null;
        booking6.setPaymentStrategy(paymentStrategy7);
        com.group13.roombookingsystem.model.room.Room room9 = null;
        booking6.setRoomBooked(room9);
        java.lang.Integer int11 = booking6.getId();
        boolean boolean13 = booking6.pay(100.0d);
        com.group13.roombookingsystem.model.room.Room room14 = booking6.getRoomBooked();
        booking6.checkIn();
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 1 + "'", int11 == 1);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNull(room14);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getBookingID();
        java.lang.String str9 = booking5.toString();
        booking5.setBookingId((int) '4');
        java.time.LocalDate localDate12 = booking5.getDate();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str9, "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
        org.junit.Assert.assertNull(localDate12);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        int int9 = booking5.getDepositAmount();
        booking5.setBookingId((int) (byte) -1);
        java.time.LocalDate localDate12 = booking5.getBookingDate();
        booking5.setBookingId(35);
        int int15 = booking5.getRoomId();
        java.time.LocalTime localTime16 = booking5.getStartTime();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNull(localDate12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 35 + "'", int15 == 35);
        org.junit.Assert.assertNull(localTime16);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(35, (int) (byte) 10, localDate2, localTime3, localTime4);
        boolean boolean7 = booking5.pay((double) 10L);
        boolean boolean8 = booking5.hasCheckedIn();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy7 = null;
        booking6.setPaymentStrategy(paymentStrategy7);
        com.group13.roombookingsystem.model.room.Room room9 = null;
        booking6.setRoomBooked(room9);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy11 = booking6.getPaymentStrategy();
        java.time.LocalDate localDate12 = null;
        booking6.setDate(localDate12);
        org.junit.Assert.assertNull(paymentStrategy11);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) 1, 100, localDate2, localTime3, localTime4);
        java.time.LocalTime localTime6 = booking5.getEndTime();
        org.junit.Assert.assertNull(localTime6);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (short) -1, (int) '#', localDate2, localTime3, localTime4);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(10, (int) (byte) 1, localDate2, localTime3, localTime4);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(10, (int) '#', localDate2, localTime3, localTime4);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        java.time.LocalDate localDate12 = null;
        booking5.setBookingDate(localDate12);
        int int14 = booking5.getBookingID();
        booking5.setId((java.lang.Integer) 10);
        boolean boolean18 = booking5.pay((double) 1L);
        int int19 = booking5.getBookingID();
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + (-1) + "'", int14 == (-1));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 10 + "'", int19 == 10);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        booking5.checkIn();
        java.time.LocalDate localDate9 = null;
        booking5.setDate(localDate9);
        com.group13.roombookingsystem.model.user.User user11 = null;
        booking5.setBooker(user11);
        int int13 = booking5.getBookingID();
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + (-1) + "'", int13 == (-1));
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        boolean boolean9 = booking5.hasCheckedIn();
        boolean boolean10 = booking5.hasCheckedIn();
        java.time.LocalDate localDate13 = null;
        java.time.LocalTime localTime14 = null;
        java.time.LocalTime localTime15 = null;
        com.group13.roombookingsystem.model.booking.Booking booking16 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate13, localTime14, localTime15);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy17 = null;
        booking16.setPaymentStrategy(paymentStrategy17);
        com.group13.roombookingsystem.model.user.User user19 = null;
        booking16.setBooker(user19);
        com.group13.roombookingsystem.model.room.Room room21 = null;
        booking16.setRoomBooked(room21);
        booking16.setDepositAmount((int) (byte) 10);
        java.time.LocalDate localDate25 = null;
        booking16.setBookingDate(localDate25);
        com.group13.roombookingsystem.model.user.User user27 = null;
        booking16.setBooker(user27);
        booking16.checkIn();
        java.time.LocalDate localDate30 = null;
        booking16.setDate(localDate30);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy32 = booking16.getPaymentStrategy();
        boolean boolean33 = booking5.equals((java.lang.Object) paymentStrategy32);
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNull(paymentStrategy32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        int int9 = booking5.getDepositAmount();
        booking5.setBookingId((int) (byte) -1);
        java.time.LocalDate localDate12 = booking5.getBookingDate();
        java.time.LocalTime localTime13 = booking5.getStartTime();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNull(localDate12);
        org.junit.Assert.assertNull(localTime13);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        java.time.LocalDate localDate12 = null;
        booking5.setBookingDate(localDate12);
        int int14 = booking5.getBookingID();
        booking5.setId((java.lang.Integer) 10);
        com.group13.roombookingsystem.model.room.Room room17 = null;
        booking5.setRoomBooked(room17);
        com.group13.roombookingsystem.model.room.Room room19 = booking5.getRoomBooked();
        booking5.setBookingId((int) (short) 100);
        com.group13.roombookingsystem.model.room.Room room22 = booking5.getRoomBooked();
        java.time.LocalDate localDate23 = booking5.getDate();
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + (-1) + "'", int14 == (-1));
        org.junit.Assert.assertNull(room19);
        org.junit.Assert.assertNull(room22);
        org.junit.Assert.assertNull(localDate23);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setDepositAmount((int) (byte) 10);
        java.lang.String str14 = booking5.toString();
        int int15 = booking5.getRoomId();
        int int16 = booking5.getUserId();
        java.time.LocalDate localDate17 = booking5.getDate();
        java.time.LocalDate localDate18 = booking5.getBookingDate();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Class<?> wildcardClass19 = localDate18.getClass();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"Object.getClass()\" because \"o\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=10, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str14, "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=10, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 35 + "'", int15 == 35);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
        org.junit.Assert.assertNull(localDate17);
        org.junit.Assert.assertNull(localDate18);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy7 = null;
        booking6.setPaymentStrategy(paymentStrategy7);
        com.group13.roombookingsystem.model.room.Room room9 = null;
        booking6.setRoomBooked(room9);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy11 = booking6.getPaymentStrategy();
        int int12 = booking6.getRoomId();
        org.junit.Assert.assertNull(paymentStrategy11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) ' ', (int) '#', localDate2, localTime3, localTime4);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        java.lang.Integer int9 = booking5.getId();
        java.time.LocalDate localDate10 = null;
        booking5.setBookingDate(localDate10);
        com.group13.roombookingsystem.model.room.Room room12 = null;
        booking5.setRoomBooked(room12);
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertNull(int9);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        java.time.LocalDate localDate12 = null;
        booking5.setBookingDate(localDate12);
        int int14 = booking5.getBookingID();
        java.time.LocalDate localDate15 = null;
        booking5.setDate(localDate15);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + (-1) + "'", int14 == (-1));
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        java.lang.String str7 = booking6.toString();
        booking6.checkIn();
        com.group13.roombookingsystem.model.room.Room room9 = null;
        booking6.setRoomBooked(room9);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Booking{id=1, bookerId=0, roomId=0, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str7, "Booking{id=1, bookerId=0, roomId=0, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy7 = null;
        booking6.setPaymentStrategy(paymentStrategy7);
        com.group13.roombookingsystem.model.room.Room room9 = null;
        booking6.setRoomBooked(room9);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy11 = booking6.getPaymentStrategy();
        java.time.LocalDate localDate15 = null;
        java.time.LocalTime localTime16 = null;
        java.time.LocalTime localTime17 = null;
        com.group13.roombookingsystem.model.booking.Booking booking18 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate15, localTime16, localTime17);
        java.time.LocalTime localTime19 = booking18.getEndTime();
        boolean boolean20 = booking6.equals((java.lang.Object) booking18);
        org.junit.Assert.assertNull(paymentStrategy11);
        org.junit.Assert.assertNull(localTime19);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, (int) (byte) 100, (int) (short) 10, localDate3, localTime4, localTime5);
        int int7 = booking6.getBookingID();
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking6.setBooker(user8);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        java.time.LocalDate localDate12 = null;
        booking5.setBookingDate(localDate12);
        int int14 = booking5.getBookingID();
        booking5.setId((java.lang.Integer) 10);
        com.group13.roombookingsystem.model.room.Room room17 = null;
        booking5.setRoomBooked(room17);
        java.lang.Integer int19 = booking5.getId();
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + (-1) + "'", int14 == (-1));
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 10 + "'", int19 == 10);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        booking5.setBookingId(1);
        com.group13.roombookingsystem.model.user.User user10 = booking5.getBooker();
        booking5.setId((java.lang.Integer) (-1));
        org.junit.Assert.assertNull(user10);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setDepositAmount((int) (byte) 1);
        com.group13.roombookingsystem.model.user.User user14 = booking5.getBooker();
        int int15 = booking5.getBookingID();
        org.junit.Assert.assertNull(user14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + (-1) + "'", int15 == (-1));
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy7 = null;
        booking6.setPaymentStrategy(paymentStrategy7);
        com.group13.roombookingsystem.model.room.Room room9 = null;
        booking6.setRoomBooked(room9);
        java.time.LocalTime localTime11 = null;
        booking6.setEndTime(localTime11);
        java.time.LocalDate localDate13 = booking6.getBookingDate();
        boolean boolean15 = booking6.equals((java.lang.Object) 10L);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy16 = booking6.getPaymentStrategy();
        org.junit.Assert.assertNull(localDate13);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNull(paymentStrategy16);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 10, 35, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.room.Room room7 = null;
        booking6.setRoomBooked(room7);
        java.time.LocalDate localDate11 = null;
        java.time.LocalTime localTime12 = null;
        java.time.LocalTime localTime13 = null;
        com.group13.roombookingsystem.model.booking.Booking booking14 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate11, localTime12, localTime13);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy15 = null;
        booking14.setPaymentStrategy(paymentStrategy15);
        com.group13.roombookingsystem.model.user.User user17 = null;
        booking14.setBooker(user17);
        com.group13.roombookingsystem.model.room.Room room19 = null;
        booking14.setRoomBooked(room19);
        booking14.setDepositAmount((int) (byte) 10);
        java.time.LocalDate localDate23 = null;
        booking14.setBookingDate(localDate23);
        com.group13.roombookingsystem.model.user.User user25 = null;
        booking14.setBooker(user25);
        booking14.checkIn();
        int int28 = booking14.getBookingID();
        java.time.LocalTime localTime29 = booking14.getStartTime();
        java.lang.String str30 = booking14.toString();
        boolean boolean31 = booking6.equals((java.lang.Object) str30);
        java.lang.String str32 = booking6.toString();
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + (-1) + "'", int28 == (-1));
        org.junit.Assert.assertNull(localTime29);
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=10, hasCheckedIn=true, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str30, "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=10, hasCheckedIn=true, booker=null, roomBooked=null, paymentStrategy=null}");
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "Booking{id=1, bookerId=10, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str32, "Booking{id=1, bookerId=10, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy7 = null;
        booking6.setPaymentStrategy(paymentStrategy7);
        com.group13.roombookingsystem.model.room.Room room9 = null;
        booking6.setRoomBooked(room9);
        java.time.LocalTime localTime11 = null;
        booking6.setEndTime(localTime11);
        java.time.LocalTime localTime13 = booking6.getStartTime();
        java.time.LocalDate localDate14 = null;
        booking6.setDate(localDate14);
        org.junit.Assert.assertNull(localTime13);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        int int12 = booking5.getUserId();
        com.group13.roombookingsystem.model.room.Room room13 = null;
        booking5.setRoomBooked(room13);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy15 = null;
        booking5.setPaymentStrategy(paymentStrategy15);
        int int17 = booking5.getBookingID();
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + (-1) + "'", int17 == (-1));
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        booking6.setBookingId((int) (short) 100);
        java.time.LocalTime localTime9 = booking6.getEndTime();
        booking6.setId((java.lang.Integer) 0);
        java.lang.Integer int12 = booking6.getId();
        org.junit.Assert.assertNull(localTime9);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy7 = null;
        booking6.setPaymentStrategy(paymentStrategy7);
        com.group13.roombookingsystem.model.room.Room room9 = null;
        booking6.setRoomBooked(room9);
        booking6.setId((java.lang.Integer) 10);
        java.time.LocalTime localTime13 = booking6.getStartTime();
        org.junit.Assert.assertNull(localTime13);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        java.time.LocalDate localDate11 = null;
        java.time.LocalTime localTime12 = null;
        java.time.LocalTime localTime13 = null;
        com.group13.roombookingsystem.model.booking.Booking booking14 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate11, localTime12, localTime13);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy15 = null;
        booking14.setPaymentStrategy(paymentStrategy15);
        int int17 = booking14.getUserId();
        boolean boolean18 = booking5.equals((java.lang.Object) int17);
        boolean boolean20 = booking5.pay((double) 0.0f);
        java.time.LocalDate localDate21 = booking5.getDate();
        java.time.LocalDate localDate22 = null;
        booking5.setDate(localDate22);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + (-1) + "'", int17 == (-1));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNull(localDate21);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.room.Room room6 = booking5.getRoomBooked();
        boolean boolean7 = booking5.hasCheckedIn();
        java.time.LocalTime localTime8 = null;
        booking5.setStartTime(localTime8);
        org.junit.Assert.assertNull(room6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        java.time.LocalDate localDate7 = null;
        booking6.setDate(localDate7);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy9 = null;
        booking6.setPaymentStrategy(paymentStrategy9);
        java.time.LocalDate localDate11 = null;
        booking6.setBookingDate(localDate11);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy13 = booking6.getPaymentStrategy();
        int int14 = booking6.getUserId();
        java.lang.String str15 = booking6.toString();
        org.junit.Assert.assertNull(paymentStrategy13);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "Booking{id=1, bookerId=0, roomId=0, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str15, "Booking{id=1, bookerId=0, roomId=0, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setDepositAmount((int) (byte) 10);
        java.lang.String str14 = booking5.toString();
        int int15 = booking5.getRoomId();
        int int16 = booking5.getUserId();
        java.time.LocalTime localTime17 = booking5.getStartTime();
        booking5.setBookingId(1);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=10, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str14, "Booking{id=null, bookerId=-1, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=10, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 35 + "'", int15 == 35);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
        org.junit.Assert.assertNull(localTime17);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking(35, (int) (byte) 10, localDate2, localTime3, localTime4);
        java.time.LocalDate localDate6 = null;
        booking5.setBookingDate(localDate6);
        java.time.LocalDate localDate8 = booking5.getDate();
        java.time.LocalTime localTime9 = booking5.getEndTime();
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertNull(localTime9);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        booking6.setBookingId((int) (short) 100);
        com.group13.roombookingsystem.model.user.User user9 = null;
        booking6.setBooker(user9);
        com.group13.roombookingsystem.model.room.Room room11 = booking6.getRoomBooked();
        int int12 = booking6.getDepositAmount();
        boolean boolean13 = booking6.hasCheckedIn();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy14 = booking6.getPaymentStrategy();
        org.junit.Assert.assertNull(room11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNull(paymentStrategy14);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        booking5.setBookingId(1);
        java.time.LocalDate localDate10 = null;
        booking5.setDate(localDate10);
        int int12 = booking5.getDepositAmount();
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        java.time.LocalDate localDate12 = null;
        booking5.setBookingDate(localDate12);
        int int14 = booking5.getBookingID();
        booking5.setId((java.lang.Integer) 10);
        com.group13.roombookingsystem.model.room.Room room17 = null;
        booking5.setRoomBooked(room17);
        com.group13.roombookingsystem.model.room.Room room19 = booking5.getRoomBooked();
        int int20 = booking5.getRoomId();
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + (-1) + "'", int14 == (-1));
        org.junit.Assert.assertNull(room19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 35 + "'", int20 == 35);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        java.time.LocalDate localDate12 = null;
        booking5.setBookingDate(localDate12);
        java.time.LocalDate localDate14 = null;
        booking5.setBookingDate(localDate14);
        com.group13.roombookingsystem.model.user.User user16 = booking5.getBooker();
        org.junit.Assert.assertNull(user16);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) (-1), (int) (short) 100, (int) (short) 1, localDate3, localTime4, localTime5);
        int int7 = booking6.getUserId();
        boolean boolean9 = booking6.pay(0.0d);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 100 + "'", int7 == 100);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (short) 0, (int) (short) 0, localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.room.Room room6 = null;
        booking5.setRoomBooked(room6);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        java.time.LocalTime localTime9 = booking5.getStartTime();
        java.time.LocalDate localDate10 = booking5.getBookingDate();
        boolean boolean12 = booking5.pay((double) (short) 10);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertNull(localTime9);
        org.junit.Assert.assertNull(localDate10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        booking6.setBookingId((int) (short) 100);
        java.time.LocalTime localTime9 = booking6.getEndTime();
        java.time.LocalTime localTime10 = booking6.getStartTime();
        org.junit.Assert.assertNull(localTime9);
        org.junit.Assert.assertNull(localTime10);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 35, 0, (int) (byte) 100, localDate3, localTime4, localTime5);
        java.lang.String str7 = booking6.toString();
        int int8 = booking6.getBookingID();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Booking{id=35, bookerId=0, roomId=100, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str7, "Booking{id=35, bookerId=0, roomId=100, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 35 + "'", int8 == 35);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, 0, 0, localDate3, localTime4, localTime5);
        java.time.LocalDate localDate7 = null;
        booking6.setDate(localDate7);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy9 = null;
        booking6.setPaymentStrategy(paymentStrategy9);
        java.time.LocalDate localDate11 = null;
        booking6.setBookingDate(localDate11);
        java.time.LocalTime localTime13 = booking6.getStartTime();
        booking6.setId((java.lang.Integer) 100);
        org.junit.Assert.assertNull(localTime13);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) 1, (-1), localDate2, localTime3, localTime4);
        int int6 = booking5.getBookingID();
        com.group13.roombookingsystem.model.room.Room room7 = null;
        booking5.setRoomBooked(room7);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + (-1) + "'", int6 == (-1));
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) 10, 1, localDate2, localTime3, localTime4);
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        com.group13.roombookingsystem.model.room.Room room12 = booking5.getRoomBooked();
        java.time.LocalTime localTime13 = null;
        booking5.setStartTime(localTime13);
        org.junit.Assert.assertNull(room12);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        booking5.setBookingId(1);
        java.time.LocalDate localDate10 = null;
        booking5.setBookingDate(localDate10);
        java.time.LocalDate localDate12 = booking5.getBookingDate();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy13 = booking5.getPaymentStrategy();
        boolean boolean15 = booking5.pay((double) (byte) 1);
        int int16 = booking5.getUserId();
        java.time.LocalDate localDate17 = null;
        java.time.LocalTime localTime18 = null;
        java.time.LocalTime localTime19 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean20 = booking5.overlaps(localDate17, localTime18, localTime19);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.equals(Object)\" because \"this.bookingDate\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(localDate12);
        org.junit.Assert.assertNull(paymentStrategy13);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) (-1), (int) (short) 10, 10, localDate3, localTime4, localTime5);
        boolean boolean8 = booking6.pay((double) 0.0f);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getDepositAmount();
        com.group13.roombookingsystem.model.user.User user9 = booking5.getBooker();
        boolean boolean10 = booking5.hasCheckedIn();
        java.time.LocalDate localDate11 = booking5.getDate();
        com.group13.roombookingsystem.model.room.Room room12 = null;
        booking5.setRoomBooked(room12);
        java.time.LocalDate localDate14 = null;
        java.time.LocalTime localTime15 = null;
        java.time.LocalTime localTime16 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = booking5.overlaps(localDate14, localTime15, localTime16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDate.equals(Object)\" because \"this.bookingDate\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNull(user9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNull(localDate11);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        java.time.LocalDate localDate8 = booking5.getDate();
        java.lang.Integer int9 = booking5.getId();
        int int10 = booking5.getUserId();
        java.time.LocalTime localTime11 = booking5.getStartTime();
        java.time.LocalDate localDate12 = booking5.getDate();
        org.junit.Assert.assertNull(localDate8);
        org.junit.Assert.assertNull(int9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + (-1) + "'", int10 == (-1));
        org.junit.Assert.assertNull(localTime11);
        org.junit.Assert.assertNull(localDate12);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (short) 0, (int) (short) 0, localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        booking5.checkIn();
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 35, 10, (int) (byte) 100, localDate3, localTime4, localTime5);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) 1, (int) (short) 0, (int) (byte) 1, localDate3, localTime4, localTime5);
        booking6.setBookingId(10);
        java.time.LocalTime localTime9 = booking6.getStartTime();
        org.junit.Assert.assertNull(localTime9);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) '#', 35, localDate2, localTime3, localTime4);
        java.time.LocalDate localDate6 = booking5.getDate();
        java.lang.Integer int7 = booking5.getId();
        java.lang.String str8 = booking5.toString();
        org.junit.Assert.assertNull(localDate6);
        org.junit.Assert.assertNull(int7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "Booking{id=null, bookerId=35, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}" + "'", str8, "Booking{id=null, bookerId=35, roomId=35, bookingDate=null, startTime=null, endTime=null, depositAmount=0, hasCheckedIn=false, booker=null, roomBooked=null, paymentStrategy=null}");
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test248");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.user.User user6 = null;
        booking5.setBooker(user6);
        booking5.setBookingId(1);
        java.time.LocalDate localDate10 = null;
        booking5.setBookingDate(localDate10);
        java.time.LocalDate localDate12 = booking5.getBookingDate();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy13 = booking5.getPaymentStrategy();
        boolean boolean15 = booking5.pay((double) (byte) 1);
        int int16 = booking5.getUserId();
        java.time.LocalTime localTime17 = null;
        booking5.setStartTime(localTime17);
        org.junit.Assert.assertNull(localDate12);
        org.junit.Assert.assertNull(paymentStrategy13);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test249");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        int int8 = booking5.getUserId();
        java.time.LocalTime localTime9 = booking5.getStartTime();
        int int10 = booking5.getRoomId();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy11 = null;
        booking5.setPaymentStrategy(paymentStrategy11);
        int int13 = booking5.getRoomId();
        int int14 = booking5.getDepositAmount();
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertNull(localTime9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 35 + "'", int10 == 35);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 35 + "'", int13 == 35);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test250");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (short) 1, (int) (byte) 1, localDate2, localTime3, localTime4);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test251");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        booking5.setBookingId((int) '#');
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setBookingId((int) (byte) 0);
        java.time.LocalTime localTime14 = booking5.getStartTime();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy15 = null;
        booking5.setPaymentStrategy(paymentStrategy15);
        org.junit.Assert.assertNull(localTime14);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test252");
        java.time.LocalDate localDate3 = null;
        java.time.LocalTime localTime4 = null;
        java.time.LocalTime localTime5 = null;
        com.group13.roombookingsystem.model.booking.Booking booking6 = new com.group13.roombookingsystem.model.booking.Booking((java.lang.Integer) (-1), (int) (short) 10, 10, localDate3, localTime4, localTime5);
        int int7 = booking6.getRoomId();
        int int8 = booking6.getBookingID();
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy9 = booking6.getPaymentStrategy();
        java.time.LocalDate localDate10 = null;
        booking6.setBookingDate(localDate10);
        int int12 = booking6.getDepositAmount();
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 10 + "'", int7 == 10);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertNull(paymentStrategy9);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test253");
        java.time.LocalDate localDate2 = null;
        java.time.LocalTime localTime3 = null;
        java.time.LocalTime localTime4 = null;
        com.group13.roombookingsystem.model.booking.Booking booking5 = new com.group13.roombookingsystem.model.booking.Booking((int) (byte) -1, (int) '#', localDate2, localTime3, localTime4);
        com.group13.roombookingsystem.model.payment.PaymentStrategy paymentStrategy6 = null;
        booking5.setPaymentStrategy(paymentStrategy6);
        com.group13.roombookingsystem.model.user.User user8 = null;
        booking5.setBooker(user8);
        com.group13.roombookingsystem.model.room.Room room10 = null;
        booking5.setRoomBooked(room10);
        booking5.setDepositAmount((int) (byte) 10);
        java.time.LocalDate localDate14 = null;
        booking5.setBookingDate(localDate14);
        com.group13.roombookingsystem.model.user.User user16 = null;
        booking5.setBooker(user16);
        booking5.setBookingId((int) (short) 0);
        int int20 = booking5.getDepositAmount();
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 10 + "'", int20 == 10);
    }
}


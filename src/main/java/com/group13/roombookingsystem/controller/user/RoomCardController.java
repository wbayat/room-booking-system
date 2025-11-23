package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.service.BookingService;
import com.group13.roombookingsystem.service.RoomService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RoomCardController implements Initializable {
    public Label roomID;
    public Label roomLocation;
    public Label roomCapacity;
    public Label sensorID;
    public DatePicker checkInDate;
    public ComboBox<LocalTime> checkinTime;
    public ComboBox<LocalTime> checkoutTime;
    public Button bookButton;
    public HBox iconBox;
    public ImageView projectorIcon;
    public ImageView speakerIcon;

    public List<LocalTime> list = new ArrayList<>();

    private Room room;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        checkInDate.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isBefore(LocalDate.now()) || date.isAfter(LocalDate.now().plusDays(30)));
            }
        });
    }

    public void setData(Room room){
        this.room = room;
        LocalTime time = LocalTime.of(9, 0);
        for(int i = 0; i < 13; i++) {
            list.add(time);
            time = time.plusHours(1);
        }

        roomID.setText(room.getRoomName());
        roomLocation.setText(room.getLocation());
        roomCapacity.setText(String.valueOf(room.getCapacity()));
        sensorID.setText(String.valueOf(room.getSensorId()));
        checkinTime.getItems().addAll(list);
        checkoutTime.getItems().addAll(list);
        if (!room.getHasProjector()){
            projectorIcon.setVisible(false);
        }
        if (!room.getHasSpeakers()){
            speakerIcon.setVisible(false);
        }
    }

    public void handleBookRoom(ActionEvent actionEvent) {
//        BookingService.getInstance().
    }
}

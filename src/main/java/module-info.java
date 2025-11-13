module com.group13.roombookingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.opencsv;
    requires javafx.graphics;
    requires org.apache.commons.logging;

    opens com.group13.roombookingsystem.controller to javafx.fxml;
    opens com.group13.roombookingsystem.view to javafx.graphics, javafx.fxml;

    exports com.group13.roombookingsystem;
    exports com.group13.roombookingsystem.view;

}
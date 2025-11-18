module com.group13.roombookingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.sql;
    requires com.group13.roombookingsystem;

    opens com.group13.roombookingsystem.controller to javafx.fxml;
    opens com.group13.roombookingsystem.view to javafx.graphics, javafx.fxml;

    exports com.group13.roombookingsystem;
    exports com.group13.roombookingsystem.view;
    opens com.group13.roombookingsystem.controller.user to javafx.fxml;
    opens com.group13.roombookingsystem.controller.user.admin to javafx.fxml;
    opens com.group13.roombookingsystem.controller.user.admin.chief to javafx.fxml;

}
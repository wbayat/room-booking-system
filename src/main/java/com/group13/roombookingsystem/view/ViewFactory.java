package com.group13.roombookingsystem.view;

import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.model.user.Admin;
import com.group13.roombookingsystem.model.user.ChiefEventCoordinator;

import java.io.IOException;

public class ViewFactory {

    public static UserView createUserView(User user) throws IOException {

        if (user instanceof ChiefEventCoordinator) {
            return new ChiefView();
        }

        if (user instanceof Admin) {
            return new AdminView();
        }

        return new UserView();
    }
}

package com.group13.roombookingsystem.model.payment;

public interface PaymentStrategy {
    boolean pay(double amount);
    void setID(int id);
    int getID();


}

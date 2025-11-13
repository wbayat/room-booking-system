package com.group13.roombookingsystem.model.payment;

public class DebitCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String pin;

    public DebitCardPaymentStrategy(String cardNumber, String cardHolderName, String pin) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.pin = pin;
    }

    @Override
    public boolean pay(double amount) {
        return true;
    }

}

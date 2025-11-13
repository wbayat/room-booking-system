package com.group13.roombookingsystem.model.payment;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext() {}

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean pay(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment method selected.");
            return false;
        }
        return paymentStrategy.pay(amount);
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }
}

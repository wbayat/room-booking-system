package com.group13.roombookingsystem.model.payment;

/**
 * Context holder for the payment strategy pattern. The context is mutable so
 * callers can reuse a single instance when processing multiple payments.
 */
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public synchronized void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        if (paymentStrategy == null) {
            throw new IllegalArgumentException("Payment strategy cannot be null.");
        }
        this.paymentStrategy = paymentStrategy;
    }

    public synchronized PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public synchronized boolean pay(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy has not been set.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Payment amount cannot be negative.");
        }
        return paymentStrategy.pay(amount);
    }
}


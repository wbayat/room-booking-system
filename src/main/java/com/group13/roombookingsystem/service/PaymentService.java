package com.group13.roombookingsystem.service;

import com.group13.roombookingsystem.model.payment.PaymentStrategy;

/**
 * Facade for executing payments using the strategy pattern. All mutations are
 * synchronized to avoid side effects when the same context is shared across
 * multiple booking workflows.
 */
public class PaymentService {
//    private final PaymentContext paymentContext;
//
//    public PaymentService() {
//        this(new PaymentContext());
//    }
//
//    public PaymentService(PaymentContext paymentContext) {
//        if (paymentContext == null) {
//            throw new IllegalArgumentException("Payment context cannot be null.");
//        }
//        this.paymentContext = paymentContext;
//    }
//
//    public synchronized boolean processPayment(PaymentStrategy paymentStrategy, double amount) {
//        if (paymentStrategy == null) {
//            throw new IllegalArgumentException("Payment strategy must be provided.");
//        }
//        if (amount < 0) {
//            throw new IllegalArgumentException("Payment amount cannot be negative.");
//        }
//        paymentContext.setPaymentStrategy(paymentStrategy);
//        return paymentContext.pay(amount);
//    }
//
//    public PaymentContext getPaymentContext() {
//        return paymentContext;
//    }
}


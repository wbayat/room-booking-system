package com.group13.roombookingsystem.model.payment;

public class InstitutionalBillingPaymentStrategy implements PaymentStrategy {
    private String institutionAccountId;
    private String departmentName;

    public InstitutionalBillingPaymentStrategy(String institutionAccountId, String departmentName) {
        this.institutionAccountId = institutionAccountId;
        this.departmentName = departmentName;
    }

    @Override
    public boolean pay(double amount) {
        return true;
    }
}

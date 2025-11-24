package com.group13.roombookingsystem.model.payment;

public class InstitutionalBillingPaymentStrategy implements PaymentStrategy {
    private final String departmentName;
    private final String accountId;

    public InstitutionalBillingPaymentStrategy(String departmentName, String accountId) {
        this.departmentName = departmentName;
        this.accountId = accountId;
    }

    @Override
    public boolean pay(double amount) {
        return true;
    }

    private int id;

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getAccountId() {
        return accountId;
    }
}

package com.group13.roombookingsystem.model.payment;

public class InstitutionalBillingPaymentStrategy implements PaymentStrategy {
    private String departmentName;

    public InstitutionalBillingPaymentStrategy(String departmentName) {
        this.departmentName = departmentName;
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
}

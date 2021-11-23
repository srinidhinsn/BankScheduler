package com.distarise.bank.model;

public class Transaction {
    private double previousBalance = 1000;
    private double currrentBalance = 2000;

    public double getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(double previousBalance) {
        this.previousBalance = previousBalance;
    }

    public double getCurrrentBalance() {
        return currrentBalance;
    }

    public void setCurrrentBalance(double currrentBalance) {
        this.currrentBalance = currrentBalance;
    }
}

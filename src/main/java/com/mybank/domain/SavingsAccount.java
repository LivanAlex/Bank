package com.mybank.domain;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;


    }

    public void accumulateInterest() {
        balance = balance + (balance * (interestRate / 12));
    }
}

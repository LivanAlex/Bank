package com.mybank.domain;

public class Account {
    protected double balance;

    protected Account(double initBalance) {
        balance = initBalance;
    }

    public void deposit(double amt) {
        balance += amt;
    }

    public void withdraw(double amt) throws OverdraftException {
        if (balance >= amt) {
            balance -= amt;
        } else {
            throw new OverdraftException("Insufficient funds", amt - balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

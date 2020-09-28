package com.mybank.domain;

public class CheckingAccount extends Account{

    private double overdraftAmount;

    public CheckingAccount(double initBalance, double overdraftAmount){
        super(initBalance);
        this.overdraftAmount = overdraftAmount;
    }
    public CheckingAccount(double initBalance){
        super(initBalance);
        this.overdraftAmount = 0.0;
    }

    @Override
    public void withdraw (double amt) throws OverdraftException {
        // if balance equals or more than withdraw amount
        if(balance >= amt){
            // subtract amt from balance
            balance -= amt;
        } else {
            // if amount less or equals than balance and overdraft
            if (amt <= balance + overdraftAmount){
                // subtract amt from balance and overdraftAmount
                overdraftAmount -= amt - balance;
                balance = 0.0;
            } else {
                // not enough money
                throw new OverdraftException("Insufficient funds for overdraft protection", amt - balance - overdraftAmount);
            }
        }
    }
}

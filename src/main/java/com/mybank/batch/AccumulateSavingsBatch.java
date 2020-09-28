package com.mybank.batch;

import com.mybank.domain.Account;
import com.mybank.domain.Bank;
import com.mybank.domain.Customer;
import com.mybank.domain.SavingsAccount;

public class AccumulateSavingsBatch {
    public void doBatch(){
        for (Customer customer: Bank.getCustomers()) {
            for (Account account: customer.getAccounts()) {
                if(account instanceof SavingsAccount){
                    SavingsAccount tempAcc = (SavingsAccount) account;
                    tempAcc.accumulateInterest();
                }
            }
        }
    }
}

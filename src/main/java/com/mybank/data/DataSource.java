package com.mybank.data;

import com.mybank.domain.Bank;
import com.mybank.domain.CheckingAccount;
import com.mybank.domain.Customer;
import com.mybank.domain.SavingsAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataSource {
    private File datafile;
    public DataSource(String dataFilePath){
        datafile = new File(dataFilePath);
    }
    public void loadData() throws FileNotFoundException {
        Scanner scanner = new Scanner(datafile);

        int numberOfClients = scanner.nextInt();

        for (int i = 0; i < numberOfClients; i++) {
            String clientName;
            String clientLastName;

            clientName = scanner.nextLine();
            clientLastName = scanner.nextLine();
            Bank.addCustomer(clientName, clientLastName);

            int numOfAccounts;
            numOfAccounts = scanner.nextInt();
            for (int j = 0; j < numOfAccounts; j++) {
                char accountType;
                double initialBalance;
                double secondNum;
                accountType = scanner.nextLine().charAt(0);
                initialBalance = scanner.nextDouble();
                secondNum = scanner.nextDouble();
                switch (accountType) {
                    case 'S' :
                        Bank.getCustomer(i).addAccount(new SavingsAccount(initialBalance, secondNum));
                    case 'C' :
                        Bank.getCustomer(i).addAccount(new CheckingAccount(initialBalance, secondNum));
                }
            }
        }



    }
}

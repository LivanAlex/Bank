package com.mybank.domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static List<Customer> customers;

    static{
        customers = new ArrayList<Customer>();
    }

    private Bank() {
    }

    public static void addCustomer(String firstName, String lastName) {
        customers.add(new Customer(firstName, lastName));
    }

    public static int getNumOfCustomers() {
        return customers.size();
    }

    public static Customer getCustomer(int index) {
        return customers.get(index);
    }

    public static List<Customer> getCustomers() {
        return customers;
    }
}

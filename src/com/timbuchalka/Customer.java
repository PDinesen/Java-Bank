package com.timbuchalka;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name) {
        this.name = name;
        transactions = new ArrayList<Double>();
    }

    public void addTransaction(double amount){
        transactions.add(amount);
        System.out.println(amount + " added to the transactions of " + name);
    }

    public String getName() {
        return name;
    }


    public void getTransactions(){
        double balance =0;
        System.out.println("Transactions for " + name + ": ");
        for (int i = 0; i < transactions.size();i++){
            balance += transactions.get(i);
            System.out.println((i+1) + ". transaction was " + transactions.get(i) +
                    ". The balance is now " + balance);
        }
    }
}

package com.timbuchalka;

import javax.swing.text.Position;
import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customerArrayList;

    public Branch(String name) {
        this.name = name;
        this.customerArrayList = new ArrayList<Customer>();
    }

    public void addCustomer(String name){
        Customer customer = new Customer(name);
        customerArrayList.add(customer);
        System.out.println(customer.getName() + " has been added to the branch " + this.name);
    }

    public String getName() {
        return name;
    }

    public int numCustomer(){
        return customerArrayList.size();
    }


    public void addTransactionToCustomer(String name, double amount){
        int position = searchNamePosition(name);
        if (position < 0){
            System.out.println("No customer with name " + name + " in branch " + this.name);
        } else {
            customerArrayList.get(position).addTransaction(amount);
        }
    }

    public void getTransaction(String name){
        int position = searchNamePosition(name);
        if (position < 0){
            System.out.println("No customer named " + name + " in the branch " + this.name);
        } else {
            customerArrayList.get(position).getTransactions();
        }
    }

    public void getTransaction(int position){
        if (position < 1 || position > customerArrayList.size()){
            System.out.println("Position out of bounds. Choose between 1 and " + customerArrayList.size());
        } else {
            getTransaction(customerArrayList.get(position-1).getName());
        }
    }

    public int searchNamePosition(String name){

        for (int i = 0; i < customerArrayList.size();i++){
            if (this.customerArrayList.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public Customer getCustomer(int position){
        if (position < 0){
            return null;
        } else {
            return customerArrayList.get(position);
        }
    }

    public Customer getCustomer(String name){
        int position =  searchNamePosition(name);
        return getCustomer(position);

    }

    public void printCustomers(){
        System.out.println("The customers in branch " + this.name + " is:");
        for (int i = 0 ; i < customerArrayList.size(); i++){
            System.out.println((i+1) + ". " + customerArrayList.get(i).getName());
        }
    }
}

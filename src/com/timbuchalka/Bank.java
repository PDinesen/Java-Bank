package com.timbuchalka;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }

    public String getName() {
        return name;
    }

    public void addBranch(String name){
        Branch branch = new Branch(name);
        branches.add(branch);
        System.out.println(branch.getName() + " has been added to the bank " + this.name);
    }

    public int numBranches(){
        return branches.size();
    }

    public void addCustomer(String branch,String customer){
        int position = searchBranch(branch);
        if (position < 0){
            System.out.println("No branch named " + branch + " in the bank " + this.name);
        } else {
            branches.get(position).addCustomer(customer);
        }
    }

    public void addTransaction(String branch, String customer, double amount){
        int position = searchBranch(branch);
        if (position < 0){
            System.out.println("No branch named " + branch + " in the bank " + this.name);
        } else {
            int position2 = branches.get(position).searchNamePosition(customer);
            if (position2 < 0 ){
                System.out.println("In branch " + branch +
                        " there is no customer named " + customer);
            } else {
                branches.get(position).addTransactionToCustomer(customer, amount);
            }
        }
    }

    public void printBranches(){
        System.out.println("The branches in " + name + " is: ");
        for (int i = 0; i <  branches.size();i++){
            System.out.println((i+1) + ". " + branches.get(i).getName());
        }
    }

    public void printCustomer(String branch){
        int position = searchBranch(branch);
        if (position < 0){
            System.out.println("No branch named " + branch + " in bank " + this.name);
        } else {
            branches.get(position).printCustomers();
        }
    }

    public Branch getBranch(String name){
        int position = searchBranch(name);
        if (position < 0){
            return null;
        }
        return branches.get(position);
    }

    public String getCustomer(String branch, int position2){
        int position =  searchBranch(branch);
        return branches.get(position).getCustomer(position2).getName();
    }


    public void getTransactions(String branch, String customer){
        int position = searchBranch(branch);
        if (position < 0){
            System.out.println("No branch named " + branch + " in bank " + this.name);
        } else {
            branches.get(position).getTransaction(customer);
        }
    }

    public int searchBranch(String name){
        for (int i = 0; i < branches.size();i++){
            if (branches.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public String branchFromPosition(int position){
        if (position < 0){
            return null;
        } else {
            return branches.get(position).getName();
        }
    }
}

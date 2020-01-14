package com.timbuchalka;

import java.util.Scanner;

// You job is to create a simple banking application.
// There should be a Bank class
// It should have an arraylist of Branches
// Each Branch should have an arraylist of Customers
// The Customer class should have an arraylist of Doubles (transactions)
// Customer:
// Name, and the ArrayList of doubles.
// Branch:
// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch
// Bank:
// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions
// Demonstration autoboxing and unboxing in your code
// Hint: Transactions
// Add data validation.
// e.g. check if exists, or does not exist, etc.
// Think about where you are adding the code to perform certain actions
public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Bank mybank = new Bank("Jobcenteret");

    public static void main(String[] args) {
	// write your code here
        /*
        Customer customer = new Customer("Patrick");
        customer.addTransaction(12.42);
        customer.addTransaction(645);
        customer.getTransactions();
        System.out.println("");
        Branch branch = new Branch("LSB");
        branch.addCustomer("Ole");
        branch.addTransactionToCustomer("Ole",10);
        branch.addCustomer("Patrick");
        branch.addTransactionToCustomer("Patrick",10);
        branch.getCustomer("Ole").getTransactions();
        branch.printCustomers();
        branch.getTransaction(1);
        branch.addCustomer("Daniel");
        branch.addTransactionToCustomer("Daniel", 1000000);
        branch.addTransactionToCustomer("Daniel", 1000);
        branch.printCustomers();
        branch.getTransaction("Daniel");
        System.out.println("");*/
//        sc.nextDouble();
//        Bank bank = new Bank("Danmark");
//        bank.addBranch("DanskeBank");
//        bank.addBranch("LSB");
//        bank.printBranches();
//        bank.addCustomer("LSB","Patrick");
//        bank.addTransaction("LSB","Patrick",10);
//        bank.addCustomer("LSB","Daniel");
//        bank.printCustomer("LSB");
//        bank.getTransactions("LSB","Patrick");
//        bank.addTransaction("LSB","Patrick",10.1);
        enterBank();

    }

    private static void enterBank(){
        boolean quit = false;
        openBank();
        printActionsBank();

        while (!quit) {

            System.out.println("\nEnter action: ");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("The bank " + mybank.getName() + " is now closed");
                    quit = true;
                    break;
                case 1:
                    createBranch();
                    break;
                case 2:
                    enterBranch();
                    break;
                case 3:
                    mybank.printBranches();
                    break;
                case 4:
                    printActionsBank();
                    break;
                default:
                    System.out.println("Invalid action. Enter an integer between 0 and 4. 4 for list of action");
                    break;
            }
        }
    }

    private static void enterBranch(){
        if (mybank.numBranches() == 0){
            System.out.println("There are no branches jet.");
            return;
        }
        System.out.println("With branch do you want to enter? Choose either position or name at: ");
        mybank.printBranches();
        String name = "";
        if (sc.hasNextInt()){
            int position = sc.nextInt() - 1;
            name = mybank.branchFromPosition(position);
        } else {
            name = sc.nextLine();
        }
        System.out.println("You have enteret branch " + name );
        printActionsBranches();
        boolean quitbranch = false;
        while (!quitbranch){
            System.out.println("\nEnter action: ");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("The branch " + name + " is now closed. Return to bank " + mybank.getName());
                    quitbranch = true;
                    break;
                case 1:
                    createCustomer(name);
                    break;
                case 2:
                    getTransactions(name);
                    break;
                case 3:
                    addTransaction(name);
                    break;
                case 4:
                    mybank.printCustomer(name);
                    break;
                case 5:
                    printActionsBranches();
                    break;
                default:
                    System.out.println("Invalid action");
                    break;
            }
        }
    }

    private static void addTransaction(String branchname){
        mybank.printCustomer(branchname);
        System.out.println("Which customer as made a transaction: ");
        String name = "";
        if (sc.hasNextInt()){
            int position = sc.nextInt() -1;
            sc.nextLine();
            name = mybank.getBranch(branchname).getCustomer(position).getName();
        }
        name = sc.nextLine();        System.out.println("What is the amount? Double is possible like 10,1. Not 10.1: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        mybank.addTransaction(branchname,name,amount);
    }

    private static void getTransactions(String branchname){
        if (mybank.getBranch(branchname).numCustomer() == 0){
            System.out.println("There are no customers jet.");
            return;
        }
        mybank.printCustomer(branchname);
        System.out.println("Choose which customer in " + branchname + " that have made a transaction:");
        String name = "";
        if (sc.hasNextInt()){
            int position = sc.nextInt() -1;
//            sc.nextLine();
            name = mybank.getBranch(branchname).getCustomer(position).getName();
        }
        name = sc.nextLine();
        mybank.getTransactions(branchname,name);
    }

    private static void createCustomer(String branchname){
        System.out.println("You are about to create a new customer in the bank " + mybank.getName() +
                "and branch " + branchname + "\nWhat is the name of the customer: ");
        String name = sc.nextLine();
        mybank.addCustomer(branchname,name);
    }

    private static void createBranch(){
        System.out.println("You are about to create a new branch in the bank " + mybank.getName() +
                "\nWhat is the name of the branch: ");
        String name = sc.nextLine();
        mybank.addBranch(name);
    }

    private static void openBank(){
        System.out.println("The bank " + mybank.getName() +
                " is now open for transactions of new and existing " +
                "customers in different braches");
    }

    private static void printActionsBank(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to close bank\n" +
                "1 - to create a new branch\n" +
                "2 - to enter an existing branch\n" +
                "3 - to get a list of branches\n" +
                "4 - to print a list of available actions.");
        System.out.println("Choose your action: ");

    }

    private static void printActionsBranches(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - Return to bank\n" +
                "1 - to create a new customer\n" +
                "2 - to get transaction of an customer\n" +
                "3 - to add a transaction to a customer\n" +
                "4 - to get a list of customers\n" +
                "5 - to print a list of available actions.");
        System.out.println("Choose your action: ");

    }
}

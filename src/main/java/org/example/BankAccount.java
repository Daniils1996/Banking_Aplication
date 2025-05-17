package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Changes?
public class BankAccount {
    String accountHolder;
    double balance;
    LinkedList<String> transactionHistory = new LinkedList<>();

    public BankAccount(String accountHolder, double balance){
        this.accountHolder = accountHolder;
        this.balance = balance;
        addTransaction("Account created with balance: " + balance);
    }
    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    public void setTransactionHistory(LinkedList<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        if (amount <=0){
            System.out.println("Deposit ammount must be positive: ");
            return;
        }
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
        System.out.println("You deposited: " + amount);

    }

    public void withdraw(double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("Withdrawal amount must be positive!");
        }
        if (amount > balance){
            throw new IllegalArgumentException("Insufficient funds. Cannot withdraw more than balance.");
        }else {
            balance -= amount;
            transactionHistory.add("Withdraw: " + amount);
            System.out.println("You withdrew: " + amount);
        }
    }

    public void printBalance(){
        System.out.printf("%s, your balance is: %.2f%n", accountHolder, balance);
    }

    private void addTransaction(String entry) {
        if (transactionHistory.size() == 10) {
            transactionHistory.removeFirst(); // Remove oldest
        }
        transactionHistory.addLast(entry); // Add newest
    }
}

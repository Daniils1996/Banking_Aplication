package org.example;

//Changes?
public class BankAccount {
    String accountHolder;
    double balance;


    public BankAccount(String accountHolder, double balance){
        this.accountHolder = accountHolder;
        this.balance = balance;
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
        System.out.println("You deposited: " + balance);

    }

    public void withdraw(double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("Withdrawal amount must be positive!");
        }
        if (amount > balance){
            throw new IllegalArgumentException("Insufficient funds. Cannot withdraw more than balance.");
        }else {
            balance -= amount;
            System.out.println("You withdrew: " + amount);
        }
    }

    public void printBalance(){
        System.out.printf("%s, your balance is: %.2f%n", accountHolder, balance);
    }

}

package org.example;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @org.junit.jupiter.api.Test
    void getAccountHolder() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        assertEquals("Alice", account.getAccountHolder());
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        assertEquals(1000,
                account.getBalance(), 0.001);
    }

    @org.junit.jupiter.api.Test
    void setAccountHolder() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        account.setAccountHolder("Bob");
        assertEquals("Bob", account.getAccountHolder());
    }

    @org.junit.jupiter.api.Test
    void setBalance() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        account.setBalance(2000);
        assertEquals(2000,
                account.getBalance(), 0.001);
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        BankAccount account = new BankAccount("Alice",1000);
        account.deposit(500);
        assertEquals(1500, account.getBalance(), 0.001);
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        BankAccount account = new BankAccount("Alice",1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance(), 0.001);
    }

    @org.junit.jupiter.api.Test
    void printBalance() {
        BankAccount account = new BankAccount("Alice",1000);
        assertEquals(1000, account.getBalance(), 0.001);
    }
}
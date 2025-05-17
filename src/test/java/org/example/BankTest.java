package org.example;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    @org.junit.jupiter.api.Test
    void testGetAccountHolder() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        assertEquals("Alice", account.getAccountHolder());
    }

    @org.junit.jupiter.api.Test
    void testSetAccountHolder() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        account.setAccountHolder("Bob");
        assertEquals("Bob", account.getAccountHolder());
    }

    @org.junit.jupiter.api.Test
    void testGetBalance() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        assertEquals(1000, account.getBalance(), 0.001);
    }

    @org.junit.jupiter.api.Test
    void testSetBalance() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        account.setBalance(2000);
        assertEquals(2000, account.getBalance(), 0.001);
    }

    @org.junit.jupiter.api.Test
    void testDepositWithValidAmount() {
        BankAccount account = new BankAccount("Bob", 500);
        account.deposit(200);
        assertEquals(700, account.getBalance(), 0.001);
    }

    @org.junit.jupiter.api.Test
    void testDepositWithNegativeAmount() {
        BankAccount account = new BankAccount("Bob", 500);
        account.deposit(-200);
        assertEquals(500, account.getBalance(), 0.001);
    }

    @org.junit.jupiter.api.Test
    void testWithdrawWithSufficientFunds() {
        BankAccount account = new BankAccount("John",2000);
        account.withdraw(500);
        assertEquals(1500, account.getBalance(), 0.001);
    }

    @org.junit.jupiter.api.Test
    void testWithdrawWithInsufficientFunds() {
        BankAccount account = new BankAccount("John",2000);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
            account.withdraw(2500);
        });
        assertEquals("Insufficient funds. Cannot withdraw more than balance.", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void testWithdrawWithNegativeAmount() {
        BankAccount account = new BankAccount("John",2000);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
            account.withdraw(-500);
        });
        assertEquals("Withdrawal amount must be positive!", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void testPrintBalance() {
        BankAccount account = new BankAccount("Alice",1000);
        assertEquals(1000, account.getBalance(), 0.001);
    }
}
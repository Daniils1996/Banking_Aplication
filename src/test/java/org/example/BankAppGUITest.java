package org.example;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAppGUITest {

    @org.junit.jupiter.api.Test
    void testInitialBalanceDisplayedCorrectly() {

    }

    @org.junit.jupiter.api.Test
    void testDepositUpdatesBalanceLabel() {
        BankAccount account = new BankAccount("Bob", 100.0);
        JLabel label = new JLabel();
        BankAppGUI gui = new BankAppGUI(account, label);

        account.deposit(50.0);
        gui.updateBalanceLabel();

        assertEquals("Balance: 150.0", label.getText());

    }

    @org.junit.jupiter.api.Test
    void testWithdrawUpdatesBalanceLabel() {
        BankAccount account = new BankAccount("Bob", 200.0);
        JLabel balanceLabel = new JLabel();
        BankAppGUI gui = new BankAppGUI(account,balanceLabel);

        account.withdraw(50);
        gui.updateBalanceLabel();

        assertEquals("Balance: 150.0", balanceLabel.getText());
    }

    @org.junit.jupiter.api.Test
    void testInvalidDepositShowsErrorMessage() {
        // TODO: Simulate entering invalid deposit amount
    }

    @org.junit.jupiter.api.Test
    void testWithdrawWithInsufficientFundsShowsError() {
        // TODO: Simulate withdrawing more than available
    }

    @org.junit.jupiter.api.Test
    void testCheckBalanceButtonDisplaysCorrectValue() {
        // TODO: Simulate button click and validate message dialog
    }

    @org.junit.jupiter.api.Test
    void testExitButtonClosesApplication() {
        // TODO: Simulate clicking exit button
    }

}
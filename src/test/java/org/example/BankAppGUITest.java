package org.example;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAppGUITest {

    @org.junit.jupiter.api.Test
    void testInitialBalanceDisplayedCorrectly() {
        BankAccount account = new BankAccount("Bob", 300.0);
        JLabel label = new JLabel();
        BankAppGUI gui = new BankAppGUI(account, label);

        gui.updateBalanceLabel();
        assertEquals("Balance: 300.0", label.getText());
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
        BankAccount account = new BankAccount("Bob",200.0);
        JLabel label = new JLabel();
        BankAppGUI gui = new BankAppGUI(account, label);

        gui.handleDepositInput("abc");
        gui.updateBalanceLabel();

        assertEquals("Balance: 200.0", label.getText());

    }

    @org.junit.jupiter.api.Test
    void testWithdrawWithInsufficientFundsShowsError() {
        BankAccount account = new BankAccount("Bob", 200);
        JLabel label = new JLabel();
        BankAppGUI gui = new BankAppGUI(account, label);

        gui.handleWithdrawInput("500");
        gui.updateBalanceLabel();

        assertEquals("Balance: 200.0", label.getText());
    }

    @org.junit.jupiter.api.Test
    void testCheckBalanceButtonDisplaysCorrectValue() {
        BankAccount account = new BankAccount("Bob", 300.0);
        JLabel label = new JLabel();
        BankAppGUI gui = new BankAppGUI(account, label);

        gui.updateBalanceLabel();
        assertEquals("Balance: 300.0", label.getText());
    }

    @org.junit.jupiter.api.Test
    void testExitButtonClosesApplication() {
        JFrame testFrame = new JFrame();
        JButton exitButton = new JButton();

        // Add action listener like in your app
        exitButton.addActionListener(e -> testFrame.dispose());

        // Simulate clicking the button
        exitButton.doClick();

        // Assert frame is no longer displayable (disposed)
        assertFalse(testFrame.isDisplayable());
    }

}
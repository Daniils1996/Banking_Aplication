package org.example;

import javax.swing.*;

public class BankAppGUI {
    private BankAccount bankAccount;
    private JLabel balanceLabel;


    public BankAppGUI(){
        String name = JOptionPane.showInputDialog("Enter Account Holder: ");
        double balance = Double.parseDouble(JOptionPane.showInputDialog("Enter Initial Bilance: "));

        bankAccount = new BankAccount(name, balance);

        JFrame frame = new JFrame("Bank App");
        frame.setSize(300, 240);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        balanceLabel = new JLabel("Balance" + bankAccount.getBalance());
        balanceLabel.setBounds(50, 10, 200, 20);
        frame.add(balanceLabel);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(50, 40, 180, 30);
        frame.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50, 80, 180, 30);
        frame.add(withdrawButton);

        JButton balanceButton = new JButton("Check Balance");
        balanceButton.setBounds(50, 120, 180, 30);
        frame.add(balanceButton);

        JButton exitButton = new JButton("EXIT!");
        exitButton.setBounds(50, 160, 180, 30);
        frame.add(exitButton);

        depositButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter Amount to Deposit");
                if (input != null){
                    try {
                        double amount = Double.parseDouble(input);
                        if (amount <= 0){
                            JOptionPane.showMessageDialog(null, "Please Enter positive amount! ");
                        }else {
                            bankAccount.deposit(amount);
                            updateBalanceLabel();
                        }
                    }catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Invalid Input. Please Enter a numeric Value");
                    }
            updateBalanceLabel();
            }
        });

        withdrawButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter Amount to Withdraw");
                if (input != null){
                    try{
                        double amount = Double.parseDouble(input);
                        if (amount < 0){
                            JOptionPane.showMessageDialog(null, "Please Enter Positive amount!");
                        }else{
                            bankAccount.withdraw(amount);
                            updateBalanceLabel();
                        }
                    }catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Invalid Input. Please Enter a numeric Value");
                    }catch (IllegalArgumentException ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    updateBalanceLabel();
            }
        });

        balanceButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Balance" + bankAccount.getBalance());
        });

        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Goodbye");
            System.exit(0);
        });

        frame.setVisible(true);


    }
    public void updateBalanceLabel(){
        balanceLabel.setText("Balance: " + bankAccount.getBalance());
    }


}

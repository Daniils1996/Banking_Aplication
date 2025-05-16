package org.example;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        new BankAppGUI();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Acount holder: ");
        String accountHolder = scanner.nextLine();

        System.out.println("Enter your balance: ");
        double balance = scanner.nextDouble();

        BankAccount bankAccount = new BankAccount(accountHolder, balance);

        while (true){

            System.out.println("\n---Bank Menu---");
            System.out.println("1. Deposit.");
            System.out.println("2. Withdraw.");
            System.out.println("3. Check balance.");
            System.out.println("4. Exit.");


            System.out.println("Choose an option: ");

            int choise = scanner.nextInt();

            switch (choise){
                case 1:
                    System.out.println("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    bankAccount.printBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using app!");
                    return;
                default:
                    System.out.println("Invalid input, please try again!");
                    return;
            }

        }
    }
}

/*
--Saad--ATM.java
This program simulates a simple ATM interface where users can deposit, withdraw, and check their balance
Author: Saad
Date: 2024-06
*/

import java.util.Scanner;

public class ATM {

    static Scanner scanner = new Scanner(System.in);
    static String bankName = "MyBank";
    static double balance = 567.95; // Required starting balance

    public static void main(String[] args) {
        // 1. Ask the user for their first name
        System.out.print("Please enter your first name: ");
        String firstName = scanner.nextLine();

        // 2. Display welcome with their name
        myBankWelcome(firstName);

        int choice;
        do {
            myBankUserMenu();
            choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw(); // loops internally until valid withdrawal
                    break;
                case 3:
                    // 3. Display final balance and thank-you message on exit
                    System.out.printf("%nFinal Balance: $%.2f%n", balance);
                    System.out.println("Thank you for using " + bankName + ", " + firstName + ". Goodbye!");
                    break;
                default:
                    myMenuWarningMessage("Invalid option. Please select 1, 2, or 3.");
            }
        } while (choice != 3);

        scanner.close();
    }

    // Module 1: Welcome message (personalized with first name)
    public static void myBankWelcome(String firstName) {
        System.out.println("\n==========================================");
        System.out.println("    Welcome to " + bankName + " ATM, " + firstName + "!");
        System.out.println("==========================================");
        System.out.printf("    Current Balance: $%.2f%n", balance);
        System.out.println("==========================================\n");
    }

    // Module 2: User menu
    public static void myBankUserMenu() {
        System.out.println("\n------------------------------------------");
        System.out.println("              " + bankName + " Menu");
        System.out.println("------------------------------------------");
        System.out.println("  1 -> Deposit");
        System.out.println("  2 -> Withdraw");
        System.out.println("  3 -> Exit");
        System.out.println("------------------------------------------");
    }

    // Module 3: Menu warning message (customizable)
    public static void myMenuWarningMessage(String message) {
        System.out.println("\n[WARNING] " + message);
    }

    // Module 4: Withdraw warning message (customizable)
    public static void myWithdrawWarningMessage(String message) {
        System.out.println("\n[WARNING] " + message);
    }

    // Deposit logic
    public static void deposit() {
        System.out.println("\n--- Deposit ---");
        double amount = getDoubleInput("Enter deposit amount: $");

        if (amount <= 0) {
            myMenuWarningMessage("Deposit amount must be greater than $0.00.");
        } else {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f. New balance: $%.2f%n", amount, balance);
        }
    }

    // Withdraw logic — loops until a valid withdrawal or user has enough funds
    public static void withdraw() {
        System.out.println("\n--- Withdraw ---");

        while (true) {
            System.out.printf("Available balance: $%.2f%n", balance);
            double amount = getDoubleInput("Enter withdrawal amount: $");

            if (amount <= 0) {
                myMenuWarningMessage("Withdrawal amount must be greater than $0.00.");
            } else if (amount > balance) {
                // Keep asking again after warning
                myWithdrawWarningMessage(
                    String.format("Insufficient funds. You requested $%.2f but only $%.2f is available. Please try again.", amount, balance)
                );
            } else {
                balance -= amount;
                System.out.printf("Successfully withdrew $%.2f. New balance: $%.2f%n", amount, balance);
                break; // Exit loop only on successful withdrawal
            }
        }
    }

    // Helper: safely read an integer
    public static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } else {
                scanner.nextLine();
                myMenuWarningMessage("Invalid input. Please enter a whole number.");
            }
        }
    }

    // Helper: safely read a double
    public static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } else {
                scanner.nextLine();
                myMenuWarningMessage("Invalid input. Please enter a valid amount.");
            }
        }
    }
}
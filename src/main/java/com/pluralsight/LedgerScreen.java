package com.pluralsight;

import java.util.Scanner;
import java.util.ArrayList;

public class LedgerScreen {

    public static void ledgerScreen() {
        TransactionFileHelper helper = new TransactionFileHelper();
        ArrayList<Transaction> transactionList = helper.readAllTransactions();
        /*Ask the helper object to read all the transactions from the file,
        and store them inside an array list called transactionList*/
        Scanner scanner = new Scanner(System.in);
        char choice = ' ';

        do {
            System.out.println("\n===$$$ LEDGER MENU $$$===");
            System.out.println("A) All: Displays all entries");
            System.out.println("D) Deposits: Displays only the entries that are deposits into the account");
            System.out.println("P) Payments: Display only the negative entries (or payments)");
            System.out.println("R) Reports: A new screen that allows the user to run pre-defined reports");
            System.out.println("H) Home: Go back to the Home Screen");
            System.out.println("===$$$ LEDGER MENU $$$===");

            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("No input detected! — Choose a letter from the menu.");
                continue; // goes back to start of the loop
            }
            choice = Character.toUpperCase(line.charAt(0));

            // Chain of method that reads user input from the keyboard,
            // Converts to uppercase and takes the first character.

            switch (choice) {
                case 'A':
                    System.out.println("All: Display all entries");
                    displayAllTransactions(transactionList);
                    break;

                case 'D':
                    System.out.println("Deposits: Displays only the entries that are deposits into the account");
                    displayAllDeposits(transactionList);
                    break;

                case 'P':
                    System.out.println("Payments: Display only negative entries (or payments)");
                    displayAllPayments(transactionList);
                    break;
                // switches to ledger page with different options


                case 'R':
                    System.out.println("Reports: A new screen that allows the user to run pre-defined reports");
                    ReportScreen.reportScreen();// refresh
                    // refresh list in case new transactions were added elsewhere
                    transactionList = helper.readAllTransactions();
                    break;

                case 'H':
                    System.out.println("Home: Goes back to home screen");
                    // Goes back to home screen
                    break;

                case 'X':
                    System.out.println("Exit");
                    // Exits
                    break;

                default:
                    System.out.println("Invalid choice! Please try that again");


            }

        } while (choice != 'H');


    }

    // Helper Methods
    public static void displayAllTransactions(ArrayList<Transaction> transactionList) {
        System.out.println("\n===$$$ FULL TRANSACTION LIST (Most Recent First) $$$===");

        for (var i = transactionList.size() - 1; i >= 0; i--) {
            System.out.println(transactionList.get(i).toString());
        }
    }

    public static void displayAllDeposits(ArrayList<Transaction> transactionList) {
        System.out.println("\n\n=== LEDGER DEPOSIT LIST (Most Recent First) ===");

        for (var i = transactionList.size() - 1; i >= 0; i--) {
            if (transactionList.get(i).getAmount() >= 0) {
                System.out.println(transactionList.get(i).toString());
            }
        }
    }

    public static void displayAllPayments(ArrayList<Transaction> transactionList) {
        System.out.println("\n\n=== LEDGER PAYMENT LIST (Most Recent First) ===");

        for (var i = transactionList.size() - 1; i >= 0; i--) {
            if (transactionList.get(i).getAmount() < 0) {
                System.out.println(transactionList.get(i).toString());
            }
        }

    }
}
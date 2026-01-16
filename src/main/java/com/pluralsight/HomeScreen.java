package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class HomeScreen {

    public static void homeScreen() {


        TransactionFileHelper transactionFileHelper = new TransactionFileHelper();
        // Instantiates (create) an object to help read and write transactions to the transactions.csv file.
        Scanner scanner = new Scanner(System.in);
        char choice = ' ';
        // Run the homeScreen in a do- while loop until the user exits the menu
        do {
            // Displays the home screen
            System.out.println("\n===$$$ MO' MONEY NO PROBLEMS MENU $$$===");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger - display the ledger screen");
            System.out.println("X) Exit ");

            String line = scanner.nextLine().trim(); // removes extra spaces so inputs aren't misread
            if (line.isEmpty()) {
                System.out.println("No input detected yo. Choose a letter from the menu homie/homette.");
                continue;
            }
            choice = Character.toUpperCase(line.charAt(0));
            // Chain of method that reads user input from the keyboard
            // Converts to uppercase and takes the first character

            switch (choice) {

                case 'D':
                    System.out.println("Add Deposit selected");
                    LocalDate date = LocalDate.now();
                    LocalTime time = LocalTime.now();
                    System.out.println("Enter description");
                    String description = scanner.nextLine();
                    System.out.println("Enter vendor");
                    String vendor = scanner.nextLine();
                    System.out.println("Enter amount");
                    double amount = Double.parseDouble(scanner.nextLine());
                    String transaction = date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
                    transactionFileHelper.writeTransaction(transaction);
                    //date|time|description|vendor|amount
                    break;
                //  public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount)
                case 'P':
                    System.out.println("Make Payment selected");
                    LocalDate dateP = LocalDate.now();
                    LocalTime timeP = LocalTime.now();
                    System.out.println("Enter description");
                    String descriptionP = scanner.nextLine();
                    System.out.println("Enter vendor");
                    String vendorP = scanner.nextLine();
                    System.out.println("Enter amount");
                    double amountP = -1 * Double.parseDouble(scanner.nextLine());
                    String transactionP = dateP + "|" + timeP + "|" + descriptionP + "|" + vendorP + "|" + amountP;
                    transactionFileHelper.writeTransaction(transactionP);
                    //date|time|description|vendor|amount
                    break;

                case 'L':
                    System.out.println("Cruisin' to the ledger screen...");
                    // switches to ledger page with different options
                    LedgerScreen.ledgerScreen();
                    break;

                case 'X':
                    System.out.println("Peace!");
                    break;

                default:
                    System.out.println("Oh snap, invalid choice! Try that again playa! ");

            }

        } while (choice != 'X');
          // Loops repeats until user chooses x

    }
}
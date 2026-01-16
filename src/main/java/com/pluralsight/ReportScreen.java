package com.pluralsight;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import models.Transaction;
public class ReportScreen {


    // Shows Report Screens and user choices
    public static void reportScreen() {

        Scanner scanner = new Scanner(System.in);
        char choice = ' ';

        TransactionFileHelper helper = new TransactionFileHelper();
        ArrayList<Transaction> transactions = helper.readAllTransactions();

        do {
            System.out.println("\n===$$$ REPORT MENU $$$===");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year to Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor - prompt the use for the vendor name and display all it's entries");
            System.out.println("0) Back - Go back to Ledger page");
            System.out.println("===$$$ Pick yo poison tell me watcha doin' $$$===");

            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("No input detected yo. Choose a number from the menu homie/homette");
                continue;
            }

            choice = line.charAt(0); // digits don't need uppercase like other screens

            switch (choice) {

                case '1':
                    System.out.println("Display all transactions in the current month");
                    showMonthToDate(transactions);
                    break;

                case '2':
                    System.out.println("Display all transactions in the previous month");
                    showPreviousMonth(transactions);
                    break;

                case '3':
                    System.out.println("Display all transactions in the current year");
                    showYearToDate(transactions);
                    break;
                case '4':
                    System.out.println("Display all transactions in the previous year");
                    showPreviousYear(transactions);
                    break;

                case '5':
                    System.out.println("Search by vendor and show matching transactions");
                    searchByVendor(transactions, scanner);
                    break;

                case '0':
                    System.out.println("Return to the Ledger Screen");
                    return;

                default:
                    System.out.println("Oh snap, invalid choice! Try that again playa!");
                    break;
            }

        } while (choice != '0');
    }

    // Helper Methods
    private static void showMonthToDate(ArrayList<Transaction> list) {
        LocalDate today = LocalDate.now();
        System.out.println("\nMonth to Date Transactions:");
        for (Transaction t : list) {
            if (t.getDate().getMonth() == today.getMonth() &&
                    t.getDate().getYear() == today.getYear()) {
                System.out.println(t);
            }
        }
    }

    private static void showPreviousMonth(ArrayList<Transaction> list) {
        LocalDate today = LocalDate.now();
        LocalDate lastMonth = today.minusMonths(1);
        System.out.println("\nPrevious Month Transactions:");
        for (Transaction t : list)
            if (t.getDate().getMonth() == lastMonth.getMonth() &&
                    t.getDate().getYear() == lastMonth.getYear()) {
                System.out.println(t);
            }

    }
    private static void showYearToDate(ArrayList<Transaction> list) {
        LocalDate today = LocalDate.now();
        System.out.println("\nYear to Date Transactions:");
        for (int i = list.size() - 1; i >= 0; i--) {
            Transaction t = list.get(i);
            if (t.getDate().getYear() == today.getYear()) {
                System.out.println(t);
            }
        }
    }
    private static void showPreviousYear(ArrayList<Transaction> list) {
        LocalDate today = LocalDate.now();
        int prevYear = today.getYear() - 1;
        System.out.println("\nPrevious Year Transactions:");
        for (int i = list.size() - 1; i >= 0; i--) {
            Transaction t = list.get(i);
            if (t.getDate().getYear() == prevYear) {
                System.out.println(t);
            }
        }
    }

    private static void searchByVendor(ArrayList<Transaction> list, Scanner scanner) {
        System.out.print("\nEnter vendor name to search: ");
        String vendor = scanner.nextLine().trim();
        boolean found = false;

        for (Transaction t : list) {
            if (t.getVendorName().equalsIgnoreCase(vendor)) {
                System.out.println(t);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found for vendor G!: " + vendor);
        }
    }
}
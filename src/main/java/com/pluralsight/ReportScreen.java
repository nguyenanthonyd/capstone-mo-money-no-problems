package com.pluralsight;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class ReportScreen {

    // Shows Report Screens and user choices
    public static void reportScreen() {

        Scanner scanner = new Scanner(System.in);
        char choice = ' ';

        TransactionFileHelper helper = new TransactionFileHelper();
        ArrayList<Transaction> transactions = helper.readAllTransactions();

        do {
            System.out.println(
                    Colors.BOLD + Colors.PURPLE +
                            "\n===$$$ REPORT MENU $$$===" +
                            Colors.RESET
            );

            System.out.println(Colors.CYAN + "1) Month To Date" + Colors.RESET);
            System.out.println(Colors.CYAN + "2) Previous Month" + Colors.RESET);
            System.out.println(Colors.CYAN + "3) Year to Date" + Colors.RESET);
            System.out.println(Colors.CYAN + "4) Previous Year" + Colors.RESET);
            System.out.println(Colors.YELLOW + "5) Search by Vendor" + Colors.RESET);
            System.out.println(Colors.BLUE + "0) Back - Go back to Ledger page" + Colors.RESET);

            System.out.println(
                    Colors.BOLD +
                            "===$$$ Pick yo poison tell me watcha doin' $$$===" +
                            Colors.RESET
            );

            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println(Colors.RED + "No input detected. Choose a number from the menu!" + Colors.RESET);
                continue;
            }

            choice = line.charAt(0);

            switch (choice) {

                case '1':
                    System.out.println(Colors.CYAN + "\nMonth To Date Transactions 📅" + Colors.RESET);
                    showMonthToDate(transactions);
                    break;

                case '2':
                    System.out.println(Colors.CYAN + "\nPrevious Month Transactions ⏮️" + Colors.RESET);
                    showPreviousMonth(transactions);
                    break;

                case '3':
                    System.out.println(Colors.CYAN + "\nYear To Date Transactions 📆" + Colors.RESET);
                    showYearToDate(transactions);
                    break;

                case '4':
                    System.out.println(Colors.CYAN + "\nPrevious Year Transactions 🕰️" + Colors.RESET);
                    showPreviousYear(transactions);
                    break;

                case '5':
                    System.out.println(Colors.YELLOW + "\nSearch by Vendor 🔍" + Colors.RESET);
                    searchByVendor(transactions, scanner);
                    break;

                case '0':
                    System.out.println(Colors.BLUE + "Returning to Ledger Screen 📘" + Colors.RESET);
                    return;

                default:
                    System.out.println(Colors.RED + "Oh snap, invalid choice! Try that again playa!" + Colors.RESET);
                    break;
            }

        } while (choice != '0');
    }

    // ================= HELPER METHODS =================

    private static void showMonthToDate(ArrayList<Transaction> list) {
        LocalDate today = LocalDate.now();

        for (Transaction t : list) {
            if (t.getDate().getMonth() == today.getMonth() &&
                    t.getDate().getYear() == today.getYear()) {

                printColoredTransaction(t);
            }
        }
    }

    private static void showPreviousMonth(ArrayList<Transaction> list) {
        LocalDate today = LocalDate.now();
        LocalDate lastMonth = today.minusMonths(1);

        for (Transaction t : list) {
            if (t.getDate().getMonth() == lastMonth.getMonth() &&
                    t.getDate().getYear() == lastMonth.getYear()) {

                printColoredTransaction(t);
            }
        }
    }

    private static void showYearToDate(ArrayList<Transaction> list) {
        LocalDate today = LocalDate.now();

        for (int i = list.size() - 1; i >= 0; i--) {
            Transaction t = list.get(i);
            if (t.getDate().getYear() == today.getYear()) {
                printColoredTransaction(t);
            }
        }
    }

    private static void showPreviousYear(ArrayList<Transaction> list) {
        LocalDate today = LocalDate.now();
        int prevYear = today.getYear() - 1;

        for (int i = list.size() - 1; i >= 0; i--) {
            Transaction t = list.get(i);
            if (t.getDate().getYear() == prevYear) {
                printColoredTransaction(t);
            }
        }
    }

    private static void searchByVendor(ArrayList<Transaction> list, Scanner scanner) {
        System.out.print(Colors.CYAN + "\nEnter vendor name to search: " + Colors.RESET);
        String vendor = scanner.nextLine().trim();
        boolean found = false;

        for (Transaction t : list) {
            if (t.getVendor().equalsIgnoreCase(vendor)) {
                printColoredTransaction(t);
                found = true;
            }
        }

        if (!found) {
            System.out.println(Colors.RED + "No transactions found for vendor: " + vendor + Colors.RESET);
        }
    }

    // ===== COLOR LOGIC FOR TRANSACTIONS =====
    private static void printColoredTransaction(Transaction t) {
        if (t.getAmount() >= 0) {
            System.out.println(Colors.GREEN + t + Colors.RESET);
        } else {
            System.out.println(Colors.RED + t + Colors.RESET);
        }
    }
}

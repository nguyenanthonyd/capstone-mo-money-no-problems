package com.pluralsight;

import java.util.Scanner;
import java.util.ArrayList;

public class LedgerScreen {


            public static void ledgerScreen() {
            TransactionFileHelper helper = new TransactionFileHelper();
            ArrayList<Transaction> transactionList = helper.readAllTransactions();

            Scanner scanner = new Scanner(System.in);
            char choice = ' ';

            do {
                System.out.println(
                        Colors.BOLD + Colors.PURPLE +
                                "\n===$$$ LEDGER MENU $$$===" +
                                Colors.RESET
                );

                System.out.println(Colors.CYAN + "A) All - Displays all entries" + Colors.RESET);
                System.out.println(Colors.GREEN + "D) Deposits - Displays only deposits" + Colors.RESET);
                System.out.println(Colors.RED + "P) Payments - Displays only payments" + Colors.RESET);
                System.out.println(Colors.YELLOW + "R) Reports - Run pre-defined reports" + Colors.RESET);
                System.out.println(Colors.BLUE + "H) Home - Go back to Home Screen" + Colors.RESET);

                System.out.println(Colors.BOLD + "===$$$ Pick yo poison tell me watcha doin' $$$===" + Colors.RESET);

                String line = scanner.nextLine().trim();

                if (line.isEmpty()) {
                    System.out.println(Colors.RED + "No input detected dawg! — Choose a letter from the menu." + Colors.RESET);
                    continue;
                }

                choice = Character.toUpperCase(line.charAt(0));

                switch (choice) {

                    case 'A':
                        System.out.println(Colors.CYAN + "\nAll - Display all entries" + Colors.RESET);
                        displayAllTransactions(transactionList);
                        break;

                    case 'D':
                        System.out.println(Colors.GREEN + "\nDeposits - Showing all deposits 💰" + Colors.RESET);
                        displayAllDeposits(transactionList);
                        break;

                    case 'P':
                        System.out.println(Colors.RED + "\nPayments - Showing all payments 💳" + Colors.RESET);
                        displayAllPayments(transactionList);
                        break;

                    case 'R':
                        System.out.println(Colors.YELLOW + "\nReports Screen 📊" + Colors.RESET);
                        ReportScreen.reportScreen();
                        transactionList = helper.readAllTransactions(); // refresh after reports
                        break;

                    case 'H':
                        System.out.println(Colors.BLUE + "Heading back home 🏠" + Colors.RESET);
                        break;

                    default:
                        System.out.println(Colors.RED + "Oh snap, invalid choice! Try that again playa!" + Colors.RESET);
                }

            } while (choice != 'H');
        }

        // ================= HELPER METHODS =================

        public static void displayAllTransactions(ArrayList<Transaction> transactionList) {

            System.out.println(
                    Colors.BOLD + Colors.PURPLE +
                            "\n===$$$ FULL TRANSACTION LIST (Oldest to Newest) $$$===" +
                            Colors.RESET
            );

            for (int i = 0; i < transactionList.size(); i++) {
                Transaction t = transactionList.get(i);

                if (t.getAmount() >= 0) {
                    System.out.println(Colors.GREEN + t + Colors.RESET);
                } else {
                    System.out.println(Colors.RED + t + Colors.RESET);
                }
            }
        }

        public static void displayAllDeposits(ArrayList<Transaction> transactionList) {

            System.out.println(
                    Colors.BOLD + Colors.GREEN +
                            "\n=== LEDGER DEPOSIT LIST (Most Recent First) ===" +
                            Colors.RESET
            );

            for (int i = transactionList.size() - 1; i >= 0; i--) {
                Transaction t = transactionList.get(i);
                if (t.getAmount() >= 0) {
                    System.out.println(Colors.GREEN + t + Colors.RESET);
                }
            }
        }

        public static void displayAllPayments(ArrayList<Transaction> transactionList) {

            System.out.println(
                    Colors.BOLD + Colors.RED +
                            "\n=== LEDGER PAYMENT LIST (Most Recent First) ===" +
                            Colors.RESET
            );

            for (int i = transactionList.size() - 1; i >= 0; i--) {
                Transaction t = transactionList.get(i);
                if (t.getAmount() < 0) {
                    System.out.println(Colors.RED + t + Colors.RESET);
                }
            }
        }
    }
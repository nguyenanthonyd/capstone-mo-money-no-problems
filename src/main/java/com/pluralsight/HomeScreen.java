package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class HomeScreen {



        public static void homeScreen() {


            TransactionFileHelper transactionFileHelper = new TransactionFileHelper();
            Scanner scanner = new Scanner(System.in);
            char choice = ' ';

            do {
                // MENU HEADER
                System.out.println(
                        Colors.BOLD + Colors.GREEN +
                                "\n===$$$ MO' MONEY NO PROBLEMS MENU $$$===" +
                                Colors.RESET
                );

                System.out.println(Colors.CYAN + "D) Add Deposit" + Colors.RESET);
                System.out.println(Colors.YELLOW + "P) Make Payment (Debit)" + Colors.RESET);
                System.out.println(Colors.BLUE + "L) Ledger - display the ledger screen" + Colors.RESET);
                System.out.println(Colors.RED + "X) Exit" + Colors.RESET);

                String line = scanner.nextLine().trim();

                if (line.isEmpty()) {
                    System.out.println(Colors.RED + "No input detected. Choose a letter from the menu!" + Colors.RESET);
                    continue;
                }

                choice = Character.toUpperCase(line.charAt(0));

                switch (choice) {

                    case 'D':
                        System.out.println(Colors.GREEN + "Add Deposit selected 💰" + Colors.RESET);

                        LocalDate date = LocalDate.now();
                        LocalTime time = LocalTime.now();

                        System.out.println(Colors.CYAN + "Enter description:" + Colors.RESET);
                        String description = scanner.nextLine();

                        System.out.println(Colors.CYAN + "Enter vendor:" + Colors.RESET);
                        String vendor = scanner.nextLine();

                        System.out.println(Colors.CYAN + "Enter amount:" + Colors.RESET);

                        double amount;

                        while (true) {
                            String input = scanner.nextLine().trim();

                            try {
                                amount = Double.parseDouble(input);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println(Colors.RED + "Invalid number. Please enter a valid amount:" + Colors.RESET);
                            }
                        }

                        String transaction = date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
                        transactionFileHelper.writeTransaction(transaction);

                        System.out.println(Colors.GREEN + "Deposit saved successfully! ✅" + Colors.RESET);
                        break;

                    case 'P':
                        System.out.println(Colors.YELLOW + "Make Payment selected 💳" + Colors.RESET);

                        LocalDate dateP = LocalDate.now();
                        LocalTime timeP = LocalTime.now();

                        System.out.println(Colors.CYAN + "Enter description:" + Colors.RESET);
                        String descriptionP = scanner.nextLine();

                        System.out.println(Colors.CYAN + "Enter vendor:" + Colors.RESET);
                        String vendorP = scanner.nextLine();

                        System.out.println(Colors.CYAN + "Enter amount:" + Colors.RESET);

                        double amountP;

                        while (true) {
                            String input = scanner.nextLine().trim();

                            try {
                                amountP = Double.parseDouble(input);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println(Colors.RED + "Invalid number. Please enter a valid amount:" + Colors.RESET);
                            }
                        }

                        String transactionP = dateP + "|" + timeP + "|" + descriptionP + "|" + vendorP + "|" + amountP;
                        transactionFileHelper.writeTransaction(transactionP);

                        System.out.println(Colors.GREEN + "Payment recorded successfully! ✅" + Colors.RESET);
                        break;

                    case 'L':
                        System.out.println(Colors.BLUE + "Cruisin' to the ledger screen... 📘" + Colors.RESET);
                        LedgerScreen.ledgerScreen();
                        break;

                    case 'X':
                        System.out.println(Colors.PURPLE + "Peace! Thanks for using Mo' Money 😎✌️" + Colors.RESET);
                        break;

                    default:
                        System.out.println(Colors.RED + "Oh snap, invalid choice! Try again playa!" + Colors.RESET);
                }

            } while (choice != 'X');
        }
    }
package com.pluralsight;
// Imported wildcards to streamline imports
import java.io.*; // For reading and writing files.
import java.util.*; // For Array and List.
import java.time.LocalDate;
import models.Transaction;



public class TransactionFileHelper {

    public final String TRANSACTIONS = "transactions.csv";
    // Saves a transaction line to file "transactions.csv"
    public void writeTransaction(String transactionline) {
        try {
            // FileWriter - to open the file
            // This method adds one new transaction line to your CSV file.
            FileWriter writer = new FileWriter(TRANSACTIONS, true);
            PrintWriter writer2 = new PrintWriter(writer);

            writer2.println(transactionline);

            writer2.close();
            writer.close();

            System.out.println("Transaction saved to file! Yee!");

        } catch (IOException e) {
            System.out.println("Oops! Could not write to file: " + e.getMessage());
        }
    }

    //  This method reads all transactions from the file
    public ArrayList<Transaction> readAllTransactions() {

        ArrayList<Transaction> transactions = new ArrayList<>();

        File file = new File(TRANSACTIONS);

        if (!file.exists()) {
            // No file yet? Return empty list without crashing
            return transactions;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            // Go line by line
            while ((line = reader.readLine()) != null) { /*Reads one line at a time. Removes extra spaces.
                                                                       Skips empty lines.*/
                line = line.trim();
                if (line.isEmpty()) continue;

                // Expecting format: date|time|description|vendor|amount
                String[] transactionLine = line.split("\\|");
                if (transactionLine.length != 5) continue;

                try {
                    LocalDate date = LocalDate.parse(transactionLine[0].trim());
                   //LocalTime time = LocalTime.parse(transactionLine[1].trim());
                    String description = transactionLine[2].trim();
                    String vendor = transactionLine[3].trim();
                    double amount = Double.parseDouble(transactionLine[4].trim());

                    Transaction t = new Transaction(date, description, vendor, amount);
                    transactions.add(t);
                } catch (Exception parseError) {
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println(" Error reading file:  " + e.getMessage());
        }

        return transactions;
    }
}



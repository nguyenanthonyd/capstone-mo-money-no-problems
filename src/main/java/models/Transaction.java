package models;

import java.time.LocalDate;


public class Transaction {
    private int transactionId;
    private String description;
    private String vendorName;
    private double amount;
    private LocalDate date;

    public Transaction(LocalDate date, String description, String vendor, double amount) {

    }

    public Transaction(int transactionId, String description, String vendorName, double amount, LocalDate date) {
        this.transactionId = transactionId;
        this.description = description;
        this.vendorName = vendorName;
        this.amount = amount;
        this.date = date;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
     }
}

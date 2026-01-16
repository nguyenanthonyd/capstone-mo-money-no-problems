package models;

import java.time.LocalDateTime;

public class Transaction {
    private int transactionId;
    private String description;
    private String vendorName;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction() {

    }

    public Transaction(int transactionId, String description, String vendorName, double amount, LocalDateTime dateTime) {
        this.transactionId = transactionId;
        this.description = description;
        this.vendorName = vendorName;
        this.amount = amount;
        this.dateTime = dateTime;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

# capstone-mo-money-no-problems
# 💸 MO' MONEY NO PROBLEMS

**MO' MONEY NO PROBLEMS** is a Java console-based ledger app that helps users **track deposits, payments, and generate simple financial reports**.  
It’s built using **Object-Oriented Programming (OOP)** principles and stores data in a CSV file — combining real-world problem solving with core Java fundamentals.

---

## 🧾 Project Description

The application simulates a small personal finance tracker.  
Users can:
- Add **deposits** (positive amounts)
- Add **payments/debits** (negative amounts)
- View their **ledger** of all transactions
- Filter by **deposits** or **payments**
- Generate **reports** for Month-to-Date, Previous Month, Year-to-Date, Previous Year, or search by Vendor

Each transaction is saved to a `transactions.csv` file in the format:
date|time|description|vendor|amount

---

### 🏠 Home Screen
<img width="1919" height="1013" alt="Screenshot 2025-10-16 213704" src="https://github.com/user-attachments/assets/5be75b53-d0c2-4fdc-8874-ab5ad92ac282" />
<img width="1919" height="1013" alt="Screenshot 2025-10-16 213722" src="https://github.com/user-attachments/assets/8986e3a8-4526-460c-8da1-d463e659b2c4" />
<img width="1919" height="1013" alt="Screenshot 2025-10-16 213722" src="https://github.com/user-attachments/assets/b89bf4d5-42bd-425c-b772-fa225a7c428d" />



### 📒 Ledger Screen
![Ledger Screen](images/ledger-screen.png)

### 📊 Reports Screen
![Reports Screen](images/reports-screen.png)

*(Images show sample terminal outputs from running the program.)*

---

## 🧠 Interesting Piece of Code

Below is a snippet from the **ReportScreen** class that filters transactions by the current month and year.  
It demonstrates **date handling** with `LocalDate` and use of an **ArrayList loop** to display only transactions from this month.

```java
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

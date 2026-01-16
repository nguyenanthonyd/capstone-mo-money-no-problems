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
<img width="426" height="287" alt="Screenshot 2026-01-16 093352" src="https://github.com/user-attachments/assets/4763052c-7c3d-47b4-8604-f907a3f00253" />




### 📒 Ledger Screen
<img width="775" height="309" alt="Screenshot 2026-01-16 093416" src="https://github.com/user-attachments/assets/79619257-db23-4a4c-a2d0-b78e6862e011" />





### 📊 Reports Screen
<img width="862" height="236" alt="image" src="https://github.com/user-attachments/assets/22565d15-d87e-4d7c-8fba-c264521999c0" />



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

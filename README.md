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
<img width="1919" height="1012" alt="Screenshot 2025-10-16 214210" src="https://github.com/user-attachments/assets/f8faa1be-8813-4c37-a4ee-f1bb544f2174" />
<img width="1914" height="1015" alt="Screenshot 2025-10-16 214246" src="https://github.com/user-attachments/assets/149b9461-c8ba-4eba-976b-93251261d165" />
<img width="1916" height="1014" alt="Screenshot 2025-10-16 214305" src="https://github.com/user-attachments/assets/24975458-df44-480e-a89e-100118cea57d" />




### 📊 Reports Screen
<img width="1919" height="1013" alt="Screenshot 2025-10-16 214441" src="https://github.com/user-attachments/assets/b237a93b-b5b9-4418-a5b3-68f9c23fcaa1" />
<img width="1919" height="1014" alt="Screenshot 2025-10-16 214456" src="https://github.com/user-attachments/assets/3b01ecf9-abb3-48b6-8ba3-dfbc486901ca" />
<img width="1919" height="1014" alt="Screenshot 2025-10-16 214456" src="https://github.com/user-attachments/assets/4ed88ff2-d421-429f-a6d9-55400b213b73" />
<img width="1918" height="1012" alt="Screenshot 2025-10-16 214510" src="https://github.com/user-attachments/assets/2743392a-cede-44ea-8b37-17eee0714a2d" />
<img width="1909" height="1009" alt="Screenshot 2025-10-16 214526" src="https://github.com/user-attachments/assets/0827bd38-eb6e-4d8e-a78b-2ff95352c865" />
<img width="1919" height="1010" alt="Screenshot 2025-10-16 214538" src="https://github.com/user-attachments/assets/c21ad874-59c3-46e1-8b0e-229456a6d96a" />
<img width="1918" height="1014" alt="Screenshot 2025-10-16 214624" src="https://github.com/user-attachments/assets/4e9684db-bfe4-479b-a716-b3d5e4ad6935" />


<img width="1808" height="889" alt="Screenshot 2025-10-16 215358" src="https://github.com/user-attachments/assets/b545209b-04c7-4d5c-b4ef-51b060e61858" />


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

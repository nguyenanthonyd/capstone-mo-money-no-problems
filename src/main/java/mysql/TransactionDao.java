package mysql;

import models.Transaction;

import java.util.List;

public interface TransactionDao {

    List<Transaction> getAllTransactions();
    Transaction getById(int transactionId);
    Transaction create(Transaction transaction);
    void update(int transactionId, Transaction transaction);
    void delete(int transactionId);
}

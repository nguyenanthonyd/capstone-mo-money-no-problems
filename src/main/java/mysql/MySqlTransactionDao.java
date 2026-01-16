package mysql;


import models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlTransactionDao implements TransactionDao {
    private final DataSource dataSource;

    @Autowired
    public MySqlTransactionDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        String sql = "SELECT transaction_id, description, vendor_name, amount, transaction_time FROM transactions_db.transactions;";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Transaction transaction = new Transaction(
                        rs.getInt("transaction_id"),
                        rs.getString("description"),
                        rs.getString("vendor_name"),
                        rs.getDouble("amount"),
                        rs.getDate("transaction_time").toLocalDate()
                );
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }

    @Override
    public Transaction getById(int transactionId) {
        return null;
    }

    @Override
    public Transaction create(Transaction transaction) {
        return null;
    }

    @Override
    public void update(int transactionId, Transaction transaction) {

    }

    @Override
    public void delete(int transactionId) {

    }

}

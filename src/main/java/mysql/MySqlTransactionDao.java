package mysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySqlTransactionDao{
    private final TransactionDao transactionDao;

    @Autowired
    public MySqlTransactionDao(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
}

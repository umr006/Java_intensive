package ex04;

public interface TransactionsList {
    void addTransaction(Transaction transaction);
    void removeTransactionById(String UUID);
    Transaction[] toArray();
}

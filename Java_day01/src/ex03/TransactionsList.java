package ex03;

public interface TransactionsList {
    void addTransaction();
    void removeTransactionById();
    Transaction[] toArray();
}

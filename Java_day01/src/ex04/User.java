package ex04;
import java.util.UUID;


public class User {
    private int id;
    private String name;
    private double balance;
    private TransactionsLinkedList listOfUsertTransactions = new TransactionsLinkedList();

    public User() {

    }

    public User(String name, double balance) throws IllegalTransactionException {
        setId();
        setName(name);
        try {
            setBalance(balance);
        } catch (IllegalTransactionException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getId() {
        return id;
    }
    //method is private
    private void setId() {
        this.id = UserIdsGenerator.getInstance().generateId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) throws IllegalTransactionException {
        if (balance < 0) {
            throw new IllegalTransactionException("Balance cannot be less zero!");
        }
        this.balance = balance;
    }

    public void addTransactionInList(Transaction newTransaction) {
        listOfUsertTransactions.addTransaction(newTransaction);
    }

    public void removeTransactionInList(Transaction transaction) {
        listOfUsertTransactions.removeTransactionById(transaction.getId());
    }

    public void removeTransactionInListById(UUID transactionId) {
        listOfUsertTransactions.removeTransactionById(transactionId);
    }

    public TransactionsLinkedList getList() {
        return listOfUsertTransactions;
    }

    public Transaction[] userTransactionToArray() {
        return listOfUsertTransactions.toArray();
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + ", balance=" + balance + "'}";
    }
}
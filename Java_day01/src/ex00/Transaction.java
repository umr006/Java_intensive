package ex00;

import java.util.*;
public class Transaction {
    private UUID uuid;
    private User sender;
    private User recipient;
    private TransactionCategory category;
    private double amount;

    enum TransactionCategory {
        DEBIT,
        CREDIT
    }

    public Transaction(User sender, User recipient, TransactionCategory cat, double amount) {
        this.uuid = setUuid();
        setSender(sender);
        setRecipient(recipient);
        this.category = cat;
        setTransactionAmount(amount);
        TransactionProcess(sender, recipient, amount);
    }

    public UUID setUuid() {
         return UUID.randomUUID();
    }

    public void setRecipient(User recipient) {
        try{
            if (recipient.getBalance() >= 0)
                this.recipient = recipient;
            else
                throw new IllegalArgumentException("The balance cannot be less zero!");
        } catch (IllegalArgumentException e) {
            System.out.println("The balance cannot be less zero!");
        }
    }

    public void setSender(User sender){
        try{
            if (sender.getBalance() >= 0)
                this.sender = sender;
            else
                throw new IllegalArgumentException("The balance cannot be less zero!");
        } catch (IllegalArgumentException e) {
            System.out.println("The balance cannot be less zero!");
        }
    }

    public void setTransactionAmount(double amount) {
        try {
            if ((amount > 0 && this.category == TransactionCategory.DEBIT) || (amount < 0 && this.category == TransactionCategory.CREDIT)) {
                this.amount = amount;
            } else {
                throw new IllegalArgumentException("The transfer amount does not match the type");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    public void TransactionProcess(User sender, User recipient, Double amount) {
        try {
            if ((sender.getBalance() < amount && this.category == TransactionCategory.DEBIT) || (sender.getBalance() < -amount && this.category == TransactionCategory.CREDIT)) {
                throw new IllegalArgumentException("The transfer amount cannot be less sender balance");
            } else {
                sender.setBalance(sender.getBalance() - amount);
                recipient.setBalance(recipient.getBalance() + amount);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Transaction(" + uuid + ")" +
                "{"
                + sender
                + " ==>("
                + amount
                + ") "
                + recipient
                + " with category - "
                + category
                + "}";
    }
}

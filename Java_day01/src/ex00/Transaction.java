package ex00;

import java.util.UUID;

public class Transaction {
    private UUID Identifier;
    private User Recipient;
    private User Sender;
    private TransferCategory Category;
    private double TransferAmount;

    enum TransferCategory {
        DEBIT, CREDIT
    }

    public Transaction(UUID Identifier, User Recipient, User Sender, TransferCategory Category, double TransferAmount) {
        if ()
    }

    public UUID getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(UUID identifier) {
        Identifier = UUID.randomUUID();
    }

    public User getRecipient() {
        return Recipient;
    }

    public void setRecipient(User recipient) {
        Recipient = recipient;
    }

    public User getSender() {
        return Sender;
    }

    public void setSender(User sender) {
        Sender = sender;
    }

    public TransferCategory getCategory() {
        return Category;
    }

    public void setCategory(TransferCategory category) {
        Category = category;
    }

    public double getTransferAmount() {
        return TransferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        TransferAmount = transferAmount;
    }
}






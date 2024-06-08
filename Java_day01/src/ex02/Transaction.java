package ex02;

import ex00.User;

import java.util.UUID;

public class Transaction {
    private UUID Identifier;
    private ex00.User Recipient;
    private ex00.User Sender;
    private TransferCategory Category;
    private double TransferAmount;

    enum TransferCategory {
        DEBIT, CREDIT
    }

    public Transaction(ex00.User Sender, ex00.User Recipient, TransferCategory Category, double TransferAmount) throws IllegalArgumentException {
        setIdentifier();
        setSender(Sender);
        setRecipient(Recipient);
        setCategory(Category);
        Transfer(Sender, Recipient, TransferAmount);
    }

    public UUID getIdentifier() {
        return Identifier;
    }

    public void setIdentifier() {
        Identifier = UUID.randomUUID();
    }

    public ex00.User getRecipient() {
        return Recipient;
    }

    public void setRecipient(ex00.User recipient) {
        Recipient = recipient;
    }

    public ex00.User getSender() {
        return Sender;
    }

    public void setSender(ex00.User sender) {
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

    public void setTransferAmount(double transferAmount) throws IllegalArgumentException {
        try {
            if(transferAmount > 0) {
                this.TransferAmount = transferAmount;
            } else {
                throw new IllegalArgumentException("TransferAmount cannot be less zero");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void Transfer(ex00.User sender, User recipient, double TransferAmount) throws IllegalArgumentException {
        try {
            if (sender.getBalance() - TransferAmount >= 0) {
                sender.setBalance(sender.getBalance() - TransferAmount);
                recipient.setBalance(recipient.getBalance() + TransferAmount);
            } else {
                throw new IllegalArgumentException("Sender balance less TransferAmount");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
}






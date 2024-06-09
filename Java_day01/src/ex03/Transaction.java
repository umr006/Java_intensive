package ex03;

import ex03.User;

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

    public Transaction(User Sender, User Recipient, TransferCategory Category, double TransferAmount) throws IllegalArgumentException {
        setIdentifier();
        setSender(Sender);
        setRecipient(Recipient);
        setCategory(Category);
        setTransferAmount(TransferAmount);
        Transfer(Sender, Recipient, TransferAmount);
    }

    public UUID getIdentifier() {
        return Identifier;
    }

    public void setIdentifier() {
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

    public void setTransferAmount(double transferAmount) throws IllegalArgumentException {
        try {
            if((transferAmount > 0 && Category == TransferCategory.DEBIT) || (transferAmount < 0 && Category == TransferCategory.CREDIT)) {
                this.TransferAmount = transferAmount;
            } else {
                System.out.println("TransferAmount cannot be less zero");
                throw new IllegalArgumentException("TransferAmount cannot be less zero");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void Transfer(User sender, User recipient, double TransferAmount) throws IllegalArgumentException {
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
    @Override
    public String toString() {
        return " ID " + Identifier + " TransferAmount " + TransferAmount;
    }
}






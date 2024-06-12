package ex04;

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

    public static class IllegalTransactionException extends RuntimeException {
        public IllegalTransactionException(String errMessage) {
            super(errMessage);
        }
    }

    public Transaction(UUID id,User Sender, User Recipient, TransferCategory Category, double TransferAmount) throws IllegalTransactionException {
        setIdentifier(id);
        setSender(Sender);
        setRecipient(Recipient);
        setCategory(Category);
        setTransferAmount(TransferAmount);
        Transfer(Sender, Recipient, TransferAmount);
    }

    public UUID getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(UUID id) {
        Identifier = id;
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

    public void setTransferAmount(double transferAmount) throws IllegalTransactionException {
        try {
            if((transferAmount > 0 && Category == TransferCategory.DEBIT) || (transferAmount < 0 && Category == TransferCategory.CREDIT)) {
                this.TransferAmount = transferAmount;
            } else {
                System.out.println("TransferAmount cannot be less zero");
                throw new IllegalTransactionException("TransferAmount cannot be less zero");
            }
        } catch (IllegalTransactionException e) {
            System.out.println(e.getMessage());
        }
    }

    public void Transfer(User sender, User recipient, double TransferAmount) throws IllegalTransactionException {
        try {
            if (sender.getBalance() - TransferAmount >= 0) {
                sender.setBalance(sender.getBalance() - TransferAmount);
                recipient.setBalance(recipient.getBalance() + TransferAmount);
            } else {
                throw new IllegalTransactionException("Sender balance less TransferAmount");
            }
        } catch (IllegalTransactionException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
    @Override
    public String toString() {
        return " ID " + Identifier + " TransferAmount " + TransferAmount;
    }
}






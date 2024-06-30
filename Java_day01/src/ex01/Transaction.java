package ex01;
import java.util.UUID;

public class Transaction {
    private UUID id;
    private User recipient;
    private User sender;
    private Transaction.transferCategory type;
    private double transferAmount;

    enum transferCategory {
        CREDIT,
        DEBIT
    }

    public Transaction(User sender, User recipient, Transaction.transferCategory type, double transferAmount) {
        setId();
        setRecipient(recipient);
        setSender(sender);
        setType(type);
        setTransferAmount(transferAmount);
        initTransaction(sender, recipient, transferAmount);
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Transaction.transferCategory getType() {
        return type;
    }

    public void setType(Transaction.transferCategory type) {
        this.type = type;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) throws IllegalArgumentException {
        try {
            if (Transaction.transferCategory.DEBIT == type && transferAmount < 0 || Transaction.transferCategory.CREDIT == type && transferAmount > 0) {
                throw new IllegalArgumentException("Not correct amount!");
            } else {
                this.transferAmount = transferAmount;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public void initTransaction(User sender, User recipient, double transferAmount) {
        sender.setBalance(sender.getBalance() - transferAmount);
        recipient.setBalance(recipient.getBalance() + transferAmount);
    }

}
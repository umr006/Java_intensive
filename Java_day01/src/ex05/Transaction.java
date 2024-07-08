package ex05;


import java.util.UUID;

public class Transaction {
    private UUID id;
    private User recipient;
    private User sender;
    private transferCategory type;
    private double transferAmount;

    enum transferCategory {
        CREDIT,
        DEBIT
    }

    @Override
    public String toString() {
        return "Transaction {id=" + id + ", sender='" + sender +  ", recipient " + recipient + "transferAmount" + transferAmount +  ", type=" + type + "'}";
    }

    public Transaction(User sender, User recipient, transferCategory type, double transferAmount) {
        setId();
        setRecipient(recipient);
        setSender(sender);
        setType(type);
        setTransferAmount(transferAmount);
        initTransaction(sender, recipient, type, transferAmount);
    }
    public Transaction(UUID id, User sender, User recipient, transferCategory type, double transferAmount) {
        setId(id);
        setRecipient(recipient);
        setSender(sender);
        setType(type);
        setTransferAmount(transferAmount);
        initTransaction(sender, recipient, type, transferAmount);
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public void setId(UUID id) {
        this.id = id;
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

    public transferCategory getType() {
        return type;
    }

    public void setType(transferCategory type) {
        this.type = type;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) throws IllegalArgumentException {
        try {
            if (transferCategory.DEBIT == type && transferAmount < 0 || transferCategory.CREDIT == type && transferAmount > 0) {
                throw new IllegalArgumentException("Not correct amount!");
            } else {
                this.transferAmount = transferAmount;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private void initTransaction(User sender, User recipient, transferCategory type, double amount) {
        if (sender.getBalance() >= amount) {
            if (type == transferCategory.CREDIT)
                sender.setBalance(sender.getBalance() + amount);
            else if (type == transferCategory.DEBIT)
                recipient.setBalance(recipient.getBalance() + amount);
        } else {
            throw new IllegalArgumentException("The sender does not have enough funds");
        }
    }

}
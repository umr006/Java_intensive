package ex04;

import java.util.UUID;

public class TransactionsService {

    UsersArrayList usersArrayTransactionsService = new UsersArrayList();

    public void addUserInArray(User newUser) {
        usersArrayTransactionsService.addUser(newUser);
    }

    public double receiveUserBalance(User user) {
        user.getBalance();
    }

    public void initTransaction(int senderId, int recipientId, double amount) {
        UUID transId = UUID.randomUUID();
        Transaction transactionSender = new Transaction(usersArrayTransactionsService.retrieveUserById(senderId), usersArrayTransactionsService.retrieveUserById(recipientId), Transaction.transferCategory.DEBIT, amount);
        Transaction transactionRecipient = new Transaction(usersArrayTransactionsService.retrieveUserById(senderId), usersArrayTransactionsService.retrieveUserById(recipientId), Transaction.transferCategory.CREDIT, amount);
        usersArrayTransactionsService.retrieveUserById(senderId).addTransactionInList(transactionSender);
        usersArrayTransactionsService.retrieveUserById(recipientId).addTransactionInList(transactionRecipient);
    }

    public Transaction[] toArrayUserTransactions(User user) {
        return user.getList().toArray();
    }

    public void removeUserTransaction(UUID transactionId, int userId) {
        usersArrayTransactionsService.retrieveUserById(userId).removeTransactionInListById(transactionId);
    }
}

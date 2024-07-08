package ex05;

import java.util.UUID;

public class TransactionsService {

    UsersArrayList usersArrayTransactionsService = new UsersArrayList();

    public void addUserInArray(User newUser) {
        usersArrayTransactionsService.addUser(newUser);
    }

    public int addUserInArray(String name, int balance) {
        User newUser = new User(name, balance);
        usersArrayTransactionsService.addUser(newUser);
        return newUser.getId();
    }

    public double receiveUserBalance(User user) {
        return user.getBalance();
    }

    public void initTransaction(int senderId, int recipientId, double amount) {
        UUID transId = UUID.randomUUID();
        Transaction transactionSender = new Transaction(transId, usersArrayTransactionsService.retrieveUserById(senderId), usersArrayTransactionsService.retrieveUserById(recipientId), Transaction.transferCategory.DEBIT, amount);
        Transaction transactionRecipient = new Transaction(transId, usersArrayTransactionsService.retrieveUserById(senderId), usersArrayTransactionsService.retrieveUserById(recipientId), Transaction.transferCategory.CREDIT, -amount);
        usersArrayTransactionsService.retrieveUserById(senderId).addTransactionInList(transactionSender);
        usersArrayTransactionsService.retrieveUserById(recipientId).addTransactionInList(transactionRecipient);
    }


    public Transaction[] toArrayUserTransactions(User user) {
        return user.getList().toArray();
    }

    public void removeUserTransaction(UUID transactionId, int userId) {
        usersArrayTransactionsService.retrieveUserById(userId).removeTransactionInListById(transactionId);
    }

    public Transaction[] CheckValidTransactions(User user) {
        TransactionsLinkedList incorrectTransactionsList = new TransactionsLinkedList();
        Transaction[] userTransactions = user.getList().toArray();

        for (int i = 0; i < user.listOfUsertTransactions.numberTransaction(); i++) {
            boolean isFound = false;

            Transaction[] RecipientTransactions = userTransactions[i].getRecipient().getList().toArray();
            int cntSecondTransaction = userTransactions[i].getRecipient().listOfUsertTransactions.cntTransaction;

            for (int j = 0; j < cntSecondTransaction; j++) {
                if (userTransactions[i].getId() == RecipientTransactions[j].getId()) {
                    isFound = true;
                    break;
                }
            }

            if(!isFound) {
                incorrectTransactionsList.addTransaction(userTransactions[i]);
            }
        }
        return incorrectTransactionsList.toArray();
    }

    public int NumberOfUser() {
        return usersArrayTransactionsService.retrieveNumberOfUsers();
    }
}

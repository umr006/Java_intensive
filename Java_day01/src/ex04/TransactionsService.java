package ex04;

import java.util.UUID;

public class TransactionsService {
    UserArrayList userArray = new UserArrayList();

    public void addUser(String name, double balance) {
        userArray.addUser(name, balance);
    }

    public double getUserBalance(User user) {
        return user.getBalance();
    }

    public UUID transferInit(int idSender, int idRepicient, double transAmount) {
        UUID id = UUID.randomUUID();
        Transaction senderTrans = new Transaction(id, userArray.retrieveUserById(idSender), userArray.retrieveUserById(idRepicient), Transaction.TransferCategory.CREDIT, transAmount);
        Transaction repicientTrans = new Transaction(id, userArray.retrieveUserById(idSender), userArray.retrieveUserById(idRepicient), Transaction.TransferCategory.DEBIT, -transAmount);

        userArray.retrieveUserById(idSender).addTransactionInList(senderTrans);
        userArray.retrieveUserById(idRepicient).addTransactionInList(repicientTrans);
        return id;
    }

    public Transaction[] retrieveTrans(User user) {
        return user.list.toArray();
    }

    public Transaction[] retrieveTrans(int idUser) {
        return userArray.retrieveUserById(idUser).list.toArray();
    }

    public void removeTransaction(int idUser, UUID idTransaction) {
        userArray.retrieveUserById(idUser).removeTransactionInList(idTransaction);
    }

    public Transaction[] validTransaction(User user) {
        TransactionsLinkedList listUnvalid = new TransactionsLinkedList();
        Transaction[] tmp;
        Transaction[] transactions = user.list.toArray();

        for(int i = 0; i < user.list.cntTransaction; i++) {
            int countSecondTransactions;
            boolean isFound = false;
            if (transactions[i].getCategory() == Transaction.TransferCategory.CREDIT) {
                countSecondTransactions = transactions[i].getRecipient().list.cntTransaction;
                tmp = transactions[i].getRecipient().list.toArray();
            } else {
                countSecondTransactions = transactions[i].getSender().list.cntTransaction;
                tmp = transactions[i].getSender().list.toArray();
            }
            for (int j = 0; j < countSecondTransactions; j++) {
                if (transactions[i] == tmp[j]) {
                    isFound = true;
                }
            }
            if (!isFound) listUnvalid.addTransaction(transactions[i]);
        }
        return listUnvalid.toArray();
    }
}

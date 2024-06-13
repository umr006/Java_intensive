package ex04;

import java.util.UUID;

public class TransactionsService {
    UserArrayList userArrayTransService = new UserArrayList();

    public void addUser(User user) {
        userArrayTransService.addUser(user);
    }
    public void addUser(String name, double balance) {
        userArrayTransService.addUser(name, balance);
    }

    public double getUserBalance(User user) {
        return user.getBalance();
    }

    public UUID transferInit(int idSender, int idRepicient, double transAmount) {
        UUID id = UUID.randomUUID();
        Transaction senderTrans = new Transaction(id, userArrayTransService.retrieveUserById(idSender), userArrayTransService.retrieveUserById(idRepicient), Transaction.TransferCategory.CREDIT, transAmount);
        Transaction repicientTrans = new Transaction(id, userArrayTransService.retrieveUserById(idSender), userArrayTransService.retrieveUserById(idRepicient), Transaction.TransferCategory.DEBIT, -transAmount);

        userArrayTransService.retrieveUserById(idSender).addTransactionInList(senderTrans);
        userArrayTransService.retrieveUserById(idRepicient).addTransactionInList(repicientTrans);
        return id;
    }

    public Transaction[] retrieveTrans(User user) {
        return user.list.toArray();
    }

    public Transaction[] retrieveTrans(int idUser) {
        return userArrayTransService.retrieveUserById(idUser).list.toArray();
    }

    public void removeTransaction(int idUser, UUID idTransaction) {
        userArrayTransService.retrieveUserById(idUser).removeTransactionInList(idTransaction);
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

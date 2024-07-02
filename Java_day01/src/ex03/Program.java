package ex03;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("user1", 600);
        User user2 = new User("user2", 500);

        Transaction transaction1 = new Transaction(user1, user2, Transaction.transferCategory.DEBIT, 100);
        Transaction transaction2 = new Transaction(user1, user2, Transaction.transferCategory.DEBIT, 100);
        Transaction transaction3 = new Transaction(user1, user2, Transaction.transferCategory.DEBIT, 100);
        Transaction transaction4 = new Transaction(user1, user2, Transaction.transferCategory.DEBIT, 100);
        Transaction transaction5 = new Transaction(user1, user2, Transaction.transferCategory.DEBIT, 100);
        TransactionsLinkedList transList = new TransactionsLinkedList();
        transList.addTransaction(transaction1);
        transList.addTransaction(transaction2);
        transList.addTransaction(transaction3);
        transList.addTransaction(transaction4);
        transList.addTransaction(transaction5);

        Transaction[] array = transList.toArray();

        System.out.println(transaction1);
        System.out.println(transaction2);
        System.out.println(transaction3);
        System.out.println(transaction4);
        System.out.println(transaction5);
        System.out.println("-------------------");
        for(int i = 0; i < transList.cntTransaction; i++) {
            System.out.println(array[i]);
        }
        System.out.println("-------------------");
        System.out.println(transaction2.getId());
        for(int i = 0; i < transList.cntTransaction; i++) {
            System.out.println(array[i]);
        }
        System.out.println("-------------------");
        transList.removeTransactionById(transaction1.getId());
        for(int i = 0; i < transList.cntTransaction; i++) {
            System.out.println(array[i]);
        }
        System.out.println(user2);
    }
}

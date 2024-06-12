package ex04;

public class Program {
    public static void main(String[] args) {
        User Mark = new User("Mark", 1000);
        User Oleg = new User("Oleg", 1000);

        Transaction[] array;

        Transaction one = new Transaction(Mark, Oleg, Transaction.TransferCategory.DEBIT, 100);
        Transaction two = new Transaction(Oleg, Mark, Transaction.TransferCategory.CREDIT, -100);
        Transaction three = new Transaction(Oleg, Mark, Transaction.TransferCategory.DEBIT, 50);
        Transaction four = new Transaction(Mark, Oleg, Transaction.TransferCategory.CREDIT, -50);
        Transaction five = new Transaction(Mark, Oleg, Transaction.TransferCategory.CREDIT, -50);
        System.out.println(one.getTransferAmount());
        Mark.addTransactionInList(one);
        Mark.addTransactionInList(two);
        Mark.addTransactionInList(three);
        Mark.addTransactionInList(four);
        System.out.println(Mark.list.cntTransaction);
        array = Mark.list.toArray();

        for (Transaction value : array) {
            System.out.println(value);
            System.out.print(" ");
        }
        Mark.list.removeTransactionById(four);
        Mark.list.addTransaction(five);
        array = Mark.list.toArray();
        for (Transaction value : array) {
            System.out.println(value);
            System.out.print(" ");
        }
        System.out.println("ex04");
        System.out.println();
    }
}

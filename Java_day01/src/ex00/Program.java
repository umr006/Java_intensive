package ex00;

public class Program {
    public static void main(String[] args) {
                User user1 = new User(1, "John", 340);
                User user2 = new User(2, "Drakula", 200);
                System.out.println(user1);
                System.out.println(user2);
                Transaction trans1 = new Transaction(user1, user2, Transaction.TransactionCategory.DEBIT, 300);
                System.out.println(trans1);
                System.out.println(user1);
                System.out.println(user2);
    }
}

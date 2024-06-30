package ex00;

public class Program {

    public static void main (String[] args) {
        User user1 = new User(1, "foo", 400);
        User user2 = new User(2, "foo1", 500);

        System.out.println(user1.getBalance());
        System.out.println(user2.getBalance());

        Transaction t1 = new Transaction(user1, user2, Transaction.transferCategory.CREDIT, -100);
        System.out.println(user1.getBalance());
        System.out.println(user2.getBalance());
    }
}

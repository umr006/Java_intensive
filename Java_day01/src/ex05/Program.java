package ex05;


public class Program {

    public static void main(String[] args) {
        User user1 = new User("user1", 1000);
        User user2 = new User("user2", 1000);
        User user3 = new User("user3", 1000);
        User user4 = new User("user4", 1000);

        TransactionsService service = new TransactionsService();
        service.addUserInArray(user1);
        service.addUserInArray(user2);
        service.addUserInArray(user3);
        service.addUserInArray(user4);

        service.initTransaction(user1.getId(), user2.getId(), 100);
        service.initTransaction(user1.getId(), user2.getId(), 100);

        System.out.println(user1);
        System.out.println(user2);

        Transaction[] array = user1.userTransactionToArray();
        Transaction[] array1 = user2.userTransactionToArray();

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array1[0]);
        System.out.println(array1[1]);
        System.out.println("ex05");
    }
}

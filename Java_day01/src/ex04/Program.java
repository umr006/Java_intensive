package ex04;

public class Program {
    public static void main(String[] args) {
        TransactionsService facede = new TransactionsService();

        User aboba = new User("Aboba", 4567);
        User qwerty = new User("Qwerty", 12345);

        facede.addUser(aboba);
        facede.addUser(qwerty);

        System.out.println(facede.userArray.retrieve);

        facede.transferInit(aboba.getId(), qwerty.getId(), 500);
        System.out.println(aboba.getBalance());
        System.out.println(qwerty.getBalance());

    }
}

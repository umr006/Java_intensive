package ex01;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("ALEX", 2000);
        User user2 = new User("BOB", 2345);

        System.out.printf("%d %s %f", user1.getId(), user1.getName(), user1.getBalance());
        System.out.printf("\n%d %s %f", user2.getId(), user2.getName(), user2.getBalance());
    }
}

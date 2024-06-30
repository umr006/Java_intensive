package ex01;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("foo", 400);
        User user2 = new User("foo1", 500);

        System.out.println(user1.getId());
        System.out.println(user2.getId());
        System.out.println(user2.getId());
    }
}

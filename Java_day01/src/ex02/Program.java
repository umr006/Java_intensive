package ex02;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("foo", 400);
        User user2 = new User("foo1", 500);
        UsersArrayList arr = new UsersArrayList();
        arr.addUser(user1);
        arr.addUser(user2);
        Transaction trn1 = new Transaction(user1, user2, Transaction.transferCategory.DEBIT, 200);


        for(int i = 0; i < arr.retrieveNumberOfUsers(); i++) {
            System.out.println(arr.retrieveUserByIndex(i));
        }
    }
}

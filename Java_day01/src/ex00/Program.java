package ex00;

public class Program {
    public static void main(String[] args) {
        User u = new User(1, "Kms", 100);
        User u2 = new User(2, "Umdf", 200);
        Transaction uTou1 = new Transaction(u, u2, Transaction.TransferCategory.DEBIT, 100);
        System.out.println(u.getBalance());
        System.out.println(u2.getBalance());
    }
}

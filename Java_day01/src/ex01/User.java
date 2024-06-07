package ex01;
import java.util.Scanner;
public class User {
    private int id;
    private String name;
    private double balance;
    //UserIdsGenerator UserIdsGenerator;
    public User(String name, double balance) {
        setId(id);
        setName(name);
        setBalance(balance);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = UserIdsGenerator.getInstance().generateId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {

        try {
            if (balance >= 0) {
                this.balance = balance;
            } else {
                throw new IllegalAccessError("The balance cannot be less zero!");
            }
        } catch (IllegalAccessError e) {
            System.out.println(e.getMessage());
        }
    }
}

package ex00;
import java.util.Scanner;
//Таким образом, следующий набор состояний (полей) является типичным для класса User:
//
//        Идентификатор
//        Имя
//        Баланс
public class User {
    private int id;
    private String name;
    private double balance;

    public User(int id, String name, double balance) {
        setId(id);
        setName(name);
        setBalance(balance);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
            if (balance > 0) {
                this.balance = balance;
            } else {
                throw new IllegalAccessError("The balance cannot be less zero!");
            }
        } catch (IllegalAccessError e) {
            System.out.println(e.getMessage());
        }
    }
}
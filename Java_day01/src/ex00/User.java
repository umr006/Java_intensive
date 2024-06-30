package ex00;

public class User {
    private int id;
    private String name;
    private double balance;

    public User() {

    }

    public User(int id, String name, double balance) throws IllegalArgumentException {
        setId(id);
        setName(name);
        try {
            setBalance(balance);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
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

    public void setBalance(double balance) throws IllegalArgumentException {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be less zero!");
        }
        this.balance = balance;
    }
}

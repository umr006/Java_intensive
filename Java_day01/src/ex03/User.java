package ex03;


public class User {
    private int id;
    private String name;
    private double balance;

    public User() {

    }

    public User(String name, double balance) throws IllegalArgumentException {
        setId();
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
    //method is private
    private void setId() {
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

    public void setBalance(double balance) throws IllegalArgumentException {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be less zero!");
        }
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + ", balance=" + balance + "'}";
    }
}
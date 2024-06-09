package ex03;

public class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private static int id;

    private UserIdsGenerator() {
        id = 0;
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }

    public static int generateId() {
        return ++id;
    }
}

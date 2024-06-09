package ex03;

import ex02.User;
import ex02.UserList;

public class UserArrayList implements UserList {
    private int userArraySize = 10;
    private ex02.User[] userArray = new ex02.User[userArraySize];
    private int capacity = 0;

    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException() {
            super("User not found");
        }
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    public void printUserList() {
        for (int i = 0; i < userArray.length; i++) {
            System.out.println(userArray[i]);
        }
    }

    private void resize() {
        userArraySize *= 2;
        ex02.User[] newUserArray = new ex02.User[userArraySize];
        for (int i = 0; i < userArray.length; i++) {
            newUserArray[i] = userArray[i];
        }
        userArray = newUserArray;
    }

    public void addUser(String name) {
        ex02.User newUser = new ex02.User(name, 0);
        userArray[capacity++] = newUser;
        if(capacity == userArray.length) {
            resize();
        }
    }

    public ex02.User retrieveUserById(int id) {
        int userFound = -1;
        for(int i = 0; i < userArray.length; i++) {
            if (userArray[i].getId() == id) {
                userFound = id;
                break;
            }
            if (userFound == -1) {
                System.out.println("User id does not exist");
                throw new UserNotFoundException("User id does not exist");
            }
        }
        return userArray[userFound];
    }

    public User retrieveUserByIndex(int index) {
        if (index > capacity || index < 0) {
            System.out.println("User index does not exist");
            throw new UserNotFoundException("User index does not exist");
        }
        return userArray[index];
    }

    public int retrieveNumberOfUser() {
        return capacity;
    }
}

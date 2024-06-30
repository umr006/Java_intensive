package ex03;


public class UsersArrayList implements UsersList {
    private int arraySize = 10;
    private int userCnt = 0;
    private User[] userArray = new User[arraySize];

    private void resize() {
        arraySize *= 2;
        userArray = new User[arraySize];
    }

    public void addUser(User newUser) {
        if (arraySize == userCnt) {
            resize();
        }
        userArray[userCnt] = newUser;
        userCnt++;
    }

    public User retrieveUserById(int id) throws UserNotFoundException {
        for (User curUser : userArray) {
            if(curUser.getId() == id) {
                return curUser;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public User retrieveUserByIndex(int index) {
        return userArray[index];
    }

    public int retrieveNumberOfUsers() {
        return userCnt;
    }
}
package ex03;

import ex02.User;

public interface UserList {
    void addUser(String name);
    ex02.User retrieveUserById(int id);
    User retrieveUserByIndex(int index);
    int retrieveNumberOfUser();
}

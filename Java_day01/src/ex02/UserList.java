package ex02;

public interface UserList {
    void addUser(String name);
    User retrieveUserById(int id);
    User retrieveUserByIndex(int index);
    int retrieveNumberOfUser();
}

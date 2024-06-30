package ex03;

interface UsersList {
    void addUser(User newUser);
    User retrieveUserById(int id);
    User retrieveUserByIndex(int index);
    int retrieveNumberOfUsers();
}
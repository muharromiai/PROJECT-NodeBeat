public class UserManager {

    User[] users;
    int size;

    public UserManager(int capacity) {
        users = new User[capacity];
        size = 0;

        addUser("admin", "1111", "admin");
        addUser("user", "2222", "user");
    }

    public void addUser(String username, String password, String role) {
        users[size] = new User(username, password, role);
        size++;
    }

    public User login(String username, String password) {
        for (int i = 0; i < size; i++) {
            User u = users[i];
            if (u.username.equals(username) && u.password.equals(password)) {
                return u;
            }
        }
        return null;
    }
}
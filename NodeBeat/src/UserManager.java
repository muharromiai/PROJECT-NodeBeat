import java.util.ArrayList;

public class UserManager {
    ArrayList<User> users = new ArrayList<>();

    // Menambah user baru
    public void addUser(User u) {
        users.add(u);
    }

    // Login sesuai kebutuhan LoginSystem
    public User login(String username, String password) {
        for (User u : users) {
            if (u.username.equals(username) && u.password.equals(password)) {
                return u;
            }
        }
        return null;
    }

    // Menampilkan semua user (opsional)
    public void showUsers() {
        for (User u : users) {
            System.out.println(u.username + " (" + u.role + ")");
        }
    }
}

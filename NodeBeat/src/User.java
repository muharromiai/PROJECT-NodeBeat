public class User {
    String username;
    String password;
    String role; // admin atau user biasa

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
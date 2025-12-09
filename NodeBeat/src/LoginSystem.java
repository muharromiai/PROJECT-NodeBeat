import java.util.Scanner;

public class LoginSystem {
    UserManager userManager;

    public LoginSystem(UserManager userManager) {
        this.userManager = userManager;
    }

    public User startLogin() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Login =====");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        User u = userManager.login(username, password);

        if (u == null) {
            System.out.println("Login gagal! Username atau password salah.");
            return null;
        }

        System.out.println("Login berhasil sebagai: " + u.role);
        return u;
    }
}

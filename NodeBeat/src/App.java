import java.util.Scanner;
public class App {
    static UserManager userManager = new UserManager(10);
    static LoginSystem loginSystem = new LoginSystem(userManager);
    public static void main(String[] args) {
        User logged = null;
        while (logged == null) {
            logged = loginSystem.startLogin();
        }
        if (logged.role.equals("admin")) {
            menuAdmin();
        }else {
            menuUser();
        }
    }


    // Nyoba aja nii
    // admin
    public static void menuAdmin() {
        Scanner sc = new Scanner(System.in);
        int pilih = 0;
        do {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Tambah lagu ke library");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            switch (pilih) {

                // Belom ada fungsi add lagu, ntar bikin yak
                case 1:
                    System.out.println("Tambahkan lagu");
                    break;
            }

        } while (pilih != 0);
    }
    // user biasa
    public static void menuUser() {
        Scanner sc = new Scanner(System.in);
        int pilih = 0;
        do {
            System.out.println("\n=== MENU USER ===");
            System.out.println("1. Cari lagu");
            System.out.println("2. Play lagu");
            System.out.println("3. Tambah ke Queue");
            System.out.println("4. Buat playlist");
            System.out.println("5. Putar playlist");
            System.out.println("6. Undo lagu");
            System.out.println("7. Next lagu");
            System.out.println("0. Logout");

            System.out.print("Pilih: ");
            pilih = sc.nextInt();

            switch (pilih) {
                // Ini jugak
                case 1: System.out.println("Fungsi cari lagu..."); break;
                case 2: System.out.println("Fungsi play lagu..."); break;
                case 3: System.out.println("Tambah ke queue..."); break;
                case 4: System.out.println("Buat playlist..."); break;
                case 5: System.out.println("Putar playlist..."); break;
                case 6: System.out.println("Undo lagu..."); break;
                case 7: System.out.println("Next lagu..."); break;
            }

        } while (pilih != 0);
    }
}
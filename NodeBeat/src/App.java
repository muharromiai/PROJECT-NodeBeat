import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class App {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Lagu> semuaLagu = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();

    static Queue<Lagu> antrian = new LinkedList<>();
    static Stack<Lagu> riwayat = new Stack<>();

    static Playlist playlist = new Playlist("Playlist");

    public static void main(String[] args) {

        // ADMIN DEFAULT
        users.add(new Admin("admin", "admin123"));

        menuAwal();
    }

    // ===================== MENU AWAL =====================
    static void menuAwal() {
        while (true) {
            System.out.println("\n=====   NODEBEAT   =====");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.print("Pilih: ");

            int pilih = Integer.parseInt(sc.nextLine());

            switch (pilih) {
                case 1 -> menuLogin();
                case 2 -> menuSignUp();
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    // ===================== SIGN UP (USER OTOMATIS) =====================
    static void menuSignUp() {
        System.out.println("\n===== SIGN UP =====");

        System.out.print("Username: ");
        String u = sc.nextLine();

        for (User x : users) {
            if (x.username.equalsIgnoreCase(u)) {
                System.out.println("Username sudah digunakan!");
                return;
            }
        }

        System.out.print("Password: ");
        String p = sc.nextLine();

        // Otomatis user biasa
        users.add(new User(u, p, "user"));
        System.out.println("Akun User berhasil dibuat!");
    }

    // ===================== LOGIN =====================
    static void menuLogin() {
        System.out.println("\n===== LOGIN =====");
        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();

        User login = null;

        for (User x : users) {
            if (x.username.equals(u) && x.password.equals(p)) {
                login = x;
                break;
            }
        }

        if (login == null) {
            System.out.println("Login gagal! Username atau password salah.");
            return;
        }

        System.out.println("Login berhasil sebagai: " + login.role);

        if (login instanceof Admin)
            menuAdmin();
        else
            menuUser();
    }

    // ===================== MENU ADMIN =====================
    static void menuAdmin() {
        while (true) {
            System.out.println("\n===== MENU ADMIN =====");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Lihat Semua Lagu");
            System.out.println("3. Logout");
            System.out.print("Pilih: ");

            int pilih = Integer.parseInt(sc.nextLine());

            switch (pilih) {
                case 1 -> tambahLaguAdmin();
                case 2 -> tampilkanSemuaLagu();
                case 3 -> { 
                    System.out.println("Logout berhasil!");
                    return; 
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static void tambahLaguAdmin() {
        System.out.println("\n===== TAMBAH LAGU =====");
        System.out.print("Judul: ");
        String j = sc.nextLine();
        System.out.print("Penyanyi: ");
        String p = sc.nextLine();

        semuaLagu.add(new Lagu(j, p));
        System.out.println("Lagu berhasil ditambahkan!");
    }

    static void tampilkanSemuaLagu() {
        System.out.println("\n===== DAFTAR LAGU =====");
        int i = 1;
        for (Lagu l : semuaLagu) {
            System.out.println(i + ". " + l);
            i++;
        }
    }

    // ===================== MENU USER =====================
    static void menuUser() {
        while (true) {
            System.out.println("\n===== MENU USER =====");
            System.out.println("1. Lihat Lagu");
            System.out.println("2. Mainkan Lagu");
            System.out.println("3. Lihat Playlist");
            System.out.println("4. Tambah ke Playlist");
            System.out.println("5. Logout");
            System.out.print("Pilih: ");

            int pilih = Integer.parseInt(sc.nextLine());

            switch (pilih) {
                case 1 -> tampilkanSemuaLagu();
                case 2 -> playLaguUser();
                case 3 -> playlist.tampilkan();
                case 4 -> tambahKePlaylist();
                case 5 -> { 
                    System.out.println("Logout berhasil!");
                    return; 
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    // ===================== USER: MAIN LAGU =====================
    static void playLaguUser() {
        if (semuaLagu.isEmpty()) {
            System.out.println("Tidak ada lagu tersedia.");
            return;
        }

        tampilkanSemuaLagu();
        System.out.print("Pilih lagu: ");
        int pilih = Integer.parseInt(sc.nextLine());

        if (pilih < 1 || pilih > semuaLagu.size()) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        Lagu lagu = semuaLagu.get(pilih - 1);
        antrian.add(lagu);
        riwayat.push(lagu);

        System.out.println("Memainkan: " + lagu);
    }

    // ===================== USER: TAMBAH KE PLAYLIST =====================
    static void tambahKePlaylist() {
        tampilkanSemuaLagu();
        System.out.print("Pilih lagu: ");

        int pilih = Integer.parseInt(sc.nextLine());

        if (pilih < 1 || pilih > semuaLagu.size()) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        playlist.tambah(semuaLagu.get(pilih - 1));
    }
}

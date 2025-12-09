import java.util.Scanner;
public class Main {
    static UserManager userManager = new UserManager(10);
    static LoginSystem loginSystem = new LoginSystem(userManager);
    static MusicLibrary library = new MusicLibrary();
  
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

    // admin
    public static void menuAdmin() {
        Scanner sc = new Scanner(System.in);
        int pilih = 0;
        do {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Tambah lagu ke library");
            System.out.println("2. Logout");
            System.out.print("Pilih: ");
            pilih = sc.nextInt(); sc.nextLine();

            switch (pilih) {
                // Menu admin buat masukin genre, artis, ma judul.
                case 1:
                    System.out.print("Masukkan genre: ");
                    String genre = sc.nextLine();

                    System.out.print("Masukkan artis: ");
                    String artist = sc.nextLine();

                    System.out.print("Masukkan judul lagu: ");
                    String title = sc.nextLine();

                    library.addSong(genre, artist, title);
                    System.out.println("Lagu berhasil ditambahkan!");
                    break;
                case 2: // (balik ke menu login)
                    return;
                default:
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
                case 1: System.out.println("Fungsi cari lagu..."); break; // tambahin fungsi
                case 2: System.out.println("Fungsi play lagu..."); break;// tambahin fungsi
                case 3: System.out.println("Tambah ke queue..."); break; // tambahin fungsi
                case 4: System.out.println("Buat playlist..."); break; // tambahin fungsi
                case 5: System.out.println("Putar playlist..."); break; // tambahin fungsi
                case 6: System.out.println("Undo lagu..."); break; // tambahin fungsi
                case 7: System.out.println("Next lagu..."); break; // tambahin fungsi
            }

        } while (pilih != 0);
    }


    
    // ini menu buat user? kalo iya, coba tambahiin di yg atas ini aja
    UndoRedo playlist = new UndoRedo();
    Scanner sc = new Scanner(System.in);



    // Tambah 3 lagu default
    playlist.addSong("Lagu A");
    playlist.addSong("Lagu B");
    playlist.addSong("Lagu C");

    int pilih;

    do {
        System.out.println("\n===== MENU MUSIK =====");
        playlist.showCurrent();
        System.out.println("1. Next Lagu");
        System.out.println("2. Prev Lagu");
        System.out.println("3. Undo");
        System.out.println("4. Exit");
        System.out.print("Pilih: ");

        pilih = sc.nextInt();
        sc.nextLine(); // buang newline

        switch (pilih) {
            case 1:
                playlist.next();
                break;
            case 2:
                playlist.prev();
                break;
            case 3:
                playlist.undo();
                break;
            case 4:
                System.out.println("Keluar...");
                break;
            default:
                System.out.println("Pilihan salah!");
        }

    } while (pilih != 4);
}
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryLagu {
    public static ArrayList<Lagu> daftarLagu = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void tambahLagu() {
        System.out.print("Judul : ");
        String j = input.nextLine();
        System.out.print("Artist : ");
        String a = input.nextLine();
        System.out.print("Durasi (detik): ");
        int d = input.nextInt();
        input.nextLine();

        daftarLagu.add(new Lagu(j, a, d));
        System.out.println("Lagu berhasil ditambahkan!");
    }

    public static void tampilkanLagu() {
        System.out.println("===== LIBRARY LAGU =====");
        int i = 1;
        for (Lagu l : daftarLagu) {
            System.out.println(i + ". " + l.judul + " - " + l.artist + " (" + l.durasi + "s)");
            i++;
        }
    }

    public static void hapusLagu() {
        tampilkanLagu();
        System.out.print("Pilih nomor untuk dihapus: ");
        int idx = input.nextInt(); input.nextLine();
        daftarLagu.remove(idx - 1);
        System.out.println("Lagu berhasil dihapus.");
    }
}

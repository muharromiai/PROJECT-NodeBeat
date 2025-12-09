import java.util.ArrayList;

public class Playlist {
    String nama;
    ArrayList<Lagu> daftar = new ArrayList<>();

    public Playlist(String nama) {
        this.nama = nama;
    }

    public void tambah(Lagu l) {
        daftar.add(l);
        System.out.println("Ditambahkan ke playlist.");
    }

    public void hapus(String judul) {
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getJudul().equalsIgnoreCase(judul)) {
                daftar.remove(i);
                System.out.println("Lagu dihapus dari playlist.");
                return;
            }
        }
        System.out.println("Tidak ditemukan.");
    }

    public void tampilkan() {
        if (daftar.isEmpty()) {
            System.out.println("Playlist kosong.");
            return;
        }

        System.out.println("\n===== PLAYLIST: " + nama + " =====");
        for (Lagu l : daftar) {
            System.out.println("- " + l);
        }
    }
}

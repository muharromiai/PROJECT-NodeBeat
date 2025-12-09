public class Lagu {
    public String judul;
    public String artist;
    public int durasi;

    public Lagu(String judul, String artist, int durasi) {
        this.judul = judul;
        this.artist = artist;
        this.durasi = durasi;
    }

    public String getJudul() {
        return judul;
    }

    public String getArtist() {
        return artist;
    }

    public int getDurasi() {
        return durasi;
    }

    @Override
    public String toString() {
        return judul + " - " + artist + " (" + durasi + "s)";
    }
}

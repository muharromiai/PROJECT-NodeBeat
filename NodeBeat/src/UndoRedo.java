public class UndoRedo {

    NodePrevNext head;
    NodePrevNext tail;
    NodePrevNext current;

    NodePrevNext lastState; // untuk UNDO

    public UndoRedo() {
        head = null;
        tail = null;
        current = null;
        lastState = null;
    }

    // Tambah lagu ke playlist
    public void addSong(String song) {
        NodePrevNext newNode = new NodePrevNext(song);

        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Simpan posisi sebelum pindah (UNDO)
    private void saveState() {
        lastState = current;
    }

    // Pindah ke lagu berikutnya
    public void next() {
        if (current == null) return;

        saveState();

        if (current.next != null) {
            current = current.next;
        } else {
            System.out.println("Sudah di lagu terakhir!");
        }
    }

    // Pindah ke lagu sebelumnya
    public void prev() {
        if (current == null) return;

        saveState();

        if (current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Sudah di lagu pertama!");
        }
    }

    // Kembali ke posisi sebelumnya
    public void undo() {
        if (lastState == null) {
            System.out.println("Undo tidak tersedia!");
            return;
        }

        current = lastState;
        lastState = null;
    }

    // Menampilkan lagu saat ini
    public void showCurrent() {
        if (current == null) {
            System.out.println("Playlist kosong!");
        } else {
            System.out.println("Sedang diputar: " + current.song);
        }
    }
}

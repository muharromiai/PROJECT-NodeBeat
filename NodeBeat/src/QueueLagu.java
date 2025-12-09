public class QueueLagu {

    // Node untuk menyimpan data lagu
    private class Node {
        String judul;
        String artis;
        Node next;

        Node(String judul, String artis) {
            this.judul = judul;
            this.artis = artis;
            this.next = null;
        }
    }

    private Node front; // elemen terdepan
    private Node rear;  // elemen terakhir

    // Konstruktor → antrian kosong
    public QueueLagu() {
        this.front = null;
        this.rear = null;
    }

    // ➤ Tambah lagu ke antrian
    public void enqueue(String judul, String artis) {
        Node baru = new Node(judul, artis);

        if (rear == null) {      // jika antrian kosong
            front = rear = baru;
            return;
        }

        rear.next = baru;        // tambahkan di belakang
        rear = baru;             // update rear
    }

    // ➤ Ambil & hapus lagu dari antrian
    public String dequeue() {
        if (front == null) {
            return null;         // antrian kosong
        }

        String laguDiputar = front.judul + " - " + front.artis;
        front = front.next;      // pindahkan front ke node berikutnya

        if (front == null) {     // jika front null, rear juga harus null
            rear = null;
        }

        return laguDiputar;
    }

    // ➤ Cek apakah antrian kosong
    public boolean isEmpty() {
        return front == null;
    }

    // ➤ Menampilkan isi antrian
    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian lagu kosong.");
            return;
        }

        Node temp = front;
        System.out.println("=== ANTRIAN LAGU ===");
        while (temp != null) {
            System.out.println("- " + temp.judul + " | " + temp.artis);
            temp = temp.next;
        }
    }
}

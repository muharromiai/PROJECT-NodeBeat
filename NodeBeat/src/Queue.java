public class Queue {
    Lagu[] data;
    int front, rear, size, max;

    public Queue(int max) {
        this.max = max;
        data = new Lagu[max];
        front = rear = size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void enqueue(Lagu l) {
        if (isFull()) {
            System.out.println("Antrian penuh.");
            return;
        }
        data[rear] = l;
        rear = (rear + 1) % max;
        size++;
    }

    public Lagu dequeue() {
        if (isEmpty()) {
            return null;
        }
        Lagu l = data[front];
        front = (front + 1) % max;
        size--;
        return l;
    }

    public void tampilkan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("\n===== ANTRIAN =====");
        int idx = front;
        for (int i = 0; i < size; i++) {
            System.out.println("- " + data[idx]);
            idx = (idx + 1) % max;
        }
    }
}

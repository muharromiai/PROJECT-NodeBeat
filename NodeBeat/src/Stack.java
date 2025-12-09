public class Stack {
    Lagu[] data;
    int top, max;

    public Stack(int max) {
        this.max = max;
        data = new Lagu[max];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == max - 1;
    }

    public void push(Lagu l) {
        if (isFull()) {
            System.out.println("Riwayat penuh.");
            return;
        }
        data[++top] = l;
    }

    public Lagu pop() {
        if (isEmpty()) return null;
        return data[top--];
    }

    public void tampilkan() {
        if (isEmpty()) {
            System.out.println("Riwayat kosong.");
            return;
        }

        System.out.println("\n===== RIWAYAT =====");
        for (int i = top; i >= 0; i--) {
            System.out.println("- " + data[i]);
        }
    }
}

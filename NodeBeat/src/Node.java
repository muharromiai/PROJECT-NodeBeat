public class Node { // buat tree tempet nyimpen data lagunya
    String name;
    Node child;
    Node sibling;

    public Node(String name) {
        this.name = name;
        this.child = null;
        this.sibling = null;
    }

    public Node findChild(String name) {
        Node temp = child;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.sibling;
        }
        return null;
    }

    public Node addChild(String name) {
        Node existing = findChild(name);
        if (existing != null) return existing;

        Node newNode = new Node(name);
        newNode.sibling = child;
        child = newNode;
        return newNode;
    }
}
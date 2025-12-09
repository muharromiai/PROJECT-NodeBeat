public class NodePrevNext {
    String song;
    NodePrevNext next;
    NodePrevNext prev;

    public NodePrevNext(String song) {
        this.song = song;
        next = null;
        prev = null;
    }
}

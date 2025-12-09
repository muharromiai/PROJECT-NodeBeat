public class MusicLibrary { // ini fungsi untuk masukin data lagunya
    Node root = new Node("Library");

    public void addSong(String genre, String artist, String title) {
        Node genreNode = root.addChild(genre);
        Node artistNode = genreNode.addChild(artist);
        artistNode.addChild(title);
    }
}
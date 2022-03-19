public class Song {
    public final String title;
    public final Artist artist;
    public final Album album;

    public Song(String name, Artist artist, Album album) {
        this.title = name;
        this.artist = artist;
        this.album = album;
    }

    public String toString() {
        return title + " - " + artist.name + "\n" + album.title + "(" + album.year + ")";
    }
}

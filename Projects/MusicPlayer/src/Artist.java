import java.util.ArrayList;

public class Artist {
    public final String name;
    private final ArrayList<Album> albums = new ArrayList<>();

    public Artist(String name) {
        this.name = name;
    }

    public ArrayList<Album> getAlbums(){
        return albums;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }
}

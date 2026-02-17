public class Song {
    private String title;
    private String artist;
    private String album;
    private int length;
    private int year;
    private String genre;

    public Song(String title, String artist, String album, int length, int year, String genre){
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.length = length;
        this.year = year;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getLength() {
        return length;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toString() {
        return String.format("%-22s %-20s %-30s %-6d %-12s",
                title, artist, album, year, genre);
    }
}

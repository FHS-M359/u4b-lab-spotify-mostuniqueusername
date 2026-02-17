public class SpotifyTester {

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.readSongsFromFile("U4BLab/spotify_unique_years_artists.txt");
        System.out.println(playlist);
    }
}

import java.util.Scanner;

public class SpotifyTester {

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.readSongsFromFile("U4BLab/spotify_unique_years_artists.txt");
        System.out.println(playlist);

        Scanner input = new Scanner(System.in);

        System.out.println("What genre are you searching for?");
        String genreSearching = input.nextLine();

        playlist.searchByGenre(genreSearching);
    }
}

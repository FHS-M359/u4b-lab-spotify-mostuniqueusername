import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Playlist {
    private ArrayList<Song> songs = new ArrayList<Song>();

    public Playlist() {
        this.songs = songs;
    }

    public void readSongsFromFile(String name) {
        try {
            Scanner fileReader = new Scanner(new File(name));

            while (fileReader.hasNextLine()) {

                String line = fileReader.nextLine();
                String[] parts = line.split(",");

                String title = parts[0];
                String artist = parts[1];
                String album = parts[2];
                int length = Integer.parseInt(parts[3]);
                int year = Integer.parseInt(parts[4]);
                String genre = parts[5];

                Song s = new Song(title, artist, album, length, year, genre);
                songs.add(s);
            }

            fileReader.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public String toString() {

        String result = "";

        result += String.format("%-22s %-20s %-30s %-6s %-12s%n",
                "Title", "Artist", "Album", "Year", "Genre");

        result += "-------------------------------------------------------------------------------\n";

        for (Song song : songs) {
            result += song.toString() + "\n";
        }

        return result;
    }
}

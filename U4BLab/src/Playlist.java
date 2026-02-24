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

        result += "---------------------------------------------------------------------------------------\n";

        for (Song song : songs) {
            result += song.toString() + "\n";
        }

        return result;
    }

    public void searchByGenre(String genreSearching) {
        boolean searched = false;

        for (int i = 0; i < songs.size(); i++) {
            String returned = songs.get(i).getGenre();
            if (returned.equalsIgnoreCase(genreSearching)) {
                System.out.println(songs.get(i));
                searched = true;
            }
        }
        if (!searched) {
            System.out.println("No songs were found in that genre.");
        }
    }

    public void sortArtistAZ() {
        for (int i = 0; i < songs.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < songs.size(); j++) {
                String artistJ = songs.get(j).getArtist();
                String artistMin = songs.get(minIndex).getArtist();
                if (artistJ.compareTo(artistMin) < 0) {
                    minIndex = j;
                }
            }

            Song temp = songs.get(i);
            songs.set(i, songs.get(minIndex));
            songs.set(minIndex, temp);
        }
    }

    public void sortArtistZA() {
        for (int i = 0; i < songs.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < songs.size(); j++) {
                String artistJ = songs.get(j).getArtist();
                String artistMin = songs.get(maxIndex).getArtist();
                if (artistJ.compareTo(artistMin) > 0) {
                    maxIndex = j;
                }
            }

            Song temp = songs.get(i);
            songs.set(i, songs.get(maxIndex));
            songs.set(maxIndex, temp);
        }
    }

    public void sortYearOldNew() {
        for (int i = 1; i < songs.size(); i++) {
            Song temp = songs.get(i);
            int position = i;
            while (position > 0 &&
                    songs.get(position - 1).getYear() > temp.getYear()) {
                songs.set(position, songs.get(position - 1));
                position--;
            }

            songs.set(position, temp);
        }
    }

    public void sortYearNewOld(){
        for (int i = 1; i < songs.size(); i++) {
            Song temp = songs.get(i);
            int position = i;
            while (position > 0 &&
                    songs.get(position - 1).getYear() < temp.getYear()) {

                songs.set(position, songs.get(position - 1));
                position--;
            }

            songs.set(position, temp);
        }
    }
}

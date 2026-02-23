import java.util.InputMismatchException;
import java.util.Scanner;

public class SpotifyTester {

    public static int SORT_AZ = 1;
    public static int SORT_ZA = 2;
    public static int SORT_YEAR_OLD_NEW = 3;
    public static int SORT_YEAR_NEW_OLD = 4;
    public static int SEARCH_GENRE = 5;
    public static int DISPLAY_ALL = 6;
    public static int QUIT = 7;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = getValidChoice(input);

        input.close();
    }

    public static void printMenu() {
        System.out.println("\n--- Spotify Menu ---");
        System.out.println("1. Sort by Artist A-Z");
        System.out.println("2. Sort by Artist Z-A");
        System.out.println("3. Sort by Year Old-New");
        System.out.println("4. Sort by Year New-Old");
        System.out.println("5. Search by Genre");
        System.out.println("6. Display All Songs");
        System.out.println("7. Quit");
    }

    public static int getValidChoice(Scanner input) {
        int choice = -1;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println("\n--- Spotify Menu ---");
                System.out.println("1. Sort by Artist A-Z");
                System.out.println("2. Sort by Artist Z-A");
                System.out.println("3. Sort by Year Old-New");
                System.out.println("4. Sort by Year New-Old");
                System.out.println("5. Search by Genre");
                System.out.println("6. Display All Songs");
                System.out.println("7. Quit");
                System.out.println("Enter your choice (1-7): ");
                choice = Integer.parseInt(input.nextLine());

                Playlist playlist = new Playlist();
                playlist.readSongsFromFile("U4BLab/spotify_unique_years_artists.txt");

                if (choice >= 1 && choice <= 7) {
                    valid = true;

                    if (choice == SORT_AZ) {
                        playlist.sortArtistAZ();
                        System.out.println(playlist);
                    }
                    else if (choice == SORT_ZA) {
                        playlist.sortArtistZA();
                        System.out.println(playlist);
                    }
                    else if (choice == SORT_YEAR_OLD_NEW) {
                        playlist.sortYearOldNew();
                        System.out.println(playlist);
                    }
                    else if (choice == SORT_YEAR_NEW_OLD) {
                        playlist.sortYearNewOld();
                        System.out.println(playlist);
                    }
                    else if (choice == SEARCH_GENRE) {
                        System.out.println("What genre are you searching for?");
                        String genreSearching = input.nextLine();
                        playlist.searchByGenre(genreSearching);
                    }
                    else if (choice == DISPLAY_ALL) {
                        System.out.println(playlist);
                    }
                    else if (choice == QUIT) {
                        System.out.println("Goodbye!");
                    }
                }
                else {
                    System.out.println("Invalid option. Try again.");
                }

            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        }

        return choice;
    }
}

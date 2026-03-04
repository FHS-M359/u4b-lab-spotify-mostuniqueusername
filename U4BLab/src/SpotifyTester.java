import java.util.Scanner;

public class SpotifyTester {

    public static final int SORT_AZ = 1;
    public static final int SORT_ZA = 2;
    public static final int SORT_YEAR_OLD_NEW = 3;
    public static final int SORT_YEAR_NEW_OLD = 4;
    public static final int SEARCH_GENRE = 5;
    public static final int DISPLAY_ALL = 6;
    public static final int QUIT = 7;

    /**
     * Main method:
     * Creates the Playlist object, loads the file,
     * and repeatedly shows the menu until the user quits.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Playlist playlist = new Playlist();
        playlist.readSongsFromFile("U4BLab/spotify_unique_years_artists.txt");

        int choice = 0;

        while (choice != QUIT) {
            choice = getValidChoice(input, playlist);
        }

        input.close();
    }

    /**
     * Displays the menu options to the user.
     */
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

    /**
     * Prompts the user for a valid menu choice.
     * Executes the selected action if valid.
     * Uses try/catch to prevent the program from crashing
     * if the user enters invalid input.
     *
     * @param input Scanner for user input
     * @param playlist Playlist object to manipulate
     * @return the user’s menu choice
     */
    public static int getValidChoice(Scanner input, Playlist playlist) {
        int choice = -1;

        printMenu();
        System.out.print("Enter your choice (1-7): ");

        try {
            choice = Integer.parseInt(input.nextLine());

            if (choice < 1 || choice > 7) {
                System.out.println("Invalid option. Try again.");
                return -1;
            }

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
                System.out.print("What genre are you searching for? ");
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
        catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }

        return choice;
    }
}

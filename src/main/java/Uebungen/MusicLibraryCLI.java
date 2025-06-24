/* package Uebungen;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.function.Predicate;

public class MusicLibraryCLI {
    private MusicLibrary library = new MusicLibrary();

    public void initializeLibrary() {
        List<Song> initialSongs = Arrays.asList(
            new Song("Blitzkrieg Bop", "Ramones", "Ramones", "Punk", 125, 4.8, 500, 1976),
            new Song("I Wanna Be Sedated", "Ramones", "Road to Ruin", "Punk", 150, 4.7, 450, 1978),
            new Song("London Calling", "The Clash", "London Calling", "Punk", 180, 4.9, 600, 1979),
            new Song("Anarchy in the U.K.", "Sex Pistols", "Never Mind the Bollocks", "Punk", 200, 4.6, 550, 1977),
            new Song("God Save the Queen", "Sex Pistols", "Never Mind the Bollocks", "Punk", 170, 4.5, 500, 1977),
            new Song("Smells Like Teen Spirit", "Nirvana", "Nevermind", "Grunge", 301, 4.9, 1200, 1991),
            new Song("Come as You Are", "Nirvana", "Nevermind", "Grunge", 219, 4.8, 950, 1991),
            new Song("Alive", "Pearl Jam", "Ten", "Grunge", 344, 4.7, 800, 1991),
            new Song("Black", "Pearl Jam", "Ten", "Grunge", 344, 4.9, 850, 1991),
            new Song("Man in the Box", "Alice in Chains", "Facelift", "Grunge", 270, 4.6, 700, 1990),
            new Song("Would?", "Alice in Chains", "Dirt", "Grunge", 207, 4.7, 750, 1992),
            new Song("Heart-Shaped Box", "Nirvana", "In Utero", "Grunge", 268, 4.8, 900, 1993),
            new Song("Lithium", "Nirvana", "Nevermind", "Grunge", 257, 4.6, 950, 1991),
            new Song("Jeremy", "Pearl Jam", "Ten", "Grunge", 319, 4.7, 900, 1991),
            new Song("Rooster", "Alice in Chains", "Dirt", "Grunge", 378, 4.8, 800, 1992),
            new Song("Basket Case", "Green Day", "Dookie", "Punk", 181, 4.9, 750, 1994),
            new Song("When I Come Around", "Green Day", "Dookie", "Punk", 177, 4.8, 720, 1994),
            new Song("Holiday", "Green Day", "American Idiot", "Punk", 232, 4.7, 680, 2004),
            new Song("American Idiot", "Green Day", "American Idiot", "Punk", 174, 4.9, 800, 2004),
            new Song("All the Small Things", "Blink-182", "Enema of the State", "Punk", 153, 4.8, 780, 1999),
            new Song("Enter Sandman", "Metallica", "Metallica", "Metal", 331, 4.9, 1200, 1991),
            new Song("Master of Puppets", "Metallica", "Master of Puppets", "Metal", 515, 4.9, 1100, 1986),
            new Song("Back in Black", "AC/DC", "Back in Black", "Rock", 255, 4.8, 900, 1980),
            new Song("Iron Man", "Black Sabbath", "Paranoid", "Metal", 356, 4.7, 850, 1970),
            new Song("Paranoid", "Black Sabbath", "Paranoid", "Metal", 168, 4.8, 800, 1970),
            new Song("One", "Metallica", "...And Justice for All", "Metal", 448, 4.9, 950, 1988),
            new Song("Nothing Else Matters", "Metallica", "Metallica", "Metal", 388, 4.8, 1000, 1991),
            new Song("Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV", "Rock", 482, 4.9, 900, 1971),
            new Song("Whole Lotta Love", "Led Zeppelin", "Led Zeppelin II", "Rock", 333, 4.8, 850, 1969),
            new Song("Smoke on the Water", "Deep Purple", "Machine Head", "Rock", 340, 4.8, 920, 1972),
            new Song("Child in Time", "Deep Purple", "Deep Purple in Rock", "Rock", 610, 4.9, 800, 1970),
            new Song("Comfortably Numb", "Pink Floyd", "The Wall", "Rock", 384, 4.9, 1100, 1979),
            new Song("Wish You Were Here", "Pink Floyd", "Wish You Were Here", "Rock", 334, 4.8, 950, 1975),
            new Song("21st Century (Digital Boy)", "Bad Religion", "Against the Grain", "Punk", 171, 4.7, 700, 1990),
            new Song("Sorrow", "Bad Religion", "The Process of Belief", "Punk", 196, 4.8, 720, 2002),
            new Song("Punk Rock Song", "Bad Religion", "The Gray Race", "Punk", 167, 4.6, 750, 1996),
            new Song("Los Angeles Is Burning", "Bad Religion", "The Empire Strikes First", "Punk", 223, 4.7, 710, 2004),
            new Song("Self Esteem", "The Offspring", "Smash", "Punk", 263, 4.8, 780, 1994),
            new Song("The Kids Aren't Alright", "The Offspring", "Americana", "Punk", 180, 4.7, 760, 1998),
            new Song("Pull Me Under", "Dream Theater", "Images and Words", "Progressive Metal", 504, 4.9, 850, 1992),
            new Song("Metropolis Pt. 1", "Dream Theater", "Images and Words", "Progressive Metal", 570, 4.8, 800, 1992),
            new Song("The Dance of Eternity", "Dream Theater", "Metropolis Pt. 2: Scenes from a Memory", "Progressive Metal", 388, 4.9, 820, 1999),
            new Song("Schism", "Tool", "Lateralus", "Progressive Metal", 402, 4.9, 850, 2001),
            new Song("Parabola", "Tool", "Lateralus", "Progressive Metal", 608, 4.8, 800, 2001),
            new Song("Roundabout", "Yes", "Fragile", "Progressive Rock", 512, 4.9, 750, 1971),
            new Song("Close to the Edge", "Yes", "Close to the Edge", "Progressive Rock", 1133, 4.8, 600, 1972),
            new Song("Symphony of Destruction", "Megadeth", "Countdown to Extinction", "Metal", 289, 4.9, 950, 1992),
            new Song("Peace Sells", "Megadeth", "Peace Sells... but Who's Buying?", "Metal", 249, 4.8, 850, 1986),
            new Song("Holy Wars... The Punishment Due", "Megadeth", "Rust in Peace", "Metal", 419, 4.9, 900, 1990),
            new Song("Raining Blood", "Slayer", "Reign in Blood", "Metal", 247, 4.9, 1200, 1986),
            new Song("Angel of Death", "Slayer", "Reign in Blood", "Metal", 292, 4.9, 1100, 1986),
            new Song("A-Punk", "Vampire Weekend", "Vampire Weekend", "Indie Rock", 153, 4.5, 700, 2008),
            new Song("Little Lion Man", "Mumford & Sons", "Sigh No More", "Folk Rock", 246, 4.6, 750, 2009),
            new Song("Ho Hey", "The Lumineers", "The Lumineers", "Folk Rock", 164, 4.7, 800, 2012),
            new Song("Pompeii", "Bastille", "Bad Blood", "Indie Pop", 214, 4.6, 900, 2013),
            new Song("Dog Days Are Over", "Florence + The Machine", "Lungs", "Indie Pop", 252, 4.8, 850, 2008),
            new Song("Budapest", "George Ezra", "Wanted on Voyage", "Folk Pop", 205, 4.6, 720, 2014),
            new Song("Electric Feel", "MGMT", "Oracular Spectacular", "Indie Rock", 231, 4.7, 800, 2007),
            new Song("1901", "Phoenix", "Wolfgang Amadeus Phoenix", "Indie Rock", 214, 4.6, 750, 2009),
            new Song("Kids", "MGMT", "Oracular Spectacular", "Indie Rock", 312, 4.7, 820, 2007),
            new Song("Sex on Fire", "Kings of Leon", "Only by the Night", "Indie Rock", 203, 4.8, 900, 2008),
            new Song("Take Me Out", "Franz Ferdinand", "Franz Ferdinand", "Indie Rock", 235, 4.8, 850, 2004),
            new Song("The Less I Know the Better", "Tame Impala", "Currents", "Indie Rock", 216, 4.7, 860, 2015),
            new Song("Do You Want To", "Franz Ferdinand", "You Could Have It So Much Better", "Indie Rock", 219, 4.7, 700, 2005),
            new Song("No You Girls", "Franz Ferdinand", "Tonight: Franz Ferdinand", "Indie Rock", 224, 4.6, 750, 2009),
            new Song("I Bet You Look Good on the Dancefloor", "Arctic Monkeys", "Whatever People Say I Am, That's What I'm Not", "Indie Rock", 170, 4.8, 800, 2005),
            new Song("Fluorescent Adolescent", "Arctic Monkeys", "Favourite Worst Nightmare", "Indie Rock", 180, 4.7, 770, 2007),
            new Song("Lisztomania", "Phoenix", "Wolfgang Amadeus Phoenix", "Indie Rock", 238, 4.7, 750, 2009),
            new Song("New Slang", "The Shins", "Oh, Inverted World", "Indie Rock", 223, 4.8, 740, 2001),
            new Song("Australia", "The Shins", "Wincing the Night Away", "Indie Rock", 239, 4.6, 720, 2007),
            new Song("Oxford Comma", "Vampire Weekend", "Vampire Weekend", "Indie Rock", 207, 4.6, 710, 2008)
        );

        initialSongs.forEach(library::addSong);
    }

    public void printAllSongs() {
        System.out.println("All Songs in the Library:");
        library.getSongs().forEach(song -> System.out.println(song));
    }

    public void startCLI() {
        Scanner scanner = new Scanner(System.in);
        initializeLibrary();
        while (true) {
            System.out.println("MusicLibrary CLI");
            System.out.println("1. Top-gespielte Songs pro Genre anzeigen");
            System.out.println("2. Durchschnittliche Bewertung pro Künstler anzeigen");
            System.out.println("3. Längste Songs pro Album anzeigen");
            System.out.println("4. Gesamtlänge aller Songs eines Genres anzeigen");
            System.out.println("5. Künstler mit mindestens einer Bewertung über 4.5 anzeigen");
            System.out.println("6. Top-N Songs basierend auf Bewertung und Wiedergaben anzeigen");
            System.out.println("7. Song hinzufügen");
            System.out.println("8. Song entfernen");
            System.out.println("9. Songs nach Jahr filtern");
            System.out.println("10. Songs nach Jahr sortieren");
            System.out.println("11. Songs nach benutzerdefinierten Kriterien sortieren");
            System.out.println("12. Songs nach benutzerdefinierten Kriterien filtern");
            System.out.println("13. Alle Songs anzeigen");
            System.out.println("14. Songs in einem bestimmten Bereich anzeigen (z.B. zwischen zwei Jahren)");
            System.out.println("15. Nächster Song nach einem bestimmten Song");
            System.out.println("16. Vorheriger Song vor einem bestimmten Song");
            System.out.println("0. Beenden");
            System.out.print("Auswahl: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    library.topPlayedSongsPerGenre().forEach((genre, songs) -> {
                        System.out.println("Genre: " + genre);
                        songs.forEach(song -> System.out.println(song));
                    });
                    break;
                case 2:
                    library.averageRatingPerArtist().forEach((artist, rating) -> {
                        System.out.println("Artist: " + artist + ", Average Rating: " + rating);
                    });
                    break;
                case 3:
                    library.longestSongPerAlbum().forEach((album, song) -> {
                        System.out.println("Album: " + album + ", Longest Song: " + song.orElse(null));
                    });
                    break;
                case 4:
                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();
                    System.out.println("Total Length of Genre (in minutes): " + library.totalLengthOfGenre(genre));
                    break;
                case 5:
                    library.artistsWithHighRatedSongs().forEach(artist -> {
                        System.out.println("Artist: " + artist);
                    });
                    break;
                case 6:
                    System.out.print("Number of top songs: ");
                    int n = scanner.nextInt();
                    library.topNSongs(n).forEach(song -> System.out.println(song));
                    break;
                case 7:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Artist: ");
                    String artist = scanner.nextLine();
                    System.out.print("Album: ");
                    String album = scanner.nextLine();
                    System.out.print("Genre: ");
                    String genre1 = scanner.nextLine();
                    System.out.print("Length (in seconds): ");
                    int length = scanner.nextInt();
                    System.out.print("Rating: ");
                    double rating = scanner.nextDouble();
                    System.out.print("Play Count: ");
                    int playCount = scanner.nextInt();
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    library.addSong(new Song(title, artist, album, genre1, length, rating, playCount, year));
                    break;
                case 8:
                    System.out.print("Title: ");
                    String titleToRemove = scanner.nextLine();
                    Song songToRemove = library.getSongs().stream().filter(song -> song.getTitle().equals(titleToRemove)).findFirst().orElse(null);
                    if (songToRemove != null) {
                        library.removeSong(songToRemove);
                        System.out.println("Song entfernt.");
                    } else {
                        System.out.println("Song nicht gefunden.");
                    }
                    break;
                case 9:
                    System.out.print("Year: ");
                    int yearFilter = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    library.filterSongsByYear(yearFilter).forEach(song -> System.out.println(song));
                    break;
                case 10:
                    library.sortSongsByYear().forEach(song -> System.out.println(song));
                    break;
                case 11:
                    System.out.println("Sortieren nach benutzerdefinierten Kriterien:");
                    System.out.println("1. Nach Länge");
                    System.out.println("2. Nach Bewertung");
                    System.out.println("3. Nach Anzahl der Wiedergaben");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Comparator<Song> comparator;
                    switch (sortChoice) {
                        case 1:
                            comparator = Comparator.comparingInt(Song::getLength);
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Ungültige Auswahl.");
                            continue;
                    }
                    library.sortSongsByCriteria(comparator).forEach(song -> System.out.println(song));
                    break;
                case 12:
                    System.out.println("Filtern nach benutzerdefinierten Kriterien:");
                    System.out.println("1. Länge");
                    System.out.println("2. Bewertung");
                    System.out.println("3. Anzahl der Wiedergaben");
                    int filterChoice = scanner.nextInt();
                    System.out.print("Wählen Sie 1 für > oder 2 für <: ");
                    int comparison = scanner.nextInt();
                    System.out.print("Geben Sie den Wert ein: ");
                    double value = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    Predicate<Song> predicate;
                    switch (filterChoice) {
                        case 1:
                            predicate = comparison == 1
                                    ? song -> song.getLength() > value
                                    : song -> song.getLength() < value;
                            break;
                        case 2:
                            predicate =. . .
                            break;
                        case 3:
                            predicate = . . .
                            break;
                        default:
                            System.out.println("Ungültige Auswahl.");
                            continue;
                    }
                    library.filterSongsByCriteria(predicate).forEach(song -> System.out.println(song));
                    break;
                case 13:
                    printAllSongs();
                    break;
                case 14:
                    System.out.print("Von Song Titel: ");
                    String fromTitle = scanner.nextLine();
                    System.out.print("Bis Song Titel: ");
                    String toTitle = scanner.nextLine();
                    Song fromSong = ...
                    Song toSong = ...
                    if (fromSong != null && toSong != null) {
                        library.getSongsInRange(fromSong, toSong).forEach(song -> System.out.println(song));
                    } else {
                        System.out.println("Ein oder beide Songs nicht gefunden.");
                    }
                    break;
                case 15:
                    System.out.print("Song Titel: ");
                    String nextTitle = scanner.nextLine();
                    Song nextSong = ...
                    if (nextSong != null) {
                        Song next = library.getNextSong(nextSong);
                        System.out.println("Nächster Song: " + (next != null ? next : "Kein nächster Song vorhanden."));
                    } else {
                        System.out.println("Song nicht gefunden.");
                    }
                    break;
                case 16:
                    System.out.print("Song Titel: ");
                    String prevTitle = scanner.nextLine();
                    Song prevSong = ...
                    if (prevSong != null) {
                        Song previous = library.getPreviousSong(prevSong);
                        System.out.println("Vorheriger Song: " + (previous != null ? previous : "Kein vorheriger Song vorhanden."));
                    } else {
                        System.out.println("Song nicht gefunden.");
                    }
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte erneut versuchen.");
            }
        }
    }

    public static void main(String[] args) {
        MusicLibraryCLI cli = new MusicLibraryCLI();
        cli.startCLI();
    }
}
*/
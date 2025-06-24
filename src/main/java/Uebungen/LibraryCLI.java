package Uebungen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class LibraryCLI {
    private LibraryManagementSystem libraryManagementSystem;
    private Scanner scanner;

    public LibraryCLI(LibraryManagementSystem libraryManagementSystem) {
        this.libraryManagementSystem = libraryManagementSystem;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        loadBooksFromCSV("C:\\Users\\damon\\Downloads\\books.csv");

        boolean running = true;

        while (running) {
            System.out.println("\n--- Bücherverwaltungssystem ---");
            System.out.println("1. Buch hinzufügen");
            System.out.println("2. Alle Bücher anzeigen");
            System.out.println("3. Bücher nach Jahr filtern");
            System.out.println("4. Bücher nach Seitenanzahl sortieren");
            System.out.println("5. Gesamtanzahl der Seiten berechnen");
            System.out.println("6. Buch ausleihen");
            System.out.println("7. Buch zurückgeben");
            System.out.println("8. Ausgeliehene Bücher eines Nutzers anzeigen");
            System.out.println("9. Alle ausgeliehenen Bücher anzeigen, sortiert nach Rückgabedatum");
            System.out.println("10. Bücher nach Genre filtern");
            System.out.println("11. Durchschnittliche Bewertung pro Genre berechnen");
            System.out.println("12. Top-bewertete Bücher anzeigen");
            System.out.println("13. Autoren mit den meisten Büchern anzeigen");
            System.out.println("14. Bücher nach Bewertung sortieren");
            System.out.println("15. Gefilterte und sortierte Liste der Bücher anzeigen");
            System.out.println("16. Programm beenden");
            System.out.print("Bitte wählen Sie eine Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> displayAllBooks();
                case 3 -> filterBooksByYear();
                case 4 -> sortBooksByPages();
                case 5 -> calculateTotalPages();
                case 6 -> borrowBook();
                case 7 -> returnBook();
                case 8 -> displayBorrowedBooksByUser();
                case 9 -> displayAllBorrowedBooks();
                case 10 -> filterBooksByGenre();
                case 11 -> calculateAverageRatingPerGenre();
                case 12 -> displayTopRatedBooks();
                case 13 -> displayTopAuthors();
                case 14 -> sortBooksByRating();
                case 15 -> filterAndSortBooks();
                case 16 -> running = false;
                default -> System.out.println("Ungültige Auswahl.");
            }
        }
    }

    private void loadBooksFromCSV(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("title")) continue; // Skip header
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());
                    int pages = Integer.parseInt(parts[3].trim());
                    String genre = parts[4].trim();
                    double rating = Double.parseDouble(parts[5].trim());

                    Book book = new Book(title, author, year, pages, genre, rating, false, null);
                    libraryManagementSystem.addBook(book);
                }
            }
            System.out.println("Bücher erfolgreich aus der CSV geladen.");
        } catch (IOException e) {
            System.out.println("Fehler beim Laden der CSV-Datei: " + e.getMessage());
        }
    }

    private void addBook() {
        System.out.print("Titel: ");
        String title = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        System.out.print("Erscheinungsjahr: ");
        int year = scanner.nextInt();
        System.out.print("Seitenanzahl: ");
        int pages = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Bewertung (1.0 - 5.0): ");
        double rating = scanner.nextDouble();
        scanner.nextLine();

        Book book = new Book(title, author, year, pages, genre, rating, false, null);
        libraryManagementSystem.addBook(book);
        System.out.println("Buch hinzugefügt.");
    }

    private void displayAllBooks() {
        libraryManagementSystem.getBooksSortedByPages().forEach(System.out::println);
    }

    private void filterBooksByYear() {
        System.out.print("Jahr: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        libraryManagementSystem.getBooksAfterYear(year).forEach(System.out::println);
    }

    private void sortBooksByPages() {
        libraryManagementSystem.getBooksSortedByPages().forEach(System.out::println);
    }

    private void calculateTotalPages() {
        int total = libraryManagementSystem.getTotalPages();
        System.out.println("Gesamtanzahl Seiten: " + total);
    }

    private void borrowBook() {
        System.out.print("ReaderID: ");
        String readerID = scanner.nextLine();
        System.out.print("Name des Nutzers (falls neu): ");
        String name = scanner.nextLine();
        libraryManagementSystem.addUser(new User(name, readerID));

        System.out.print("Buchtitel: ");
        String title = scanner.nextLine();
        System.out.print("Rückgabedatum (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        Book book = libraryManagementSystem.getBooksSortedByPages().stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst().orElse(null);

        if (book != null && libraryManagementSystem.borrowBook(readerID, book, date)) {
            System.out.println("Buch ausgeliehen.");
        } else {
            System.out.println("Ausleihe fehlgeschlagen.");
        }
    }

    private void returnBook() {
        System.out.print("ReaderID: ");
        String readerID = scanner.nextLine();
        System.out.print("Buchtitel: ");
        String title = scanner.nextLine();

        Book book = libraryManagementSystem.getBooksSortedByPages().stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst().orElse(null);

        if (book != null && libraryManagementSystem.getBooksByUser(readerID).contains(book)) {
            libraryManagementSystem.getBooksByUser(readerID).remove(book);
            book.setBorrowed(false);
            book.setReturnDate(null);
            System.out.println("Buch zurückgegeben.");
        } else {
            System.out.println("Rückgabe fehlgeschlagen.");
        }
    }

    private void displayBorrowedBooksByUser() {
        System.out.print("ReaderID: ");
        String readerID = scanner.nextLine();
        libraryManagementSystem.getBooksByUser(readerID).forEach(System.out::println);
    }

    private void displayAllBorrowedBooks() {
        libraryManagementSystem.getAllBorrowedBooks().forEach(System.out::println);
    }

    private void filterBooksByGenre() {
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        libraryManagementSystem.getBooksByGenre(genre).forEach(System.out::println);
    }

    private void calculateAverageRatingPerGenre() {
        Map<String, Double> avgMap = libraryManagementSystem.getAverageRatingPerGenre();
        avgMap.forEach((genre, avg) -> System.out.println(genre + ": " + avg));
    }

    private void displayTopRatedBooks() {
        libraryManagementSystem.getTopRatedBooks(3).forEach(System.out::println);
    }

    private void displayTopAuthors() {
        libraryManagementSystem.getTopAuthors().forEach(System.out::println);
    }

    private void sortBooksByRating() {
        libraryManagementSystem.getBooksSortedByRating().forEach(System.out::println);
    }

    private void filterAndSortBooks() {
        System.out.print("Mindestbewertung: ");
        double minRating = scanner.nextDouble();
        scanner.nextLine();

        Predicate<Book> filter = b -> b.getRating() >= minRating;
        Comparator<Book> sorter = Comparator.comparing(Book::getGenre)
                .thenComparing(Book::getRating).reversed();

        List<Book> result = libraryManagementSystem.getFilteredAndSortedBooks(filter, sorter);
        result.forEach(System.out::println);
    }
}

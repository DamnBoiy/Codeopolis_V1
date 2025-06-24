package Uebungen;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LibraryManagementSystem {
    private Set<Book> books; // sortiert nach Titel
    private Map<String, User> users; // readerID -> User
    private Set<Book> borrowedBooks; // sortiert nach Rückgabedatum

    public LibraryManagementSystem() {
        books = new TreeSet<>(); // Book implementiert Comparable nach Titel
        users = new HashMap<>();
        borrowedBooks = new TreeSet<>(
                Comparator.comparing(Book::getReturnDate, Comparator.nullsLast(Comparator.naturalOrder()))
                        .thenComparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER)
        );
    }

    // Buch hinzufügen
    public boolean addBook(Book book) {
        return books.add(book);
    }

    // Benutzer hinzufügen
    public boolean addUser(User user) {
        if (users.containsKey(user.getReaderID())) return false;
        users.put(user.getReaderID(), user);
        return true;
    }

    // Buch ausleihen
    public boolean borrowBook(String readerID, Book book, LocalDate returnDate) {
        User user = users.get(readerID);
        if (user == null || book == null || book.isBorrowed() || !books.contains(book)) {
            return false;
        }

        boolean success = user.borrowBook(book, returnDate);
        if (success) {
            borrowedBooks.add(book);
        }
        return success;
    }

    // Bücher eines Benutzers anzeigen
    public Set<Book> getBooksByUser(String readerID) {
        User user = users.get(readerID);
        return user != null ? user.getBorrowedBooks() : Set.of();
    }

    // Alle ausgeliehenen Bücher nach Rückgabedatum
    public List<Book> getAllBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    // Bücher nach Erscheinungsjahr filtern
    public List<Book> getBooksAfterYear(int year) {
        return books.stream()
                .filter(book -> book.getYear() > year)
                .collect(Collectors.toList());
    }

    // Bücher nach Seitenanzahl sortieren
    public List<Book> getBooksSortedByPages() {
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getPages))
                .collect(Collectors.toList());
    }

    // Gesamtseitenzahl berechnen
    public int getTotalPages() {
        return books.stream()
                .mapToInt(Book::getPages)
                .sum();
    }

    // Bücher nach Genre filtern
    public List<Book> getBooksByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    // Durchschnittliche Bewertung pro Genre
    public Map<String, Double> getAverageRatingPerGenre() {
        return books.stream()
                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.averagingDouble(Book::getRating)
                ));
    }

    // Top 3 Bücher nach Bewertung
    public List<Book> getTopRatedBooks(int topN) {
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getRating).reversed())
                .limit(topN)
                .collect(Collectors.toList());
    }

    // Autoren mit den meisten Büchern
    public List<String> getTopAuthors() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // Bücher nach Bewertung sortiert
    public List<Book> getBooksSortedByRating() {
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getRating).reversed())
                .collect(Collectors.toList());
    }

    // Gefilterte & sortierte Bücher – per Predicate & Comparator
    public List<Book> getFilteredAndSortedBooks(Predicate<Book> filter, Comparator<Book> sorter) {
        return books.stream()
                .filter(filter)
                .sorted(sorter)
                .collect(Collectors.toList());
    }
}


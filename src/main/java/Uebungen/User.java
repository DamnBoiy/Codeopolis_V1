package Uebungen;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class User {
    private String name;
    private String readerID;

    // TreeSet sortiert nach Rückgabedatum
    private Set<Book> borrowedBooks;

    public User(String name, String readerID) {
        this.name = name;
        this.readerID = readerID;

        // Bücher nach Rückgabedatum sortieren (früheste zuerst)
        this.borrowedBooks = new TreeSet<>(
                Comparator.comparing(Book::getReturnDate, Comparator.nullsLast(Comparator.naturalOrder()))
                        .thenComparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER)
        );
    }

    public String getName() {
        return name;
    }

    public String getReaderID() {
        return readerID;
    }

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Buch ausleihen
    public boolean borrowBook(Book book, LocalDate returnDate) {
        if (book == null || book.isBorrowed()) {
            return false;
        }

        book.setBorrowed(true);
        book.setReturnDate(returnDate);
        return borrowedBooks.add(book);
    }

    // Buch zurückgeben
    public boolean returnBook(Book book) {
        if (book == null || !borrowedBooks.contains(book)) {
            return false;
        }

        borrowedBooks.remove(book);
        book.setBorrowed(false);
        book.setReturnDate(null);
        return true;
    }

    @Override
    public String toString() {
        return String.format("Leser: %s (ID: %s), ausgeliehene Bücher: %d",
                name, readerID, borrowedBooks.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(readerID, user.readerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readerID);
    }
}

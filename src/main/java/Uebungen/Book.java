package Uebungen;

import java.time.LocalDate;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int year;
    private int pages;
    private String genre;
    private double rating; // Bewertung von 1.0 bis 5.0
    private boolean borrowed;
    private LocalDate returnDate; // Rückgabedatum bei ausgeliehenem Buch

    public Book(String title, String author, int year, int pages, String genre, double rating, boolean borrowed, LocalDate returnDate) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.genre = genre;
        this.rating = rating;
        this.borrowed = borrowed;
        this.returnDate = returnDate;
    }

    // Getter & Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    // Vergleich nach Titel (für natürliche Ordnung)
    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    // equals und hashCode nach Titel und Autor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    // Lesbare Darstellung
    @Override
    public String toString() {
        return String.format("'%s' von %s (%d), %d Seiten, Genre: %s, Bewertung: %.1f, %s",
                title, author, year, pages, genre, rating,
                borrowed ? "ausgeliehen bis " + returnDate : "verfügbar");
    }
}

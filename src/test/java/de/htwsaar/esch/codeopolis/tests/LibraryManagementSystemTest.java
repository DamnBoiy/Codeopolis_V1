package de.htwsaar.esch.codeopolis.tests;


import Uebungen.Book;
import Uebungen.LibraryManagementSystem;
import Uebungen.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryManagementSystemTest {

    private LibraryManagementSystem system;
    private Book book1;
    private Book book2;
    private Book book3;
    private User user;

    @BeforeEach
    public void setup() {
        system = new LibraryManagementSystem();
        book1 = new Book("Der Hobbit", "J.R.R. Tolkien", 1937, 310, "Fantasy", 4.8, false, null);
        book2 = new Book("1984", "George Orwell", 1949, 328, "Dystopie", 4.7, false, null);
        book3 = new Book("Java Grundlagen", "Max Meier", 2015, 450, "Sachbuch", 4.1, false, null);

        system.addBook(book1);
        system.addBook(book2);
        system.addBook(book3);

        user = new User("Max Mustermann", "r001");
        system.addUser(user);
    }

    @Test
    public void testAddAndBorrowBook() {
        boolean borrowed = system.borrowBook("r001", book1, LocalDate.of(2025, 7, 1));
        assertTrue(borrowed);
        assertTrue(book1.isBorrowed());
        assertEquals(1, system.getBooksByUser("r001").size());
    }

    @Test
    public void testReturnBook() {
        system.borrowBook("r001", book1, LocalDate.of(2025, 7, 1));
        assertTrue(user.returnBook(book1));
        assertFalse(book1.isBorrowed());
        assertEquals(0, system.getBooksByUser("r001").size());
    }

    @Test
    public void testGetBooksAfterYear() {
        List<Book> books = system.getBooksAfterYear(1950);
        assertEquals(1, books.size());
        assertEquals("Java Grundlagen", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksSortedByPages() {
        List<Book> sorted = system.getBooksSortedByPages();
        assertEquals("Der Hobbit", sorted.get(0).getTitle());
        assertEquals("Java Grundlagen", sorted.get(2).getTitle());
    }

    @Test
    public void testGetTotalPages() {
        int total = system.getTotalPages();
        assertEquals(310 + 328 + 450, total);
    }

    @Test
    public void testGetBooksByGenre() {
        List<Book> fantasy = system.getBooksByGenre("Fantasy");
        assertEquals(1, fantasy.size());
        assertEquals("Der Hobbit", fantasy.get(0).getTitle());
    }

    @Test
    public void testGetAverageRatingPerGenre() {
        Map<String, Double> avg = system.getAverageRatingPerGenre();
        assertEquals(4.8, avg.get("Fantasy"));
    }

    @Test
    public void testTopRatedBooks() {
        List<Book> top = system.getTopRatedBooks(2);
        assertEquals("Der Hobbit", top.get(0).getTitle());
        assertEquals(2, top.size());
    }

    @Test
    public void testGetTopAuthors() {
        List<String> authors = system.getTopAuthors();
        assertEquals("J.R.R. Tolkien", authors.get(0));
    }

    @Test
    public void testFilteredAndSortedBooks() {
        List<Book> result = system.getFilteredAndSortedBooks(
                b -> b.getRating() >= 4.5,
                (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle())
        );
        assertEquals(2, result.size());
        assertEquals("1984", result.get(0).getTitle());
    }
}

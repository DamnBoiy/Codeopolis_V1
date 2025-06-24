package Uebungen;

public class LibraryMain {
    public static void main(String[] args) {
        LibraryManagementSystem librarySystem = new LibraryManagementSystem();
        LibraryCLI cli = new LibraryCLI(librarySystem);
        cli.run();
    }
}


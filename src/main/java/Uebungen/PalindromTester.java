package Uebungen;

import java.io.File;
import java.nio.file.*;
import java.io.IOException;
import java.util.Scanner;

public class PalindromTester {

    public static void main(String[] args) {

        // Scanner erstellen, um Benutzereingaben über die Konsole zu lesen
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte geben Sie ein Wort oder einen Pfad ein: ");
        String input = scanner.nextLine();

        // Testen, ob der Input ein Pfad ist
        if (isPath(input)) {
            // Wenn der Input ein Pfad ist, versuche, die Datei zu lesen
            try {
                String fileContent = new String(Files.readAllBytes(Paths.get(input)));
                System.out.println("Dateiinhalt: ");
                System.out.println(fileContent);
                // Nach Palindromen im Dateiinhalt suchen
                testPalindromeInText(fileContent);
            } catch (IOException e) {
                System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
            }
        } else {
            // Wenn der Input kein Pfad ist, als Wort behandeln
            System.out.println("Überprüfe, ob das Wort ein Palindrom ist...");
            testPalindrome(input);
        }

        // Scanner schließen
        scanner.close();




        //oder


        //PalindromTest();


    }

   /* public static void PalindromTest() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte geben Sie ein Wort oder einen Pfad ein: ");
        String input = scanner.nextLine();

        // Testen, ob der Input ein Pfad ist
        if (isPath(input)) {
            // Wenn der Input ein Pfad ist, versuche, die Datei zu lesen
            try {
                String fileContent = new String(Files.readAllBytes(Paths.get(input)));
                System.out.println("Dateiinhalt: ");
                System.out.println(fileContent);
                // Nach Palindromen im Dateiinhalt suchen
                testPalindromeInText(fileContent);
            } catch (IOException e) {
                System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
            }
        } else {
            // Wenn der Input kein Pfad ist, als Wort behandeln
            System.out.println("Überprüfe, ob das Wort ein Palindrom ist...");
            testPalindrome(input);
        }

        // Scanner schließen
        scanner.close();

        }
    */






    // Methode, die prüft, ob der Input ein Pfad ist
    public static boolean isPath(String input) {
        File file = new File(input);
        return file.exists() && file.isFile();
    }

    // Testet, ob das Wort ein Palindrom ist (iterativ und rekursiv)
    public static void testPalindrome(String input) {
        // Iterative Lösung
        boolean iterativeResult = new PalindromIterativ().istPalindrom(input);
        if (iterativeResult) {
            System.out.println("Das Wort '" + input + "' ist ein Palindrom (iterativ).");
        } else {
            System.out.println("Das Wort '" + input + "' ist kein Palindrom (iterativ).");
        }

        // Rekursive Lösung
        boolean recursiveResult = new PalindromRekursiv().istPalindrom(input);
        if (recursiveResult) {
            System.out.println("Das Wort '" + input + "' ist ein Palindrom (rekursiv).");
        } else {
            System.out.println("Das Wort '" + input + "' ist kein Palindrom (rekursiv).");
        }
    }

    // Testet auf Palindrome im Text
    public static void testPalindromeInText(String text) {
        // Text in Zeilen unterteilen und jede Zeile auf Palindrom überprüfen
        String[] lines = text.split("\n");
        for (String line : lines) {
            line = line.trim(); // Leerzeichen am Anfang/Ende entfernen
            if (!line.isEmpty()) {
                System.out.println("Überprüfe Zeile: " + line);
                testPalindrome(line); // Palindromprüfung für jede Zeile
            }
        }
    }
}

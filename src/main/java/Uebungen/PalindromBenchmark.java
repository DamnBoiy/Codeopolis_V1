package Uebungen;

import java.io.FileWriter;
import java.io.IOException;

public class PalindromBenchmark {

    public static void main(String[] args) {
        String dateiname = "C:\\Users\\damon\\IdeaProjects\\src\\main\\java\\de\\htwsaar\\esch\\Codeopolis\\CSV\\benchmark.csv";
        int maxLength = 1000;  // maximale Stringlänge (anpassbar)
        int step = 10;         // Schrittweite

        try (FileWriter writer = new FileWriter(dateiname)) {
            // CSV-Header schreiben
            writer.write("Laenge;Iterativ(ms);Rekursiv(ms)\n");

            Palindrom iterativ = new PalindromIterativ();
            Palindrom rekursiv = new PalindromRekursiv();

            for (int len = 10; len <= maxLength; len += step) {
                String testString = generatePalindrome(len);

                // Iterative Zeitmessung
                long startIterativ = System.nanoTime();
                iterativ.istPalindrom(testString);
                long endIterativ = System.nanoTime();
                long elapsedIterativ = endIterativ - startIterativ;
                double iterativMillis = (double) elapsedIterativ / 1_000_000.0  ;

                // Rekursive Zeitmessung
                long startRekursiv = System.nanoTime();
                rekursiv.istPalindrom(testString);
                long endRekursiv = System.nanoTime();
                long timeRekursiv = endRekursiv - startRekursiv;
                double rekursivMillis = (double) timeRekursiv / 1_000_000.0  ;

                // In CSV-Datei schreiben
                writer.write(len + ";" + iterativMillis + ";" + rekursivMillis + "\n");

                System.out.println("Länge: " + len + " getestet.");
            }

            System.out.println("Benchmark abgeschlossen. Ergebnisse in " + dateiname);
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben der Datei: " + e.getMessage());
        }
    }

    // Hilfsmethode zur Erzeugung eines Palindroms gegebener Länge
    private static String generatePalindrome(int length) {
        StringBuilder half = new StringBuilder();
        for (int i = 0; i < length / 2; i++) {
            half.append((char) ('a' + (i % 26)));
        }
        String firstHalf = half.toString();
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();
        return length % 2 == 0
                ? firstHalf + secondHalf
                : firstHalf + "x" + secondHalf;
    }
}

// Diese Zeile ist Teil eines Algorithmus zur Bildung eines Palindroms aus zwei Hälften.
// firstHalf = "abc" → secondHalf = "cba" → Palindrom = "abccba"

// Problem: Wenn die ursprüngliche Zeichenkette eine ungerade Länge hat, fehlt ein mittleres Zeichen,
// da die beiden Hälften unterschiedlich lang wären. In diesem Fall wird ein x in die Mitte dazu addiert und die Seiten ausgegleicht




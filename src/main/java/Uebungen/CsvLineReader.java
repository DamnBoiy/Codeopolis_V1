package Uebungen;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class CsvLineReader {

    /**
     * Liest eine CSV-Datei und gibt ab Zeile 3 (Index 2) einen Stream von Zeilen zurueck.
     *
     * @param filePath Pfad zur CSV-Datei
     * @return Stream mit den Nutzdaten-Zeilen (ohne Ueberschrift und Header)
     * @throws IOException falls Datei nicht lesbar
     */
    public static Stream<String> readCsvSkippingHeader(String filePath) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of(filePath));

        // Rückgabe als Stream ab Zeile 3
        return reader.lines()
                     .skip(2); // Überschrift und Spaltenkopf überspringen
    }
}

package Uebungen;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Diese Klasse liest eine CSV-Datei mit Vulkanausbrüchen ein
 * und wandelt jede Zeile in ein {@link Eruption}-Objekt um.
 */
public class EruptionCsvParser {

    /**
     * Liest die Datei ein und gibt eine Liste von Eruptionen zurück.
     * Nutzt dabei CsvLineReader und verarbeitet jede Zeile mit Streams.
     *
     * @param filePath Pfad zur CSV-Datei
     * @return Liste von Eruptionen
     * @throws IOException wenn Datei nicht lesbar ist
     */
    public List<Eruption> parse(String filePath) throws IOException {
        return CsvLineReader.readCsvSkippingHeader(filePath)
                .map(this::parseLine)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * Parst eine einzelne CSV-Zeile in ein Eruption-Objekt.
     * Behandelt fehlende Daten wie gefordert.
     *
     * @param line eine Zeile der CSV-Datei
     * @return Eruption oder null bei Fehler
     */
    public Eruption parseLine(String line) {
        String[] parts = line.split(";", -1); // -1 = auch leere Felder behalten

        try {
            int volcanoNumber = parseInt(parts[0]);
            String volcanoName = parts[1].trim();
            int eruptionNumber = parseInt(parts[2]);
            String evidenceMethod = parts[14].trim();

            int startYear = parseIntOrDefault(parts[8], 0);
            int startMonth = parseIntOrDefault(parts[10], 1);
            int startDay = parseIntOrDefault(parts[12], 1);
            LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);

            LocalDate endDate = null;
            Integer endYear = parseNullableInt(parts[16]);
            Integer endMonth = parseNullableInt(parts[18]);
            Integer endDay = parseNullableInt(parts[20]);

            if (endYear != null) {
                int m = (endMonth != null) ? endMonth : 12;
                int d = (endDay != null)
                        ? endDay
                        : YearMonth.of(endYear, m).lengthOfMonth();
                endDate = LocalDate.of(endYear, m, d);
            }

            double latitude = parseDouble(parts[22]);
            double longitude = parseDouble(parts[23]);

            return new Eruption(volcanoNumber, volcanoName, eruptionNumber,
                    startDate, endDate, evidenceMethod, latitude, longitude);

        } catch (Exception e) {
            System.err.println("Fehler beim Parsen: " + e.getMessage());
            return null;
        }
    }

    private int parseInt(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return 0;
        }
    }

    private int parseIntOrDefault(String s, int defaultValue) {
        try {
            int value = Integer.parseInt(s.trim());
            return (value >= 1 && value <= 12) ? value : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    private Integer parseNullableInt(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return null;
        }
    }

    private double parseDouble(String s) {
        try {
            return Double.parseDouble(s.replace(",", ".").trim());
        } catch (Exception e) {
            return 0.0;
        }
    }
}

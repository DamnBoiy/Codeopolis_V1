package Uebungen;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainEruption {
    public static void main(String[] args) {
        EruptionCsvParser parser = new EruptionCsvParser();
        List<Eruption> eruptions;

        try {
            eruptions = parser.parse("volcanos.csv");
        } catch (IOException e) {
            System.err.println("Fehler beim Einlesen der Datei: " + e.getMessage());
            return;
        }

        // Anzahl aller Eruptionen
        System.out.println("Anzahl aller Eruptionen: " + eruptions.size());

        // Durchschnittliche Dauer in Tagen
        double avgDuration = eruptions.stream()
                .mapToLong(Eruption::getDurationInDays)
                .filter(d -> d >= 0)
                .average().orElse(0);
        System.out.printf("Durchschnittliche Dauer: %.2f Tage\n", avgDuration);

        // Letzte bekannte Eruption für alle Vulkane
        System.out.println("\nLetzte bekannte Eruption je Vulkan:");
        eruptions.stream()
                .filter(e -> e.getEndDate() != null)
                .collect(Collectors.groupingBy(
                        Eruption::getVolcanoName,
                        Collectors.maxBy(Comparator.comparing(Eruption::getEndDate))
                ))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.printf("%s: %s\n",
                        e.getKey(), e.getValue().map(Eruption::getEndDate).orElse(null)));

        // Alle Eruptionen vor dem Jahr 1000
        System.out.println("\nEruptionen vor dem Jahr 1000:");
        eruptions.stream()
                .filter(e -> e.getStartDate().getYear() < 1000)
                .forEach(System.out::println);

        // Top 10 Jahre mit den meisten Eruptionen
        System.out.println("\nTop 10 Jahre mit den meisten Eruptionen:");
        eruptions.stream()
                .collect(Collectors.groupingBy(e -> e.getStartDate().getYear(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        // Kategorisierung der Ausbrüche nach Evidence Method
        System.out.println("\nKategorisierung nach Evidence Method:");
        eruptions.stream()
                .collect(Collectors.groupingBy(Eruption::getEvidenceMethod, Collectors.counting()))
                .forEach((method, count) -> System.out.println(method + ": " + count));

        // Anzahl Eruptionen nördlich/südlich des Äquators
        long north = eruptions.stream().filter(e -> e.getLatitude() > 0).count();
        long south = eruptions.stream().filter(e -> e.getLatitude() < 0).count();
        System.out.printf("\nNordhalbkugel: %d, Südhalbkugel: %d\n", north, south);

        // Anzahl Eruptionen je Dekade
        System.out.println("\nEruptionen je Dekade:");
        eruptions.stream()
                .collect(Collectors.groupingBy(e -> (e.getStartDate().getYear() / 10) * 10, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        // Anzahl der Eruptionen je Vulkan
        System.out.println("\nEruptionen je Vulkan:");
        eruptions.stream()
                .collect(Collectors.groupingBy(Eruption::getVolcanoName, Collectors.counting()))
                .forEach((name, count) -> System.out.println(name + ": " + count));

        // Eruptionen mit Start- und Enddatum im selben Jahr
        System.out.println("\nEruptionen mit Start- und Enddatum im selben Jahr:");
        eruptions.stream()
                .filter(e -> e.getEndDate() != null && e.getStartDate().getYear() == e.getEndDate().getYear())
                .forEach(System.out::println);

        // Verteilung der Eruptionsdauer
        System.out.println("\nVerteilung der Eruptionsdauer (in Jahren):");
        Map<String, Long> durationCategories = eruptions.stream()
                .filter(e -> e.getDurationInDays() >= 0)
                .collect(Collectors.groupingBy(e -> {
                    long days = e.getDurationInDays();
                    long years = days / 365;
                    if (years <= 1) return "0-1 Jahre";
                    else if (years <= 5) return "2-5 Jahre";
                    else if (years <= 10) return "6-10 Jahre";
                    else return "10+ Jahre";
                }, Collectors.counting()));
        durationCategories.forEach((k, v) -> System.out.println(k + ": " + v));

        // Längste bekannte Eruption
        System.out.println("\nLängste bekannte Eruption:");
        eruptions.stream()
                .max(Comparator.comparing(Eruption::getDurationInDays))
                .ifPresent(System.out::println);

        // Evidence Methods, sortiert nach Häufigkeit
        System.out.println("\nEvidence Methods sortiert nach Häufigkeit:");
        eruptions.stream()
                .collect(Collectors.groupingBy(Eruption::getEvidenceMethod, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        // 10 Vulkane mit kürzester bekannter Eruption (Start = End)
        System.out.println("\n10 Vulkane mit kürzester bekannter Eruption (Start = End):");
        eruptions.stream()
                .filter(e -> e.getEndDate() != null && e.getStartDate().equals(e.getEndDate()))
                .sorted(Comparator.comparing(Eruption::getStartDate))
                .limit(10)
                .forEach(System.out::println);
    }
}

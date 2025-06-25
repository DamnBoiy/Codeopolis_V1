package Uebungen;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainEruption {
    public static void main(String[] args) {
        EruptionCsvParser parser = new EruptionCsvParser();
        List<Eruption> eruptions;

        try {
            eruptions = parser.parse("C:\\Users\\damon\\Downloads\\volcanos.csv");
        } catch (IOException e) {
            System.err.println("Fehler beim Einlesen der Datei: " + e.getMessage());
            return;
        }

        System.out.println("Anzahl aller Eruptionen: " + eruptions.size());

        double avgDuration = eruptions.stream()
                .mapToLong(Eruption::getDurationInDays)
                .filter(d -> d >= 0)
                .average().orElse(0);
        System.out.printf("Durchschnittliche Dauer: %.2f Tage\n", avgDuration);

        System.out.println("\nLetzte bekannte Eruption je Vulkan:");
        eruptions.stream()
                .filter(e -> e.getEndYear() > 0)
                .collect(Collectors.groupingBy(
                        Eruption::getVolcanoName,
                        Collectors.maxBy(Comparator.comparing(
                                e -> e.getEndYear() * 10000 + e.getEndMonth() * 100 + e.getEndDay()
                        ))
                ))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.printf("%s: %s\n",
                        e.getKey(), e.getValue().map(er -> String.format("%02d.%02d.%04d", er.getEndDay(), er.getEndMonth(), er.getEndYear())).orElse("unknown")));

        System.out.println("\nEruptionen vor dem Jahr 1000:");
        eruptions.stream()
                .filter(e -> e.getStartYear() < 1000)
                .forEach(System.out::println);

        System.out.println("\nTop 10 Jahre mit den meisten Eruptionen:");
        eruptions.stream()
                .collect(Collectors.groupingBy(Eruption::getStartYear, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        System.out.println("\nKategorisierung nach Evidence Method:");
        eruptions.stream()
                .collect(Collectors.groupingBy(Eruption::getEvidenceMethod, Collectors.counting()))
                .forEach((method, count) -> System.out.println(method + ": " + count));

        long north = eruptions.stream().filter(e -> e.getLatitude() > 0).count();
        long south = eruptions.stream().filter(e -> e.getLatitude() < 0).count();
        System.out.printf("\nNordhalbkugel: %d, S\u00fcdhalbkugel: %d\n", north, south);

        System.out.println("\nEruptionen je Dekade:");
        eruptions.stream()
                .collect(Collectors.groupingBy(e -> (e.getStartYear() / 10) * 10, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        System.out.println("\nEruptionen je Vulkan:");
        eruptions.stream()
                .collect(Collectors.groupingBy(Eruption::getVolcanoName, Collectors.counting()))
                .forEach((name, count) -> System.out.println(name + ": " + count));

        System.out.println("\nEruptionen mit Start- und Enddatum im selben Jahr:");
        eruptions.stream()
                .filter(e -> e.getEndYear() > 0 && e.getStartYear() == e.getEndYear())
                .forEach(System.out::println);

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

        System.out.println("\nL\u00e4ngste bekannte Eruption:");
        eruptions.stream()
                .max(Comparator.comparing(Eruption::getDurationInDays))
                .ifPresent(System.out::println);

        System.out.println("\nEvidence Methods sortiert nach H\u00e4ufigkeit:");
        eruptions.stream()
                .collect(Collectors.groupingBy(Eruption::getEvidenceMethod, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        System.out.println("\n10 Vulkane mit k\u00fcrzester bekannter Eruption (Start = End):");
        eruptions.stream()
                .filter(e -> e.getEndYear() == e.getStartYear() && e.getEndMonth() == e.getStartMonth() && e.getEndDay() == e.getStartDay())
                .sorted(Comparator.comparing(e -> e.getStartYear() * 10000 + e.getStartMonth() * 100 + e.getStartDay()))
                .limit(10)
                .forEach(System.out::println);
    }
}


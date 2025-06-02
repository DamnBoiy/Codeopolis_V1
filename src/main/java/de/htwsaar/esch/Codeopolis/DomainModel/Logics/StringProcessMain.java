package de.htwsaar.esch.Codeopolis.DomainModel.Logics;

import java.util.Arrays;

public class StringProcessMain {
    public static void main(String[] args) {
        // Beispielhafte Eingabe mit Leerzeichen, Groß-/Kleinschreibung, etc.
        StringProcessor processor = new StringProcessor(Arrays.asList(
                " Apfel", "banane ", "Test", "Elefant", "  giraffe  ", "Haus", "auto", "   Antilope  "
        ));

        System.out.println("Ursprüngliche Liste:");
        System.out.println(processor);

        // 1. Filtern: Strings mit mehr als 5 Zeichen
        LinkedList<String> laengerAlsFuenf = processor.filter(s -> s.length() > 5);
        System.out.println("\nStrings mit mehr als 5 Zeichen:");
        laengerAlsFuenf.forEach(System.out::println);

        // 2. Filtern: Strings, die mit Großbuchstaben beginnen
        LinkedList<String> beginntMitGross = processor.filter(s ->
                !s.isEmpty() && Character.isUpperCase(s.stripLeading().charAt(0))
        );
        System.out.println("\nStrings, die mit Großbuchstaben beginnen:");
        beginntMitGross.forEach(System.out::println);

        // 3. applyToAll: führende und nachfolgende Leerzeichen entfernen
        processor.applyToAll(String::trim);
        System.out.println("\nNach trim():");
        System.out.println(processor);

        // 4. applyToAll: alles in Großbuchstaben
        processor.applyToAll(String::toUpperCase);
        System.out.println("\nNach toUpperCase():");
        System.out.println(processor);

        // 5. applyToAll: Strings umkehren
        processor.applyToAll(s -> new StringBuilder(s).reverse().toString());
        System.out.println("\nNach Umkehrung:");
        System.out.println(processor);

        // 6. mapToInt: Längen der Strings
        LinkedList<Integer> laengen = processor.mapToInt(String::length);
        System.out.println("\nLängen der Strings:");
        laengen.forEach(System.out::println);

        // 7. mapToInt: Anzahl der 'A's zählen (Großbuchstaben durch vorheriges toUpperCase)
        LinkedList<Integer> aZaehlungen = processor.mapToInt(s ->
                (int) s.chars().filter(ch -> ch == 'A').count()
        );
        System.out.println("\nAnzahl der 'A's in jedem String:");
        aZaehlungen.forEach(System.out::println);

        // 8. forEach: Alle Strings mit » vorangestellt ausgeben
        System.out.println("\nAusgabe mit » vorangestellt:");
        processor.forEach(s -> System.out.println("» " + s));
    }
}

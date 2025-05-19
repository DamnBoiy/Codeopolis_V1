package org.example;

import java.util.List;
import java.util.Scanner;

public class TextInterface {
    private final List<ConversionStrategy> strategies = List.of(
            new CelsiusToFahrenheitStrategy(),
            new FahrenheitToCelsiusStrategy(),
            new KilometerToMileStrategy(),
            new MileToKilometerStrategy()
    );

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Hauptmenü =====");
            System.out.println("1) Umrechnung");
            System.out.println("2) Beenden");
            System.out.print("Bitte geben Sie entweder 1 oder 2 ein: ");
            int choice = scanner.nextInt();

            if (choice == 2) {
                System.out.println("Programm beendet.");
                break;
            } else if (choice == 1) {
                showConversionOptions(scanner);
            } else {
                System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
            }
        }
        scanner.close();
    }

    private void showConversionOptions(Scanner scanner) {
        System.out.println("===== Umrechner =====");
        System.out.println("Verfügbare Konvertierungen:");
        for (int i = 0; i < strategies.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, strategies.get(i).getDescription());
        }
        System.out.print("Bitte wählen Sie eine Option: ");
        int strategyIndex = scanner.nextInt() - 1;

        if (strategyIndex >= 0 && strategyIndex < strategies.size()) {
            ConversionStrategy strategy = strategies.get(strategyIndex);
            System.out.print("Geben Sie den Wert ein, der umgerechnet werden soll: ");
            float value = scanner.nextFloat();
            float result = strategy.convert(value);
            System.out.printf("Das Ergebnis der Umrechnung: %.2f%n", result);
        } else {
            System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
        }
    }
}


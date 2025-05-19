import java.util.Scanner;

public class MiniCalculator {
    public static void Calculator() {
        double ergebnis = 0;
        double zahl1 = 0;
        double zahl2 = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Bitte Zahl 1 und Zahl 2 wählen");
        try {

            while (true) {
                System.out.println("Bitte Zahl 1 eingeben:");
                if (input.hasNextDouble()) {
                    zahl1 = input.nextDouble(); // Zahl 1 einlesen
                    System.out.println("Bitte Zahl 2 eingeben:");
                        if (input.hasNextDouble()) {
                            zahl2 = input.nextDouble(); // Zahl 2 einlesen
                            break; // Beide Zahlen erfolgreich eingegeben, Schleife verlassen
                        } else {
                            System.out.println("Bitte eine ZAHL eingeben!!");
                            input.next(); // Ungültige Eingabe "verbrauchen"
                        }
                }
                else
                {
                    System.out.println("Bitte eine ZAHL eingeben!!");
                    input.next(); // Ungültige Eingabe "verbrauchen"
                }
            }

            System.out.println("Zahl 1: " + zahl1);
            System.out.println("Zahl 2: " + zahl2);


            while (true) {
                System.out.println("Bitte einen arithmetischen Operator wählen (durch 1,2,3 oder 4 eingeben): " +
                        "\n<1> +" +
                        "\n<2> -" +
                        "\n<3> *" +
                        "\n<4> /");
                String operator = input.next(); // ausgewählter Operator

                if (operator.equals("1") || operator.equals("2") || operator.equals("3") || operator.equals("4")) {
                    System.out.println("Zahl 1: " + zahl1);
                    System.out.println(operator);
                    System.out.println("Zahl 2: " + zahl2);

                    switch (operator) {
                        case "1":
                            ergebnis = zahl1 + zahl2;

                            break;
                        case "2":
                            ergebnis = zahl1 - zahl2;

                            break;
                        case "3":
                            ergebnis = zahl1 * zahl2;

                            break;
                        case "4":
                            if (zahl2 != 0) {
                                ergebnis = zahl1 / zahl2;

                            } else
                            {
                                System.out.println("Division durch null ist nicht erlaubt.");
                                continue;
                            }
                            break;

                    }
                    System.out.println("Ergebnis: " + ergebnis);
                    break; // Beendet die Schleife nach erfolgreicher Berechnung
                }
                else
                {
                    System.out.println("Ungültiger Operator. Bitte versuchen Sie es erneut (+, -, *, /): ");
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            input.close();
        }


    }

    // Ich habe durch die einfache Verständlichkeit einen Großteil des Vrocodes schon ausarbeiten konnen

    // Das FD war sehr hilfreich und hat meiner meinung einen Vorcode durch auskommentieren größtenteils ergänzt und ersetzt

    // Ich glaube das Flussdiagramme stark helfen abläufe den ein Programmierer geplant hat, einem anderen als Aufgabe zu geben
    // so können verschiedene Leute einen Code planen und doch jemand anderen diese implementierem lassen
    // bei gfrößeren Projekten kann man so einzelene Teile ergänzen. Z.B die Grobe struktur bennen und die einzelnen Teile in
    // externen Flussdiagrammen erweitern


    // Das schreiben von tests hat in diesem Fall meine Entwicklung verkompliziert. In Projekten in denen es besonders viele Schlupflöcher
    // geben kann finde ich es von Vorteil eine "komplette Version" stück für stück von innen nach außen zu testen.

    // Sinnvolle tests zu finden.

    // Ich habe die tests auf dem wissen welche Fehler passieren könnten ausgewählt also nein.






}

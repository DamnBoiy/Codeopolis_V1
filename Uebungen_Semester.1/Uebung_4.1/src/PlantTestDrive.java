import java.util.Scanner;

public class PlantTestDrive {

    public static void main(String[] args)
    {
        Plant plant = new Plant();

        System.out.println("Bitte eingeben wie viele Sonnenstunden es heute gab.");
        Scanner input = new Scanner(System.in);

       /*

       Grobe erst-Struktur

       while (input.hasNext())
        {
            if (input.hasNextInt())
            {
                while (input.hasNextInt()) {
                    if (input.nextInt() < 0) {
                        System.out.println("Bitte eine positive Zahl eingeben oder min. 0.");
                    } else {
                        int sunlightHours = input.nextInt();
                        plant.grow(sunlightHours);
                        break;
                    }
                }
            }
            else
            {
                System.out.println("Bitte eine Ganzzahl eingeben!!");
                input.next();
            }
        }*/

        while (input.hasNext()) {
            if (input.hasNextInt()) {
                int sunlightHours = input.nextInt(); // Wert einmalig lesen

                if (sunlightHours < 0) {
                    System.out.println("Bitte eine positive Zahl eingeben oder mindestens 0.");
                } else {
                    plant.grow(sunlightHours); // Wachstumsmethode aufrufen
                    break;
                }
            } else {
                System.out.println("Bitte eine Ganzzahl eingeben!!");
                input.next(); // Ungültige Eingabe aus dem Puffer entfernen
            }
        }
        input.close();

        plant.addWater(10);
            System.out.println(plant.GetWaterLevel());
        plant.addWater(20); //30
            System.out.println(plant.GetWaterLevel());
        plant.addWater(30); //60
            System.out.println(plant.GetWaterLevel());

        System.out.println("True wird ausgegeben wenn die Pflanze Wasser braucht, False wenn sie kein Wasser brauch: "
                + plant.needWater());

        if (plant.needWater())
        {
            plant.addWater(30);
            System.out.println(plant.GetWaterLevel());
        }
        else System.out.println("Die Pflanze brauhct kein Wasser.\n Wasserstand: " + plant.GetWaterLevel());

        //1. Man kann sie durch Variablen dynamisch in die Methode eingeben lassen

        //2. Eine Methode ohne Rückgabewert führt beim ausgeben z.b. System.out.println(plant.addWater(10)); zu einem Kompilierfehler
        // Eine Methode die einen Wert zurück gibt kann diesen zum weiteren Nutzen übergeben z.b. Abfragen, schleifen usw.,
        // oder zur Nutzung in anderen Methoden, sowie auch kann dieser Rückgabewert ausgegebn werden

        //3. True oder False. True: Braucht wasser. Flase: Braucht kein Wasser.

        //4. Z.b. Ein Feuchtigkeitsmesser in einem Pflanzentopf der bei einem bestimmten Waterlevel True wiedergibt
        // Also in regelmäßigen Abständen die Methode plant.needWater() ausführt und abhängig vom Wiedergabewert
        // eine Push-Benachrichtung per App schickt das man doch bitte seine Pflanzen gießen solle


        double height1 = 10;
        double height2 = 20;
        System.out.println("Sind die beiden Variablen ungleich also z.b. 10 und 20 im Wert so gibt Java folgendes aus: ");
        System.out.println(height1 == height2);

        String type1 = "Sonnenblume";
        String type2 = "Sonnenblume";
        System.out.println("Sind die beiden Variablen genau gleich also z.b. 'Sonnenblume' im Wert so gibt Java folgendes aus: ");
        System.out.println(type1 == type2);

        Plant plant1 = new Plant();
        plant1.SetHeight(10);
        plant1.SetType("Cactaea");
        plant1.SetWaterLevel(40);


        Plant plant2 = new Plant();
        plant2.SetHeight(10);
        plant2.SetType("Cactaea");
        plant2.SetWaterLevel(40);

        System.out.println(plant1 == plant2);
        // Hier wird der Wert hinter der Referenzvariable verglichen, d.h. also die Referenz zum Speciherort des Objektes,
        // da es sich hier um zwei verschiedene Objekte mit unterschiedlicher refrenz handelt kann ein genauer Vergleich nie True sein

        System.out.println(plant1.GetType().equals(plant2.GetType()) );
        //Ausgabe:  True
        plant2.SetType("Sonnenblume");
        System.out.println(plant1.GetType().equals(plant2.GetType()) );
        //Ausgabe:  False

        //== vergleicht, ob zwei Referenzen auf dasselbe Objekt im Speicher zeigen (d. h., es vergleicht die Speicheradresse der Objekte).
        //.equals() vergleicht, ob zwei Objekte den gleichen Inhalt oder Zustand haben, unabhängig davon,
        // ob sie im Speicher an der gleichen Stelle liegen.


        //1. == vergleicht den Wert der direkt hinter der Variable steht

        //2. In jedem Fall in dem Obj1 und Obj2 nicht dieselbe Speicheradresse haben sozusagen das selbe Objekt darstellen

        //3. == vergleicht, ob zwei Referenzen auf dasselbe Objekt im Speicher zeigen (d. h., es vergleicht die Speicheradresse der Objekte).
        // .equals() vergleicht, ob zwei Objekte den gleichen Inhalt oder Zustand haben, unabhängig davon,
        // ob sie im Speicher an der gleichen Stelle liegen.
        // Bei Strings funktioniert es indem die Methode .equals() die Zeichenkette die beim String in einem Array[] gespeichert
        // wird Zeichen für Zeichen vergleicht

        //4. if abfrage auf True wenn obj1.GetType().equals(obj2.GetType()) = True
       /* if(obj1.GetType().equals(obj2.GetType())) {
            nötige Bedingung
        }
       */

    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Plant plant = new Plant();
        plant.SetHeight(10.1);
        plant.SetType("Cactaceae"); //Kaktus
        plant.SetWaterLevel(60);

        System.out.println(plant.GetHeight() + "\n");



        System.out.println("Bitte eingeben wie viele Sonnenstunden es heute gab.");
        Scanner input = new Scanner(System.in);

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


        System.out.println(plant.GetHeight());


        //1. Für die Wartbarkeit und Realitätsnähe ist es Sinnvoll bestimmte Eigenschaften einer Pflanze als Instanzvariablen
        // zu speichern, denn jede Pflanze hat mindestens eine Höhe, einen Wasserstand und gehört zu einer gewissen Art

        //2. Wenn ich die Methode Grow() komplett ohne Instanzvariablen erstelle verändert diese nicht den Konkreten zustand
        // des objektes. Ich könnte sie dann auch statisch also alleinstehend nutzen

        //3. Die Methode grow() kann bei schnell wachsenden Pflanzen von nutzen sein bei denen man abschätzen kann um welchen Faktor diese wachsen

        //4. Die Pflanze würde schrumpfen durch die Methode, um dies zu verhindern kann man eine Bedingung setzen die besagt
        // das man keine Zahl unter 0 eingeben kann z.b.











    }
}
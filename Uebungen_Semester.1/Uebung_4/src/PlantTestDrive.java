import java.util.Scanner;

public class PlantTestDrive {

    public static void main(String[] args) {

        Plant plant = new Plant();
        plant.height = 10.0;
        plant.type = "Cactaceae"; //Kaktus
        plant.waterLevel = 60;

        System.out.println(plant.height + "\n");

        System.out.println("Bitte eingeben wie viele Sonnenstunden es heute gab.");
        Scanner input = new Scanner(System.in);

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
                    }
                }
            }
            else
            {
                System.out.println("Bitte eine Ganzzahl eingeben!!");
                input.next();
            }
        }



        System.out.println(plant.height);


        // Für die Wartbarkeit und Realitätsnähe ist es Sinnvoll bestimmte Eigenschaften einer Pflanze als Instanzvariablen
        // zu speichern, denn jede Pflanze hat mindestens eine Höhe, einen Wasserstand und gehört zu einer gewissen Art

        // Wenn ich die Methode Grow() komplett ohne Instanzvariablen erstelle verändert diese nicht den Konkreten zustand
        // des objektes. Ich könnte sie dann auch statisch also alleinstehend nutzen

        // Die Methode grow() kann bei schnell wachsenden Pflanzen von nutzen sein bei denen man abschätzen kann um welchen Faktor diese wachsen

        // Die Pflanze würde schrumpfen durch die Methode, um dies zu verhindern kann man eine Bedingung setzen die besagt
        // das man keine Zahl unter 0 eingeben kann z.b.
        /*
            public void grow(int sunlightHours)
            {
                if(sunlightHours < 0)
                {
                    System.out.println("Bitte eine positive Zahl oder 0 eingeben !!");

                }
                else  { height = 0.5 * sunlightHours; }
            }
         */



    }
}

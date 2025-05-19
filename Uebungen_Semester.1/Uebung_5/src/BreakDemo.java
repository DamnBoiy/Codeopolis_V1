public class BreakDemo {


    public static void GetBiggerNumberFromArray(int conditionIndex, int[] array )
    {
        System.out.print("Array: {");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) { // Kein Komma nach dem letzten Element
                System.out.print(", ");
            }
        }
        System.out.println("}");
        System.out.println("Kriterium: " + conditionIndex + "\n");

        boolean valueFound = false;

        for(int i = 0; i < array.length; i++)
        {
            if(array[i] >= conditionIndex)
            {
                System.out.print("Stelle: " + i + " hat " + array[i] +" und ist größer/gleich als " + conditionIndex + "\n");
                valueFound = true;
            }
            else System.out.print(array[i] + " und ist KLEINER als " + conditionIndex + "\n");
        }

        if(!valueFound)
        {
            System.out.println("Der Wert ist nicht vorhanden.");
        }
    }




    public static void main(String[] args)
    {
        int[] zahlen = {10,20,30,40,50,60,70,80,90,100};
        int[] zahlen2 = {5,15,20,25,30,35};
        int[] zahlen3 = {60,70,80,90};
        int[] zahlenLeer;

        BreakDemo.GetBiggerNumberFromArray(60, zahlen); //Sucht nach allen Nummern größer als die angegbene Zahl
        System.out.println("\n");

        BreakDemo.GetBiggerNumberFromArray(25, zahlen2);
        System.out.println("\n");

        BreakDemo.GetBiggerNumberFromArray(100, zahlen3);
        System.out.println("\n");
        //BreakDemo.GetBiggerNumberFromArray(10, zahlenLeer); //Variable ZahlenLeer might not have been initialized


        //Eine schleife kann man ohne break beenden in den man eine Bedingung in den Schleifenkopf setzt die diese dann beendet,
        //soll eine schleife unendlich lange bis mehrere Zustand mit verschiedenen Bedingungen beendet werden können ist break besser

        //Wenn die Schleife eine bestimmte Bedingung erfüllt und die Methode danach keine weiteren Aufgaben hat,
        // ist ein direkter return sinnvoll, um den Code kompakt und übersichtlich zu halten.

        //Alternativen sind jedoch besser geeignet wenn die Methode nach der Schleife weitee Aufgaben zu erledigen hat
    }
}

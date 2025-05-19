import java.lang.reflect.Array;
import java.util.ArrayList;

public class ForLoopDemo
{

    public static void main(String[] args)
    {

        String[] zahlen = {"eins", "zwei", "drei", "vier", "fünf"};

        for (int i = 0; i < zahlen.length; i++) //positives ausgeben der Schleife von Anfangspunkt 0 bis ende (zahlen.length)
        {
            System.out.println(zahlen[i]);
        }


        System.out.println("\n");


        for (int i = zahlen.length - 1; i >= 0; i--)
        {
            System.out.println(zahlen[i]);
        }


        System.out.println("\n");


        int length = zahlen.length;
        int counter = 0;
        while(counter != length)
        {
            System.out.println(zahlen[counter]);
            counter++;
        }


        System.out.println("\n");


        int reverseCounter = zahlen.length - 1;
        while(reverseCounter >= 0)
        {
            System.out.println(zahlen[reverseCounter]);
            reverseCounter--;
        }

    }

}

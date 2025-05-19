import java.util.*;


public class Main {
    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Hallo, bitte geben sie ihren Namen ein!");
        String name = inputScanner.nextLine();

        if (name.isEmpty()) {
            System.out.println("Du hast keinen Namen eingeben");
        }
        else { System.out.println("Hallo lieber " + name + " !");

            System.out.println("Wollen sie merhmals begrüßt werden? " +
                    "\n Dann geben sie bitte '1' ein. Wenn nicht ist die eingabe egal.");
            int i;
            if(inputScanner.nextLine().equals("1")){

                for (i=1; i <= 5; i++) {
                    System.out.println("Hallo lieber " + name + " !");
                }
            }
            else{System.out.println("Dann eben nicht :)");
            }
        }
    }
}

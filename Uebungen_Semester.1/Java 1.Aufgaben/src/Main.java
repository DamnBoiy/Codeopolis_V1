import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    //public static void Useless      Uppercase to lowercase .toUpperCase().toLowerCase().toUpperCase().toLowerCase().toUpperCase()

    public static void main(String[] args) {

        List<String> list = new ArrayList();

        System.out.println("Stellt euch bitte einmal vor! Bitte nur 3 Leute");
        Scanner input = new Scanner(System.in);
        String nameone = input.nextLine();
        String nametwo = input.nextLine();
        String namethree = input.nextLine();

        list.add(nameone);
        list.add(nametwo);
        list.add(namethree);


        System.out.println("Hallo,"+ ", " +nameone + ", " +nametwo + ", " +namethree);
        int i;
            for (i = 0; i < list.size(); i++) {
                if (i < 1)
                {
                    System.out.println("Wie alt bist du," + nameone + "?");
                    Scanner inputage = new Scanner(System.in);

                    try {
                        int age = Integer.parseInt(inputage.nextLine());
                        if (age < 18)
                        {
                            System.out.println("Bist du nicht etwas jung?");
                        } else if (age > 18 && age < 40)
                        {
                            System.out.println("Du bist ja noch knackige " + age + " Jahre!");
                        } else System.out.println("Du bist ja mal echt alt man.");

                    }
                    catch (Exception e) { e.getMessage();}


                }
                else if (i < 2)
                {
                    System.out.println("Wie alt bist du," + nametwo + "?");
                    Scanner inputage = new Scanner(System.in);

                    try {
                        int age = Integer.parseInt(inputage.nextLine());
                        if (age < 18)
                        {
                            System.out.println("Bist du nicht etwas jung?");
                        } else if (age > 18 && age < 40) {
                            System.out.println("Du bist ja noch knackige " + age + " Jahre!");
                        } else System.out.println("Du bist ja mal echt alt man.");
                    }
                    catch (Exception e) { e.getMessage();}
                }
                else if(i < 3)
                {
                    System.out.println("Wie alt bist du," + namethree + "?");
                    Scanner inputage = new Scanner(System.in);

                    try {
                        int age = Integer.parseInt(inputage.nextLine());
                        if (age < 18)
                        {
                            System.out.println("Bist du nicht etwas jung?");
                        } else if (age > 18 && age < 40)
                        {
                            System.out.println("Du bist ja noch knackige " + age + " Jahre!");
                        } else System.out.println("Du bist ja mal echt alt man.");
                    }
                    catch (Exception e) { e.getMessage();}
                }

            }

        }
    }

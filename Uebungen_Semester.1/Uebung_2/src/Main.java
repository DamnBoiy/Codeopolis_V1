import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Hallo, bitte geben sie ihren Namen ein!");
        String name = inputScanner.nextLine();

        if (name.isEmpty()) {
            System.out.println("Du hast leider keinen Namen eingeben...");
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

            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }


        Person Worker_2 = new Person("Timo", 32);
        Worker_2.greetings();

        Student student_1 = new Student("Niklas", 22, 580187320, "Praktische Informatik");
        student_1.greetings();
        student_1.tell_id();


            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }


        Cat kitty = new Cat();

        kitty.setFur_colour("Dunkles");
        kitty.setMeow_sound("Meooww~");
        kitty.setRemaining_lives(6);

        Dog doggy = new Dog();

        doggy.setAge(6);
        doggy.setBreed("Schäferhund");
        doggy.setBark_sounds("WROFF");

        System.out.println("Die Katze hat ein " + kitty.getFur_colour() +
                " Fell, \n miaut folgendermaßen: " + kitty.getMeow_sound() +
                " und hat noch " + kitty.getRemaining_lives() + " Leben übrig.");

        System.out.println("Der Hund ist ein " + doggy.getBreed() +
                ", \n bellt folgendermaßen: " + doggy.getBark_sounds() +
                " und ist " + doggy.getAge() + " Jahre alt.");
        }
    }

}
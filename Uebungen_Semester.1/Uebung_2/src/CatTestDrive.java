public class CatTestDrive {

    public static void main (String[] args) {

        Cat kitty = new Cat();

        kitty.setFur_colour("graues");
        kitty.setMeow_sound("MEOOWWWWW");
        kitty.setRemaining_lives(2);

        System.out.println("Die Katze hat ein " + kitty.getFur_colour() +
                " Fell, \n miaut folgendermaßen: " + kitty.getMeow_sound() +
                " und hat noch " + kitty.getRemaining_lives() + " Leben übrig.");
    }
}

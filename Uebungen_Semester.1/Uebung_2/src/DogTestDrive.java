public class DogTestDrive {

    public static void main(String[] args) {

        Dog doggy = new Dog();

        doggy.setAge(8);
        doggy.setBreed("Dobermann");
        doggy.setBark_sounds("Rwow");

        System.out.println("Der Hund ist ein " + doggy.getBreed() +
                ", \n bellt folgendermaßen: " + doggy.getBark_sounds() +
                " und ist " + doggy.getAge() + " Jahre alt.");


    }
}

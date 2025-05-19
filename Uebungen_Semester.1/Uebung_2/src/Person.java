public class Person {

    private String name;
    private int age;

        public Person (String name, int age) {

            this.name = name;
            this.age = age;

        }
    public void greetings()
    {
        System.out.println("Hallo ich bin " + name + " und bin " + age + " Jahre alt.");
    }

}

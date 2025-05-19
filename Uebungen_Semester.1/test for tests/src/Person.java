public class Person {

    private int age;

    private String name;

    private void setAge(int age) {
        age = age;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(21);
        person.setName("A. N. Other");
        System.out.println(person);
    }

}
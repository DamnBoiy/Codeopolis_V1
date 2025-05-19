public class PersonTestDrive {

    public static void main(String[] args) {

        Person Worker_1 = new Person("Tim", 21);
        Worker_1.greetings();

        Student student_1 = new Student("Markus", 23, 570118269, "Theoretische Mechanik");
        student_1.greetings();
        student_1.tell_id();

    }
}

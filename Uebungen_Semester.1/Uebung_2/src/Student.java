public class Student extends Person {

    private String name;
    private int age;

    private int student_id;
    private String aimed_degree;

    public Student (String name, int age, int student_id, String aimed_degree)
    {
        super(name, age);
        this.name = name;
        this.age = age;
        this.student_id = student_id;
        this.aimed_degree = aimed_degree;
    }

    public void greetings()
    {
        System.out.println("Hallo ich bin " + name + " und bin " + age + " Jahre alt. Im Moment studiere ich " + aimed_degree);
    }

    public void tell_id()
    {
        System.out.println("Meine Studenten(Matrikel)-Nummer ist "+student_id);
    }

}

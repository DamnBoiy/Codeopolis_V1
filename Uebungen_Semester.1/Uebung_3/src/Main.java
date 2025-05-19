public class Main {
    public static void main(String[] args) {

        int startNumber = 2;
        double startDouble = 290.69;
        boolean startBoolean = true;
        String greetWorld = "Hello world!";

        int intNumber = 100;
        double doubleNumber = 3.14;
        int intNumber2 = 1_000_000;
        boolean boolLogic = false;

        int intValue = 420;
       // byte byteValue = intValue;  Dies führt zu einem möglichen Verlust bei der Konvertierung von int zu byte

        long longValue = 10000000L;
        float floatValue = 3.14159f;

        //Wenn ein Wert den Zahlenbereich von int überschreitet und man das Suffix L vergisst intepretiert Java diese Wert
        //standardmäßig als int. Durch das Hinzufügen von L umgeht man dies und es führt zu keinem Fehler.


        //Java interpretiert einen float wert immer erst als double, was aber nicht so schnell ist, fügt man das
        //Suffix f hinzu wird der Wert korrekt interpretiert und erhöt performance und benötigt weniger Speciherplatz


        Dog dog = new Dog();
        //Dog ist ein Referenztyp da dieser bloß auf ein Element(Objekt von Dog) im Speicher zeigt und selbst nur den Verwies
        // auf diese Adresse beinhaltet, wobei int als primitiver(elementarer)
        //Datentyp den Wert direkt abbildet und so auch den Speicherort im Stack abbildet

        Dog dog1 = new Dog();
        Dog dog2 = dog1;

        dog2.setName("John");
        dog1.bark();

        int num1 = 69;
        int num2 = num1;

        num1 = 420;
        System.out.println("Number 2: " + num2 + " -- Number 1: " + num1);


        Dog nullDog = null;
        System.out.println("Dog " + nullDog);
        //Es wird null ausgegeben, da dies statt einem Objekt zugewiesen wurde

        Dog bullDog = new Dog();
        System.out.println("Dog " + bullDog);
        //Es wird eine Referenzvariablecfür das zugewiesene Objekt ausgegeben

         int[] numArray = new int[]{1, 2, 3, 4, 5};

         System.out.println("Arraystelle 1 ; [0] : " + numArray[0]);
         System.out.println("Arraystelle 2 ; [1] : " + numArray[1]);
         System.out.println("Arraystelle 3 ; [2] : " + numArray[2]);
         //usw...

         Dog[] dogArray = new Dog[3];

         Dog husky = new Dog();
         husky.setName("Johnson");
         husky.setSize(6);
         husky.setBreed("Husky");

         Dog bulldog = new Dog();
         bulldog.setName("Rosi");
         bulldog.setSize(4);
         bulldog.setBreed("Bulldog");

         Dog pudel = new Dog();
         pudel.setName("Lord Farquart");
         pudel.setSize(7);
         pudel.setBreed("Pudel");

         dogArray[0] = husky;
         dogArray[1] = bulldog;
         dogArray[2] = pudel;
         //Arrays sind Objekte, da sie intern im Heap-Speicher verwaltet werden, und ihre Variablen speichern Referenzen
        // auf die Objekte, nicht die tatsächlichen Werte.
        //Arrays haben Eigenschaften, die mit Objekten verbunden sind,
        // wie die length-Eigenschaft und die Fähigkeit, Methoden von der Klasse Object zu erben.
        //Daher sind Arrays in Java Referenztypen, im Gegensatz zu primitiven Datentypen,
        // die den Wert direkt speichern.


        for (int i = 0; i < dogArray.length; i++) {
            dogArray[i].bark();
        }



    }
}
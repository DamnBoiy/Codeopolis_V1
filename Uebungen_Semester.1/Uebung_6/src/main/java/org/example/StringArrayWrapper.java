package org.example;

public class StringArrayWrapper {

    private String[] stringArray;

    public StringArrayWrapper(int indizes)
    {
        stringArray = new String[indizes];
    }

    public void SetString(int index, String value)
    {
        if (index >= 0 && index < stringArray.length)
        {
            stringArray[index] = value;
        }
        else System.out.println("Index außerhalb der Grenzen des Arrays");
    }

    public String GetString(int index)
    {
        if (index >= 0 && index < stringArray.length)
        {
            return stringArray[index];
        }
        else return null;
    }

    public int size()
    {
        return stringArray.length;
    }

    public void remove(int index)
    {
        if (index >= 0 && index < stringArray.length)
        {
            stringArray[index] = null;
        }
        else System.out.println("Index außerhalb der Grenzen des Arrays");
    }

    public int add(String value) {
        int oldLength = stringArray.length;
        int newLength = oldLength + Math.max(1, oldLength / 2);
        String[] newArray = new String[newLength];

        for (int i = 0; i < oldLength; i++) {
            newArray[i] = stringArray[i];
        }
        newArray[oldLength] = value;

        stringArray = newArray; // Aktualisierung des Originalarrays

        return oldLength; // Gibt die alte Länge zurück
    }


    public static void main(String[] args) {
        StringArrayWrapper example = new StringArrayWrapper(4);
       /* example.SetString(0, "Hallo");
        example.SetString(9, "Welt");
        System.out.println(example.GetString(0)); // Ausgabe: Hallo
        System.out.println(example.GetString(9)); // Ausgabe: Welt */
       example.SetString(0,"Hola");
       example.SetString(1,"Hello");
       example.SetString(2,"Bonjour");
       example.SetString(3,"Hallo");

       System.out.println(example.size());

       for (int i = 0; i < example.size(); i++)
       {
           System.out.print(example.GetString(i) + ", ");
       }


       System.out.println(example.add("Privet"));
       System.out.println(example.size());

       for (int i = 0; i < example.size(); i++)
       {
           System.out.print(example.GetString(i) + ", ");
       }
   }
}

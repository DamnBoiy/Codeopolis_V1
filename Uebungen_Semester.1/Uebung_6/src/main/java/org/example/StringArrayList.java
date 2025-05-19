package org.example;

import java.util.ArrayList;

public class StringArrayList {

    private ArrayList<String> list;

    public StringArrayList(int size)
    {
        list = new ArrayList<>(size);
        for(int i = 0; i < size; i++)
        {
            list.add(null); // setze für jede Stelle in der list ein null ein um ein element ersetzen zu können
        }
    }

    public void SetString(int index, String value)
    {
        if (index >= 0 && index < list.size())
        {
            list.set(index, value);
        }
        else System.out.println("Index außerhalb der Grenzen des Arrays");
    }

    public String GetString(int index)
    {
        if (index >= 0 && index < list.size())
        {
            return list.get(index);
        }
        else return null;
    }

    public int size()
    {
        return list.size();
    }

    public void remove(int index)
    {
        if (index >= 0 && index < list.size())
        {
            list.set(index, null);
        }
        else System.out.println("Index außerhalb der Grenzen des Arrays");
    }

    public int add(String value) {
        int oldLength = list.size();
        list.add(value);

        return oldLength; // Gibt die alte Länge zurück
    }




    // Aufgabe 3

    public boolean contains(String value)
    {
     if (list.contains(value)) return true;
     else return false;
    }

    public void clear()
    {
        list.clear();
    }

    public String[] toArray()
    {
        return list.toArray(new String[list.size()]);
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }








    public static void main(String[] args) {

        StringArrayList list = new StringArrayList(10);

        list.SetString(0, "Joachim");
        list.SetString(1, "Michael");
        list.SetString(2, "Michaela");

        System.out.println(list.GetString(0));


        String[] array = list.toArray();

        for(String string : array)
        {
         System.out.print(string + ", ");
        }

    }
}

package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StringArrayListTest {

    @Test
    void stringArrayWrapperTests()
    {
        StringArrayList list = new StringArrayList(4);
        list.SetString(0,"a");
        list.SetString(1,"b");
        list.SetString(2,"c");
        list.SetString(3,"d");

        list.size();

        assertEquals(list.GetString(3),"d", "Es sollte Null sein, Index out of Bounds!");

        list.SetString(1, "a");
        assertEquals("a", list.GetString(1), "Der String 'a' sollte erscheinen");

        list.remove(2);
        assertNull(list.GetString(2), "Es sollte Null sein, Index out of Bounds!");


        assertEquals(list.add("Hola"), 4);


        // Aufgabe 3


        assertTrue(list.contains("Hola"));

        list.clear();
        assertTrue(list.isEmpty()); // Schauen ob es einen Wert hat oder nicht (größe > 0, hat wert, else nicht)

        String[] string = list.toArray();
        assertEquals(list.toArray().length, string.length); // beweis das beide Array und Arraylist gefüllt sind


        list.clear();
        assertTrue(list.isEmpty());

        list.add("Hola");
        assertFalse(list.isEmpty());


    }
}
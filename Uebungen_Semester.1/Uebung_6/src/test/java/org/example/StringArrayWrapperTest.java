package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringArrayWrapperTest {

    @Test
    void stringArrayWrapperTests()
    {
        StringArrayWrapper sa = new StringArrayWrapper(4); // Array mit Länge 4 initialisieren

        sa.SetString(5, "YES");
        assertNull(sa.GetString(11), "Es sollte Null sein, Index out of Bounds!");

        sa.SetString(1, "NO");
        assertEquals("NO", sa.GetString(1), "Der String 'NO' sollte erscheinen");

        sa.remove(5);
        assertNull(sa.GetString(11), "Es sollte Null sein, Index out of Bounds!");


        assertEquals(sa.add("Hola"), 4);
    }
}
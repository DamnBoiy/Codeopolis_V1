package org.example;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class KilometersToMilesStrategyTest {

    @org.junit.jupiter.api.Test
    void convert()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        ConversionStrategy lol = new KilometersToMilesStrategy();

        assertEquals(df.format(lol.convert(10.870F)), "6,76");
    }
}
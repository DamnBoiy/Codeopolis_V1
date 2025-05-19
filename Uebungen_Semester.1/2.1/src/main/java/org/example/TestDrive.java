package org.example;
import java.text.DateFormat;
import java.text.DecimalFormat;

public class TestDrive {
    public static void main(String[] args)
    {
        DecimalFormat df = new DecimalFormat("#.##");

        ConversionStrategy lol = new KilometersToMilesStrategy();
        System.out.println(df.format(lol.convert(10.870F)));


    }
}

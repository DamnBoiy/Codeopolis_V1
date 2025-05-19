package org.example;

public class NumberProcessor {


    private int[] values;

    public NumberProcessor ( int [] values ) {
        this.values = values.clone () ; // Kopie für Immutability
    }

    public int[] getValue () {
        return values ;
    }

    public void printGreaterThan(int threshold)
    {

        class Filter
        {
            boolean isGreater(int value)
            {
                return value > threshold;
            }
        }

        Filter filter = new Filter();

        for(int value: values)
        {
            if(filter.isGreater(value))
            {
                System.out.print(value + ",");
            }
        }
        System.out.println();


    }

}

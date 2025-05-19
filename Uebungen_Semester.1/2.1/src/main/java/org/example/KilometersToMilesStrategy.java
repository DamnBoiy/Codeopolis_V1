package org.example;

import java.text.DecimalFormat;

public class KilometersToMilesStrategy extends ConversionStrategy {
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public float convert(float value) {
        return super.convert(value / 1.609F);
    }

}

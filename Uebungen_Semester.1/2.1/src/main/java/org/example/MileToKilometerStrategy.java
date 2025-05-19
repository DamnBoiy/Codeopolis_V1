package org.example;

public class MileToKilometerStrategy extends ConversionStrategy {

    @Override
    public float convert(float value) {
        return super.convert(value * 1.609F);
    }

}

package org.example;

public class MileToKilometerStrategy implements ConversionStrategy {
    @Override
    public float convert(float value) {
        return value / 0.621371f;
    }

    @Override
    public String getDescription() {
        return "Meilen zu Kilometer";
    }
}
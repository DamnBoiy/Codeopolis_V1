package org.example;

public class CelsiusToFahrenheitStrategy extends ConversionStrategy {

    @Override
    public float convert(float value) {
        return super.convert((value * 9/5) + 32);
    }
}

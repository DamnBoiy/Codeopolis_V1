package org.example;

public class CelsiusToFahrenheitStrategy implements ConversionStrategy {
    @Override
    public float convert(float value) {
        return (value * 9 / 5) + 32;
    }

    @Override
    public String getDescription() {
        return "Celsius zu Fahrenheit";
    }
}


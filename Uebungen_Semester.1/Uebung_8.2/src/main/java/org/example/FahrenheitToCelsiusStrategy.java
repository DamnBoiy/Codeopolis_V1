package org.example;

public class FahrenheitToCelsiusStrategy implements ConversionStrategy {
    @Override
    public float convert(float value) {
        return (value - 32) * 5 / 9;
    }

    @Override
    public String getDescription() {
        return "Fahrenheit zu Celsius";
    }
}
package org.example;

public class FahrenheitToCelsiusStrategy extends ConversionStrategy
{
    @Override
    public float convert(float value) {
        return super.convert((value - 32F) * 5/9);
    }
}

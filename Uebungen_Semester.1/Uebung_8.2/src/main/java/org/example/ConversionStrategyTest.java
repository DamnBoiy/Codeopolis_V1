package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConversionStrategyTest {

    @Test
    public void testCelsiusToFahrenheit() {
        ConversionStrategy strategy = new CelsiusToFahrenheitStrategy();
        assertEquals(32.0, strategy.convert(0), 0.01);
        assertEquals(212.0, strategy.convert(100), 0.01);
    }

    @Test
    public void testFahrenheitToCelsius() {
        ConversionStrategy strategy = new FahrenheitToCelsiusStrategy();
        assertEquals(0.0, strategy.convert(32), 0.01);
        assertEquals(100.0, strategy.convert(212), 0.01);
    }

    @Test
    public void testKilometerToMile() {
        ConversionStrategy strategy = new KilometerToMileStrategy();
        assertEquals(0.621371, strategy.convert(1), 0.0001);
        assertEquals(6.21371, strategy.convert(10), 0.0001);
    }

    @Test
    public void testMileToKilometer() {
        ConversionStrategy strategy = new MileToKilometerStrategy();
        assertEquals(1.60934, strategy.convert(1), 0.0001);
        assertEquals(16.0934, strategy.convert(10), 0.0001);
    }
}
package org.example;

public interface ConversionStrategy {
    float convert(float value); // Deklaration der Umrechnungsmethode
    String getDescription();    // Beschreibung der Strategie
}
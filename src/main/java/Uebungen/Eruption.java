package Uebungen;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * Modelliert einen Vulkanausbruch.
 */
public class Eruption {
    private final int volcanoNumber;
    private final String volcanoName;
    private final int eruptionNumber;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String evidenceMethod;
    private final double latitude;
    private final double longitude;

    public Eruption(int volcanoNumber, String volcanoName, int eruptionNumber,
                    LocalDate startDate, LocalDate endDate,
                    String evidenceMethod, double latitude, double longitude) {
        this.volcanoNumber = volcanoNumber;
        this.volcanoName = volcanoName;
        this.eruptionNumber = eruptionNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.evidenceMethod = evidenceMethod;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Berechnet die Dauer des Ausbruchs in Tagen.
     * Gibt -1 zurück, wenn kein Enddatum bekannt ist.
     */
    public long getDurationInDays() {
        if (startDate != null && endDate != null) {
            return ChronoUnit.DAYS.between(startDate, endDate);
        }
        return -1;
    }

    /**
     * Gibt das Jahr des Ausbruchsstarts zurück.
     */
    public int getStartYear() {
        return startDate.getYear();
    }

    /**
     * Gibt true zurück, wenn Start- und Enddatum im selben Jahr liegen.
     */
    public boolean isSameYear() {
        return endDate != null && startDate.getYear() == endDate.getYear();
    }

    /**
     * Gibt true zurück, wenn der Vulkan nördlich des Äquators liegt.
     */
    public boolean isNorth() {
        return latitude > 0;
    }

    /**
     * Gibt true zurück, wenn der Vulkan südlich des Äquators liegt.
     */
    public boolean isSouth() {
        return latitude < 0;
    }

    public String getVolcanoName() {
        return volcanoName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getEvidenceMethod() {
        return evidenceMethod;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return String.format("Eruption of %s (%d), %s to %s (%d days)",
                volcanoName, volcanoNumber,
                startDate,
                (endDate != null ? endDate : "unknown"),
                getDurationInDays());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Eruption)) return false;
        Eruption eruption = (Eruption) o;
        return volcanoNumber == eruption.volcanoNumber &&
                eruptionNumber == eruption.eruptionNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volcanoNumber, eruptionNumber);
    }
}


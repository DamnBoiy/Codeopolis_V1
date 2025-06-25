package Uebungen;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;


 // Modelliert einen Vulkanausbruch.

public class Eruption {
    private int volcanoNumber;
    private String volcanoName;
    private int eruptionNumber;
    private int startYear;
    private int startMonth;
    private int startDay;
    private String evidenceMethod;
    private int endYear;
    private int endMonth;
    private int endDay;
    private double latitude;
    private double longitude;

    public Eruption(int volcanoNumber, String volcanoName, int eruptionNumber,
                    int startYear, int startMonth, int startDay,
                    String evidenceMethod,
                    int endYear, int endMonth, int endDay,
                    double latitude, double longitude) {
        this.volcanoNumber = volcanoNumber;
        this.volcanoName = volcanoName;
        this.eruptionNumber = eruptionNumber;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.evidenceMethod = evidenceMethod;
        this.endYear = endYear;
        this.endMonth = endMonth;
        this.endDay = endDay;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getVolcanoNumber() {
        return volcanoNumber;
    }

    public String getVolcanoName() {
        return volcanoName;
    }

    public int getEruptionNumber() {
        return eruptionNumber;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public int getStartDay() {
        return startDay;
    }

    public String getEvidenceMethod() {
        return evidenceMethod;
    }

    public int getEndYear() {
        return endYear;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public int getEndDay() {
        return endDay;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }


    /**
     * Berechnet die Dauer des Ausbruchs in Tagen.
     * Gibt -1 zurück, wenn kein Enddatum bekannt ist.
     */
    public long getDurationInDays() {
        try {
            LocalDate start = LocalDate.of(startYear, Math.max(1, startMonth), Math.max(1, startDay));
            LocalDate end = LocalDate.of(endYear, Math.max(1, endMonth), Math.max(1, endDay));
            return ChronoUnit.DAYS.between(start, end);
        } catch (Exception e) {
            return -1; // z.B. ungültiges Datum (Monat 0 etc.)
        }
    }


    @Override
    public String toString() {
        String start = String.format("%02d.%02d.%04d", startDay, startMonth, startYear);
        String end = (endYear > 0)
                ? String.format("%02d.%02d.%04d", endDay, endMonth, endYear)
                : "unknown";
        return String.format("Eruption of %s (%d), %s to %s (%d days)",
                volcanoName, volcanoNumber, start, end, getDurationInDays());
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


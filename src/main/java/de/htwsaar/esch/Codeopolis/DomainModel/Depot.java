package de.htwsaar.esch.Codeopolis.DomainModel;

import de.htwsaar.esch.Codeopolis.DomainModel.Harvest.*;
import de.htwsaar.esch.Codeopolis.DomainModel.*;
import de.htwsaar.esch.Codeopolis.DomainModel.Logics.LinkedList;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Depot {
    private LinkedList<Silo> silos;

    public Depot(int numberOfSilos, int capacityPerSilo) {
        this.silos = new LinkedList<>();
        for (int i = 0; i < numberOfSilos; i++) {
            this.silos.addLast(new Silo(capacityPerSilo));
        }
    }

    // Änderung: Verwendung von forEach statt Schleife zur Kopie der Silos
    public Depot(LinkedList<Silo> silosArray) {
        this.silos = new LinkedList<>();
        if (silosArray != null) {
            silosArray.forEach(s -> this.silos.addLast(new Silo(s)));
        }
    }

    public interface Iterator {
        boolean hasNext();
        Silo.Status next();
    }

    private class DepotIterator implements Iterator {
        private java.util.Iterator<Silo> internal = silos.iterator();
        private Silo nextSilo;
        private Game.GrainType filter;

        public DepotIterator() {}

        public DepotIterator(Game.GrainType filter) {
            this.filter = filter;
            advance();
        }

        private void advance() {
            while (internal.hasNext()) {
                Silo candidate = internal.next();
                if (filter == null || candidate.getGrainType() == filter) {
                    nextSilo = candidate;
                    return;
                }
            }
            nextSilo = null;
        }

        @Override
        public boolean hasNext() {
            return nextSilo != null;
        }

        @Override
        public Silo.Status next() {
            if (!hasNext()) throw new NoSuchElementException();
            Silo.Status status = Silo.getStatus(nextSilo);
            advance();
            return status;
        }
    }

    public Iterator getIterator() {
        return new DepotIterator();
    }

    public Iterator getIterator(Game.GrainType type) {
        return new DepotIterator(type);
    }

    // Änderung: Nutzung von filter + for zur Berechnung
    public int getFillLevel(Game.GrainType grainType) {
        int total = 0;
        LinkedList<Silo> filtered = silos.filter(s -> s.getGrainType() == grainType);
        for (Silo silo : filtered) {
            total += silo.getFillLevel();
        }
        return total;
    }

    // Änderung: Nutzung von forEach zur Kopie
    public LinkedList<Silo> getSilos() {
        LinkedList<Silo> copy = new LinkedList<>();
        silos.forEach(s -> copy.addLast(new Silo(s)));
        return copy;
    }

    // Änderung: Nutzung von forEach mit Akkumulator
   /* public int getTotalFillLevel() {
        int total = 0;
        silos.forEach(s -> total += s.getFillLevel());
        return total;
    }*/
    public int getTotalFillLevel() {
        final int[] total = {0};
        silos.forEach(s -> total[0] += s.getFillLevel());
        return total[0];
    }

    // Änderung: forEach statt Schleife mit if
   /* public int getCapacity(Game.GrainType grainType) {
        int capacity = 0;
        silos.forEach(s -> {
            if (s.getGrainType() == grainType || s.getGrainType() == null) {
                capacity += s.getCapacity();
            }
        });
        return capacity;
    }*/
    public int getCapacity(Game.GrainType grainType) {
        final int[] capacity = {0}; //capacity  als array da der Inhalt verändert werden kann aber nicht die Referenz
        silos.forEach(s -> {
            if (s.getGrainType() == grainType || s.getGrainType() == null) {
                capacity[0] += s.getCapacity();
            }
        });
        return capacity[0];
    }



    public boolean store(Harvest harvest) {
        for (Silo silo : silos) {
            if (silo.getGrainType() == harvest.getGrainType() || silo.getFillLevel() == 0) {
                harvest = silo.store(harvest);
                if (harvest == null) return true;
            }
        }

        defragment();

        for (Silo silo : silos) {
            if (silo.getGrainType() == harvest.getGrainType() || silo.getFillLevel() == 0) {
                harvest = silo.store(harvest);
                if (harvest == null) return true;
            }
        }
        return false;
    }

    // Änderung: Nutzung von filter zur Auswahl der Silos
    public int takeOut(int amount, Game.GrainType grainType) {
        int taken = 0;
        for (Silo silo : silos.filter(s -> s.getGrainType() == grainType)) {
            int current = silo.takeOut(amount);
            amount -= current;
            taken += current;
            if (amount <= 0) break;
        }
        return taken;
    }

    // Änderung: Nutzung von forEach (inkl. Methodenreferenz)
    public int takeOut(int amount) {
        int total = getTotalFillLevel();
        if (amount >= total) {
            silos.forEach(Silo::emptySilo);
            return total;
        }

        int portion = amount / silos.size();
        int remainder = amount % silos.size();

        for (int i = 0; i < silos.size(); i++) {
            Silo silo = silos.get(i);
            if (silo.getFillLevel() < portion) {
                remainder += portion - silo.getFillLevel();
                silo.emptySilo();
            } else {
                silo.takeOut(portion);
            }
        }

        int i = 0;
        while (remainder > 0) {
            Silo silo = silos.get(i);
            if (silo.getFillLevel() > 0) {
                silo.takeOut(1);
                remainder--;
            }
            i = (i + 1) % silos.size();
        }

        return amount;
    }

    public void expand(int numberOfSilos, int capacityPerSilo) {
        for (int i = 0; i < numberOfSilos; i++) {
            silos.addLast(new Silo(capacityPerSilo));
        }
        this.takeOut((int) (numberOfSilos * GameConfig.DEPOT_EXPANSION_COST));
    }

    // Änderung: defragment nutzt forEach + Methodenreferenz
    public void defragment() {
        LinkedList<Harvest> allHarvests = new LinkedList<>();
        silos.forEach(silo -> {
            LinkedList<Harvest> h = silo.emptySilo();
            if (h != null) h.forEach(allHarvests::addLast);
        });
        allHarvests.forEach(this::store);
    }

    private int getTotalHarvestCount() {
        int total = 0;
        for (Silo silo : silos) {
            total += silo.getHarvestCount();
        }
        return total;
    }

    public int decay(int currentYear) {
        int decayed = 0;
        for (Silo silo : silos) {
            decayed += silo.decay(currentYear);
        }
        return decayed;
    }

    public boolean full() {
        return getTotalFillLevel() >= totalCapacity();
    }

    public int totalCapacity() {
        int total = 0;
        for (Silo silo : silos) {
            total += silo.getCapacity();
        }
        return total;
    }

    public int[] getBushelsCategorizedByGrainType() {
        int[] result = new int[Game.GrainType.values().length];
        for (Game.GrainType type : Game.GrainType.values()) {
            result[type.ordinal()] = getFillLevel(type);
        }
        return result;
    }

    // Änderung: Verwendung von sort mit Methodenreferenz
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.00");

        LinkedList<Silo> sortedSilos = new LinkedList<>();
        sortedSilos.addAll(silos);
        sortedSilos.sort(Comparator.comparingInt(Silo::getFillLevel));

        int i = 1;
        for (Silo silo : sortedSilos) {
            builder.append("Silo ").append(i++).append(": ");
            String grain = (silo.getGrainType() != null) ? silo.getGrainType().toString() : "EMPTY";
            builder.append(grain).append("\n");

            int fill = silo.getFillLevel();
            int cap = silo.getCapacity();
            double percent = (double) fill / cap * 100;

            builder.append("Amount of Grain: ").append(fill).append(" units\n");

            int bars = 20;
            int filled = (int) (percent / 100 * bars);
            int empty = bars - filled;

            builder.append("|");
            for (int j = 0; j < filled; j++) builder.append("=");
            for (int j = 0; j < empty; j++) builder.append("-");
            builder.append("| ").append(df.format(percent)).append("% filled\n");

            builder.append("Capacity: ").append(cap).append(" units\n\n");
        }

        return builder.toString();
    }
}

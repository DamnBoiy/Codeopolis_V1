package de.htwsaar.esch.Codeopolis.DomainModel;

import de.htwsaar.esch.Codeopolis.DomainModel.Harvest.*;
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

    public Depot(LinkedList<Silo> silosArray) {
        this.silos = new LinkedList<>();
        if (silosArray != null) {
            for (Silo silo : silosArray) {
                this.silos.addLast(new Silo(silo));
            }
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

    public int getFillLevel(Game.GrainType grainType) {
        int total = 0;
        for (Silo silo : silos) {
            if (silo.getGrainType() == grainType) {
                total += silo.getFillLevel();
            }
        }
        return total;
    }

    public LinkedList<Silo> getSilos() {
        LinkedList<Silo> copy = new LinkedList<>();
        for (Silo silo : silos) {
            copy.addLast(new Silo(silo));
        }
        return copy;
    }

    public int getTotalFillLevel() {
        int total = 0;
        for (Silo silo : silos) {
            total += silo.getFillLevel();
        }
        return total;
    }

    public int getCapacity(Game.GrainType grainType) {
        int capacity = 0;
        for (Silo silo : silos) {
            if (silo.getGrainType() == grainType || silo.getGrainType() == null) {
                capacity += silo.getCapacity();
            }
        }
        return capacity;
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

    public int takeOut(int amount, Game.GrainType grainType) {
        int taken = 0;
        for (Silo silo : silos) {
            if (silo.getGrainType() == grainType) {
                int current = silo.takeOut(amount);
                amount -= current;
                taken += current;
                if (amount <= 0) break;
            }
        }
        return taken;
    }

    public int takeOut(int amount) {
        int total = getTotalFillLevel();
        if (amount >= total) {
            for (Silo silo : silos) silo.emptySilo();
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

    public void defragment() {
        LinkedList<Harvest> allHarvests = new LinkedList<>();
        for (Silo silo : silos) {
            LinkedList<Harvest> h = silo.emptySilo();
            if (h != null) {
                for (Harvest harvest : h) {
                    if (harvest != null) allHarvests.addLast(harvest);
                }
            }
        }
        for (Harvest harvest : allHarvests) {
            store(harvest);
        }
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.00");

        // Kopie der Silos erstellen
        LinkedList<Silo> sortedSilos = new LinkedList<>();
        sortedSilos.addAll(silos);

        // sortedSilos.sort((silo1, silo2) -> Integer.compare(silo1.getFillLevel(), silo2.getFillLevel()));
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

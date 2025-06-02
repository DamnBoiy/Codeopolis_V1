package de.htwsaar.esch.Codeopolis.DomainModel;

import de.htwsaar.esch.Codeopolis.DomainModel.Harvest.*;
import de.htwsaar.esch.Codeopolis.DomainModel.Logics.LinkedList;

import java.io.Serializable;

public class Silo implements Serializable, Comparable<Silo> {
    private final LinkedList<Harvest> stock;
    private final int capacity;
    private int fillLevel;

    public Silo(int capacity) {
        this.capacity = capacity;
        this.stock = new LinkedList<>();
        this.fillLevel = 0;
    }

    public Silo(Silo other) {
        this.capacity = other.capacity;
        this.fillLevel = other.fillLevel;
        this.stock = new LinkedList<>();
        other.stock.forEach(h -> this.stock.addLast(h.copy()));
    }

    public Harvest store(Harvest harvest) {
        if (fillLevel > 0 && !stock.isEmpty() && stock.get(0).getGrainType() != harvest.getGrainType()) {
            throw new IllegalArgumentException("The grain type of the given Harvest does not match the grain type of the silo");
        }

        if (fillLevel >= capacity) {
            return harvest;
        }

        int remainingCapacity = capacity - fillLevel;
        if (harvest.getAmount() <= remainingCapacity) {
            stock.addLast(harvest);
            fillLevel += harvest.getAmount();
            return null;
        } else {
            Harvest remaining = harvest.split(remainingCapacity);
            stock.addLast(remaining);
            fillLevel += remaining.getAmount();
            return harvest;
        }
    }

    public LinkedList<Harvest> emptySilo() {
        if (stock.isEmpty()) {
            return null;
        } else {
            LinkedList<Harvest> removedHarvests = new LinkedList<>();
            stock.forEach(removedHarvests::addLast);
            stock.clear();
            fillLevel = 0;
            return removedHarvests;
        }
    }

    public int takeOut(int amount) {
        int takenAmount = 0;
        java.util.Iterator<Harvest> iterator = stock.iterator();

        while (iterator.hasNext() && amount > 0) {
            Harvest currentHarvest = iterator.next();
            int taken = currentHarvest.remove(amount);
            amount -= taken;
            takenAmount += taken;

            if (currentHarvest.getAmount() == 0) {
                iterator.remove();
            }
        }
        this.fillLevel -= takenAmount;
        return takenAmount;
    }

    public int getFillLevel() {
        return this.fillLevel;
    }

    public int getCapacity() {
        return capacity;
    }

    public Game.GrainType getGrainType() {
        return (!stock.isEmpty()) ? stock.get(0).getGrainType() : null;
    }

    public int getHarvestCount() {
        return stock.size();
    }

    public int decay(int currentYear) {
        final int[] totalDecayedAmount = {0};
        stock.forEach(h -> totalDecayedAmount[0] += h.decay(currentYear));
        fillLevel -= totalDecayedAmount[0];
        return totalDecayedAmount[0];
    }

    public static Silo.Status getStatus(Silo silo) {
        return new Status(silo);
    }

    @Override
    public int compareTo(Silo other) {
        return Integer.compare(this.getFillLevel(), other.getFillLevel());
    }

    public static final class Status {
        private final int capacity;
        private final int fillLevel;

        private Status(Silo silo) {
            this.capacity = silo.getCapacity();
            this.fillLevel = silo.getFillLevel();
        }

        public int getCapacity() { return capacity; }
        public int getFillLevel() { return fillLevel; }
    }
}

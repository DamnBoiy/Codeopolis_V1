package de.htwsaar.esch.Codeopolis.DomainModel;

import de.htwsaar.esch.Codeopolis.DomainModel.Harvest.*;
import java.io.Serializable;
import java.util.Iterator;

/**
 * The Silo class represents a storage unit for a specific type of grain.
 */
public class Silo implements Serializable{
    private LinkedList<Harvest> stock;
    private final int capacity;
    private int fillLevel;

    /**
     * Constructs a Silo object with the specified initial capacity.
     *
     * @param initialCapacity The initial capacity of the silo.
     */
    public Silo(int capacity) {
        this.capacity = capacity;
        this.stock = new LinkedList<>();
        this.fillLevel = 0;
    }

    /**
     * Copy constructor for the Silo class.
     * Creates a new Silo object as a deep copy of another Silo object.
     * This constructor is used to ensure that each property of the Silo,
     * including mutable objects, is copied and independent of the original object.
     *
     * @param other The Silo object to copy.
     */
    public Silo(Silo other) {
        this.capacity = other.capacity;
        this.fillLevel = other.fillLevel;
        this.stock = new LinkedList<>();

        for (Harvest harvest : other.stock) {
            this.stock.addLast(harvest.copy());
        }
    }

    /**
     * Stores a harvest in the silo if there is available capacity.
     *
     * @param harvest The harvest to be stored in the silo.
     * @return The amount of grain that could not be stored due to capacity limitations.
     */
    public Harvest store(Harvest harvest) {
    	 // Check if the grain type matches the existing grain in the silo
        if (fillLevel > 0 && !stock.isEmpty() && stock.get(0).getGrainType() != harvest.getGrainType()) {
            throw new IllegalArgumentException("The grain type of the given Harvest does not match the grain type of the silo");
        }

        // Check if there is enough space in the silo
        if (fillLevel >= capacity) {
            return harvest; // The silo is already full, cannot be stored
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
            return harvest; // If the silo is full, return the unsaved grain
        }
    }

    /**
     * Empties the silo by removing all stored harvests and returning them.
     *
     * @return An array containing all the removed harvests from the silo.
     *         If the silo is empty, an empty array is returned.
     */
    public LinkedList<Harvest> emptySilo() {
        if (stock.isEmpty()) {
            return null;
        } else {
            LinkedList<Harvest> removedHarvests = new LinkedList<>();
            for (Harvest harvest : stock) {
                removedHarvests.addLast(harvest);
            }
            stock.clear();  // Clear the stock list
            fillLevel = 0;
            return removedHarvests;
        }
    }

    /**
     * Takes out a specified amount of grain from the silo.
     *
     * @param amount The amount of grain to be taken out.
     * @return The actual amount of grain taken out from the silo.
     */
    public int takeOut(int amount) {
        int takenAmount = 0;

        Iterator<Harvest> iterator = stock.iterator();

        while (iterator.hasNext() && amount > 0) {
            Harvest currentHarvest = iterator.next();
            int taken = currentHarvest.remove(amount);
            amount -= taken;
            takenAmount += taken;

            if (currentHarvest.getAmount() == 0) {
                iterator.remove();  // Remove the empty harvest from the list
            }
        }
        this.fillLevel -= takenAmount;
        return takenAmount;
    }

    /**
     * Gets the current fill level of the silo.
     *
     * @return The number of harvests currently stored in the silo.
     */
    public int getFillLevel() {
    	return this.fillLevel;
    }

    /**
     * Gets the capacity of the silo.
     *
     * @return The maximum number of harvests the silo can store.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the grain type stored in the silo.
     *
     * @return A string representation of the grain type.
     */
    public Game.GrainType getGrainType() {
        // Assuming each silo stores only one type of grain, we can retrieve the grain type from the first stored harvest
        if (!stock.isEmpty()) {
            Iterator<Harvest> it = stock.iterator();
            if (it.hasNext()) {
                return it.next().getGrainType();
            }
        }
        return null;
    }

    /**
     * Retrieves the number of harvests currently stored in the silo.
     *
     * @return The number of harvests stored in the silo.
     */
    public int getHarvestCount() {
        return stock.size();
    }

    /**
     * Simulates the decay of grain in all harvests stored in the silo over time.
     *
     * @param currentYear The current year used to calculate the decay.
     * @return The total amount of grain that decayed in all harvests in the silo.
     */
    public int decay(int currentYear) {
        int totalDecayedAmount = 0;
        for (Harvest currentHarvest : stock) {
            totalDecayedAmount += currentHarvest.decay(currentYear);
        }
        fillLevel -= totalDecayedAmount;
        return totalDecayedAmount;
    }

    public static Silo.Status getStatus(Silo silo)
    {
        return new Status(silo);
    }

    public static final class Status
    {
        //final Game.GrainType grainType = getGrainType();

        private final int capacity;
        private final int fillLevel;

        private Status (Silo silo)
        {
            this.capacity = silo.getCapacity();
            this.fillLevel = silo.getFillLevel();
        }

        public int getCapacity() {return capacity;}
        public int getFillLevel() {return fillLevel;}


    }


}


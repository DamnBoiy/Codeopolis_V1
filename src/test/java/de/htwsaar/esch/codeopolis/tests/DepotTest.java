package de.htwsaar.esch.codeopolis.tests;

import static org.junit.jupiter.api.Assertions.*;

import de.htwsaar.esch.Codeopolis.DomainModel.Silo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.htwsaar.esch.Codeopolis.DomainModel.Depot;
import de.htwsaar.esch.Codeopolis.DomainModel.Game;
import de.htwsaar.esch.Codeopolis.DomainModel.Harvest.*;


public class DepotTest {

    private Depot depot;
    private Harvest wheatHarvest;
    private Harvest cornHarvest;
    private Harvest cornHarvest2;

    @BeforeEach
    public void setUp() {
        depot = new Depot(3, 1000);
        wheatHarvest = Harvest.createHarvest(Game.GrainType.WHEAT, 500, 2023);
        cornHarvest = Harvest.createHarvest(Game.GrainType.CORN, 700, 2023); 
        cornHarvest2 = Harvest.createHarvest(Game.GrainType.CORN, 700, 2023);
    }

    @Test
    public void testStoreAndTakeOut() {
        assertTrue(depot.store(wheatHarvest));
        assertEquals(500, depot.getFillLevel(Game.GrainType.WHEAT));
        assertTrue(depot.store(cornHarvest));
        assertEquals(700, depot.getFillLevel(Game.GrainType.CORN));
        assertTrue(depot.store(cornHarvest2));
        assertEquals(1400, depot.getFillLevel(Game.GrainType.CORN));

        int takenOut = depot.takeOut(200, Game.GrainType.WHEAT);
        assertEquals(200, takenOut);
        assertEquals(300, depot.getFillLevel(Game.GrainType.WHEAT));

        // Taking out more than available
        takenOut = depot.takeOut(400, Game.GrainType.WHEAT);
        assertEquals(300, takenOut);
        assertEquals(0, depot.getFillLevel(Game.GrainType.WHEAT));
        
        takenOut = depot.takeOut(1000, Game.GrainType.CORN);
        assertEquals(1000, takenOut);
        assertEquals(400, depot.getFillLevel(Game.GrainType.CORN));
        takenOut = depot.takeOut(400, Game.GrainType.CORN);
        assertEquals(400, takenOut);
        assertEquals(0, depot.getFillLevel(Game.GrainType.CORN));
    }

    @Test
    public void testExpand() {
        depot.expand(2, 1500);
        assertEquals(6000, depot.getCapacity(Game.GrainType.WHEAT));
        assertEquals(6000, depot.getCapacity(Game.GrainType.CORN));
    }


        @Test
        public void testToStringSortedByFillLevel() {
            Depot depot = new Depot();

            // Beispiel-Silos manuell erstellen
            Silo silo1 = new Silo(100); // leer
            silo1.store(new Harvest("WHEAT", 20));

            Silo silo2 = new Silo(100);
            silo2.store(new Harvest("WHEAT", 50));

            Silo silo3 = new Silo(100);
            silo3.store(new Harvest("WHEAT", 10));

            // Silos zum Depot hinzufügen
            depot.addSilo(silo1);
            depot.addSilo(silo2);
            depot.addSilo(silo3);

            String output = depot.toString();

            // Stelle sicher, dass die Ausgabe in aufsteigender Reihenfolge der Füllstände erfolgt
            int index1 = output.indexOf("Silo 1:");
            int index2 = output.indexOf("Silo 2:");
            int index3 = output.indexOf("Silo 3:");

            // Silo 3 (10) soll zuerst kommen, dann Silo 1 (20), dann Silo 2 (50)
            assertTrue(index1 > index3 && index2 > index1, "Silos sollten nach Füllstand sortiert sein.");
        }
    }





}

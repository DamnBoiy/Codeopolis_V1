package de.htwsaar.esch.Codeopolis.DomainModel.Logics;

import java.util.List;
import java.util.function.*;

public class StringProcessor {

    private LinkedList<String> list;

    // Konstruktor: Initialisiert mit leerer Liste
    public StringProcessor() {
        this.list = new LinkedList<>();
    }

    // Konstruktor: Initialisiert MIT vorhandener Liste
    public StringProcessor( List<String> initialStrings) {
        this.list = new LinkedList<>();
        for (String s : initialStrings) {
            list.addLast(s);
        }
    }

    // Fügt einen String hinzu durch addLast methode von LinkedList
    public void add(String value) {
        list.addLast(value);
    }

    // Gibt eine neue gefilterte Liste zurück auf der bedingt ein String Predicate gefiltert wird
    public LinkedList<String> filter(Predicate<String> predicate) {
        return list.filter(predicate);
    }

    // Wendet eine Operation auf alle Strings an (verändert also die Liste)
    public void applyToAll(UnaryOperator<String> operator) {
        for (int i = 0; i < list.size(); i++) {
            String newValue = operator.apply(list.get(i));
            list.set(i, newValue);
        }
    }

    // Gibt eine neue Liste mit Integer-Werten zurück
    public LinkedList<Integer> mapToInt(Function<String, Integer> mapper) {
        LinkedList<Integer> result = new LinkedList<>();
        for (String value : list) {
            result.addLast(mapper.apply(value));
        }
        return result;
    }

    // Führt eine Aktion auf jedes Element aus (verändert nicht die Liste)
    public void forEach(Consumer<String> action) {
        list.forEach(action);
    }

    // Optional: Gibt die Liste als String zurück
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int i = 0;
        for (String value : list) {
            sb.append(value);
            if (i < list.size() - 1) sb.append(", ");
            i++;
        }
        sb.append("]");
        return sb.toString();
    }

    // Optional: Getter für externe Tests
    public LinkedList<String> getList() {
        return list;
    }
}




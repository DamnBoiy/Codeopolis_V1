package org.example;

// Abstrakte Superklasse Robot
abstract class Robot {
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public abstract void performTask();
}

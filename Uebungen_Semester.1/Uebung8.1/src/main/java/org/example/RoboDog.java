package org.example;

// Konkrete Klasse RoboDog
class RoboDog extends Robot implements Pet {
    private boolean isCharged;
    private int batteryLife;

    public boolean isCharged() {
        return isCharged;
    }

    public void setCharged(boolean charged) {
        isCharged = charged;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    @Override
    public void performTask() {
        if (isCharged) {
            System.out.println(getModel() + " is guarding the house.");
        } else {
            System.out.println(getModel() + " needs recharging before performing tasks.");
        }
    }

    @Override
    public void play() {
        if (isCharged) {
            System.out.println(getModel() + " is playing fetch in simulation mode.");
        } else {
            System.out.println(getModel() + " cannot play while discharged.");
        }
    }

    public void recharge() {
        System.out.println(getModel() + " is recharging.");
        isCharged = true;
    }

    public void diagnostics() {
        System.out.println(getModel() + " battery life is at " + batteryLife + "%.");
    }
}

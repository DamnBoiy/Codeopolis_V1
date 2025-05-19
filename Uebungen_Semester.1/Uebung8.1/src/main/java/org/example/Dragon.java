package org.example;



// Konkrete Klasse Dragon
class Dragon extends Animal {
    private int firePower;
    private double wingSpan;

    public int getFirePower() {
        return firePower;
    }

    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " roars and breathes fire!");
    }

    public void fly() {
        System.out.println(getName() + " flies majestically with a wingspan of " + wingSpan + " meters.");
    }

    public void breatheFire() {
        System.out.println(getName() + " breathes fire with a power level of " + firePower + ".");
    }
}

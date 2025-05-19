package org.example;

// Abstrakte Superklasse Animal
abstract class Animal {
    private String name;
    private int age;
    private double weight;

    // Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Abstrakte Methode
    public abstract void makeSound();

    // Standardmethoden
    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void move() {
        System.out.println(name + " moves.");
    }
}
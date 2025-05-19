package org.example;

// Abstrakte Unterklassen
abstract class Feline extends Animal {
    @Override
    public void eat() {
        super.eat();
        System.out.println(getName() + " licks its paws after eating.");
    }
}

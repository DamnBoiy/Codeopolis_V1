package org.example;

abstract class Canine extends Animal {
    @Override
    public void eat() {
        super.eat();
        System.out.println(getName() + " howls after eating.");
    }
}
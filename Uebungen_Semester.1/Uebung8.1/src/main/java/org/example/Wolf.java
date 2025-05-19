package org.example;

class Wolf extends Canine {
    @Override
    public void makeSound() {
        System.out.println(getName() + " howls.");
    }
}

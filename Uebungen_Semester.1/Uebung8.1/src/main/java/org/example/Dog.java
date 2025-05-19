package org.example;

class Dog extends Canine implements Pet {
    private String breed;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " barks.");
    }

    @Override
    public void play() {
        System.out.println(getName() + " is fetching the ball.");
    }

    public void guard() {
        System.out.println(getName() + " is guarding the house.");
    }
}

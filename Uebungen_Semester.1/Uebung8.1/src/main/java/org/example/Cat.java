package org.example;

// Konkrete Klassen
class Cat extends Feline implements Pet {
    private String favoriteToy;

    public String getFavoriteToy() {
        return favoriteToy;
    }

    public void setFavoriteToy(String favoriteToy) {
        this.favoriteToy = favoriteToy;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " meows.");
    }

    @Override
    public void play() {
        System.out.println(getName() + " is playing with a ball of yarn.");
    }

    public void hunt() {
        System.out.println(getName() + " is hunting.");
    }
}

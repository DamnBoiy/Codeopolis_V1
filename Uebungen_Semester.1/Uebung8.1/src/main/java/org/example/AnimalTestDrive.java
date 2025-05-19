package org.example;

// Testklasse
class AnimalTestDrive {
    public static void main(String[] args) {
        // Instanzen erstellen und testen

        Dragon smaug = new Dragon();
        smaug.setName("Smaug");
        smaug.setWingSpan(15.5);
        smaug.setFirePower(100);
        smaug.makeSound();
        smaug.eat();
        smaug.fly();
        smaug.breatheFire();

        Cat whiskers = new Cat();
        whiskers.setName("Whiskers");
        whiskers.setFavoriteToy("ball of yarn");
        whiskers.makeSound();
        whiskers.eat();
        whiskers.play();
        whiskers.hunt();

        Dog buddy = new Dog();
        buddy.setName("Buddy");
        buddy.setBreed("Golden Retriever");
        buddy.makeSound();
        buddy.eat();
        buddy.play();
        buddy.guard();

        Lion simba = new Lion();
        simba.setName("Simba");
        simba.setPrideSize(10);
        simba.makeSound();
        simba.eat();

        Wolf ghost = new Wolf();
        ghost.setName("Ghost");
        ghost.makeSound();
        ghost.eat();

        RoboDog r2d2 = new RoboDog();
        r2d2.setModel("R2-D2");
        r2d2.setBatteryLife(80);
        r2d2.setCharged(true);
        r2d2.performTask();
        r2d2.play();
        r2d2.diagnostics();

        r2d2.setCharged(false);
        r2d2.performTask();
        r2d2.play();
        r2d2.recharge();
        r2d2.performTask();
    }
}

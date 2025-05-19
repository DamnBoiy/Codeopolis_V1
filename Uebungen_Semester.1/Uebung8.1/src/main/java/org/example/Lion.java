package org.example;

class Lion extends Feline {
    private int prideSize;

    public int getPrideSize() {
        return prideSize;
    }

    public void setPrideSize(int prideSize) {
        this.prideSize = prideSize;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " roars loudly.");
    }
}

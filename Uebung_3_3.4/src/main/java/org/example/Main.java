package org.example;

public class Main {
    public static void main(String[] args) {

        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34};
        NumberProcessor processor = new NumberProcessor(intArray);

        processor.printGreaterThan(17);

        Calculator calculator = new Calculator();

        BinaryOperation addition = new BinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return a + b;  // Durchführung der Addition
            }
        };

        BinaryOperation subtraction = new BinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return a - b;
            }
        };
        BinaryOperation multiplication = new BinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        };

        BinaryOperation division = new BinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return a / b;
            }
        };

        System.out.println("Das Ergebnis bei den Zahlen 20 und 5 ist jeweils: \n" +
                calculator.compute(20, 5, addition) + "\n" +
                calculator.compute(20, 5, subtraction) + "\n" +
                calculator.compute(20, 5, multiplication) + "\n" +
                calculator.compute(20, 5, division) );

    }
}
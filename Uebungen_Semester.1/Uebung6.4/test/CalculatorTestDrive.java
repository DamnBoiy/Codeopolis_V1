package test;

import main.Calculator;

public class CalculatorTestDrive {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Test the methods
        System.out.println("Addition (5 + 3): " + calculator.add(5, 3));
        System.out.println("Subtraction (5 - 3): " + calculator.subtract(5, 3));
        System.out.println("Multiplication (5 * 3): " + calculator.multiply(5, 3));
        System.out.println("Division (5 / 3): " + calculator.divide(5, 3));

        // Test division by zero
        try {
            calculator.divide(5, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

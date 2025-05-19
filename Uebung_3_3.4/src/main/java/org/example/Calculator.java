package org.example;

public class Calculator {

    /* *
     * Wendet eine übergebene Operation op auf a und b an .
     * @param a erster Operand
     * @param b zweiter Operand
     * @param op Operation , die auf die beiden Operanden angewendet wird
     * @return Ergebnis der Operation
     */
    public int compute(int a, int b, BinaryOperation op) {
        return op.apply(a, b);
    }


/*
    BinaryOperation addition = new Addition() {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    };

    BinaryOperation subtraction = new Subtraktion() {
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    };

    BinaryOperation multiplication = new Multiplikation() {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    };

    BinaryOperation division = new Division() {
        @Override
        public int apply(int a, int b) {
            return a / b;
        }
    };  */

}

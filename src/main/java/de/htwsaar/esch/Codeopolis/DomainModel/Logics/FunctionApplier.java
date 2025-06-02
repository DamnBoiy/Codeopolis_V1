package de.htwsaar.esch.Codeopolis.DomainModel.Logics;

public class FunctionApplier {

    public static void applyAndPrint(int i, int j, MyFunction function) {
        if (i > j) throw new IllegalArgumentException("i darf nicht größer als j sein.");
        for (int x = i; x <= j; x++) {
            int result = function.apply(x);
            System.out.println("f(" + x + ") = " + result);
        }
    }

    // Top-Level-Klasse
    public static class Factorial implements MyFunction {
        public int apply(int i) {
            int result = 1;
            for (int x = 2; x <= i; x++) result *= x;
            return result;
        }
    }

    public static void main(String[] args) {

        System.out.println("\ni) Quadrat (Lambda):");
        applyAndPrint(1, 5, i -> i * i);

        System.out.println("i) Quadrat (anonyme Klasse):");
        MyFunction squareAnon = new MyFunction() {
            public int apply(int i) {
                return i * i;
            }
        };
        applyAndPrint(1, 5, squareAnon);

        System.out.println("\nii) Fakultät (Lambda):");
        applyAndPrint(1, 5, i -> {
            int res = 1;
            for (int x = 2; x <= i; x++) res *= x;
            return res;
        });

        System.out.println("ii) Fakultät (anonyme Klasse):");
        MyFunction factorialAnon = new MyFunction() {
            public int apply(int i) {
                int res = 1;
                for (int x = 2; x <= i; x++) res *= x;
                return res;
            }
        };
        applyAndPrint(1, 5, factorialAnon);

        System.out.println("\nii) Fakultät (Top-Level-Klasse):");
        applyAndPrint(1, 5, new Factorial());

        System.out.println("ii) Fakultät (innere Klasse):");
        class InnerFactorial implements MyFunction {
            public int apply(int i) {
                int res = 1;
                for (int x = 2; x <= i; x++) res *= x;
                return res;
            }
        }
        MyFunction innerFactorial = new InnerFactorial();
        applyAndPrint(1, 5, innerFactorial);




        System.out.println("\niii) x^(x+1) (Lambda):");
        applyAndPrint(1, 5, i -> (int) Math.pow(i, i + 1));

        System.out.println("iii) x(x+1) (anonyme Klasse):");
        MyFunction timesSuccAnon = new MyFunction() {
            public int apply(int i) {
                return (int) Math.pow(i, i + 1);
            }
        };
        applyAndPrint(1, 5, timesSuccAnon);




        System.out.println("\niv) Fibonacci (Lambda):");
        applyAndPrint(1, 10, i -> {
            if (i <= 1) return i;
            int a = 0, b = 1;
            for (int x = 2; x <= i; x++) {
                int tmp = b;
                b = a + b;
                a = tmp;
            }
            return b;
        });

        System.out.println("iv) Fibonacci (anonyme Klasse):");
        MyFunction fibAnon = new MyFunction() {
            public int apply(int i) {
                if (i <= 1) return i;
                int a = 0, b = 1;
                for (int x = 2; x <= i; x++) {
                    int tmp = b;
                    b = a + b;
                    a = tmp;
                }
                return b;
            }
        };
        applyAndPrint(1, 10, fibAnon);



        System.out.println("\nZusatz: conditionateInput – nur gerade Eingaben werden verarbeitet:");
        ConditionalFunction squareNumber = i -> i * i;
        ConditionalFunction squareOnlyEvenInput = squareNumber.conditionateInput(i -> i % 2 == 0);
        applyAndPrint(1, 5, squareOnlyEvenInput);

        System.out.println("\nZusatz: conditionateOutput – nur Ergebnisse > 10 werden ausgegeben:");
        ConditionalFunction cubicNumber = i -> i * i * i;
        ConditionalFunction cubeOnlyIfResultGreater10 = cubicNumber.conditionateOutput(result -> result > 10);
        applyAndPrint(1, 5, cubeOnlyIfResultGreater10);





    }
}

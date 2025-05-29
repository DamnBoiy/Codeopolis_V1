package Logic;

import java.util.function.Predicate;
import static Logic.FunctionApplier.applyAndPrint;

class Predicates {
    public static final Predicate<Integer> even = i -> i % 2 == 0;

    public static final Predicate<Integer> odd = new Predicate<Integer>() {
        @Override
        public boolean test(Integer i) {
            return i % 2 != 0;
        }
    };




    public static void main(String[] args) {

        // (e) conditionateInput mit even
        System.out.println("\n(e) Nur gerade Eingaben werden quadriert:");
        ConditionalFunction square = i -> i * i;
        ConditionalFunction evenInputSquared = square.conditionateInput(Predicates.even);
        applyAndPrint(1, 6, evenInputSquared);

        // (f) conditionateOutput mit odd
        System.out.println("\n(f) Fibonacci-Zahl wird nur ausgegeben, wenn sie ungerade ist:");
        ConditionalFunction fib = i ->
        {
            if (i <= 1) return i;
            int a = 0, b = 1;
            for (int x = 2; x <= i; x++) {
                int tmp = b;
                b = a + b;
                a = tmp;
            }
            return b;
        };
        ConditionalFunction oddFibonacciOutput = fib.conditionateOutput(Predicates.odd);
        applyAndPrint(1, 10, oddFibonacciOutput);
    }

}

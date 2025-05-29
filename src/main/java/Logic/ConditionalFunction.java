package Logic;


import java.util.function.Predicate;

interface ConditionalFunction extends MyFunction {

    default ConditionalFunction conditionateInput(Predicate<Integer> predicate) {
        return (int i) -> { return predicate.test(i) ? this.apply(i) : 0;};
    }

    default ConditionalFunction conditionateOutput(Predicate<Integer> predicate) {
        return (int i) -> {
            int result = this.apply(i);
            return predicate.test(result) ? result : 0;
        };
    }
}
package Uebungen;

import java.util.*;

public class Consumer {

    private final Map<Integer, List<Long>> resultMap = new HashMap<>();

    public void consume(int number) {
        int crossSum = calculateCrossSum(number);
        long timestamp = System.currentTimeMillis();

        resultMap.computeIfAbsent(crossSum, k -> new ArrayList<>()).add(timestamp);
    }

    private int calculateCrossSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int numberOfDifferentResults() {
        return resultMap.size();
    }

    public int numberOfOccurrences(int crossSum) {
        return resultMap.getOrDefault(crossSum, Collections.emptyList()).size();
    }

    public Set<Integer> getCrossTotalsAscending() {
        return new TreeSet<>(resultMap.keySet());
    }

    public Set<Integer> getCrossTotalsDescending() {
        return new TreeSet<>(resultMap.keySet()).descendingSet().headSet(100); // alternativ: new TreeSet<>(...).descendingSet()
    }   //return new TreeSet<>(resultMap.keySet()).descendingSet();


    public List<Long> getTimestampsForResult(int crossSum) {
        return resultMap.getOrDefault(crossSum, Collections.emptyList());
    }






    public static class Main {

        public static void main(String[] args) {
            // Argumente prüfen
            if (args.length < 1) {
                System.out.println("Bitte FIFO oder SORTED als Startparameter übergeben.");
                return;
            }

            String mode = args[0].toUpperCase();
            Queue<Integer> queue;

            switch (mode) {
                case "FIFO" -> queue = new LinkedList<>();
                case "SORTED" -> queue = new PriorityQueue<>();
                default -> {
                    System.out.println("Ungültiger Modus. Verwende FIFO oder SORTED.");
                    return;
                }
            }

            Producer producer = new Producer();
            Consumer consumer = new Consumer();
            Random random = new Random();

            for (int i = 0; i < 10_000; i++) {
                if (random.nextInt(2) > 0) {
                    int value = producer.produce();
                    queue.offer(value);
                } else {
                    Integer value = queue.poll();
                    if (value != null) {
                        consumer.consume(value);
                    }
                }
            }

            // Statistiken ausgeben
            System.out.println("Unterschiedliche Quersummen: " + consumer.numberOfDifferentResults());

            System.out.println("Quersummen (aufsteigend): " + consumer.getCrossTotalsAscending());
            System.out.println("Quersummen (absteigend): " + consumer.getCrossTotalsDescending());

            System.out.print("Häufigkeit der Quersumme 10: ");
            System.out.println(consumer.numberOfOccurrences(10));

            System.out.print("Zeitstempel für Quersumme 10: ");
            System.out.println(consumer.getTimestampsForResult(10));
        }
    }


}

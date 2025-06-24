package Uebungen;

import java.util.Random;

public class Producer {
    private final Random random = new Random();

    public int produce() {
        return random.nextInt(1001); // 0 bis 1000
    }
}


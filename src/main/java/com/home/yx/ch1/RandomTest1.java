package com.home.yx.ch1;

import java.util.concurrent.ThreadLocalRandom;

public class RandomTest1 {
    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 10; ++i) {
            System.out.println(random.nextInt(5));
        }
    }
}

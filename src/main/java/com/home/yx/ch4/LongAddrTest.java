package com.home.yx.ch4;

import java.util.concurrent.atomic.LongAdder;

public class LongAddrTest {
    private static LongAdder atomicLong = new LongAdder();
    private static Integer[] arrayOne = new Integer[]{0, 1, 2, 3, 0, 5, 6, 0, 56, 0};
    private static Integer[] arrayTwo = new Integer[]{10, 1, 2, 3, 0, 5, 6, 0, 56, 0};

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayOne.length;
                for (int i = 0; i < size; ++i) {
                    if (arrayOne[i].intValue() == 0) {
                        atomicLong.increment();
                    }
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayTwo.length;
                for (int i = 0; i < size; ++i) {
                    if (arrayTwo[i].intValue() == 0) {
                        atomicLong.add(1);
                    }
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("count 0: " + atomicLong.intValue());
    }
}

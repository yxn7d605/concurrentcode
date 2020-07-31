package com.home.yx.ch1;

import java.util.concurrent.TimeUnit;

public class VolatileLearn1 {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            final NumberRange numberRange = new NumberRange();
            numberRange.setLower(0);
            numberRange.setUpper(5);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    numberRange.setUpper(3);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    numberRange.setLower(4);
                }
            }).start();

            TimeUnit.MILLISECONDS.sleep(100);

            System.out.println(numberRange.getLower() + ", " + numberRange.getUpper());

            if (numberRange.getLower() > numberRange.getUpper()) {
                break;
            }
        }
    }
}

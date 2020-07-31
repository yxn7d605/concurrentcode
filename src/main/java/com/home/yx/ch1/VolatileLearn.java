package com.home.yx.ch1;

import java.util.concurrent.TimeUnit;

public class VolatileLearn {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            NumberRange numberRange = new NumberRange();
            numberRange.setLower(0);
            numberRange.setUpper(5);

            TestSub testSub = new TestSub(numberRange);
            TestSup testSup = new TestSup(numberRange);
            new Thread(testSub).start();
            new Thread(testSup).start();

            TimeUnit.MILLISECONDS.sleep(100);

            System.out.println(numberRange.getLower() + ", " + numberRange.getUpper());

            if (numberRange.getLower() > numberRange.getUpper()) {
                break;
            }
        }
    }
}

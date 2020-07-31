package com.home.yx.ch1;

public class TestSup implements Runnable {
    private NumberRange v;

    public TestSup(NumberRange v) {
        this.v = v;
    }

    @Override
    public void run() {
        v.setUpper(3);
    }
}

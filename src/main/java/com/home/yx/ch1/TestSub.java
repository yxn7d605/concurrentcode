package com.home.yx.ch1;

public class TestSub implements Runnable {
    private NumberRange v;

    public TestSub(NumberRange v) {
        this.v = v;
    }

    @Override
    public void run() {
        v.setLower(4);
    }
}

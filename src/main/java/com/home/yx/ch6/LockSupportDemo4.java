package com.home.yx.ch6;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo4 {
    private void testPart() {
        LockSupport.park(this);
    }

    public static void main(String[] args) {
        LockSupportDemo4 lockSupportDemo4 = new LockSupportDemo4();
        lockSupportDemo4.testPart();
    }
}

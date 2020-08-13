package com.home.yx.ch4;

import com.home.yx.ch1.UnsafeInst;

public class MyStriped64 extends Number {
    transient volatile long base;

    transient volatile int cellsBusy;

//    transient volatile MyStriped64.Cell[] cells;

    MyStriped64() {}

    // Unsafe mechanics
    private static final sun.misc.Unsafe UNSAFE;
    private static final long BASE;
    private static final long CELLSBUSY;
    private static final long PROBE;
    static {
        try {
            UNSAFE = UnsafeInst.instance();
            BASE = UNSAFE.objectFieldOffset(MyStriped64.class.getDeclaredField("base"));
            CELLSBUSY = UNSAFE.objectFieldOffset(MyStriped64.class.getDeclaredField("cellsBusy"));
            PROBE = UNSAFE.objectFieldOffset(Thread.class.getDeclaredField("threadLocalRandomProbe"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    public static void main(String[] args) {

    }
}

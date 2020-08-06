package com.home.yx.ch1;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeInst {
    public static Unsafe instance() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe unsafe = (Unsafe) theUnsafe.get(null);

            return unsafe;
        } catch (Exception e) {
            return null;
        }
    }
}

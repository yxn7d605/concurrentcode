package com.home.yx.ch1;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafe4 {
    public static void main(String[] args) throws NoSuchFieldException {
        Unsafe unsafe = UnsafeInst.instance();
        // 常量池中会存入abc
        String s = "abc";
        String s1 = new String("abc");
        // 发现常量池中有abc，直接指向常量池中的abc引用
        System.out.println(s1.intern() == s);
        Field valueInString = String.class.getDeclaredField("value");
        long offset = unsafe.objectFieldOffset(valueInString);
        long base = unsafe.arrayBaseOffset(char[].class);
        long scale = unsafe.arrayIndexScale(char[].class);
        char[] values = (char[]) unsafe.getObject(s, offset);
        unsafe.putChar(values, base + scale, 'c');
        System.out.println("s=" + s + ", s1=" + s1);

        s = "abc";
        System.out.println("s=" + s + ", s1=" + s1);

        String s2 = "abc";
        System.out.println("s=" + s + ", s1=" + s1 + ", s2=" + s2);
    }
}

package com.home.yx.ch1;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafe3 {
    public static void main(String[] args) throws InstantiationException, NoSuchFieldException {
        Unsafe unsafe = UnsafeInst.instance();

        // 通过unsafe获取Test类的实例，不会执行Test类的构造函数
        Test test = (Test) unsafe.allocateInstance(Test.class);
        // 获取intField的偏移地址
        long b1 = unsafe.objectFieldOffset(Test.class.getDeclaredField("intField"));
        // 将intField的值修改为2
        unsafe.putInt(test, b1, 2);
        System.out.println("intField: " + test.intField);

        // 由于静态变量位于方法区，所以它的地址偏移值与Test类在方法区的地址有关，与Test类的实例无关
        Field staticIntField = Test.class.getDeclaredField("staticIntField");
        // 获取静态变量所属的类在方法区的首地址
        Object obj = unsafe.staticFieldBase(staticIntField);
        System.out.println(obj == Test.class);
        // 获取静态变量地址偏移值
        long b4 = unsafe.staticFieldOffset(staticIntField);
        unsafe.putInt(obj, b4, 10);
        System.out.println("staticIntField: " + unsafe.getInt(Test.class, b4));
    }

    static class Test {
        int intField;

        static int staticIntField;

        static int[] arr;

        private Test() {
            System.out.println("constructor called");
        }
    }
}

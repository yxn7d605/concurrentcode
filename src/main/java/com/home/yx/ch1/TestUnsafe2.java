package com.home.yx.ch1;

import com.sun.javaws.exceptions.ErrorCodeResponseException;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafe2 {
    static final Unsafe unsafe;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);

            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            // int数组第一个元素地址相对于数组起始地址的偏移值
            int b = unsafe.arrayBaseOffset(int[].class);
            // int数组中一个元素占用的字节数
            int s= unsafe.arrayIndexScale(int[].class);
            // 将arr数组的第10个元素改为1
            unsafe.putInt(arr, (long) (b + s * 9), 1);
            for (int i = 0; i < 10; i++) {
                int v = unsafe.getInt(arr, (long) b + s * i);
                System.out.print(v + ", ");
            }
        } catch (Exception e) {
            e.printStackTrace();

            throw new Error(e);
        }
    }

    public static void main(String[] args) {
    }
}

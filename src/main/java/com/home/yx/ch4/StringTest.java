package com.home.yx.ch4;

/**
 *
 *
 */
public class StringTest {
    public static void main(String[] args) {
        // 1. 两个或者两个以上的字符串常量相加，在预编译的时候”+“会被优化，
        // 相当于两个或者两个以上字符串常量自动合并成一个字符串常量
        // 2. 字符串常量相加，不会用到StringBuilder对象来优化
        String s1 = "hello" + "world";
        String s2 = "helloworld";
        System.out.println(s1 == s2);

        // 1. new String("hello")先在常量池中看有没有hello，如果没有则创建一个，然后
        // 在堆中创建一个String的对象
        // 2. 字符串+会被优化为StringBuilder的append
        // 3. StringBuilder完成append后，会在堆中创建一个合并后的字符串对象引用，并且指向常量池中的字符串
        String s3 = new String("hello") + new String("world");
        System.out.println(s3 == s2);

        String s4 = "ab";
        String s5 = "b";
        String s6 = "a" + s5;
        System.out.println(s4 == s6);

        // 因为final修饰的s7在编译期就可以识别，它在编译时被解析为常量值的一个本地拷贝
        // 存储到自己的常量池中或嵌入到它的字节码流中。所以此时的"a" + s7和"a" + "b"效果是一样的
        final String s7 = "b";
        String s8 = "a" + s7;
        System.out.println(s4 == s8);
    }
}

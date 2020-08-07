package com.home.yx.ch4;

public class StringTest1 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str3 == str4);
        System.out.println(str5.intern() == str3);
        System.out.println(str4.intern() == str3);
    }
}

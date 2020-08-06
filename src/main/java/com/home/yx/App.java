package com.home.yx;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(Integer.SIZE);

        int r = -1 << 29;
        System.out.println(r);

        int CAPACITY   = (1 << 3) - 1;
        System.out.println(CAPACITY);
    }
}

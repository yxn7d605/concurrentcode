package com.home.yx.ch1;

import java.util.concurrent.TimeUnit;

public class ReorderThreadTest {
    private static int num = 0;

    private static boolean ready = false;

    public static void main(String[] args) throws InterruptedException {
        ReadThread rt = new ReadThread();
        rt.start();

        WriteThread wt = new WriteThread();
        wt.start();

        TimeUnit.MILLISECONDS.sleep(10);
        rt.interrupt();
        System.out.println("main exit");
    }

    static class ReadThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (ready) {
                    System.out.println(num + num);
                }

                System.out.println("read thread...");
            }
        }
    }

    static class WriteThread extends Thread {
        @Override
        public void run() {
            num = 2;
            ready = true;
            System.out.println("write thread set over...");
        }
    }
}

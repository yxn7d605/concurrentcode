package com.home.yx.ch1;

public class ThreadDamonDemo1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;);
            }
        });

        thread.setDaemon(true);
        thread.start();

        System.out.println("main thread is over");
    }
}

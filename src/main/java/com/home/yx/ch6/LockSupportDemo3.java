package com.home.yx.ch6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park!");
                while (!Thread.currentThread().isInterrupted()) {
                    LockSupport.park();
                }
                System.out.println("child thread unpark!");
            }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println("main thread begin unpark!");

//        LockSupport.unpark(thread);
        thread.interrupt();
    }
}

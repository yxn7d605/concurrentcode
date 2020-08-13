package com.home.yx.ch6;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters = new ConcurrentLinkedQueue<>();

    public void lock() {
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        // 当前线程入队列
        waiters.add(current);
        // 如果队列首部不是当前线程或者锁已经被占用了
        while (waiters.peek() != current || !locked.compareAndSet(false, true)) {
            // 线程被阻塞
            LockSupport.park(this);
            // 如果当前线程是中断状态则中断标志设置为true
            if (Thread.interrupted()) {
                wasInterrupted = true;
            }
        }

        waiters.remove();
        if (wasInterrupted) {
            current.interrupt();
        }
    }

    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }
}

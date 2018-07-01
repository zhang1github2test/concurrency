package com.concurrency.example.atomic;

import com.concurrency.annoations.ThreadSaft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * zhshl  2018/6/29
 */
@ThreadSaft
public class AtomicExample4 {
    private static AtomicReference<Integer> count = new AtomicReference<>(0);
    private final static Logger log = LoggerFactory.getLogger(AtomicExample4.class);
    public static void main(String[] args) {
        count.compareAndSet(0,2);
        count.compareAndSet(0,1);
        count.compareAndSet(1,3);
        count.compareAndSet(2,4);
        count.compareAndSet(3,5);
        log.info("count:{}",count.get());
    }
}

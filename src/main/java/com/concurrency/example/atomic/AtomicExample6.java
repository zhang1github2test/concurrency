package com.concurrency.example.atomic;

import com.concurrency.annoations.ThreadSaft;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * zhshl  2018/6/29
 */
@ThreadSaft
public class AtomicExample5 {
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");
    
    public volatile int count = 100;

    private final static Logger log = LoggerFactory.getLogger(AtomicExample5.class);
    public static void main(String[] args) {
        AtomicExample5 atomicExample5 = new AtomicExample5();
        if(updater.compareAndSet(atomicExample5,100,120)){
            log.info("update success 1,{}",atomicExample5.getCount());
        }
        if(updater.compareAndSet(atomicExample5,100,130)){
            log.info("update success 2,{}",atomicExample5.getCount());
        }else {
            log.error("update failed {}",atomicExample5.getCount());
        }
    }

    public int getCount() {
        return count;
    }
}

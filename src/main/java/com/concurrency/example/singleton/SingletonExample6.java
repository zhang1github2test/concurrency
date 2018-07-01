package com.concurrency.example.singleton;

import com.concurrency.annoations.ThreadSaft;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * zhshl  2018/7/1
 * 饿汉模式
 * 单例实例在类装载的时进行创建
 */
@Slf4j
@ThreadSaft
public class SingletonExample5 {

    static {
        instance = new SingletonExample5();
    }
    private static SingletonExample5 instance;
    private SingletonExample5(){}

    public static SingletonExample5 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i< 20; i++){
            executorService.execute(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(SingletonExample5.getInstance());
            });
        }
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}

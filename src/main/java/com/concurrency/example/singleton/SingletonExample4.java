package com.concurrency.example.singleton;

import com.concurrency.annoations.NotThreadSaft;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * zhshl  2018/6/30
 * 双重检查锁模式
 */
@NotThreadSaft
@Slf4j
public class SingletonExample3 {
    //私有构造函数
    private SingletonExample3(){}

    /**
     * 调用构造函数初始化对象的时候，系统所做的事情
     * 1、memory = allocate()  分配对象的内存空间
     * 2、ctorInstance()  初始化对象
     * 3、instance = memory 设置instance指向刚刚分配的内存
     *
     * JVM  和cpu 优化，发生了指令重排
     *
     *  1、memory = allocate()  分配对象的内存空间
     * 3、instance = memory 设置instance指向刚刚分配的内存
     * 2、ctorInstance()  初始化对象

     */

    //单例对象
    private static SingletonExample3 instance = null;
    //静态的工厂方法
    public static SingletonExample3 getInstance(){
        if(instance == null){
            synchronized (SingletonExample3.class){
                if(instance == null){
                    instance = new SingletonExample3();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args)  {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i= 0;i<10;i++){
            executorService.submit(()->{
                SingletonExample3 example1 = SingletonExample3.getInstance();
                log.info("地址值：{}",example1);
            });
        }
        executorService.shutdown();
    }

}

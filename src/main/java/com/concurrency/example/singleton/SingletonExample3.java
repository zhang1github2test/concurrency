package com.concurrency.example.singleton;

import com.concurrency.annoations.NotThreadSaft;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * zhshl  2018/6/30
 * 懒汉模式  对象用到的时候才进行添加
 */
@NotThreadSaft
@Slf4j
public class SingletonExample1 {
    //私有构造函数
    private SingletonExample1(){}
    //单例对象
    private static SingletonExample1 instance = null;
    //静态的工厂方法
    public static SingletonExample1 getInstance(){
        if(instance == null){
                instance = new SingletonExample1();
        }
        return instance;
    }

    public static void main(String[] args)  {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i= 0;i<10;i++){
            executorService.submit(()->{
                SingletonExample1 example1 = SingletonExample1.getInstance();
                log.info("地址值：{}",example1);
            });
        }
        executorService.shutdown();
    }

}

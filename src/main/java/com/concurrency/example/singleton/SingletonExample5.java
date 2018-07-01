package com.concurrency.example.singleton;

import com.concurrency.annoations.ThreadSaft;
import lombok.extern.slf4j.Slf4j;

/**
 * zhshl  2018/7/1
 * 饿汉模式
 * 单例实例在类装载的时进行创建
 */
@Slf4j
@ThreadSaft
public class SingletonExample2 {
    private static SingletonExample2 singletonExample2 = new SingletonExample2();
    private SingletonExample2 (){}
    private static SingletonExample2 instance = new SingletonExample2();
    public static SingletonExample2 getInstance(){
        return instance;
    }
}

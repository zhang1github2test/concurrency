package com.concurrency.example.immutable;

import com.concurrency.annoations.NotThreadSaft;
import com.google.common.collect.Maps;
import java.util.HashMap;

/**
 * zhshl  2018/7/1
 */
@NotThreadSaft
public class ImmutableExample1 {
    //基础数据类型不可以修改
    private final static Integer a = 1;
    private final static  String b = "2";
    //一旦赋值就不能指向其他的对象
    private final  static HashMap<Object, Object> map = Maps.newHashMap();
    static {
        map.put(1,2);
        map.put(3,5);
        map.put(4,4);
        map.put(6,6);
    }

    public static void main(String[] args) {
        map.put(1,3);
        System.out.println(map.get(1));
    }
}

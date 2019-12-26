package com.jxy.jvm.gc;

/*
    参数设置：
        -verbose:gc
        -XX:+PrintGCDetails
        -Xms20m
        -Xmx20m
        -Xmn10m
        -XX:SurvivorRatio=8
        -XX:PretenureSizeThreshold=4194304
        -XX:+UseSerialGC

    测试用例：
        1. -XX:PretenureSizeThreshold=4194304 存入对象的大小为 5m
            结果 ： 大对象直接进入老年代，并没有出现gc

        2. -XX:PretenureSizeThreshold=4194304 没有参数 -XX:+UseSerialGC
            结果 ： 大对象存入年轻代，没有出现gc

        3. 将对象的大小调整为8m ，不需要设置 PretenureSizeThreshold
            结果 ： Eden区存有其他的内置对象，不可能有8m的空闲空间，大对象直接进入老年大
* */

public class MyTest2 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] b1 = new byte[5*size];
        System.out.println("gc learning!");
    }
}

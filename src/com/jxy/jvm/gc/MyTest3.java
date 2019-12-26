package com.jxy.jvm.gc;

/*
    参数设置：
        -verbose:gc
        -XX:+PrintGCDetails
        -XX:+PrintCommandLineFlags
        -Xms20m
        -Xmx20m
        -Xmn10m
        -XX:SurvivorRatio=8
        -XX:MaxTenuringThreshold=5
        -XX:+PrintTenuringDistribution

        -XX:PretenureSizeThreshold=4194304
        -XX:+UseSerialGC


    测试用例：
        1. -XX:PretenureSizeThreshold=4194304 存入对象的大小为 5m
            结果 ： 大对象直接进入老年代，并没有出现gc

        2. -XX:PretenureSizeThreshold=4194304 没有参数 -XX:+UseSerialGC
            结果 ： 大对象存入年轻代，没有出现gc

        3. 将对象的大小调整为8m ，不需要设置 PretenureSizeThreshold
            结果 ： Eden区存有其他的内置对象，不可能有8m的空闲空间，大对象直接进入老年大

     关键点记录：
            在经历了多次GC后，存活的对象会在From Survivor与To Survivor之间来回存放，而这里面的一个前提是两个空间有足够的大小俩存放这些数据，
        在GC算法中，会计算每个对象年龄的大小，如果达到某个年龄后发现总大小已经大于了Survivor空间的50%，那么这时就需要调整阈值，不能再继续
        等到默认的15次GC后才完成晋升，因为这样会导致Survivor空间不足，所以需要调整阈值，让这些存活对象尽快完成晋升；
            MaxTenuringThreshold作用：在可以自动调节对象晋升(Promote)到老年代阈值的GC中，设置该阈值的最大值。该参数的默认值为15，
            CMS中默认值为6
            G1中默认为15

* */

public class MyTest3 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] b1 = new byte[2*size];
        byte[] b2 = new byte[2*size];
        byte[] b3 = new byte[2*size];
        byte[] b4 = new byte[2*size];
        System.out.println("gc learning!");
    }
}

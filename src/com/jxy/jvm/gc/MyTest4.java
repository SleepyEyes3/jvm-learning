package com.jxy.jvm.gc;

/*
    参数设置：
        -verbose:gc
        -XX:+PrintGCDetails
        -Xmx200m
        -Xmn50m
        -XX:MaxTenuringThreshold=3
        -XX:+PrintTenuringDistribution
        -XX:TargetSurvivorRatio=60
        -XX:+PrintGCDateStamps
        -XX:+UseConcMarkSweepGC
        -XX:+UseParNewGC


    测试用例：
        1. 设置如下参数 ：MaxTenuringThreshold=3  TargetSurvivorRatio=60
           现象：
               在第5次gc时，new threshold 变成了1
           原因：
               TargetSurvivorRatio=60 的设置，意味着垃圾收集器检测到 from to survivor 的空间使用大于 50m*0.1*0.6 = 3m 时，将会重新动态计算
           threshold的值，计算的结果为 1 ，此时，垃圾收集器将会将生命周期为 1,2,3 的对象从 to survivor 中移到老年代中；


     关键点记录：


* */

public class MyTest4 {
    public static void main(String[] args) throws InterruptedException {
        byte[] byte_1 = new byte[512 * 1024];
        byte[] byte_2 = new byte[512 * 1024];

        myGc();
        Thread.sleep(1000);
        System.out.println("111");

        myGc();
        Thread.sleep(1000);
        System.out.println("222");

        myGc();
        Thread.sleep(1000);
        System.out.println("333");

        myGc();
        Thread.sleep(1000);
        System.out.println("444");

        byte[] byte_3 = new byte[1024 * 1024];
        byte[] byte_4 = new byte[1024 * 1024];
        byte[] byte_5 = new byte[1024 * 1024];

        myGc();
        Thread.sleep(1000);
        System.out.println("555");

        myGc();
        Thread.sleep(1000);
        System.out.println("666");

        System.out.println("Let's roll!");

    }

    public static void myGc(){
        for(int i = 0; i< 40;i++){
            byte[] bytes = new byte[1024 * 1024];
        }
    }
}

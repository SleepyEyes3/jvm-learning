package com.jxy.jvm.gc;

/*
    jvm参数：
        -verbose:gc
        -XX:+PrintGCDetails
        -Xms20m
        -Xmx20m
        -Xmn10m
        -XX:SurvivorRatio=8
        -XX:+UseConcMarkSweepGC
    gc日志详解：
        1. 设置了老年代的回收器，jvm会自动指定年轻代的回收器 ParNew

        2. CMS垃圾回收器标记清除的过程
            初始标记 -> 并发标记 -> 最终标记 -> 并发清除
            CMS Initial Mark
            CMS-concurrent-mark
            CMS-concurrent-preclean
            CMS-concurrent-abortable-preclean
            CMS Final Remark
            CMS-concurrent-sweep
            CMS-concurrent-reset

            最后 一个4m 一个2m的对象存在于年轻代中，两个4m的对象存在于老年代中；

    测试用例 :

*/
public class MyTest5 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] b1 = new byte[4*size];
        System.out.println("11111");

        byte[] b2 = new byte[4*size];
        System.out.println("22222");

        byte[] b3 = new byte[4*size];
        System.out.println("33333");

        byte[] b4 = new byte[2*size];
        System.out.println("44444");

        System.out.println("gc learning!");
    }
}

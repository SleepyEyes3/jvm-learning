package com.jxy.jvm.gc;

/*
    jvm参数： -verbose:gc
             -XX:+PrintGCDetails
             -Xms20m
             -Xmx20m
             -Xmn10m
             -XX:SurvivorRatio=8
    gc日志详解：
        [PSYoungGen: 5791K->744K(9216K)] 5791K->4848K(19456K), 0.0037302 secs]
        PSYoungGen : 垃圾回收器的名称
        5791K->744K :垃圾回收前后年轻代中锁占用的空间
        9216K : 年轻代总的可以使用的空间 = Eden + From Survivor = 9m
        5791K->4848K(19456K) : 总空间 -> 同上 = 19m
        0037302 : 垃圾回收执行时间

    测试用例 :
        1.  2m 2m 3m
            年轻代的回收空间要远大于总的回收空间  5791K-744K = 5791K-4848K+4104K
            原因 ： 年轻代的回收的空间：一部分真正回收了， 还有一部分去了老年代；

        2. 2m 2m 2m 2m 会发生full gc,但是 2m 2m 3m 3m却不会发生full gc
           原因 ：当年轻代容不下新建对象的时候，将会被直接分配在老年代

        3.


*/
public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] b1 = new byte[2*size];
        byte[] b2 = new byte[2*size];
        byte[] b3 = new byte[3*size];

        System.out.println("gc learning!");
    }
}

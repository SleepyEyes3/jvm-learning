package com.jxy.jvm.g1;

/*
    参数设置：
        -verbose:gc
        -Xms10m
        -Xmx10m
        -XX:+UseG1GC
        -XX:+PrintGCDetails
        -XX:+PrintGCDateStamps
        -XX:MaxGCPauseMillis=200m


* */
public class MyTest1 {
    public static void main(String[] args) {

        int size = 1024 * 1024;
        byte[] b1 = new byte[1*size];
        byte[] b2 = new byte[1*size];
        byte[] b3 = new byte[1*size];
        byte[] b4 = new byte[1*size];

        System.out.println("g1 learning!");
    }

}

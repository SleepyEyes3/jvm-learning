package com.jxy.jvm.classLoading;

import java.util.UUID;
/*
* 当一个常量的值并非在编译阶段可以确定的，那么其值就不会放到调用类的常量池中，
* 这时在程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类被初始化；
*
* */
public class ClassLoadingTest03 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}


class MyParent3{
    public static final String str = UUID.randomUUID().toString();
    static {
        System.out.println("parent3 static block");
    }
}
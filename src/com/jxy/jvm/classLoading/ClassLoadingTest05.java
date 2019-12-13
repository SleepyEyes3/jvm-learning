package com.jxy.jvm.classLoading;

import java.util.Random;

/*
*  当一个接口在初始化时，并不要求其父接口都完成初始化（这和“类”是不同的，类则是，child被使用到了，parent就一定会使用到）
*  只有在真正使用到父接口的时候（如引用接口中所定义的常量时），才会初始化
*  注意：
*      这里不要加载的（也就是在TraceClassLoading中不显示的，都是可以删除的）
* */

public class ClassLoadingTest05 {
    public static void main(String[] args) {
        System.out.println(MyChild5.a);
//        new C();
        System.out.println(MyParent5_1.thread);
    }
}

interface MyParent5{
    int a = 1;
    public static Thread thread = new Thread(){
        {
            System.out.println("parent5 block"); // 用于验证parent是否被加载
        }
    };
}

interface MyChild5 extends MyParent5{
//    public static int b = new Random().nextInt(4);
    public static final int b = 4;
}
/*
* 加载的几种情况：
*   1. child parent 都是class
*       child/parent都会“加载”
*   2. child是class，parent是interface
*       child中的常量是在编译时间确定的（也就是修饰符有final），该class是不会被加载的；同时用不到interface中的变量的话，interface是不会被加载的；
*   3. child parent 都是interface
*       都不会加载（为什么？因为：interface中的变量的默认修饰是public static final，在编译期间就已经确定了，放到了调用类的常量池中，故不需要加载）
*
* */

// 实例代码块会在构造函数之前执行，且每次创建实例的时候都会执行
// 而static代码块只会执行一次
class  C{
    {
        System.out.println("c block");
    }

    C(){
        System.out.println("generator");
    }
}

/*
* 验证：在初始化一个接口的时候，并不会先初始化他的父接口
* */

interface MyGradParent5_1{
    public static Thread thread = new Thread(){
        {
            System.out.println("gradParent5 block"); // 用于验证parent是否被加载
        }
    };
}
interface MyParent5_1{
    public static Thread thread = new Thread(){
        {
            System.out.println("parent5_1 block"); // 用于验证parent是否被加载
        }
    };
}


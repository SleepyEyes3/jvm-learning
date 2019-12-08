package com.jxy.jvm.classLoading;

public class ClassLoadingTest06 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        System.out.println(singleton.counter1); // 输出 1
        System.out.println(singleton.counter2); // 输出 1
        System.out.println(singleton.counter3); // 输出 0  （）

    }
}

/*
* 这个demo旨在告诉我们，在类的加载过程中，类的“初始化”这一步，初始化的顺序是从上到下的；
*
* */
class Singleton{
    public static int counter1 = 1;
    public static int counter2 = 0;

    private static Singleton singleton = new Singleton();

    private Singleton(){
        counter1++;
        counter2++;
        counter3++; // 这边要是没有初始化的话，那这个构造器中的操作是没有办法执行的
        System.out.println("构造器中的counter1："+counter1);
        System.out.println("构造器中的counter2："+counter2);
        System.out.println("构造器中的counter3："+counter3);
    }

    public static int counter3 = 0; // 在这一行将counter3重新赋值为0

    public static Singleton getSingleton(){
        return singleton;
    }


}
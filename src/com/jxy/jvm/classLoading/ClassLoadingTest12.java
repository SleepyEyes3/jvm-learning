package com.jxy.jvm.classLoading;

/*
*   结论 ： 调用ClassLoder类的loadClass方法加载一个类，并不是对类的主动调用，不会导致类的初始化
* */

class CL{
    static {
        System.out.println("CL static block");
    }
}
public class ClassLoadingTest12 {

    // 由此可见：
    //        加载不一定意味着会 初始化
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass("com.jxy.jvm.classLoading.CL");
        System.out.println(aClass);
        System.out.println("------------");
        aClass = Class.forName("com.jxy.jvm.classLoading.CL");
        System.out.println(aClass);
    }
}

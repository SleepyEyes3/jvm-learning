package com.jxy.jvm.classLoading;


/*
*  关于命名空间：
*       1. 子加载器所加载的类可以访问父加载器所加载的类
*       2. 父加载器所加载的类不可以访问子加载器所加载的类
* */
public class ClassLoadingTest17 {
    // 测试：分别将classpath中的MyCat.class文件，或者MySample.class文件删了，看看什么情况
    public static void main(String[] args) throws Exception {
        ClassLoadingTest16 load1 = new ClassLoadingTest16("loader1");
        Class<?> clazz = load1.loadClass("com.jxy.jvm.classLoading.MySample"); // 创建class对象并放到内存中
        System.out.println("class: " + clazz.hashCode());

        // 如果注释掉该行，就不会创建MySample实例，即不会调用MySample的构造函数，就不会创建MyCat的实例
        // 就不会主动调用，就不会加载MyCat class
        Object o = clazz.newInstance(); // 创建实例对象

    }
}

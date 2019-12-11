package com.jxy.jvm.classLoading;

import java.lang.reflect.Method;
/*
*  类加载器的双亲委托模型的好处：
*   1. 可以确保Java核心库的类型安全：所有的Java引用都至少会引用java.lang.Object类，也就是说在运行期，java.lang.Object这个类会被加载到Java虚拟机中，
*      如果这个加载过程是由Java应用自己的类加载器所完成的，那么很可能就会在JVM中存在多个版本的java.lang.Object类，而且这些类之间还是不相兼容的，相互
*      不可见的（正是命名空间在发挥着作用）
*   2. 可以确保Java核心库所提供的类不会被自定义的类所取代
*   3. 不同的类加载器可以为相同名称（binary name）的类创建额外的命名空间。相同名称的类可以并存在Java虚拟机中，只需要用不同的类加载器来加载他们即可；
*      不同类加载器所加载的类之间是不兼容的，这就相当于在Java虚拟机内部创建了一个有一个相互隔离的Java类空间，这类技术在很多框架中都得到了实际应用；
*
* */
public class ClassLoadingTest20 {
    public static void main(String[] args) throws Exception{
        ClassLoadingTest16 load1 = new ClassLoadingTest16("load1");
        ClassLoadingTest16 load2 = new ClassLoadingTest16("load2");

        load1.setPath("C:\\Users\\10715\\Desktop"); // 将classpath中的相关的class文件删除，可以得到命名空间相关的结论，同名类不可以相互转换
        load2.setPath("C:\\Users\\10715\\Desktop");

        Class<?> clazz1 = load1.loadClass("com.jxy.jvm.classLoading.MyPerson");
        Class<?> clazz2 = load2.loadClass("com.jxy.jvm.classLoading.MyPerson");

        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1,object2); // 参数一： 通过哪个参数调用该方法 参数二： 所需传入的参数

    }
}

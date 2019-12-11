package com.jxy.jvm.classLoading;
/*
*   当前类加载器（Current ClassLoader）
*
*   每个类都会使用自己的类加载器（即加载自身的类加载器）去加载其他类（指的是所依赖的类），
*   如果ClassX引用率了ClassY，那么ClassX的类加载器就会去加载ClassY（前提是ClassY尚未被加载）
*
*   线程上下文加载器（Context ClassLoader）
*
*   线程上下文加载器是从JDK 1.2 开始引入的，类Thread中的getContextClassLoader()与setContextClassLoader(ClassLoader classLoader)
*   分别用来获取和设置上下文加载器。
*
*   如果没有通过setContextClassLoader(ClassLoder classLoader)进行设置的话，线程将继承其父线程的上下文类加载器；
*   Java应用运行时的初始线程的上下文加载器是系统加载器。在线程中运行的代码可以通过该类加载器来加载类与资源；
*
*   线程上下文的重要性：
*
*   SPI(Service Provider Interface)
*
*   父ClassLoader可以使用当前线程Thread.currentThread().getContextClassLoader()所指定的ClassLoader加载的类，
*   这就改变了父ClassLoader不能使用子ClassLoader或是其他没有父子关系的ClassLoader加载的类的情况，即改变了
*   双亲委派模型；
*
*   线程上下文加载器就是当前线程的Current ClassLoader；
*
*   在双亲委托模型下，类的加载时由下至上的，即下层的类加载器会委托上层进行加载。但是对于SPI来说，有些接口是Java核心库锁提供的，
*   而Java核心库是由启动类加载器加载的，而这些接口的实现来自不同的Jar包（厂商提供），Java的启动类加载器是不会加载其他来源的jar包的，
*   这样传统的双亲委派模型就无法满足SPI的要求。而通过给当前线程设置上下文类加载器，就可以由设置的上下文类加载器来实现对于接口实
*   现类的加载；
*
*
* */
public class ClassLoadingTest24 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}

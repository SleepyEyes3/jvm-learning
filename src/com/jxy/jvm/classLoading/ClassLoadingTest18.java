package com.jxy.jvm.classLoading;

import sun.misc.Launcher;

public class ClassLoadingTest18 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        // 扩展类加载器需要在指定路径中的 .jar包中才能找到需要加载的.class文件，
        // 与其他类加载器不同
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        /*
        *   内建于JVM中的启动类加载器会加载java.lang.ClassLoader以及其他的Java平台类，当JVM启动时，一块特殊的机器码
        *   会运行，它会加载扩展类加载器与系统类加载器，这块特殊的机器码叫做启动类加载器(Bootstrap)
        *
        *   启动类加载器并不是Java类，而其他的加载器则是Java类，启动类加载器是特定于平台的机器指令，它负责开启整个加载过程；
        *
        *   所有类加载器（除了启动类加载器）都被时限为Java类，不过，总归要有一个组件来加载第一个Java类加载器，从而让整个加载过程
        *   能够顺利进行下去，加载第一个纯Java类加载器就是启动类的职责；
        *
        *   启动类加载器还会负责加载供JRE正常运行所需要的基本组件，这包括java.util与java.lang包中的类等等；
        * */
        System.out.println(ClassLoader.class.getClassLoader());

        // 扩展类加载器与系统类加载器也是有启动类加载器锁加载的
        System.out.println(Launcher.class.getClassLoader());

        // 通过下面的路径，可以改变系统类加载器
        System.out.println(System.getProperty("java.system.class.loader"));

        System.out.println(ClassLoader.getSystemClassLoader());
    }
}

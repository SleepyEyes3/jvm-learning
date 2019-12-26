package com.jxy.jvm.classLoading;


/*
*  关于命名空间：
*     子加载器的命名空间包含所有父加载器的命名空间。
*       1. 子加载器所加载的类可以访问父加载器所加载的类
*       2. 父加载器所加载的类不可以访问子加载器所加载的类
*       3. 包含类的加载器会去尝试加载被包含类
*       4. 如果两个加载器之间没有直接或间接的父子关系，那么他们各自加载的类相互不可见
*
* 测试用例：
*       1. 将classpath中的MySample.class删除
*       2. 将classpath中的MyCat.class删除
*       3. 将classpath中的MySample.class删除，在MyCat类中添加 System.out.println("from MySample: " + MySample.class);
*
* 测试结果：
*       1. MySample.class由自定义的类加载器加载,MyCat.class由AppClassLoader加载
*       2. Caused by: java.lang.ClassNotFoundException: com.jxy.jvm.classLoading.MyCat (原因：MySample的类加载器会去尝试
*           加载MyCat，也就是AppClassLoader会去加载MyCat.class，但是在classpath中找不到MyCat.class)
*       3. Caused by: java.lang.ClassNotFoundException: com.jxy.jvm.classLoading.MySample
*           （原因：子类加载器所加载的类可以调用父类加载器所加载的类的信息，但是父类加载器所加载的类不可以获取子类加载器所加载的类的信息）
* */


public class ClassLoadingTest17 {
    // 测试：分别将classpath中的MyCat.class文件，或者MySample.class文件删了，看看什么情况
    public static void main(String[] args) throws Exception {
        ClassLoadingTest16 load1 = new ClassLoadingTest16("loader1");
        load1.setPath("C:\\Users\\10715\\Desktop\\");
        Class<?> clazz = load1.loadClass("com.jxy.jvm.classLoading.MySample"); // 创建class对象并放到内存中
        System.out.println("class: " + clazz.hashCode());

        // 如果注释掉该行，就不会创建MySample实例，即不会调用MySample的构造函数，就不会创建MyCat的实例
        // 就不会主动调用，就不会加载MyCat class
        Object o = clazz.newInstance(); // 创建实例对象

    }
}

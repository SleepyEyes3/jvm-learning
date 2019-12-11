package com.jxy.jvm.classLoading;

public class MyCat {
    public MyCat() {
        System.out.println("MyCat is loaded by: " + this.getClass().getClassLoader());
        System.out.println("from MySample: " + MySample.class);  // 如果将从classpath中的MySample删除，则会报错
        // 原因 ： MySample由自定义加载器加载，MyCat有AppClassLoader加载，由于加载器命名空间的缘故，父类加载器无法获取
        //        子类加载器中的信息，但是，子类加载器可以获取父类加载器中的信息（命名空间由自己的加载器及其所有的父加载器构成）
    }
}
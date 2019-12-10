package com.jxy.jvm.classLoading;

public class MySample {
    public MySample(){
        System.out.println("MySample is loaded by: " + this.getClass().getClassLoader());
        new MyCat(); // MyCat.class 需要MySample.class的类加载器加载
        System.out.println("from MyCat: " + MyCat.class); // 子加载器所加载的类中引用父加载器所加载的类的信息，是没有问题的
    }
}

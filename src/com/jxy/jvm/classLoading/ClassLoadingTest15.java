package com.jxy.jvm.classLoading;

public class ClassLoadingTest15 {

    // 总结： 数组的加载类的类型和其中的元素的加载类的类型是一样的
    //       但是 原生类型数组的类没有类加载器
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader()); // null

        System.out.println("----------");

        ClassLoadingTest15[] classLoadingTest15s = new ClassLoadingTest15[2];
        System.out.println(classLoadingTest15s.getClass().getClassLoader()); // AppClassLoader

        System.out.println("----------");

        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader()); //null ： 原生类型 数组的类 没有类加载器
    }
}

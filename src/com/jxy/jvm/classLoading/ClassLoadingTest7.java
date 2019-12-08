package com.jxy.jvm.classLoading;

public class ClassLoadingTest7 {
    public static void main(String[] args) throws Exception{
        Class<?> class1 = Class.forName("java.lang.String");
        System.out.println(class1.getClassLoader()); // bootstrap classloader

        Class<?> class2 = Class.forName("com.jxy.jvm.classLoading.ClassLoadingTest7");
        System.out.println(class2.getClassLoader()); // system classloader
    }
}


class C1{

}
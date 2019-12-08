package com.jxy.jvm.classLoading;

class Parent10{
    public  static int a= 1;
    static {
        System.out.println("parent9 static block");
    }
}

class Child10 extends Parent10{
    public static int b= 2;
    static {
        System.out.println("child9 static block");
    }
}



public class ClassLoadingTest10 {
    static {
        System.out.println("ClassLoadingTest10 static block");
    }

    // static/初始化只有一次
    public static void main(String[] args) { // main函数的调用，会触发 ClassLoadingTest10 的初始化
        Parent10 parent10;
        System.out.println("------------");

        parent10 = new Parent10();
        System.out.println("------------");

        System.out.println(parent10.a);
        System.out.println("------------");

        System.out.println(Child10.b);
    }
}


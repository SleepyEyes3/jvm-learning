package com.jxy.jvm.classLoading;

class Paren11{
    static {
        System.out.println("parent11 static block");
    }
    public static  int a =1;
    public static void doSomething(){
        System.out.println("do something!");
    }
}

class Child11 extends Paren11{
    static {
        System.out.println("child11 sattic block");
    }
    public static int b = 2;
}

public class ClassLoadingTest11 {
    public static void main(String[] args) {
        System.out.println(Child11.a); // 子类直接调用父类中的静态属性，方法，并不会初始化本身
        System.out.println("----------");
        Child11.doSomething();
    }
}

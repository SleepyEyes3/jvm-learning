package com.jxy.jvm.classLoading;

/*
 *   结论 ： 只有当前程序访问的静态变量或静态方法确实在“当前类或当前接口”中定义时，
 *          才可以认为是对类或接口的主动使用
 * */
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

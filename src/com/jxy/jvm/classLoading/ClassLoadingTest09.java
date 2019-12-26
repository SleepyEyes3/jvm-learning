package com.jxy.jvm.classLoading;
/*
*   结论 ： 只有当前程序访问的静态变量或静态方法确实在“当前类或当前接口”中定义时，
*          才可以认为是对类或接口的主动使用
* */
class Parent9{
    public  static int a= 1;
    static {
        System.out.println("parent9 static block");
    }
}

class Child9 extends Parent9{
    public static int b= 2;
    static {
        System.out.println("child9 static block");
    }
}



public class ClassLoadingTest09 {
    static {
        System.out.println("ClassLoadingTest9 static block");
    }

    public static void main(String[] args) {
//        System.out.println(Child9.a); // 没有初始化Child
        System.out.println(Child9.b); // 初始化了Child和Parent
    }
}

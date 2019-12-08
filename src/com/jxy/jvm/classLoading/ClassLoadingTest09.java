package com.jxy.jvm.classLoading;

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



public class ClassLoadingTest9 {
    static {
        System.out.println("ClassLoadingTest9 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child9.b);
    }
}

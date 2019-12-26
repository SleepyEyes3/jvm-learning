package com.jxy.jvm.bytecode;

/*
*   结论 ： 实际的类型在运行时决定，但是得先编译成功；
* */
import java.util.Date;

public class MyTest7 {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal cat = new Cat();

        animal.test("hello"); // animal str
        cat.test(new Date()); // dog date -->  动态类型 会 覆盖 静态类型

//        cat.method(); 这个方法的调用会出现编译出错的情况，静态类型 Animal 编译阶段找不到 方法 method()
    }
}

class Animal{
    public void test(String str){
        System.out.println("animal str");
    }

    public void test(Date date){
        System.out.println("animal date");
    }
}

class Cat extends Animal {
    @Override
    public void test(String str){
        System.out.println("cat str");
    }

    @Override
    public void test(Date date){
        System.out.println("cat date");
    }

    public void method(){
        System.out.println("method");
    }
}

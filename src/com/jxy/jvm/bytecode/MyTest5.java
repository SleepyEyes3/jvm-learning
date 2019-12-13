package com.jxy.jvm.bytecode;

import java.io.File;
/*
*   方法的静态分派：
*       Grandpa father = new Father();
*       以上代码，father的“静态类型”是Grandpa，而father的“实际类型”（真正指向的类型）是Father。
*
*   结论：
*       变量的静态类型是不会发生变化的，而变量的实际类型则是可以发生变化的（多态的一种体现），实际类型是在运行期间确定的；
*
* */
public class MyTest5 {
    public void test(Grandpa grandpa){
        System.out.println("grandpa");
    }

    public void test(Father father){
        System.out.println("father");
    }

    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args) {
        // 关键 ： 方法重载 ： 是一种静态的行为，编译期就可以完全确定
        Grandpa father = new Father();
        Grandpa son = new Son();

        MyTest5 myTest5 = new MyTest5();
        myTest5.test(father); // grandpa
        myTest5.test(son); // grandpa
    }
}



class Grandpa{}

class Father extends Grandpa{}

class Son extends Father{}

package com.jxy.jvm.bytecode;


/*
*   栈帧(stack frame)
*   栈帧是一种用于帮助虚拟机执行方法调用与方法执行的数据结构。
*
*   栈帧本身是一种数据结构，封装了方法的 局部变量表、动态链接信息、方法的返回地址以及操作数栈等信息；
*
*   符号引用：全局变量名
*       静态解析： 有些符号引用是在类加载阶段或是第一次使用是就会转换为直接引用，这种转换叫做静态解析；
*       动态链接： 另外一些符号引用则是在每次运行期间转换为直接引用，这种转换叫做动态链接，这体现了Java的多态性；
*   直接引用：内存地址
*
* */

/*
*   1. invokeinterface : 调用接口中的方法，实际上是在运行期决定的，决定到底调用实现该接口的那个对象的特定方法
*   2. invokestatic : 调用静态方法
*   3. invokespecial : 调用私有方法、构造方法（<init>）以及父类的方法
*   4. invokevirtual : 调用虚方法，运行期动态查找的过程
*   5. invokedynamic : 动态调用方法
* */

/*
*   静态解析的四种情形：
*       1. 静态方法
*       2. 父类方法
*       3. 构造方法
*       4. 私有方法（无法被重写）
*     以上4类方法称作“非虚方法”，他们在类加载阶段就可以将“符号引用”转换为“直接引用”的；
*
* */
public class MyTest4 {
    public static void test(){
        System.out.println("static invoked");
    }

    public static void main(String[] args) {
        test();
    }
}

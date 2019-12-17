package com.jxy.jvm.memory;

import java.util.ArrayList;

/*
*   虚拟机栈 ： stack frame ---> 8中基本数据类型 and 堆中的对象的引用
*   程序计数器 ：Program Counter ---> 字节码的行号(字节码的地址)
*   本地方方法栈 ： 处理本地方法
*   堆 : Heap
*   方法区 ：Method Area 存储元信息(class对象的一些信息，常量的一些信息)。 永久代 (Permanent Generation) ,从JDK 1.8开始，已经彻底废弃了永久代，
*           使用元空间 (Meta Space)
*           方法区中的信息很少被回收
*   运行常量池 ： 方法区的一部分内存
*   直接内存 ： Direct Memory ---> 并非Java 虚拟机直接管理的区域，与Java NIO紧密相关，JVM通过堆上的DirectByteBuffer来操作直接内存
*
*   关于Java对象创建的过程（可以分为以下三个过程）：
*       1. 在堆内存中创建出对象的实例
*       2. 为对象的实例成员变量赋初值
*       3. 将对象的引用返回
*
*   关于堆内存中的使用情况：
*       指针碰撞 ： 前提是堆中的空间通过一个指针进行分割，一侧是已被占用的空间，另一侧是饿未被占用的空间
*       空闲列表 ： 前提是堆内存中已被使用和未被使用的空间是交织在一起的，这时，虚拟机就需要通过一个列表来记录哪些空间是已使用的，
*                  哪些空间是未使用的，接下来找出可以容纳下新创建对象的且未被使用的空间，再次空间存放该对象，同时还要修改列表上的记录
*
*   通过引用的方式对堆内存上的内存进行访问：
*       1. 句柄 ： 引用指向的是一个句柄，句柄中有两个指针，一个指向堆内存中的内存，一个指向方法区中对应的元数据信息
*       2. 指针 ： 引用直接指向的部分，一部分是指向元数据的指针，另一部分直接就是对象的内存空间
*
*   VM options：
*       -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
* */
public class  MyTest1 {
    public static void main(String[] args) {
        ArrayList<MyTest1> lists = new ArrayList<>();
        for(;;){
            lists.add(new MyTest1());
            System.gc();
        }
    }
}

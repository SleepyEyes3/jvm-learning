package com.jxy.jvm.bytecode;

public class MyTest2 {

    // 下面这两个赋值过程，在字节码中，是在默认的构造器<init>中进行赋值的(如果不提供显示的构造器的话)；
    String str = "welcome";
    private int x= 5;

    // 静态变量的赋值是在<clinit>中进行赋值的；
    public static Integer in = 10;

    // 如果显示的提供构造器，属性的初始化会在每个构造器中执行；（不受构造器以及成员变量的相对位置的影响）
    public MyTest2(){}
    public MyTest2(int i){}

    public static void main(String[] args){
        MyTest2 myTest2 = new MyTest2();

        myTest2.setX(8);

        in = 20;
    }
    // private 修饰符 要通过 javap -verbose -p 显示
    // synchronized 查看oracle
    public synchronized void setX(int x) { // 给创建的对象上锁
        this.x = x;
    }

    public void test(String str){     // 查看字节码文件，发现两个monitorexit：以防程序异常
        synchronized (str){
            System.out.println(str);
        }
    }

    // 多个“静态代码块”及“静态属性的赋值”在字节码中 都会按照顺序放到一个静态代码块中进行初始化
    public static synchronized void test2(){} // 给class上锁
}

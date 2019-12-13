package com.jxy.jvm.bytecode;
 /*
 *  new 的作用：
 *      (1) 创建一个内存空间（堆里面）
 *      (2) 调用构造方法
 *      (3) 将引用赋值给一个本地变量（栈里面）
 * */

 /*
 *  方法的动态分配：
 *      方法的动态分派设置到一个重要的概念：方法接受者
 *      invokevirtual字节码指令的多态查找流程
 *
 *  方法重载(overload) 与 方法重写(override)
 *      (1) 方法重载是“静态”的，是“编译期”行为；方法重写是“动态”的，是“运行期'行为；
 *      (2) override : 不同的实际对象，调用名称相同，描述符相同的方法
 *          overload : 相同的静态对象，调用名称相同，描述符不同的方法；
 * */
public class MyTest6 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test(); // apple
        orange.test(); // orange

        apple = new Orange();
        apple.test(); // orange
    }
}


class Fruit{
    public void test(){
        System.out.println("fruit");
    }
}

class   Apple extends Fruit{
    @Override
    public void test(){
        System.out.println("apple");
    }
}

class Orange extends Fruit{
    @Override
    public void test(){
        System.out.println("orange");
    }
}
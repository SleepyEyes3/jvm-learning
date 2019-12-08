package com.jxy.jvm.classLoading;


/*
* 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中，
* 本质上，调用类并没有“直接引用”到定义常量的类，因此并不会触
* 发定义常量的类的初始化
*
* 注意：这里的是将常量存放到了ClassLoadingTest1的常量池中，之后ClassLoadingTest1与MyParent2
*       就没有任何关系了，甚至，我们可以将MyParent2的class文件删除
*
* 助记符：
*   ldc ： 表示将int,float,或是String类型的常量值从常量池中推送至栈顶
*   bipush : 表示将单字节（-128~127）的常量值推送至栈顶
*   sinput ： 表示将一个短整形常量值（-32768~32767）推送至栈顶
*   iconst_1 : 表示键int类型1推送至栈顶（iconst_1 ~ iconst_5）
*
*
* */
public class ClassLoadingTest02 {
    public static void main(String[] args) {
        System.out.println(MyParent2.s);
    }
}


class MyParent2{
    public static final String str = "hello world"; // 加了 final 后面的 static block就不会显示
    public static final short s = 127;
    public static final int i = 128;
    public static final int m = 6;
    static {
        System.out.println("parent static block");
    }
}
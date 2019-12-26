package com.jxy.jvm.practices.memory;

/*
    测试目标：
        String.intern()返回引用测试

    参数设置：


    测试结果：
        true / false
        原因：intern()返回的引用和

    参考：
        https://tech.meituan.com/2014/03/06/in-depth-understanding-string-intern.html
        https://www.cnblogs.com/sxhjoker/p/11607457.html
        https://juejin.im/post/5d88982bf265da03eb1408e8
        https://www.jianshu.com/p/8966c51e9728

    总结：
        1. Test2~Test7 是关于Intern()与字符串常量池的测试
        2. 以下是关于这几个demo的总结：
            2.1 前置知识：
                2.1.1 JDK7以后，字符串常量池放到了堆中，因为MetaSpace中的空间比较小，容易导致OutOfMemoryError

                2.1.2 字符串常量池中可以存字符串本身，也可以存储堆中字符串对象的引用

                2.1.3 new String("str")会在堆中，以及字符串常量池中分别创建对象，new String("ha") + new String("ha") 只会在堆中创建对象

            2.2 重点：
                2.2.1 new String("hello") / new StringBuilder("hello").toString() / hello = hello1 + "";(hello1 = "hello";)/ 效果一样,都只会在堆中创建一个对象

                2.2.2 new String("hel") + new String("lo") / new StringBuilder("hel").append("lo").toString() / hel = "hel"; lo = "lo"; hello = hel + lo
                      / hel = "hel"; hello = hel + "lo"; ) / 效果都是一样的，都只会在堆中创建一个对象，不会在常量池中创建对象；

                2.2.3 hello = "hello"; / hello = "hel" + "lo"; / 效果是一样的，只会在常量池中创建一个 "hello" 对象

                2.2.4 str.intern()的作用： 是将堆中的字符串对象“推”至字符串常量池中，注意，他是有返回值的，str.intern() 和 str= str.intern()是不一样的；
                     又可分为下面的几种情况:
                        (1) 如果字符串常量池中没有与堆中相等的对象（str.equals(another str)），就将堆中字符串对象的“引用”推至字符串常量池中
                        (2) 如果字符串常量池中存在相等的值，不管字符串常量池中的值，是引用的形式还是“str”的形式，都不会再将堆中的值推过去
                     因此, .intern()返回的值，同样可以是“hello”或者是堆中“hello”obj的引用

* */
public class Test2 {
    public static void main(String[]args){
        String str1 = new StringBuilder("哈哈").append("haha").toString(); // 可将其视为 new String("哈哈") + new String("haha")，不会再常量池中创建对象
        System.out.println(str1.intern() == str1); // true

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2); // false

        System.out.println("--------test1--------");
        String str3 = "test";
        String str4 = new StringBuilder("test").toString();
        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));
        System.out.println(str3 == str4.intern());

        System.out.println("--------test2--------");
        String s1 = "first";
        String s2 = "first";
        System.out.println(s1 == s2); // true s1/s2 的值在编译期间就已经确定了，返回的地址直接上常量池中的地址，根本没有在堆中创建对象；

        System.out.println("--------test3--------");
        String s3 = new String("second");
        String s4 = "second";
        System.out.println(s3 == s4); // false s3 返回的是堆中的引用地址，s4 返回是常量池中的地址

        System.out.println("--------test4--------");
        String s5 = new String("third").intern();
        String s6 = "third";
        System.out.println(s5 == s6); // true

        System.out.println("--------test5--------");
        String s7 = new String("second");
        System.out.println(s7.intern() == s7); // false 与上面test6相反

        System.out.println("--------test6--------");
        String s8 = new StringBuilder("呵呵").toString(); // 可将其视为 new String("呵呵")，会在常量池中创建对象
        System.out.println(s8.intern() == s8); // false

        System.out.println("--------test7--------");
        String s9 = new StringBuilder("test6").toString();
        String s10 = new String("test6");
        System.out.println(s9 == s10);
    }
}

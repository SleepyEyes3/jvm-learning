package com.jxy.jvm.practices.memory;

/*
    测试目标：
        String 创建过程测试


* */
public class Test3 {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = "abc";
        String s3 = new String("abc");

        System.out.println(s1 == s2); // false
        System.out.println(s1 == s3); // false
        System.out.println(s2 == s3); // false

        System.out.println("-------");

        System.out.println(s1 == s1.intern()); // false
        System.out.println(s2 == s2.intern()); // true
        System.out.println(s1.intern() == s2.intern()); // true

        System.out.println("-------");

        String hello = "hello";
        String hel = "hel";
        String lo = "lo";

        System.out.println(hello == "hello"); // true
        System.out.println(hello == "hel" + "lo"); // true
        System.out.println(hello == "hel" + lo); // false
        System.out.println(hello == hel + lo); // false

        System.out.println("-----------new test1--------------");

        String hello1 = hel + lo;
        System.out.println(hello1 == "hello"); // false 说明 hello1 肯定不是在字符串常量池中的（下面验证一下是不是和new StringBuilder().append()一样）

        String bru = "bru";
        String ce = "ce";
        String bruce = bru + ce; // 这个动作和 new StringBuilder("bru").append("ce").toString()是一样的
        System.out.println(bruce.intern() == bruce);

        String yu = "yu";
        String nl = "";
        String yunl = yu + nl; // 这个动作和 new StringBuilder("bru").toString()以及new String("yu")是一样的
        System.out.println(yunl.intern() == yunl);

        System.out.println("-----------new test1--------------");

        String jok = "jok";
        String joker = jok + "er"; // 这个动作和 new StringBuilder("jok").append("er").toString()是一样的
        System.out.println(joker.intern() == joker);
    }
}

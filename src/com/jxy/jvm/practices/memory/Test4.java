package com.jxy.jvm.practices.memory;

public class Test4 {
    public static void main(String[] args) {
        String s1 = new String("hello"); // 并没有在 常量池中 创建常量
        s1.intern();
        String s2 = "hello";
        System.out.println(s1 == s2); // false

        System.out.println("------  调整s1.intern()与String s2=\"hello\"的位置  -------");

        String s3 = new String("joker");
        String s4 = "joker";
        s3.intern();
        System.out.println( s3 == s4); // false

        System.out.println("------  输出s1.intern() == s2 的结果  -------");

        String s5 =  new String("bat man");
        String s6 = "bat man";
        System.out.println(s5.intern() == s6); // true
    }
}

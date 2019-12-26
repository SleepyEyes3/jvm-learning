package com.jxy.jvm.practices.memory;

public class Test7 {
    public static void main(String[] args) {
        String s1 = new String("he") + new String("llo");
        String s2 = new String("h") + new String("ello");
        String s3 = s1.intern(); // 返回的是
        String s4 = s2.intern();

        System.out.println(s1 == s3); // true
        System.out.println(s1 == s4); // true
    }
}

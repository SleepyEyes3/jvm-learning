package com.jxy.jvm.practices.memory;

public class Test6 {
    public static void main(String[] args) {
        String s1 = new String("he") + new String("llo");
        String s2 = new String("h") + new String("ello");

        String s3 = s1.intern();

        String s4 = s2.intern();

        System.out.println(s1 == s3); // true

        System.out.println(s1 == s4); // true

        System.out.println(s2 == s3); // false

        System.out.println(s2 == s4); // false

        System.out.println(s3 == s4); // true

    }
}

package com.jxy.jvm.classLoading;

import java.util.UUID;

public class ZTest {
    public static void main(String[] args) {
        System.out.println(A.str);

    }
}

class A{
    public static final String str = "haha";// 加了final中，字节码常量池中 就没有了 a 的身影,但是还是会出现str
    static {
        System.out.println("class A static block");
    }
}
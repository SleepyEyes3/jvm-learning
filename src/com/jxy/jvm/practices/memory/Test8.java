package com.jxy.jvm.practices.memory;

public class Test8 {
    public static void main(String[] args) {
        String str0 = "hello ";
        String str1 = "hello " + "world";
//        String str2 = new String("hahahaha");
//        String str2 = new StringBuilder("hahahahah").toString();
        String str2 = new String("Joker") + new String("hahahah");
    }
}


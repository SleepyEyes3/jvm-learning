package com.jxy.jvm.bytecode;

public class BTest {

    public static void main(String[] args) {
        int a;
        char[] cs = new char[5];
        cs[0] = 'a';
        System.out.println(cs.length);
//        for(char c:cs){
//            System.out.println(c);
//        }

        for(int i = 0; i<cs.length;i++){
            System.out.println(cs[i]);
        }


//        System.out.println(a);
    }
}

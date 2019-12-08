package com.jxy.jvm.classLoading;


import java.util.ArrayList;

/*
* 对于数组实例来说，其类型是由JVM在运行期间动态生成的，数组的类型为 [Lcom.jxy.jvm.classLoading.Myparent4，
* 其父类型为Object；二维数组的类型为 [[Lcom.jxy.jvm.classLoading.Myparent4;
*
* 助记符：
*   anewarray: 表示创建一个引用类型的(如类、接口、数组)数组，并将其压入到栈顶
*   newarray: 表示创建一个指定的原始类型，（如 int float char）的数组，并将其压入栈顶
* */
public class ClassLoadingTest04 {
    public static void main(String[] args) {
        Myparent4[] myparent4s = new Myparent4[1]; // 不会完成初始化static
        System.out.println(myparent4s.getClass());
        System.out.println(myparent4s.getClass().getSuperclass());

        Myparent4[][] myparent4s1 = new Myparent4[1][1];
        System.out.println(myparent4s1.getClass());

        int[] ints = new int[1];
        System.out.println(ints.getClass());

//        ArrayList<Integer> integers = new ArrayList<>();
//        System.out.println(integers.getClass());
        boolean[] booleans = new boolean[1];
        System.out.println(booleans.getClass());

        byte[] bytes = new byte[1];
        System.out.println(bytes.getClass());

        char[] chars = new char[1];
        System.out.println(chars.getClass());

    }
}

class Myparent4{
    static {
        System.out.println("myparent4 static block");
    }
}

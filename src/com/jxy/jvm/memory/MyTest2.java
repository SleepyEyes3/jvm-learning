package com.jxy.jvm.memory;

/*
*   stack over flow
* */
public class MyTest2 {
    private int length;

    public int getLength(){
        return length;
    }

    public void test(){
        this.length++;
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        try {
            myTest2.test();
        }catch (Throwable t ){
            System.out.println(myTest2.getLength());
            t.printStackTrace();
        }
    }
}

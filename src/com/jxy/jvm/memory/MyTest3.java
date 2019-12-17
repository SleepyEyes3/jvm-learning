package com.jxy.jvm.memory;
/*
*   死锁 结合线程工具进行查看
* */
public class MyTest3 {
    public static void main(String[] args) {
        new Thread(()-> A.method(),"Thread-A").start();
        new Thread(()-> B.method(),"Thread-B").start();

    }
}

class A{
    public static synchronized void method(){
        System.out.println("method from class A");
        try{
            Thread.sleep(5000);
            B.method();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}


class B{
    public static synchronized void method(){
        System.out.println("method from class B");
        try{
            Thread.sleep(5000);
            A.method();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}



package com.jxy.jvm.classLoading;
/*
*   验证源码Launcher.class 中的 Thread.currentThread().setContextClassLoader(this.loader);
* */
public class ClassLoadingTest25 implements Runnable{
    private Thread thread;
    public ClassLoadingTest25(){
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run(){
        ClassLoader classLoader = this.thread.getContextClassLoader();
        this.thread.setContextClassLoader(classLoader);

        System.out.println(classLoader.getClass());
        System.out.println(classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new ClassLoadingTest25();
    }
}

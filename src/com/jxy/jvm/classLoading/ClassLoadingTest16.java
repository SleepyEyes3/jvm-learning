package com.jxy.jvm.classLoading;

import java.awt.*;
import java.io.*;
/*
* 自定义一个classLoader
* */
public class ClassLoadingTest16 extends ClassLoader{


    private String classLoderName;

    private final String fileExtention = ".class";

    public ClassLoadingTest16(String classLoderName){
        super(); // 将系统类加载器当做该类加载器的父加载器
        this.classLoderName = classLoderName;
    }

    public ClassLoadingTest16(ClassLoader parent,String classLoderName){
        super(parent); // 显示指定该类加载器的父加载器
        this.classLoderName = classLoderName;
    }

    @Override
    public String toString(){
        return "[" + this.classLoderName + "]";
    }

    @Override
    protected Class<?> findClass(String className){
        byte[] data = this.loadClassData(className);
        return this.defineClass(className,data,0, data.length);
    }

    private byte[] loadClassData(String name){
        // 读取文件，并返回byte数组的过程
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            this.classLoderName = this.classLoderName.replace(".","/");
            is = new FileInputStream(new File(name + this.fileExtention));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())){
                baos.write(ch);
            }
            data = baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
                baos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return data;

    }

    public static void main(String[] args) throws Exception {
        ClassLoadingTest16  loader1 = new ClassLoadingTest16("loader");
        test(loader1);

    }

    public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = classLoader.loadClass("com.jxy.jvm.classLoading.ClassLoadingTest15");
        Object o = clazz.newInstance();
        System.out.println(o);
    }

}

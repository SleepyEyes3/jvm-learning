package com.jxy.jvm.classLoading;

import java.awt.*;
import java.io.*;
/*
* 自定义一个classLoader
* 总结：
*    至关重要： 主要从当前类的父/祖父加载器，是否加载class文件来看，注意AppClassLoader是否能在classPath中加载到类文件
*   （1）自定义的classLoader并没有使用上，因为我们所需要加载的类，位置在classPath中，因此，由父类加载器AppClassLoader优先加载了；
*   （2）相同的class文件，即使在不同的地方，在同一个命名空间中，不会加载两次；在不同的命名空间中，可以；
* */
public class ClassLoadingTest16 extends ClassLoader{


    private String classLoderName;

    private String path;

    private final String fileExtention = ".class";

    public void setPath(String path){
        this.path = path;
    }

    public ClassLoadingTest16(String classLoderName){
        super(); // 将系统类加载器当做该类加载器的父加载器
        this.classLoderName = classLoderName;
    }

    public ClassLoadingTest16(ClassLoader parent,String classLoderName){
        super(parent); // 显示指定该类加载器的父加载器
        this.classLoderName = classLoderName;
    }

    // 自定义系统加载类，需要下面的构造函数
    public ClassLoadingTest16(ClassLoader parent){
        super(parent);
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
//        System.out.println("自定义loadClass开始执行！");
        System.out.println("classLoaderName：" + this.classLoderName);
        System.out.println("findClass invoked: " + name);
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            name = name.replace(".","/");
            is = new FileInputStream(new File(path + name + this.fileExtention));
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
        ClassLoadingTest16  loader1 = new ClassLoadingTest16("loader1");
//        test(loader1);
        // 不同的情况：
        //      1. loader1 loader2 在classpath中有class文件  ---> 加载一次class文件
        //      2. 在classpath中没有class文件                ---> 加载两次class文件
        //      3. loader2的parent是loader1                 ---> 加载一次
        loader1.setPath("C:\\Users\\10715\\Desktop\\");
        Class<?> clazz1 = loader1.loadClass("com.jxy.jvm.classLoading.ClassLoadingTest15");
        System.out.println("class hashcode:" + clazz1.hashCode());
        Object o1 = clazz1.newInstance();
        System.out.println(o1);

        System.out.println("-----------------------");

        ClassLoadingTest16  loader2 = new ClassLoadingTest16(loader1,"loader2");
        loader2.setPath("C:\\Users\\10715\\Desktop\\");
        Class<?> clazz2 = loader2.loadClass("com.jxy.jvm.classLoading.ClassLoadingTest15");
        System.out.println("class hashcode:" + clazz2.hashCode()); // hashcode相同的话，表示加载的同一个类
        Object o2 = clazz2.newInstance();
        System.out.println(o2);

        System.out.println("-----------------------");

        ClassLoadingTest16  loader3 = new ClassLoadingTest16(loader2,"loader2");
        loader2.setPath("C:\\Users\\10715\\Desktop\\");
        Class<?> clazz3 = loader2.loadClass("com.jxy.jvm.classLoading.ClassLoadingTest15");
        System.out.println("class hashcode:" + clazz2.hashCode()); // hashcode相同的话，表示加载的同一个类
        Object o3 = clazz2.newInstance();
        System.out.println(o3);
    }

    // 情况一： 自定义加载器不起作用的情况 (loadClassData根本没有执行)
    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("com.jxy.jvm.classLoading.ClassLoadingTest15");
        System.out.println(clazz.hashCode());
        Object o = clazz.newInstance();
        System.out.println(o);
    }
}

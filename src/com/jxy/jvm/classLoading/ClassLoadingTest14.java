package com.jxy.jvm.classLoading;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoadingTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String resource = "com/jxy/jvm/classLoading/ClassLoadingTest14.class";
        Enumeration<URL> urls = classLoader.getResources(resource);
        while(urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url);
        }

        System.out.println("------------");
        Class<?> class1 = ClassLoadingTest14.class;
        System.out.println(class1.getClassLoader()); // AppClassLoader

        System.out.println("------------");

        Class<?> class2 = String.class;
        System.out.println(class2.getClassLoader()); // null (BootstrapClassLoader)
    }
}

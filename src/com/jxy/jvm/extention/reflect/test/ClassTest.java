package com.jxy.jvm.extention.reflect.test;

import com.jxy.jvm.extention.reflect.Employee;

/*
* 获取类对象的三种方法
* */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cls1 = Class.forName("com.jxy.jvm.extention.reflect.Employee");
        Class cls2 = Employee.class;
        Employee emp = new Employee("Yu", "25", "Coding", 1, "Java Rookie", 10);
        Class cls3 = emp.getClass();

        if(cls1 == cls2 && cls1 ==  cls3){
            System.out.println("以上都是同一个对象");
            System.out.println(cls1);
        }

        if(cls1.equals(cls2) && cls1.equals(cls3)){
            System.out.println("以上都是同一个对象");
            System.out.println(cls1);
        }

    }
}

package com.jxy.jvm.practices.memory;

import java.util.HashSet;
import java.util.Set;

/*
    测试目标：
        查看字符串常量池的位置

    参数设置：
        -Xmx6m

    测试结果：
        报错： Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        证实 “字符串池常量池” 位于堆中
* */
public class Test1 {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();
        short i = 0;
        while (true){
            hs.add(String.valueOf(i++).intern());
        }
    }
}

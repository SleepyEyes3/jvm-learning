package com.jxy.jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/*
*   方法区产生内存溢出错误
*       使用cglib动态生成类对象，将MetaSpace填满
*   参数： -XX:MaxMetaSpaceSize=200m
*   导入的包：cglib 2.2 and asm-all-3.3.1
*
*   https://www.infoq.cn/article/java-permgen-Removed
* */
public class MyTest4 {
    public static void main(String[] args) {
        for(;;){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(obj, method, args1, proxy) -> proxy.invokeSuper(obj,args1));
            System.out.println("metaspace");
            enhancer.create();
        }
    }
}

package com.jxy.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.rmi.ServerError;

/*
*   对于Java类中的每一个实例方法（非static方法），其在编译后所生成的字节码当中，方法参数的数量总是会比源代码代码中方法
*   参数的数量多个一个（this），她位于方法的第一个参数位置处；这样，我们就可以在Java的实例方法中使用this来去访问当前对
*   象的属性以及其他方法
*
*   这个操作是在编译期间完成的，即由javac编译器在编译的时候将对this的访问转化为对一个普通实例方法参数的访问；接下来在运
*   行期间，由JVM在调用实例方法是，自动向实例方法传入该this参数。所以，在实例方法的局部变量表中，至少会有一个指向当前对象
*   的局部变量；
*
* */

public class MyTest3 {
    /*
    * stack=3 :
    * locals=4 : this / fileInputStream / serverSocket / exception中的一个
    * args_size=1 : this
    * */
    // throws 后面的异常都会出现在 Exceptions里面（不管是运行时异常，还是编译时异常）
    public void test() throws IOException, FileNotFoundException, NullPointerException{
        try{
            // 下面的两个都是“编译时异常”，
            FileInputStream fileInputStream = new FileInputStream("test.txt");
            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
        } catch (FileNotFoundException ex){

        } catch (IOException ex){

        } catch (Exception ex){

        }finally {
            System.out.println("finally");
        }
    }
}

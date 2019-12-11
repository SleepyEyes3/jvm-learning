package com.jxy.jvm.classLoading;

import java.sql.Connection;
import java.sql.DriverManager;

public class ClassLoadingTest27 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestdb", "usernaem", "password");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

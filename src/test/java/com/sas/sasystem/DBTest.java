package com.sas.sasystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {

    // 定义连接常量
    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:file://C:/Users/shenh/Code/OOAD/FinPJ/sasystem/src/main/resources/Data/sasystem";
    private static final String USER = "admin";
    private static final String PASSWORD = "123456";

    public static Connection conn = getConnection();

    // 测试
    public static void main(String[] args) throws SQLException {
        System.out.println(conn);
    }

    // jdbc连接H2数据库
    private static Connection getConnection() {
        if (null != conn) return conn;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if (null != conn) System.out.println("H2test SUCCESS!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;

    }
}

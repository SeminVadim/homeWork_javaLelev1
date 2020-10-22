package ru.geekbrains.HomeWork_07_Chat;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection getInstance()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mychat", "root","");
        } catch (Exception e) {
            throw new RuntimeException("something wrong with connection ");
        }
    }
}

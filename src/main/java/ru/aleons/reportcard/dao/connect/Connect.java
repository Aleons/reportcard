package ru.aleons.reportcard.dao.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private static final String host = "mysql.thealeons.myjino.ru";
    private static final String port ="3306";
    private static final String dataBase = "thealeons_reportcard";
    private static final String login = "thealeons";
    private static final String pass = "guap";
    private static final String url = "jdbc:mysql://"+host+":"+port+"/"+dataBase;
    public Connection getConnect() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,login,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}

package com.spring.hw.db_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static Connector connector;

    private Connector() {
        try {
            String driverClass = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/flats";
        String dbUser = "root";
        String dbPassword = "root";
        return DriverManager.getConnection(connectionUrl, dbUser, dbPassword);
    }

    public static Connector getInstance() {
        if (connector == null)
            connector = new Connector();
        return connector;
    }
}

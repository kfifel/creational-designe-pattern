package com.pattern.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseSingleton {
    // should be lazy loaded
    // should be safe thread
    private static final String SERVER_NAME = "localhost";
    private static final String DB_NAME = "database_name";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;
    private static class LazyWrapper {
        static final DataBaseSingleton INSTANCE = new DataBaseSingleton();
    }

    private DataBaseSingleton() {}

    public static DataBaseSingleton getInstance() {
        return LazyWrapper.INSTANCE;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if(connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + SERVER_NAME + "/" + DB_NAME, USERNAME, PASSWORD);
        }
        return connection;
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed())
            connection.close();

        connection = null;
    }
}

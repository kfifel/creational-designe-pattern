package com.pattern.Singleton;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseSingletonV1 {
    private static final DataBaseSingletonV1 dataBaseSingletonV1 = new DataBaseSingletonV1();
    private static final String SERVER_NAME = "localhost";
    private static final String DB_NAME = "database_name";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;
    private DataBaseSingletonV1() {}

    public static DataBaseSingletonV1 getDataBaseSingletonV1() {
        return dataBaseSingletonV1;
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

package io.github.jhoneagle.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMySQL implements Database {
    private String url;
    private String username;
    private String password;

    /**
     *
     *
     * @param url   Url is database url which is mainly in form of jdbc:mysql://hostname:port/databasename.
     *              Where hostname is MySQL server so basically IP or localhost,
     *              port is TCP/IP port and databasename is the database you connect.
     * @param username  database users name.
     * @param password  database users password.
     */
    public DatabaseMySQL(String url, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getCause());
        }

        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public void createTable(String tableName, String... colums) {
        throw new RuntimeException("SQL tables must be initialized outside the code!");
    }
}

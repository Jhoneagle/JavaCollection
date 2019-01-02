package io.github.jhoneagle.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHtwo implements Database {
    private String url;
    private String username;
    private String password;

    public DatabaseHtwo(String url, String username, String password) {
        try {
            Class.forName ("org.h2.Driver");
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
        try {
            getConnection().createStatement().executeUpdate(evalQuery(tableName, colums));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private String evalQuery(String tableName, String... colums) {
        String result = "CREATE TABLE IF NOT EXISTS " + tableName + "(id INTEGER PRIMARY KEY not NULL";

        for (String colum : colums) {
            result += ", " + colum;
        }

        return result + ")";
    }
}

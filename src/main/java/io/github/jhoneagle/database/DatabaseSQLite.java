package io.github.jhoneagle.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSQLite implements Database {
    private String databaseAddress;

    public DatabaseSQLite(String databaseAddress) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getCause());
        }

        this.databaseAddress = databaseAddress;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }

    @Override
    public void createTable(String tableName, String... colums) {
        try {
            getConnection().prepareStatement(evalQuery(tableName, colums)).execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private String evalQuery(String tableName, String... colums) {
        String result = "CREATE TABLE IF NOT EXISTS " + tableName + "(id INTEGER PRIMARY KEY";

        for (String colum : colums) {
            result += ", " + colum;
        }

        return result + ")";
    }
}

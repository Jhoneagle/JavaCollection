package io.github.jhoneagle.database;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabasePostgres implements Database {
    private String urlForDb;
    private String username;
    private String password;

    public DatabasePostgres() {
        this(null, null, null);
    }

    public DatabasePostgres(String dbUrl) {
        this(dbUrl, null, null);
    }

    public DatabasePostgres(String dbUrl, String username, String password) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getCause());
        }

        this.urlForDb = dbUrl;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");

        if (urlForDb != null) {
            if (username != null && password != null) {
                return DriverManager.getConnection(urlForDb, username, password);
            } else {
                return DriverManager.getConnection(urlForDb);
            }
        } else if (dbUrl == null) {
            try {
                URI dbUri = new URI(System.getenv("DATABASE_URL"));

                String username = dbUri.getUserInfo().split(":")[0];
                String password = dbUri.getUserInfo().split(":")[1];
                dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

                return DriverManager.getConnection(dbUrl, username, password);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            return DriverManager.getConnection(dbUrl);
        }
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
        String result = "CREATE TABLE IF NOT EXISTS " + tableName + "(id SERIAL PRIMARY KEY NOT NULL";

        for (String colum : colums) {
            result += ", " + colum;
        }

        return result + ")";
    }
}

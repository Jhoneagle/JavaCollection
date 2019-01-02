package io.github.jhoneagle.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface Database {
    Connection getConnection() throws SQLException;
    void createTable(String tableName, String... colums);
}

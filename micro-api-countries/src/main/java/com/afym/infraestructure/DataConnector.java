package com.afym.infraestructure;
import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Map;

public class DataConnector {
    private String user;
    private String password;
    private String database;
    private Connection connection;

    public DataConnector() throws SQLException, ClassNotFoundException{
        this.setConnectionEnv();
        this.buildConnection();
    }

    private void buildConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(this.database, this.user, this.password);
    }

    public Connection getConnection() {
        return this.connection;
    }

    private void setConnectionEnv(){
        Map<String, String> environments = System.getenv();
        StringBuilder database = new StringBuilder();
        database.append("jdbc:mysql://")
                .append(environments.get("MICRO_DB_COUNTRY_HOSTANME")).append("/")
                .append(environments.get("MICRO_DB_COUNTRY_DATABASE"));
        this.database = database.toString();
        this.user = environments.get("MICRO_DB_COUNTRY_USER");
        this.password = environments.get("MICRO_DB_COUNTRY_PASSWORD");
    }
}

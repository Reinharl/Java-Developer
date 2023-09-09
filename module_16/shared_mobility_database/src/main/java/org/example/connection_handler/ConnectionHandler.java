package org.example.connection_handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler implements AutoCloseable {

    private static final String DB_URL_PREFIX = "jdbc:postgresql://";
    private static final Path propsPath = Paths.get("module_16", "shared_mobility_database", "src", "main", "java", "org", "example", "config", "application.properties");
    private static volatile ConnectionHandler instance;
    private Connection connection;
    private Properties dbProperties;

    private ConnectionHandler() {
        try (BufferedReader br = Files.newBufferedReader(propsPath)) {
            dbProperties = new Properties();
            dbProperties.load(br);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // singleton pattern
    public static ConnectionHandler getInstance() {
        ConnectionHandler result = instance;

        if (result != null) {
            return result;
        }
        synchronized (ConnectionHandler.class) {
            if (instance == null)
                instance = new ConnectionHandler();

            return instance;
        }
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(getDatabaseURL(), dbProperties);
        }

        return connection;
    }

    private String getDatabaseURL() {
        return DB_URL_PREFIX +
                dbProperties.getProperty("host") + ":" +
                dbProperties.getProperty("port") + "/" +
                dbProperties.getProperty("name");
    }

    @Override
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }

    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        Connection conn = getConnection();
        return conn.prepareStatement(query);
    }
}

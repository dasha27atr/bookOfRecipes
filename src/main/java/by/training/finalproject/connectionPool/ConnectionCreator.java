package by.training.finalproject.connectionPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    public ConnectionCreator() {
    }

    public Connection createConnection() {
        Connection connection = null;
        try {
            connection = getConnection();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private Connection getConnection() throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("properties\\database.properties"));
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}

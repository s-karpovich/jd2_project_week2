package by.tut.mdcatalog.repository.connection;

import by.tut.mdcatalog.repository.ConnectionService;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ConnectionHandler {

    private static volatile Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (ConnectionHandler.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(ConnectionService.DB_URL, ConnectionService.USER, ConnectionService.PASSWORD);
                }
            }
        }
        return connection;
    }
}
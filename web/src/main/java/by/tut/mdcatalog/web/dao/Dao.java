package by.tut.mdcatalog.web.dao;

import by.tut.mdcatalog.repository.connection.ConnectionHandler;
import by.tut.mdcatalog.service.dto.DocumentDTO;
import by.tut.mdcatalog.web.DocumentController;
import by.tut.mdcatalog.web.impl.DocumentControllerImpl;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class Dao {

    private static volatile Dao dao;
    public DocumentController<DocumentDTO> model;

    private Dao() {
        model = new DocumentControllerImpl();
    }

    public static Dao getDao(){
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null) {
                    dao =new Dao();
                }
            }
        }
        return dao;
    }

    static boolean executeUpdate(String sql) throws SQLException {
        try (Connection connection = ConnectionHandler.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static int executeCreateAndGetId(String sql) throws SQLException {
        try (Connection connection = ConnectionHandler.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        }
        return -1;
    }
}

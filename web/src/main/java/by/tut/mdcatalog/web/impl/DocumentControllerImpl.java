package by.tut.mdcatalog.web.impl;

import by.tut.mdcatalog.repository.connection.ConnectionHandler;
import by.tut.mdcatalog.service.dto.DocumentDTO;
import by.tut.mdcatalog.web.DocumentController;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class DocumentControllerImpl implements DocumentController<DocumentDTO> {
    public boolean add(DocumentDTO model) throws SQLException {
        String sql = String.format(
                "INSERT INTO `models` (`description`) " +
                        "VALUES ('%s')",
                model.getDescription()
        );
        try (Connection connection = ConnectionHandler.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    model.setId(generatedKeys.getInt(1));
                }
                return true;
            }
        }
        return false;
    }

    public boolean delete(DocumentDTO description) throws SQLException {
        String sql = String.format(
                "DELETE FROM `models` WHERE `models`.`id` = %d",
                description.getId()
        );
        try (Connection connection = ConnectionHandler.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public DocumentDTO get(Long id) throws SQLException {
        String sql = String.format("SELECT `description` " +
                "FROM `models` WHERE id=%d", id);
        try (Connection connection = ConnectionHandler.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String description = resultSet.getString("description");
                return new DocumentDTO(id, description);
            } else
                return null;
        }
    }
}

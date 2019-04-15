package by.tut.mdcatalog;

import by.tut.mdcatalog.repository.connection.DatabaseInitializer;
import by.tut.mdcatalog.service.dto.DocumentDTO;
import by.tut.mdcatalog.repository.ConnectionService;
import by.tut.mdcatalog.web.config.AppConfig;
import by.tut.mdcatalog.web.dao.Dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) throws SQLException {

        try (Connection connection = DriverManager.getConnection(ConnectionService.URL, ConnectionService.USER, ConnectionService.PASSWORD)) {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
            context.register(AppConfig.class);
            context.refresh();

            Dao dto = context.getBean(Dao.class);
            Statement statement = connection.createStatement();
            DatabaseInitializer.createDatabase(statement);
            DocumentDTO model = context.getBean(DocumentDTO.class);

            model.setDescription("description of document #2");
            if (dto.model.add(model))
                logger.info("add: " + model);
            model = dto.model.get(model.getId());
            logger.info("get: " + model);
            if (dto.model.delete(model))
                logger.info("delete: " + model);
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }
}


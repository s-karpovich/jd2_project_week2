package by.tut.mdcatalog.repository.connection;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    @PostConstruct
    public static void createDatabase(Statement statement) throws SQLException {

        statement.executeUpdate("DROP SCHEMA IF EXISTS `skarpovich`");
        statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `skarpovich` DEFAULT CHARACTER SET utf8");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `skarpovich`.`models` (" +
                "  `id` INT NOT NULL AUTO_INCREMENT," +
                "  `description` VARCHAR(45) NULL," +
                "  PRIMARY KEY (`id`)," +
                "  UNIQUE INDEX `description_UNIQUE` (`description` ASC))" +
                "ENGINE = InnoDB;");

        statement.executeUpdate("INSERT INTO `skarpovich`.`models` (`id`, `description`) VALUES (DEFAULT, 'description');");
    }
}

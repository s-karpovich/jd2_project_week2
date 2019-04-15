package by.tut.mdcatalog.repository;

public interface ConnectionService {
    String URL = "jdbc:mysql://127.0.0.1:3306/" +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF-8";
    String DB_URL = "jdbc:mysql://127.0.0.1:3306/skarpovich?" +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF-8";
    String USER = "root";
    String PASSWORD = "";
}

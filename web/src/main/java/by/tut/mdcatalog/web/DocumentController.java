package by.tut.mdcatalog.web;

import java.sql.SQLException;

public interface DocumentController<DocumentDTO> {
    boolean add(DocumentDTO bean) throws SQLException;

    boolean delete(DocumentDTO bean) throws SQLException;

    DocumentDTO get(Long id) throws SQLException;
}


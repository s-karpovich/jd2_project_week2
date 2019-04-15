package by.tut.mdcatalog.service.dto;

import org.springframework.stereotype.Service;

@Service
public class DocumentDTO {
    private long id;
    private String description;

    public DocumentDTO() {
    }

    public DocumentDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

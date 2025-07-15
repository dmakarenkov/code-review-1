package com.dm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "documents")
public class DocumentEntity {
    @Id
    private UUID id = UUID.randomUUID();
    private String path;
    // ... other data

    public UUID getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

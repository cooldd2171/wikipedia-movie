package com.shourya.demo.persistance.document;

import org.springframework.data.annotation.Id;

public abstract class BaseDocumentStringID extends BaseDocument<String> {
    @Id
    private String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

}

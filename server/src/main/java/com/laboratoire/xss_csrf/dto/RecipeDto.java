package com.laboratoire.xss_csrf.dto;


import org.modelmapper.ModelMapper;
import com.laboratoire.xss_csrf.model.RecipeModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class RecipeDto {

    private UUID id;
    private String title;
    private String body;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

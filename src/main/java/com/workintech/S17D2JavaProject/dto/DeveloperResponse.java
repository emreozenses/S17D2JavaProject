package com.workintech.S17D2JavaProject.dto;

import com.workintech.S17D2JavaProject.model.Developer;

public class DeveloperResponse {

    private Developer developer;
    private String message;
    private Integer status;

    public DeveloperResponse(Developer developer, String message, Integer status) {
        this.developer = developer;
        this.message = message;
        this.status = status;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

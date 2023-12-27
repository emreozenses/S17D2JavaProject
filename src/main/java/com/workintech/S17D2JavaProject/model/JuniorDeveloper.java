package com.workintech.S17D2JavaProject.model;

public class JuniorDeveloper extends Developer{

    public JuniorDeveloper(Integer id, String name, Double salary) {
        super(id, name, salary, Experience.JUNIOR);
    }
}

package com.workintech.S17D2JavaProject.model;

public class SeniorDeveloper extends Developer{

    public SeniorDeveloper(Integer id, String name, Double salary) {
        super(id, name, salary, Experience.SENIOR);
    }
}

package com.workintech.S17D2JavaProject.model;

public class MidDeveloper extends Developer{

    public MidDeveloper(Integer id, String name, Double salary) {
        super(id, name, salary, Experience.MID);
    }
}

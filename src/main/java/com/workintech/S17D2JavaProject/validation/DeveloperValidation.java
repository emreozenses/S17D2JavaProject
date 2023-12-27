package com.workintech.S17D2JavaProject.validation;

import com.workintech.S17D2JavaProject.model.Developer;

import java.util.Map;

public class DeveloperValidation {

    public static boolean isDeveloperExist(Map<Integer, Developer> developers, Integer id){

        return developers.containsKey(id);
    }
}

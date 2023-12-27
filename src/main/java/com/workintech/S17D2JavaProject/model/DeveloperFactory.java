package com.workintech.S17D2JavaProject.model;

import com.workintech.S17D2JavaProject.tax.DeveloperTax;
import com.workintech.S17D2JavaProject.tax.Taxable;

public class DeveloperFactory {

    public static Developer createDeveloper(Developer developer, DeveloperTax tax){

        Developer createdDeveloper = null;
        switch (developer.getExperience()){
            case JUNIOR -> {
                createdDeveloper =  new JuniorDeveloper(developer.getId(), developer.getName(), (developer.getSalary()* (1-tax.getSimpleTaxRate())));
            }
            case MID -> {
                createdDeveloper =  new MidDeveloper(developer.getId(), developer.getName(), (developer.getSalary()* (1-tax.getMiddleTaxRate())));

            }
            case SENIOR -> {
                createdDeveloper =  new SeniorDeveloper(developer.getId(), developer.getName(), (developer.getSalary()* (1-tax.getUpperTaxRate())));
            }
        }
        return createdDeveloper;
    }
}

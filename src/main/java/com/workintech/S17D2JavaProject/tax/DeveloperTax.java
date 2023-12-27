package com.workintech.S17D2JavaProject.tax;

import org.springframework.stereotype.Component;

@Component
public class DeveloperTax implements Taxable{
    @Override
    public double getSimpleTaxRate() {
        return 0.25;
    }

    @Override
    public double getMiddleTaxRate() {
        return 0.35;
    }

    @Override
    public double getUpperTaxRate() {
        return 0.45;
    }
}

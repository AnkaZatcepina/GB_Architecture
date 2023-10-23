package com.anna.lesson3;

import java.awt.*;

public class Sedan extends Car {
    public Sedan(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(4);
    }

    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {
        if (motorOilChange != null){
            motorOilChange.motorOilChange();
        }
        if (checkGearbox != null){
            checkGearbox.checkGearbox(this.gearboxType);
        }
        if (checkHeadlights != null){
            checkHeadlights.checkHeadlights();
        }
    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }
}

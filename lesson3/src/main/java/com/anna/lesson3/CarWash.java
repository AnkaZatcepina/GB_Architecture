package com.anna.lesson3;

public class CarWash implements CarWashing{

    @Override
    public void wash(CarType carType) {
        System.out.println("Мойка машины");
    }
    
}

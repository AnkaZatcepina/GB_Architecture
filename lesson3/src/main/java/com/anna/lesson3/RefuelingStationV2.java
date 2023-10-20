package com.anna.lesson3;

public class RefuelingStationV2 implements Refueling {

    public void processCarFuel(FuelType fuelType) {
        /*switch (fuelType){
            case Diesel -> System.out.println("Заправка дизельным топливом");
            case Gasoline -> System.out.println("Заправка бензином");          
        }*/
        if (fuelType == FuelType.Diesel){
                System.out.println("Заправка дизельным топливом");
            }
            else if (fuelType == FuelType.Gasoline) {
                System.out.println("Заправка бензином");
            }
    }
    @Override
    public void fuel(FuelType fuelType) {
        processCarFuel(fuelType);
    }

}
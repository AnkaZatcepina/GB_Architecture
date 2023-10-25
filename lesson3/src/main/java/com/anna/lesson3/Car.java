package com.anna.lesson3;

import java.awt.*;

import com.anna.lesson3.maintenance.CheckGearbox;
import com.anna.lesson3.maintenance.CheckHeadlights;
import com.anna.lesson3.maintenance.MotorOilChange;

public abstract class Car {

    private Refueling refueling;
    private CarWashing carWashing;
    protected CheckGearbox checkGearbox;
    protected CheckHeadlights checkHeadlights;
    protected MotorOilChange motorOilChange;

    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
    }    
    
    public void setCarWash(CarWashing carWash) {
        this.carWashing = carWash;
    }

    public void setCheckGearbox(CheckGearbox checkGearbox) {
        this.checkGearbox = checkGearbox;
    }
    public void setCheckHeadlights(CheckHeadlights checkHeadlights) {
        this.checkHeadlights = checkHeadlights;
    }
    public void setMotorOilChange(MotorOilChange motorOilChange) {
             this.motorOilChange = motorOilChange;
    }

    /**
     * Заправить автомобиль
     */
    public void fuel() {
        if (refueling != null){
            refueling.fuel(fuelType);
        }
    }

    /**
     * Помыть автомобиль
     */
    public void wash() {
        if (carWashing != null){
            carWashing.wash(type);
        }
    }


    protected void setWheelsCount(int wheelsCount){
        this.wheelsCount = wheelsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    // Движение
    public abstract void movement();
    // Обслуживание
    public abstract void maintenance();
    // Переключение передач
    public abstract boolean gearShifting();
    // Включение фар
    public abstract boolean switchHeadlights();
    // Включение дворников
    public abstract boolean switchWipers();

    //region Конструкторы

    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    //endregion

    //region Поля

    // Марка автомобиля
    private String make;

    // Модель
    private String model;

    // Цвет
    private Color color;

    // Тип
    protected CarType type;

    // Число колес
    private int wheelsCount;

    // Тип топлива
    protected FuelType fuelType = FuelType.Diesel;

    // Тип коробки передач
    protected GearboxType gearboxType;

    // Объем двигателя
    private double engineCapacity;

    // Состояние противотуманных фар
    private boolean fogLights = false;

    //endregion



}

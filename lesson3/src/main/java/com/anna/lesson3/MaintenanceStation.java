package com.anna.lesson3;

import com.anna.lesson3.maintenance.CheckGearbox;
import com.anna.lesson3.maintenance.CheckHeadlights;
import com.anna.lesson3.maintenance.MotorOilChange;

public class MaintenanceStation implements CheckGearbox, CheckHeadlights, MotorOilChange{

    @Override
    public void motorOilChange() {
        System.out.println("Масло поменяли");
    }

    @Override
    public void checkHeadlights() {
        System.out.println("Фары проверили");
    }

    @Override
    public void checkGearbox(GearboxType gearboxType) {
        System.out.println("Коробка передач проверена");
    }
    
}

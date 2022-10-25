package org.example;

import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Car {
    private double tankFullness;
    private double fuelConsumptionPer100Km;
    private LocalDate lastTechnicalInspectionDate;

    public boolean isAbleToGo(){
        return tankFullness > 0;
    }
    public boolean isAllowedToDrive(){
        Period period = Period.between(lastTechnicalInspectionDate, LocalDate.now());
        return period.getYears() <= 2;
    }

    public double kilometersCarCanDrive(){
        Double numberOfKilometers = tankFullness / fuelConsumptionPer100Km * 100;
        //Округляємо до сотих
        return Math.round(numberOfKilometers * 100.0) / 100.0;
    }
}

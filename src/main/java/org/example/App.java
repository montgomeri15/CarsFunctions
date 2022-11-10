package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class  App {
    public static void main( String[] args ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate technicalInspectionDate = LocalDate.parse("28.01.2021", formatter);

        Car toyotaCorolla = Car.builder()
                .tankFullness(42.8)
                .fuelConsumptionPer100Km(12.4)
                .lastTechnicalInspectionDate(technicalInspectionDate)
                .build();
        System.out.println(toyotaCorolla);

        System.out.println(toyotaCorolla.isAbleToGo());
        System.out.println(toyotaCorolla.isAllowedToDrive());
        System.out.println(toyotaCorolla.kilometersCarCanDrive());
    }
}

package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppTest {
    @Test
    public void shouldCreateCar(){
        //given
        double tankFullness = 50.2;
        double fuelConsumptionPer100Km = 11.5;
        LocalDate lastTechnicalInspectionDate = LocalDate.now();

        //when
        Car car = new Car(tankFullness, fuelConsumptionPer100Km, lastTechnicalInspectionDate);

        //then
        assertEquals(50.2, car.getTankFullness());
        assertEquals(11.5, car.getFuelConsumptionPer100Km());
        assertEquals(LocalDate.now(), car.getLastTechnicalInspectionDate());
    }

    @Test
    public void shouldBeAbleToGo(){
        //given
        double tankFullness = 20.5;
        double fuelConsumptionPer100Km = 11.5;
        LocalDate lastTechnicalInspectionDate = LocalDate.now();

        //when
        Car car = new Car(tankFullness, fuelConsumptionPer100Km, lastTechnicalInspectionDate);

        //then
        assertEquals(true, car.isAbleToGo());
    }

    @Test
    public void shouldNotBeAbleToGo(){
        //given
        double tankFullness = 0;
        double fuelConsumptionPer100Km = 11.5;
        LocalDate lastTechnicalInspectionDate = LocalDate.now();

        //when
        Car car = new Car(tankFullness, fuelConsumptionPer100Km, lastTechnicalInspectionDate);

        //then
        assertEquals(false, car.isAbleToGo());
    }

    @Test
    public void shouldBeAllowedToDrive(){
        //given
        double tankFullness = 20.5;
        double fuelConsumptionPer100Km = 11.5;
        LocalDate lastTechnicalInspectionDate = LocalDate.now();

        //when
        Car car = new Car(tankFullness, fuelConsumptionPer100Km, lastTechnicalInspectionDate);

        //then
        assertEquals(true, car.isAllowedToDrive());
    }

    @Test
    public void shouldNotBeAllowedToDrive(){
        //given
        double tankFullness = 20.5;
        double fuelConsumptionPer100Km = 11.5;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate technicalInspectionDate = LocalDate.parse("28.01.2019", formatter);
        LocalDate lastTechnicalInspectionDate = technicalInspectionDate;

        //when
        Car car = new Car(tankFullness, fuelConsumptionPer100Km, lastTechnicalInspectionDate);

        //then
        assertEquals(false, car.isAllowedToDrive());
    }

    @Test
    public void tenKilometersCarCanDrive(){
        //given
        double tankFullness = 1.5;
        double fuelConsumptionPer100Km = 15;
        LocalDate lastTechnicalInspectionDate = LocalDate.now();

        //when
        Car car = new Car(tankFullness, fuelConsumptionPer100Km, lastTechnicalInspectionDate);

        //then
        assertEquals(10, car.kilometersCarCanDrive());
    }
}

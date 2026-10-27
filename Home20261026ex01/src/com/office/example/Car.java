package com.office.example;

public class Car {
    private String carColor;
    private final String carNumber;

    public Car(String carColor, String carNumber) {
        this.carColor = carColor;
        this.carNumber = carNumber;
    }

    public String getCarColor() { return carColor; }
    public String getCarNumber() { return carNumber; }

    public void setCarColor(String carColor) {   // 도색
        this.carColor = carColor;
    }

    public void printCarInfo() {
        System.out.println("Car Color: " + carColor);
        System.out.println("Car Number: " + carNumber);
    }
}
package com.office.example;

public class Student {
    private String name;
    private int age;
    private Car car;

    public Student(String name, int age) {
        this(name, age, null);
    }

    public Student(String name, int age, Car car) {
        this.name = name;
        setAge(age);
        this.car = car;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public Car getCar() { return car; }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("나이는 0 이상이어야 합니다.");
            return;
        }
        this.age = age;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        if (car != null) {
            car.printCarInfo();
        } else {
            System.out.println("보유 차량 없음");
        }
    }
}
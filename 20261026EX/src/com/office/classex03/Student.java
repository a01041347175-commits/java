package com.office.classex03;

public class Student {
	// 속성
	String name;
	int age;
	Car car;
	
	// 생성자
	public Student(String name, int age, Car car) {
		this.name = name;
		this.age = age;
		this.car = car;
	}
	
	// 기능
	public void printInfo() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		car.printCarInfo();
	}
	
}

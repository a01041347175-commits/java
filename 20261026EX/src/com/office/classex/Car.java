package com.office.classex;

public class Car {
	
	// 속성(색상, 전장, 배기량)
	String color = "Black";
	double size = 5.2;
	int displacement = 2000;
	
	// 생성자
	public Car() {
		System.out.println("Car CONSTRUCTOR CALLED");
	}
	
	//기능(전진, 후진, 정지)(함수 == 메서드)
	public void drive() {
		System.out.println("drive() CALLED");
	}
	
	public void parking() {
		System.out.println("parking() CALLED");
	}
	
	public void stop() {
		System.out.println("stop() CALLED");
	}
	
	public void callAllMethod() {
		drive();
		parking();
		stop();
	}
	
	
}

package com.office.classex04;

public class Car {
	
	// 멤버필드
	String color;
	int length;
	int price;
	int displacement;
	
	// 생성자
	public Car() {
		System.out.println("---- constructor ----");
	}

	public Car(
			String color, 
			int length, 
			int price, 
			int displacement) {	
		this.color = color;
		this.length = length;
		this.price = price;
		this.displacement = displacement;
	}
	
	// 메서드
	// int speed : 매개 변수, parameter
	public void goForward(int speed) {
		System.out.println("---- goForward() method ----");
		System.out.println(speed + "km/h");
		
	}
	
	public void goBack() {
		System.out.println("---- goBack() method ----");
		
	}
	
	public void doTest() {
		goForward(30);	// == this.goForward();
		goBack();		// == this.goBack();
	}
	
}

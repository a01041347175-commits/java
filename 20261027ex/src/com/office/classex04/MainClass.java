package com.office.classex04;

public class MainClass {

	public void printHello() {
		System.out.println("Hello");
	}
	
	public static void main(String[] args) {
		
		Car car1 = new Car();
		car1.goForward(30); // 인수
		car1.goBack();
		car1.doTest();
		
		MainClass mainClass = new MainClass();
		mainClass.printHello();
		
	}

}

package com.office.classex;

public class MainClass {

	public static void main(String[] args) {
		
		Car car1 = new Car();
		System.out.println(car1.color);
		System.out.println(car1.size);
		System.out.println(car1.displacement);
		
		car1.drive();
		car1.stop();
		car1.parking();
		
		car1.color = "Yellow";
		System.out.println("car1 color: " + car1.color);
		
		Car car2 = new Car();
		System.out.println("car2 color: " + car2.color);
		car2.color = "White";
		System.out.println("car2 color: " + car2.color);
		
		Car car3 = new Car();
		System.out.println("car3 color: " + car3.color);
		
		car3 = car2;
		System.out.println("car2 color: " + car2.color);
		System.out.println("car3 color: " + car3.color);
		
		car3 = null;
		System.out.println("car2 color: " + car2.color);
//		System.out.println("car3 color: " + car3.color); // 출력불가(데이터 삭제)
		
		car1.callAllMethod();
		
	}

}

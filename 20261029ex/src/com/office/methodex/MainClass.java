package com.office.methodex;

public class MainClass {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		int rst = calculator.addOperator(10, 20);
//		System.out.println("rst: " + rst);
		
		// calculator를 이용해서 자동차를 하나 생성
		Object myCar = calculator.productCar();
		

	}

}

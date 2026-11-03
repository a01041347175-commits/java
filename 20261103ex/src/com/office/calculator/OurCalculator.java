package com.office.calculator;

public class OurCalculator {

	public void calculate(int n1, int n2, ICalculator iCalculator) {
		
		int result = iCalculator.doOperator(n1, n2);
		System.out.println("result: " + result);
		
	}
	/*
	// 덧셈
	public void calAdd(int n1, int n2) {
		//int result = n1 + n2;
		ICalculator iCalculator = new CalAdd();
		int result = iCalculator.doOperator(n1, n2);
		//int result = calAdd.calAdd(n1, n2);
		System.out.println("result: " + result);
	}
	
	// 뺄셈
	public void calSub(int n1, int n2) {
		//int result = n1 - n2;
		ICalculator iCalculator = new CalSub();
		int result = iCalculator.doOperator(n1, n2);
		//int result = calSub.calSub(n1, n2);
		System.out.println("result: " + result);
	}
	
	// 곱셈
	public void calMul(int n1, int n2) {
		//int result = n1 * n2;
		ICalculator iCalculator = new CalMul();
		int result = iCalculator.doOperator(n1, n2);
		//int result = calMul.calMul(n1, n2);
		System.out.println("result: " + result);
	}
	
	// 나눗셈
	public void calDiv(int n1, int n2) {
		//float result = (float)n1 / n2;
		ICalculator iCalculator = new CalDiv();
		int result = iCalculator.doOperator(n1, n2);
		//float result = calDiv.calDiv(n1, n2);
		System.out.println("result: " + result);
	}
	*/
}

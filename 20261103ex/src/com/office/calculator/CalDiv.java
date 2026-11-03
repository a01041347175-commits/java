package com.office.calculator;

public class CalDiv implements ICalculator {

	// 나눗셈
//	private int calDiv(int n1, int n2) {
//		int result = n1 / n2;
//		return result;
//		
//	}

	@Override
	public int doOperator(int n1, int n2) {
//		int result = calDiv(n1, n2);
		int result = (n1 / n2);
		return result;
	}
	
}

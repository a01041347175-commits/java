package com.office.calculator;

public class CalMul implements ICalculator {

	// 곱셈
//	private int calMul(int n1, int n2) {
//		int result = n1 * n2;
//		return result;
//	}

	@Override
	public int doOperator(int n1, int n2) {
//		int result = calMul(n1, n2);
		int result = (n1 * n2);
		return result;
	}
	
}

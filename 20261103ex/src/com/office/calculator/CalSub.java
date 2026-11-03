package com.office.calculator;

public class CalSub implements ICalculator {

	// 뺄셈
//	private int calSub(int n1, int n2) {
//		int result = n1 - n2;
//		return result;
//	}

	@Override
	public int doOperator(int n1, int n2) {
//		int result = calSub(n1, n2);
		int result = (n1 - n2);
		return result;
	}
	
}

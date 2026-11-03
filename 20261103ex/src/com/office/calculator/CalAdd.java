package com.office.calculator;

public class CalAdd implements ICalculator {

	// 덧셈
//	private int calAdd(int n1, int n2) {
//		int result = n1 + n2;
//		return result;
//		
//	}

	@Override
	public int doOperator(int n1, int n2) {
		//int result = calAdd(n1, n2);
		int result = (n1 + n2);
		return result;
	}
	
}

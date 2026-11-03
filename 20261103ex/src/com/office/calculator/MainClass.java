package com.office.calculator;

public class MainClass {

	public static void main(String[] args) {
		
		OurCalculator ourCalculator = new OurCalculator();
		/*
		ourCalculator.calAdd(20, 10);
		ourCalculator.calSub(20, 10);
		ourCalculator.calMul(20, 10);
		ourCalculator.calDiv(20, 10);
		*/
		ourCalculator.calculate(20, 10, new CalAdd());
		ourCalculator.calculate(20, 10, new CalSub());
		ourCalculator.calculate(20, 10, new CalMul());
		ourCalculator.calculate(20, 10, new CalDiv());
	}

}
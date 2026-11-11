package com.office.exception;

public class MainClass {

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 0;

		System.out.println("num1 + num2 = " + (num1 + num2));		// 10
		
		//예외처리 try ~ catch문
		try {
			System.out.println("num1 / num2 = " + (num1 / num2));	// exception
			
			System.out.println("++++++++++++++++++");
			
		} catch (NullPointerException e) {
			// System.out.println(e.getMessage());
			e.printStackTrace();
			
		} catch (ArithmeticException e) {
			System.out.println("FIRE ArithmeticException");
			e.printStackTrace();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		} finally {													// 예외에 상관없이 무조건 실행(필요에 따라 사용)
			System.out.println("Finally");
			
		}
		
		System.out.println("num1 - num2 = " + (num1 - num2));		// 10
		System.out.println("num1 * num2 = " + (num1 * num2));		// 0
		
		
		
	}
	
}

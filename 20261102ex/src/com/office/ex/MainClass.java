package com.office.ex;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 상속(inheritance)
		 * 부모클래스가 자손클래스에게 멤버를 물려주는 것
		 */
		
		ChildClass childClass = new ChildClass();
		
		System.out.println(childClass.name);
		childClass.printInfo();

	}

}

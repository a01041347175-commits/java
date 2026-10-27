package com.office.classex01;

import java.util.Iterator;

public class MainClass {

	public static void main(String[] args) {
		
		Student student1 = new Student(
				"홍길동", 
				1, 
				20, 
				"Computer");	
		Student student2 = new Student(
				"박찬호", 
				2, 
				21, 
				"Baseball");
		Student student3 = new Student(
				"박세리", 
				3, 
				22, 
				"Golf");
		
		student1.printInfo();
		student2.printInfo();
		student3.printInfo();
		
		// 배열
		/*
		 * 데이터 타입 [] 레퍼런스 변수 = {아이템, 아이템, 아이템, ....}
		 */
		Student[] students = {student1, student2, student3};
		for (int i = 0; i < students.length; i++) {
			students[i].printInfo();
		}
		
		// 전공이 Baseball인 학생의 이름과 나이를 출력
		// 1. 전공이 Baseball인 학생
		// 2. 이름과 나이 출력
		System.out.println("-------------------");
		for (int i = 0; i < students.length; i++) {
			System.out.println("i: " + i);
			if (students[i].major.equals("Baseball")) {
				System.out.println("Name: " + students[i].name + ", " + "Age: " + students[i].age);
				break;	
			}
		}
		
		
	}
}

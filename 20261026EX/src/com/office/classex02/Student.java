package com.office.classex02;

public class Student {

	// 속성
	String name;
	int grade;
	int age;
	String major;
	
	// 생성자
	public Student(String name, int grade, int age, String major) {
		System.out.println("---- Constructor ----");
		
		this.name = name;
		this.grade = grade;
		this.age = age;
		this.major = major;
		
	}
	
	// 기능(메서드)
	public void printInfo() {
		System.out.println("Name: " + name);
		System.out.println("Grade: " + grade);
		System.out.println("Age: " + age);
		System.out.println("Major: " + major);
	}
	
}

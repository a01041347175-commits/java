package com.office.classex02;

public class MainClass {

	public static void main(String[] args) {
		
		Student student1 = new Student("홍길동", 1, 20, "Computer");
		Student student2 = new Student("박찬호", 2, 21, "Sports");
		
//		System.out.println("name: " + student1.name);
//		System.out.println("grade: " + student1.grade);
//		System.out.println("age: " + student1.age);
//		System.out.println("major: " + student1.major);
		
		System.out.println();
		student1.printInfo();
		
		System.out.println();
		student2.printInfo();
		
		System.out.println();
		Student student3 = new Student("박세리", 3, 22, "Sports");
		student3.printInfo();
		
		
		
	}

}

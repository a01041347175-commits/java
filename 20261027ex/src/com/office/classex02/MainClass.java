package com.office.classex02;

public class MainClass {

	public static void main(String[] args) {
		
		NewStudentClass newstudent1 = new NewStudentClass(1, 1, 5, "박찬호", false);
		NewStudentClass newstudent2 = new NewStudentClass(1, 2, 8, "박지성", false);
		
		newstudent1.printInfo();
		newstudent2.printInfo();
		
		NewStudentClass newstudent3 = new NewStudentClass(2, 8, "박세리");		
		newstudent3.printInfo();
		
		NewStudentClass newstudent4 = new NewStudentClass(2, 7, 9, "김수지");
		newstudent4.printInfo();
		
		NewStudentClass newstudent5 = new NewStudentClass(5, 4, "김연경");
		newstudent5.printInfo();
		
		NewStudentClass newstudent6 = new NewStudentClass();
		
	}

}

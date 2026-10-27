package com.office.classex02;

public class NewStudentClass {

	// 멤버필드
	int grade = 1;				// 학년
	int classNo;				// 반번호
	int studentNo;				// 학생 개인 번호
	String studentName;			// 학생 이름
	boolean absence = false;	// 휴학구분(true: 휴학, false: 재학)
	
	
	
	/*
	 * 생성자 오버로딩이란, 생성자가 과적(넘침)했다는 의미.
	 */
	
	// 생성자
	public NewStudentClass() {
		System.out.println("^^");
	}
	
	public NewStudentClass(int grade, int classNo, int studentNo, String studentName, boolean absence) {
		this.grade = grade;
		this.classNo = classNo;
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.absence = absence;
	}
	
	public NewStudentClass(int grade, int classNo, int studentNo, String studentName) {
		this.grade = grade;
		this.classNo = classNo;
		this.studentNo = studentNo;
		this.studentName = studentName;
	}

	public NewStudentClass(int classNo, int studentNo, String studentName) {
		this.classNo = classNo;
		this.studentNo = studentNo;
		this.studentName = studentName;
	}

	public NewStudentClass(int classNo, int studentNo, String studentName, boolean absence) {
		this.classNo = classNo;
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.absence = absence;
	}

	// 메서드
	public void printInfo() {
		System.out.println("학년: " + grade);
		System.out.println("반번호: " + classNo);
		System.out.println("학생 개인 번호: " + studentNo);
		System.out.println("학생 이름: " + studentName);
		System.out.println("휴학구분: " + absence);
	}



	
	
}

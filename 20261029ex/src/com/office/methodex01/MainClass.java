package com.office.methodex01;

public class MainClass {

	public static void main(String[] args) {
		
		// 메서드 오버로딩(과적) : 메서드가 여러개 선언된 것
		/*
		Greet greet = new Greet();
		greet.printGreetWord();
		greet.printGreetWord("홍길동");
		*/
		// 요구사항 변경 : 고객이름 + 안녕하세요.
		// 요구사항 : 모르는 사람 (안녕하세요)
		
		/*
		AddOperator addOperator = new AddOperator();
		
		addOperator.add(10, 20);
		
		addOperator.add(1.5f, 2.5f);
		
		addOperator.add(3.14, 9.8);
		
		addOperator.add("Hello", " World");
		*/
		
		Score score = new Score();
		score.printStudentScore(90, 80, 70);
		score.printStudentScore(90, 80, 70, 100, 90);
		score.printStudentScore(90, 80, 70, 100);
		
	}

}

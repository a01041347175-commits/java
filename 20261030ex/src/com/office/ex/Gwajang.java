package com.office.ex;

// 과장
public class Gwajang {

	// 속성
	public String name = "Kim Gwajang";
	private int money;
	
	// 생성자
	public Gwajang() {
		money = 2000000;
	}
	
	// 메서드
	public void pay() {
		System.out.println(name + "님. 노고에 감사드립니다.");
		System.out.println(money + "원 지급완료");
	}
	
	
	
}

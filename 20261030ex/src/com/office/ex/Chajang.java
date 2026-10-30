package com.office.ex;

// 차장
public class Chajang {

	// 속성
	public String name = "Kim Chajang";
	private int money;
		
	// 생성자
	public Chajang() {
		money = 3000000;
	}
		
	// 메서드
	public void pay() {
		System.out.println(name + "님. 노고에 감사드립니다.");
		System.out.println(money + "원 지급완료");
	}
	
}

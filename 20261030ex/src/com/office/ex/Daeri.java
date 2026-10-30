package com.office.ex;

// 대리
public class Daeri {

	// 속성
	public String name = "Kim Daeri";
	private int money;
	
	// 생성자
	public Daeri() {
		money = 1000000;
	}
	
	// 메서드
	public void pay() {
		System.out.println(name + "님 노고에 감사드립니다.");
		System.out.println(money + "원 지급완료.");
	}
	/*
	public void setMoney(int money, String ceoPW) {
		if (ceoPW.equals("1234")) {
			this.money = money;
		}
	}
	
	public int getMoney() {
		return this.money;
	}
	*/

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money, String ceoPW) {
		if (ceoPW.equals("1234")) {
			this.money = money;
		}
	}
	
	
	
}

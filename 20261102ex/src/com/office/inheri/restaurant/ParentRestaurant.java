package com.office.inheri.restaurant;

public abstract class ParentRestaurant {

	// 메서드
	public void makeJajang() {
		System.out.println("부모 자장면 만듦");
	}
	
	public void makeJamppong() {
		System.out.println("부모 짬뽕 만듦");
	}
	
	// 탕수육 기술 필수 학습
	public abstract void makeTangsuyuk();
	
}

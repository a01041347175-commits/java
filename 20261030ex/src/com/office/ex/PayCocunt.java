package com.office.ex;


// 싱글턴 클래스로 만들자
public class PayCocunt {

	// 속성
	private static PayCocunt payCount = null;
	private int cnt = 0;
	
	
	// 생성자
	private PayCocunt() {
	
		
		
	}
	
	// 메서드
	public static PayCocunt getPayCountInstance() {
		if (payCount == null ) {
			payCount = new PayCocunt();
		}
		return payCount;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt() {
		this.cnt++;
	}
	
}

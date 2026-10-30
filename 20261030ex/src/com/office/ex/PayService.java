package com.office.ex;

// 월급 지급 업무 처리
// 누적 급여 지급 횟수 관리
public class PayService {

	Daeri daeri;
	Gwajang gwajang;
	Chajang chajang;
	
	public PayService() {
		daeri = new Daeri();
		gwajang = new Gwajang();
		chajang = new Chajang();
		
		// daeri.money = 0;
		daeri.setMoney(1200000, "1234");
		
		System.out.println("김대리 월급: " + daeri.getMoney());
			
	}
	
	public void pay (int month) {
		
		daeri.pay();
		gwajang.pay();
		chajang.pay();
		
		System.out.println(month + "월 급여 지급 완료.");
		
		PayCocunt.getPayCountInstance().setCnt();
		
		// 누적 급여 횟수 출력
		int cnt = PayCocunt.getPayCountInstance().getCnt();
		System.out.println("누적 급여 횟수: " + cnt);
		
	}
	
}

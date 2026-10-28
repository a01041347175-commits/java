package com.office.member;

public class MemberDumy {
	
	// 속성
	MemberDB db;
	
	// 생성자
	public MemberDumy(MemberDB memberDB) {
		this.db = memberDB;
	}
	
	// 메서드
	public void initMemberDumyData() {
		System.out.println("[MemeberDumy] initMemberDumyData");
		// ID, PW, MAIL, PHONE
		String[] memberIDs = {"gildong", "chanho", "saeri"};
		String[] memberPWs = {"1234", "5678", "0000"};
		String[] memberMAILs = {"gildong@gmail.com", "chanho@naver.com", "saeri@daum.net"};
		String[] memberPHONEs = {"010-1234-5678", "010-1111-2222", "010-3333-4444"};
		
		for (int i = 0; i < memberIDs.length; i++) {
			
			Member member = new Member(memberIDs[i], memberPWs[i], memberMAILs[i], memberPHONEs[i]);
			db.memberDB.put(memberIDs[i], member);
			
		}
		
	}
	
}

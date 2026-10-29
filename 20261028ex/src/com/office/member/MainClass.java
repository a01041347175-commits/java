package com.office.member;

import java.util.HashMap;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
//		Flag flag = new Flag();
		boolean systemFlag = true;
		Config config = new Config();
		
		MemberDB memberDB = new MemberDB();
		MemberService memberService = new MemberService(memberDB);
		
		if (config.IS_DEV_MODE) {
			MemberDumy memberDumy = new MemberDumy(memberDB);
			memberDumy.initMemberDumyData();
		} else {
			System.out.println("배포버젼_No dumy data");
		}
		/*
		 * 과제1 : 데이터초기화는 개발환경과 실환경으로 구분하라. (해결)
		 */
		
		while (systemFlag) {
			
			System.out.println("1. SIGN-UP    2. SIGN-IN    3. MODIFY    4. DELETE    5. PRINT-ALL-MEMBER    99. SYSTEM-OUT");
			int selectedMenu = scanner.nextInt();
			
			switch (selectedMenu) {
			case Menu.SIGN_UP:				//SIGN-UP
				// memberService = new MemberService();
				memberService.doSignUp(scanner);
				break;
				
			case Menu.SIGN_IN:				// SIGN-IN
				// memberService = new MemberService();
				memberService.doSignIn(scanner);
				
				if (memberService.signInFailCount > 3) {
					systemFlag = false;
					System.out.println("PW ERROR, SIGN-IN FAIL");
				}
				break;
				
			case Menu.MODIFY:				// MODIFY
				memberService.doModify(scanner);
				break;
		
			case Menu.DELETE:				// DELETE
				memberService.doDelete(scanner);
				break;
				
			case Menu.PRINT_ALL_MEMBER:		// ALL-MEMBER
				HashMap<String, Member> db =  memberDB.memberDB;
				
				for(String key : db.keySet()) {
					Member member = db.get(key);
					System.out.println(member.memberId);
					System.out.println(member.memberPw);
					System.out.println(member.memberMail);
					System.out.println(member.memberPhone);
				}
				
				for (Member member : db.values()) {
					System.out.println(member.memberId);
					System.out.println(member.memberPw);
					System.out.println(member.memberMail);
					System.out.println(member.memberPhone);
				}
				
			case Menu.SYSTEM_OUT:			// SYSTEM-OUT
				systemFlag = false;
				System.out.println("Say Goodbye");
				break;	
				
				/*
				 * 과제2 : case에 사용되는 리터럴상수를 상수로 변경 (해결)
				 * 과제3 : 5번 메뉴를 만들어서 -> 전체 회원 정보 출력 기능 구현 (해결)
				 */
			
			}
			
		}
		
		scanner.close();
		

	}

}

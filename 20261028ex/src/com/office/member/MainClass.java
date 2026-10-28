package com.office.member;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		final int SIGN_UP = 1;
		final int SIGN_IN = 2;
		final int MODIFY = 3;
		final int DELETE = 4;
		final int SYSTEM_OUT = 99;
		
		Scanner scanner = new Scanner(System.in);
		boolean systemFlag = true;
		boolean isDevMode = true;
		
		MemberDB memberDB = new MemberDB();
		MemberService memberService = new MemberService(memberDB);
		
		if (isDevMode) {
			MemberDumy memberDumy = new MemberDumy(memberDB);
			memberDumy.initMemberDumyData();
		} else {
			System.out.println("배포버젼_No dumy data");
		}
		/*
		 * 과제1 : 데이터초기화는 개발환경과 실환경으로 구분하라. (해결)
		 */
		
		while (systemFlag) {
			
			System.out.println("1. SIGN-UP    2. SIGN-IN    3. MODIFY    5. DELETE    99. SYSTEM-OUT");
			int selectedMenu = scanner.nextInt();
			
			switch (selectedMenu) {
			case SIGN_UP:				//SIGN-UP
				// memberService = new MemberService();
				memberService.doSignUp(scanner);
				break;
				
			case SIGN_IN:				// SIGN-IN
				// memberService = new MemberService();
				memberService.doSignIn(scanner);
				
				if (memberService.signInFailCount > 3) {
					systemFlag = false;
					System.out.println("PW ERROR, SIGN-IN FAIL");
				}
				break;
				
			case MODIFY:				// MODIFY
				memberService.doModify(scanner);
				break;
		
			case DELETE:				// DELETE
				memberService.doDelete(scanner);
				break;
				
			case SYSTEM_OUT:			// SYSTEM-OUT
				systemFlag = false;
				System.out.println("Say Goodbye");
				break;	
				
				/*
				 * 과제2 : case에 사용되는 리터럴상수를 상수로 변경 (해결)
				 * 과제3 : 5번 메뉴를 만들어서 -> 전체 회원 정보 출력 기능 구현
				 */
			
			}
			
		}
		
		scanner.close();
		

	}

}

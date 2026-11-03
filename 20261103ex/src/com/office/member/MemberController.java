package com.office.member;

import java.util.Scanner;

public class MemberController implements MemberConfig {

	public void execute() {
		
		Scanner scanner = new Scanner(System.in);
		boolean systemFlag = true;
		
		MemberService memberService = new MemberService();
		
		while (systemFlag) {
			System.out.println("1.SIGN-UP    2.SIGN-IN    3.MODIFY    4.DELETE    99.SYSTEM-OUT");
			int selectedMenuNum = scanner.nextInt();
			
			switch (selectedMenuNum) {
			case SIGN_UP:
				memberService.signUp(scanner);
				break;
				
			case SIGN_IN:
				memberService.signIn(scanner);
				break;
				
			case MODIFY:
				memberService.modify(scanner);
				break;
				
			case DELETE:
				memberService.delete(scanner);
				break;
				
			case SYSTEM_OUT:
				systemFlag = false;
				System.out.println("good bye");
				break;
			}
		}
		
		scanner.close();
		
	}
	
}

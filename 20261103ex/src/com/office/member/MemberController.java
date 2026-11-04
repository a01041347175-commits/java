package com.office.member;

import java.util.Scanner;

public class MemberController implements MemberConfig {

	public void execute() {
		
		Scanner scanner = new Scanner(System.in);
		boolean systemFlag = true;
		MemberService memberService = new MemberService();
		
		if (IS_DEV)
			new MemberDumy().signUpForDumy(memberService);
		
		String memId;
		String memPw;
		String memMail;
		String memPhone;
		MemberDto memberDto;
		
		while (systemFlag) {
			System.out.println("1.SIGN-UP    2.SIGN-IN    3.MODIYF    4.DELETE    99.SYSTEM-OUT");
			int selectedMenuNum = scanner.nextInt();
			
			switch (selectedMenuNum) {
			case SIGN_UP:
				
				System.out.println("Input new member ID!!");
				memId = scanner.next();
				
				System.out.println("Input new member PW!!");
				memPw = scanner.next();
				
				System.out.println("Input new member MAIL!!");
				memMail = scanner.next();
				
				System.out.println("Input new member Phone!!");
				memPhone = scanner.next();
				
				memberDto = new MemberDto(memId, memPw, memMail, memPhone);
				
				memberService.signUp(memberDto);
				
				break;
			case SIGN_IN:
				
				System.out.println("Input member ID!!");
				memId = scanner.next();
				
				System.out.println("Input member PW!!");
				memPw = scanner.next();
				
				memberDto = new MemberDto(memId, memPw, null);
				
				memberService.signIn(memberDto);	
				
				break;
			case MODIFY:
				memberService.modify();
				break;
			case DELETE:
				memberService.delete();
				break;
			case SYSTEM_OUT:
				systemFlag = false;
				System.out.println("good bye~");
				break;
			
			}
			
		}
		
		scanner.close();
		
	}
	
}
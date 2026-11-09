package com.office.member;

import java.util.Scanner;

import com.office.menu.Menu;
import com.office.session.Session;

public class MemberController {

	final private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
		
	}

	public void execute(Scanner scanner, int selectedMenu) {
		
		String memId;
		String memPw;
		String memMail;
		String memPhone;
		
		switch (selectedMenu) {
		case Menu.MEMBER_SIGN_UP:
			System.out.println("Input new member ID");
			memId = scanner.next();
			
			System.out.println("Input new member PW");
			memPw = scanner.next();
			
			System.out.println("Input new member MAIL");
			memMail = scanner.next();
			
			System.out.println("Input new member PHONE");
			memPhone = scanner.next();
			
			int resultForSignUp = memberService.signUp(
					new MemberDto(memId, memPw, memMail, memPhone));
			
			if (resultForSignUp == MemberService.SIGN_UP_SUCCESS) {
				System.out.println("SIGN-UP SUCCEESS");
				
			} else {
				System.out.println("SIGN-UP FAIL");
				
			}
			
			break;

		case Menu.MEMBER_SIGN_IN:
			
			System.out.println("Input member ID");
			memId = scanner.next();
			
			System.out.println("Input member PW");
			memPw = scanner.next();
			
			MemberDto signInedMemberDto = memberService.signIn(
													new MemberDto(memId, memPw, null, null));
			
			if (signInedMemberDto != null) {
				System.out.println("SIGN-IN SUCCESS");
				Session.getInstance().setAttribute(
						"signInedMemberId", 
						signInedMemberDto.getMemId());
				
			} else {
				System.out.println("SIGN-IN FAIL");
			}
			
			break;
			
		case Menu.MEMBER_SIGN_OUT:
			
			break;
			
		case Menu.MEMBER_MODIFY:
			
			break;
			
		case Menu.MEMBER_DELETE:
	
			break;
		}
		
	}
	
}

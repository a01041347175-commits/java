package com.office.member;

import java.util.Scanner;

import com.office.Container;
import com.office.config.Config;
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
			System.out.println("Input new member ID!!");
			memId = scanner.next();
			
			System.out.println("Input new member PW!!");
			memPw = scanner.next();
			
			System.out.println("Input new member MAIL!!");
			memMail = scanner.next();
			
			System.out.println("Input new member PHONE!!");
			memPhone = scanner.next();
			
			int resultForSignUp = memberService.signUp(
					new MemberDto(memId, memPw, memMail, memPhone)
					);
			
			if (resultForSignUp == MemberService.SIGN_UP_SUCCESS) {
				System.out.println("SIGN-UP SUCCESS!!");
				
			} else {
				System.out.println("SIGN-UP FAIL!!");
				
			}
			
			break;
			
		case Menu.MEMBER_SIGN_IN:
			System.out.println("Input member ID!!");
			memId = scanner.next();
			
			System.out.println("Input member PW!!");
			memPw = scanner.next();
			
			MemberDto signInedMember = memberService.signIn(new MemberDto(memId, memPw, null, null));
			
			if (signInedMember != null) {
				System.out.println("SIGN-IN SUCCESS!!");
				Session.getInstance().setAttribute(
						Config.SIGNINED_MEMBER_ID, 
						signInedMember.getMemId());
				
			} else {
				System.out.println("SIGN-IN FAIL!!");
				
			}
			
			
			break;
			
		case Menu.MEMBER_SIGN_OUT:
			Session.getInstance().removeAttribute(Config.SIGNINED_MEMBER_ID);
			System.out.println("SIGN-OUT SUCCESS!!");
			
			break;
			
		case Menu.MEMBER_MODIFY:
			System.out.println("Input member ID!!");
			memId = scanner.next();
			
			System.out.println("Input member PW!!");
			memPw = scanner.next();
			
			System.out.println("Input member MAIL!!");
			memMail = scanner.next();
			
			System.out.println("Input member PHONE!!");
			memPhone = scanner.next();
			
			int resultForModify = memberService.modify(new MemberDto(memId, memPw, memMail, memPhone));
			
			if (resultForModify == MemberService.MODIFY_SUCCESS) {
				System.out.println("MODIFY SUCCESS!!");
				
			} else {
				System.out.println("MODIFY FAIL!!");
				
			}
			
			break;
			
		case Menu.MEMBER_DELETE:
			System.out.println("Input member ID!!");
			memId = scanner.next();
			
			System.out.println("Input member PW!!");
			memPw = scanner.next();
			
			int resultForDelete = memberService.delete(new MemberDto(memId, memPw, null, null));	
			
			break;
			
		}
		
	}
	
}

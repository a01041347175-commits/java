package com.office.member;

import java.util.Scanner;

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
			memId = scanner.nextLine().trim();

			System.out.println("Input new member PW!! (min " + Config.MIN_PW_LENGTH + " characters)");
			memPw = scanner.nextLine().trim();

			System.out.println("Input new member MAIL!!");
			memMail = scanner.nextLine().trim();

			System.out.println("Input new member PHONE!!");
			memPhone = scanner.nextLine().trim();

			int resultForSignUp = memberService.signUp(
					new MemberDto(memId, memPw, memMail, memPhone)
					);

			switch (resultForSignUp) {
			case MemberService.SIGN_UP_SUCCESS:
				System.out.println("SIGN-UP SUCCESS!!");
				break;
			case MemberService.SIGN_UP_FAIL_EMPTY_ID:
				System.out.println("SIGN-UP FAIL!! (ID is required)");
				break;
			case MemberService.SIGN_UP_FAIL_DUPLICATED_ID:
				System.out.println("SIGN-UP FAIL!! (ID already exists)");
				break;
			case MemberService.SIGN_UP_FAIL_INVALID_PW:
				System.out.println("SIGN-UP FAIL!! (PW must be at least " + Config.MIN_PW_LENGTH + " characters)");
				break;
			default:
				System.out.println("SIGN-UP FAIL!!");

			}

			break;

		case Menu.MEMBER_SIGN_IN:
			System.out.println("Input member ID!!");
			memId = scanner.nextLine().trim();

			System.out.println("Input member PW!!");
			memPw = scanner.nextLine().trim();

			MemberDto signInedMember = memberService.signIn(new MemberDto(memId, memPw, null, null));

			if (signInedMember != null) {
				System.out.println("SIGN-IN SUCCESS!!");
				Session.getInstance().setAttribute(
						Config.SIGNINED_MEMBER_ID,
						signInedMember.getMemId());

			} else {
				System.out.println("SIGN-IN FAIL!! (check ID or PW)");

			}

			break;

		case Menu.MEMBER_SIGN_OUT:
			Session.getInstance().removeAttribute(Config.SIGNINED_MEMBER_ID);
			System.out.println("SIGN-OUT SUCCESS!!");

			break;

		case Menu.MEMBER_MODIFY:
			// 수정 대상 ID는 입력받지 않고 로그인한 회원 ID 사용 (다른 회원 정보 수정 방지)
			memId = Session.getInstance().getSignInedMemberId();
			System.out.println("MODIFY MEMBER : " + memId);

			System.out.println("Input current PW!!");
			String currentPw = scanner.nextLine().trim();

			System.out.println("Input new PW!! (min " + Config.MIN_PW_LENGTH + " characters)");
			memPw = scanner.nextLine().trim();

			System.out.println("Input new MAIL!!");
			memMail = scanner.nextLine().trim();

			System.out.println("Input new PHONE!!");
			memPhone = scanner.nextLine().trim();

			int resultForModify = memberService.modify(
					memId, currentPw, new MemberDto(memId, memPw, memMail, memPhone));

			switch (resultForModify) {
			case MemberService.MODIFY_SUCCESS:
				System.out.println("MODIFY SUCCESS!!");
				break;
			case MemberService.MODIFY_FAIL_WRONG_PW:
				System.out.println("MODIFY FAIL!! (wrong current PW)");
				break;
			case MemberService.MODIFY_FAIL_INVALID_PW:
				System.out.println("MODIFY FAIL!! (PW must be at least " + Config.MIN_PW_LENGTH + " characters)");
				break;
			default:
				System.out.println("MODIFY FAIL!!");

			}

			break;

		case Menu.MEMBER_DELETE:
			memId = Session.getInstance().getSignInedMemberId();
			System.out.println("DELETE MEMBER : " + memId);

			System.out.println("Input member PW!!");
			memPw = scanner.nextLine().trim();

			int resultForDelete = memberService.delete(memId, memPw);

			switch (resultForDelete) {
			case MemberService.DELETE_SUCCESS:
				// 탈퇴 후에는 로그아웃 처리
				Session.getInstance().removeAttribute(Config.SIGNINED_MEMBER_ID);
				System.out.println("DELETE SUCCESS!! Good bye " + memId + "~");
				break;
			case MemberService.DELETE_FAIL_WRONG_PW:
				System.out.println("DELETE FAIL!! (wrong PW)");
				break;
			default:
				System.out.println("DELETE FAIL!!");

			}

			break;

		}

	}

}

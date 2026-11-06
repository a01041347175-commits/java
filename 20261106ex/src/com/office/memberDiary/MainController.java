package com.office.memberDiary;

import java.util.Scanner;

public class MainController implements MemberConfig {

	final private MemberController membercontrller;
	final private MemberSession memberSession;
	
	public MainController(
			MemberController memberController, 
			MemberSession memSession) {
		this.membercontrller = memberController;
		this.memberSession = memSession;
	}
	
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		boolean systemFlag = true;
		
		while (systemFlag) {
			if (memberSession.isLogin()) {
				System.out.println("\n---로그인메뉴" + memberSession.getLogInMemId() + "---");
				
				System.out.println("3. 로그아웃    4. 정보수정    5. 회원탈퇴    6. 다이어리    99. 시스템아웃");
			} else {
				System.out.println("\n---메인메뉴---");
				System.out.println("1. 회원가입    2. 로그인    99. 시스템아웃");
			}
			
			System.out.print("메뉴선택");
			int selectedMenuNum = scanner.nextInt();
			scanner.nextLine();
			
			switch (selectedMenuNum) {
			case SIGN_UP:
				if (!memberSession.isLogin()) {
					membercontrller.signUp(scanner);
				} else {
					System.out.println("로그아웃 해주세요.");
				}
				break;
			case LOG_IN:
				if(!memberSession.isLogin()) {
					membercontrller.logIn(scanner);
				} else {
					System.out.println("이미 로그인 상태입니다.");
				}
				break;
			case LOG_OUT:
				if (memberSession.isLogin()) {
					membercontrller.logOut();
				} else {
					System.out.println("로그인 필요");
				}
				break;
			case MODIFY:
				if (memberSession.isLogin()) {
					membercontrller.modify(scanner);
				} else {
					System.out.println("로그인 필요");
				}
				break;
				
			case DELETE:
				if (memberSession.isLogin()) {
					membercontrller.delete(scanner);
				} else {
					System.out.println("로그인 필요");
				}
				break;
				
			case DIARY:
				if (memberSession.isLogin()) {
					diaryController.execute(scanner);
				} else {
					System.out.println("로그인 필요");
				}
				break;
				
			case SYSTEM_OUT:
				systemFlag = false;
				memberSession.logOut();
				System.out.println("프로그램 종료");
				break;
			
			}
		}
			
	
	scanner.close();
	}
	
	
	
}

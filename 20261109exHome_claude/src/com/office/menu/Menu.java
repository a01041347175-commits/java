package com.office.menu;

import com.office.session.Session;

public class Menu {

	final public static int MEMBER_SIGN_UP 		= 1;
	final public static int MEMBER_SIGN_IN 		= 2;
	final public static int MEMBER_SIGN_OUT 	= 3;
	final public static int MEMBER_MODIFY 		= 4;
	final public static int MEMBER_DELETE 		= 5;

	final public static int DIARY_WRITE 		= 6;
	final public static int DIARY_READ 			= 7;

	final public static int SYSTEM_OUT			= 99;

	public static void generateMenu() {

		 if (!Session.getInstance().isSignIned()) {
			 System.out.println("1.SIGN-UP    2.SIGN-IN    99.SYSTEM-OUT");

		 } else {
			 System.out.println("[" + Session.getInstance().getSignInedMemberId() + "] "
					 + "3.SIGN-OUT    4.MODIFY    5.DELETE    6.DIARY-WRITE    7.DIARY-READ    99.SYSTEM-OUT");

		 }

	 }

	/*
	 * 현재 로그인 상태에서 선택 가능한 메뉴인지 확인
	 * (화면에 보이지 않는 메뉴 번호를 직접 입력해도 실행되지 않도록 막는다)
	 */
	public static boolean isAvailable(int selectedMenu) {

		if (selectedMenu == SYSTEM_OUT)
			return true;

		if (!Session.getInstance().isSignIned()) {
			return selectedMenu == MEMBER_SIGN_UP
					|| selectedMenu == MEMBER_SIGN_IN;

		} else {
			return selectedMenu >= MEMBER_SIGN_OUT
					&& selectedMenu <= DIARY_READ;

		}

	}

}

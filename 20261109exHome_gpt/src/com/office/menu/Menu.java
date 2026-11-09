package com.office.menu;

import com.office.config.Config;
import com.office.session.Session;

public class Menu {
    public static final int MEMBER_SIGN_UP = 1, MEMBER_SIGN_IN = 2, MEMBER_SIGN_OUT = 3;
    public static final int MEMBER_MODIFY = 4, MEMBER_DELETE = 5;
    public static final int DIARY_WRITE = 6, DIARY_READ = 7, SYSTEM_OUT = 99;
    public static void generateMenu() {
        Object id = Session.getInstance().getAttribute(Config.SIGNINED_MEMBER_ID);
        System.out.println();
        if (id == null) System.out.println("1.회원가입  2.로그인  99.종료");
        else {
            System.out.println("로그인 회원: " + id);
            System.out.println("3.로그아웃  4.정보수정  5.탈퇴  6.일기작성  7.일기목록  99.종료");
        }
        System.out.print("메뉴 선택: ");
    }
}

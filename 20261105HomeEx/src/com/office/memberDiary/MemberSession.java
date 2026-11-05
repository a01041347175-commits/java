package com.office.memberDiary;

// 콘솔 프로그램에서 현재 로그인한 회원의 ID를 기억하는 싱글턴 객체입니다.
public class MemberSession {

    private static MemberSession memberSession;
    private String loginMemId;

    private MemberSession() { }

    public static MemberSession getInstance() {
        if (memberSession == null) {
            memberSession = new MemberSession();
        }
        return memberSession;
    }

    public boolean isLogin() {
        return loginMemId != null;
    }

    public String getLoginMemId() {
        return loginMemId;
    }

    public void setLoginMemId(String memId) {
        loginMemId = memId;
    }

    public void logOut() {
        loginMemId = null;
    }
}

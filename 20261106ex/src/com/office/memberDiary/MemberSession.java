package com.office.memberDiary;

public class MemberSession {

	private static MemberSession memberSession;
	private String logInMemId;
	
	private MemberSession() { }
	
	public static MemberSession getInstance() {
		if (memberSession == null) {
			memberSession = new MemberSession();
		}
		return memberSession;
	}
	
	public boolean isLogin() {
		return logInMemId !=  null;
		
	}
	
	public String getLogInMemId () {
		return logInMemId;
	}
	
	public void setLoginMemId(String memId) {
		logInMemId = memId;
	}
	
	public void logOut() {
		logInMemId = null;
	}

	public String getLoginMemId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

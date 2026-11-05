package com.office.member;

public class MainClass {

	public static void main(String[] args) {
		
//		new MemberController().execute();
		
//		MemberContainer memberContainer = MemberContainer.getInstance();
//		memberContainer.getMemberController().execute();
		
		MemberContainer.getInstance()
					   .getMemberController()
					   .execute();
		
	}
	
}
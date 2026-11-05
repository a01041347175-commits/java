package com.office.member;

public class MemberContainer {
	
	final private MemberDao memberDao = new MemberDao();
	final private MemberService memberService = new MemberService(memberDao);
	final private MemberController memberController = new MemberController(memberService);
	
	private static MemberContainer memberContainer;
	
	private MemberContainer() {}
	
	public static MemberContainer getInstance() {
		if (memberContainer == null) {
			memberContainer = new MemberContainer();
		}
		
		return memberContainer;
		
	}

	public MemberController getMemberController() {
		return memberController;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}
	
	
	
}

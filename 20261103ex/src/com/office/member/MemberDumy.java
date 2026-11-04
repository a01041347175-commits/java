package com.office.member;

public class MemberDumy {

	private String[] memIds = {"gildong", "chanho"};
	private String[] memPws = {"1234", "5678"};
	private String[] memMails = {"gildong@gmail.com", "chanho@naver.com"};
	private String[] memPhones = {"010-1234-5678", "010-0000-0000"};
	
	public void signUpForDumy(MemberService memberService) {
		
		for (int i = 0; i < memIds.length; i++) {
			MemberDto memberDto = 
					new MemberDto(
							memIds[i], 
							memPws[i], 
							memMails[i], 
							memPhones[i]);
			
			memberService.signUp(memberDto);
			
		}
		
	}

}
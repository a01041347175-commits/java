package com.office.member;

import com.office.config.Config;
import com.office.session.Session;

public class MemberService {

	final private MemberDao memberDao;
	
	final public static int SIGN_UP_FAIL 		= 0;
	final public static int SIGN_UP_SUCCESS 	= 1;
	
	final public static int MODIFY_FAIL 		= 0;
	final public static int MODIFY_SUCCESS 		= 1;
	
	final public static int DELETE_FAIL 		= 0;
	final public static int DELETE_SUCCESS 		= 1;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
		
	}

	public int singUp(MemberDto memberDto) {
		
		boolean isMember = memberDao.isMember(memberDto.getMemId());
		
		if (!isMember) {
			return memberDao.insertMember(memberDto);
			
		} else {
			return SIGN_UP_FAIL;
			
		}

	}

	public MemberDto signIn(MemberDto memberDto) {
		
		MemberDto selectedMemberDto =
				memberDao.selectMemberByMemId(memberDto.getMemId());
		
		if (selectedMemberDto != null 
				&& 
				selectedMemberDto.getMemPw().equals(memberDto.getMemPw())) {
			return selectedMemberDto;
			
		} else {
			return null;
			
		}
		
	}

	public MemberDto getMember() {
		
		return memberDao.selectMemberByMemId(
				String.valueOf(Session.getInstance().getAttribute(Config.SIGNINED_MEMBER_ID))  
				);
		
	}

	public int modify(MemberDto memberDto) {
		
		return memberDao.updateMember(memberDto);
		
	}

	public int delete(String memId) {
		
		return memberDao.deleteByMemId(memId);
		
	}
	
}








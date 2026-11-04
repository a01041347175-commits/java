package com.office.member;

import java.util.HashMap;

public class MemberDao {
	
	HashMap<String, MemberDto> db = new HashMap<String, MemberDto>();
	
	public boolean isMember(String memId) {
		
		MemberDto memberDto = db.get(memId);
		
		return memberDto != null ? true : false;
		
		
	}

	public int insertNewMember(MemberDto memberDto) {
		
		db.put(memberDto.getMemId(), memberDto);
		
		return db.get(memberDto.getMemId()) != null ? 1 : 0;
		
	}

	public MemberDto searchMemberByMemIdAndMemPw(MemberDto memberDto) {
		
		MemberDto dto = db.get(memberDto.getMemId());
		
		if (dto != null && dto.getMemPw().equals(memberDto.getMemPw())) {
			return dto;
			
		} else {
			return null;
			
		}
		
	}

}






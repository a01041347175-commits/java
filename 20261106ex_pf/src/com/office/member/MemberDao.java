package com.office.member;

import java.util.HashMap;

import com.office.db.DiaryDb;

public class MemberDao {

	final private DiaryDb diaryDb;
	
	public MemberDao(DiaryDb diaryDb) {
		this.diaryDb = diaryDb;
		
	}
	
	public boolean isMember(String memId) {
		HashMap<String, MemberDto> members = diaryDb.getMembers();
		MemberDto memberDto = members.get(memId);
		
		return memberDto != null ? true : false;
		
	}
	
	public int insertMember(MemberDto memberDto) {
		HashMap<String, MemberDto> members = diaryDb.getMembers();
		
		members.put(memberDto.getMemId(), memberDto);
		
		return members.get(memberDto.getMemId()) != null 
				? 
				MemberService.SIGN_UP_SUCCESS
				:
				MemberService.SIGN_UP_FAIL;
		
	}

	public MemberDto selectMemberByMemId(String memId) {
		HashMap<String, MemberDto> members = diaryDb.getMembers();
		
		return members.get(memId) != null ? members.get(memId) : null;
		
	}

	public int updateMember(MemberDto memberDto) {
		insertMember(memberDto);
		
		HashMap<String, MemberDto> members = diaryDb.getMembers();
		
		MemberDto updatedMember = members.get(memberDto.getMemId());
		
		if (updatedMember.getMemPw().equals(memberDto.getMemPw()) &&
			updatedMember.getMemMail().equals(memberDto.getMemMail()) && 
			updatedMember.getMemPhone().equals(memberDto.getMemPhone())) {
			return MemberService.MODIFY_SUCCESS;
			
		} else {
			return MemberService.MODIFY_FAIL;
			
		}
		
	}

	public int deleteMember(String memId) {
		HashMap<String, MemberDto> members = diaryDb.getMembers();
		
		MemberDto deletedMember = members.get(memId);
		
		return deletedMember == null 
				? 
				MemberService.DELETE_SUCCESS 
				: MemberService.DELETE_FAIL;
		
	}

}

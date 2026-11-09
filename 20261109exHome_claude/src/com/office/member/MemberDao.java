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

		return members.containsKey(memId);

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

		return members.get(memId);

	}

	public int updateMember(MemberDto memberDto) {
		HashMap<String, MemberDto> members = diaryDb.getMembers();

		// 존재하는 회원만 수정 (없는 회원이 새로 추가되지 않도록)
		if (!members.containsKey(memberDto.getMemId()))
			return MemberService.MODIFY_FAIL;

		members.put(memberDto.getMemId(), memberDto);

		return MemberService.MODIFY_SUCCESS;

	}

	public int deleteMember(String memId) {
		HashMap<String, MemberDto> members = diaryDb.getMembers();

		// get()이 아닌 remove()로 실제 삭제
		MemberDto deletedMember = members.remove(memId);

		return deletedMember != null
				?
				MemberService.DELETE_SUCCESS
				:
				MemberService.DELETE_FAIL;

	}

}

package com.office.member;

import com.office.config.Config;
import com.office.diary.DiaryDao;

public class MemberService {

	final private MemberDao memberDao;
	final private DiaryDao diaryDao;

	final public static int SIGN_UP_FAIL 				= 0;
	final public static int SIGN_UP_SUCCESS 			= 1;
	final public static int SIGN_UP_FAIL_DUPLICATED_ID 	= 2;
	final public static int SIGN_UP_FAIL_INVALID_PW 	= 3;
	final public static int SIGN_UP_FAIL_EMPTY_ID 		= 4;

	final public static int MODIFY_FAIL 				= 0;
	final public static int MODIFY_SUCCESS 				= 1;
	final public static int MODIFY_FAIL_WRONG_PW 		= 2;
	final public static int MODIFY_FAIL_INVALID_PW 		= 3;

	final public static int DELETE_FAIL 				= 0;
	final public static int DELETE_SUCCESS 				= 1;
	final public static int DELETE_FAIL_WRONG_PW 		= 2;

	public MemberService(MemberDao memberDao, DiaryDao diaryDao) {
		this.memberDao = memberDao;
		this.diaryDao = diaryDao;

	}

	/*
	 * 비밀번호 유효성 검사 (최소 4자리 이상)
	 */
	private boolean isValidPw(String memPw) {
		return memPw != null && memPw.length() >= Config.MIN_PW_LENGTH;

	}

	public int signUp(MemberDto memberDto) {

		if (memberDto.getMemId() == null || memberDto.getMemId().isEmpty())
			return SIGN_UP_FAIL_EMPTY_ID;

		if (memberDao.isMember(memberDto.getMemId()))
			return SIGN_UP_FAIL_DUPLICATED_ID;

		if (!isValidPw(memberDto.getMemPw()))
			return SIGN_UP_FAIL_INVALID_PW;

		return memberDao.insertMember(memberDto);

	}

	public MemberDto signIn(MemberDto memberDto) {

		MemberDto selectedMemberDto =
				memberDao.selectMemberByMemId(memberDto.getMemId());

		if (selectedMemberDto != null &&
				selectedMemberDto.getMemPw().equals(memberDto.getMemPw())) {
			return selectedMemberDto;

		} else {
			return null;

		}

	}

	/*
	 * 회원정보 수정
	 * memId  : 로그인한 회원 ID (세션에서 가져옴)
	 * currentPw : 본인 확인용 현재 비밀번호
	 * newMemberDto : 변경할 정보 (PW, MAIL, PHONE)
	 */
	public int modify(String memId, String currentPw, MemberDto newMemberDto) {

		if (memId == null)
			return MODIFY_FAIL;

		if (signIn(new MemberDto(memId, currentPw, null, null)) == null)
			return MODIFY_FAIL_WRONG_PW;

		if (!isValidPw(newMemberDto.getMemPw()))
			return MODIFY_FAIL_INVALID_PW;

		newMemberDto.setMemId(memId);

		return memberDao.updateMember(newMemberDto);

	}

	/*
	 * 회원탈퇴 : 회원 정보와 해당 회원의 일기를 모두 삭제
	 */
	public int delete(String memId, String memPw) {

		if (memId == null)
			return DELETE_FAIL;

		if (signIn(new MemberDto(memId, memPw, null, null)) == null)
			return DELETE_FAIL_WRONG_PW;

		diaryDao.deleteDiariesByMemId(memId);

		return memberDao.deleteMember(memId);

	}

}

package com.office.memberDiary;

import com.office.memberDiary.MemberDto;

public class MemberService implements IMemberService {

	final private MemberDao memberDao;
	final private DiaryDao diaryDao;
	final private MemberSession memberSession;
	
	public MemberService(
			MemberDao memberDao, 
			DiaryDao diaryDao, 
			MemberSession memberSession) {
		this.memberDao = memberDao;
		this.diaryDao = diaryDao;
		this.memberSession = memberSession;
	}

	@Override
	public void signUp(MemberDto memberDto) {
		
		if (memberDto.getMemId().trim().equals("")) {
			System.out.println("필수: 아이디를 입력하세요.");
			return;
		}
		
		if (memberDto.getMemPw().length() < 4) {
			System.out.println("필수: 비밀번호는 4자리 이상 입력하세요.");
			return;
		}
		
		if (memberDto.isMember(memberDto.getMemId())) {
			System.out.println("이미 존재하는 아이디입니다.");
			return;
		}
		int result = memberDao.insertNewMember(memberDto);
		if (result == 1) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
		
	}

	@Override
	public void logIn(MemberDto memberDto) {
		if (memberSession.isLogin()) {
			System.out.println("이미 로그인 상태");
			return;
		}
		
		if (!memberDao.isMember(memberDto.getMemId())) {
			System.out.println("로그인 실패(ID없음)");
			return;
		}
		
		MemberDto searchedMemberDto = memberDao.searchMemberByMemIdAndMemPw(memberDto);
		if (searchedMemberDto != null) {
			memberSession.setLoginMemId(searchedMemberDto.getMemId());
			System.out.println("로그인 성공");
		} else {
			System.out.println("비밀번호가 다릅니다.");
		}
		
	}

	@Override
	public void logOut(MemberDto memberDto) {
		if (memberSession.isLogin()) {
			System.out.println("로그인 상태가 아닙니다.");
			return;
		}
		memberSession.logOut();
		System.out.println("로그아웃 성공");
		
	}

	@Override
	public void modify(MemberDto memberDto) {
		if (memberSession.isLogin()) {
			System.out.println("로그인 필요");
			return;
		}
		
		if(!memberSession.getLogInMemId().equals(memberDto.getMemId())) {
			System.out.println("회원 정보 수정 실패");
			return;
		}
		
		if (memberDto.getMemPw().length() < 4) {
			System.out.println("비밀번호는 4자리 이상이어야 합니다.");
			return;
		}
		
		MemberDto updatedMemberDto = memberDao.updateMemberByMemId(memberDto);
		if (updatedMemberDto != null) {
			System.out.println("회원 정보 수정 성공");
		} else {
			System.out.println("회원 정보 수정 실패");
		}
		
	}

	@Override
	public void delete(MemberDto memberDto) {
		if (memberSession.isLogin()) {
			System.out.println("로그인 필요");
			return;
		}
		
		if (!memberSession.getLogInMemId().equals(memberDto.getMemId())) {
			System.out.println("회원 탈퇴 실패");
			return;
		}
		
		MemberDto deletedMemberDto = memberDao deleteMemberByMemIdAndMemPw(memberDto);
		if (deletedMemberDto != null) {
			diaryDao.deleteDiariesByMemId(memberDto.getMemId());
			memberSession.logOut();
			System.out.println("회원 탈퇴 완료");
		} else {
			System.out.println("회원 탈퇴 실패");
		}
		
		public boolean doAuthenticationByMemIdAndMemPw(MemberDto memberDto) {
	        if (!memberSession.isLogin()) {
	            return false;
	        }
	        if (!memberSession.getLoginMemId().equals(memberDto.getMemId())) {
	            return false;
	        }

	        MemberDto dto = memberDao.searchMemberByMemIdAndMemPw(memberDto);
	        return dto != null;
	    }
		
		
	}

	private void deleteMemberByMemIdAndMemPw(MemberDto memberDto) {
		// TODO Auto-generated method stub
		
	}

	public boolean doAuthenticationByMemIdAndMemPw(MemberDto authDto) {
		// TODO Auto-generated method stub
		return false;
	}

	public void logOut() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

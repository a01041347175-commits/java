package com.office.memberDiary;

public class MemberService implements IMemberService {

    final private MemberDao memberDao;
    final private DiaryDao diaryDao;
    final private MemberSession memberSession;

    public MemberService(MemberDao memberDao, DiaryDao diaryDao, MemberSession memberSession) {
        this.memberDao = memberDao;
        this.diaryDao = diaryDao;
        this.memberSession = memberSession;
    }

    @Override
    public void signUp(MemberDto memberDto) {
        if (memberDto.getMemId().trim().equals("")) {
            System.out.println("회원가입 실패: ID는 필수 입력입니다.");
            return;
        }

        if (memberDto.getMemPw().length() < 4) {
            System.out.println("회원가입 실패: 비밀번호는 4자리 이상이어야 합니다.");
            return;
        }

        if (memberDao.isMember(memberDto.getMemId())) {
            System.out.println("이미 존재하는 ID입니다.");
            return;
        }

        int result = memberDao.insertNewMember(memberDto);
        if (result == 1) {
            System.out.println("회원가입 성공!!");
        } else {
            System.out.println("회원가입 실패!!");
        }
    }

    @Override
    public void signIn(MemberDto memberDto) {
        if (memberSession.isLogin()) {
            System.out.println("이미 로그인한 상태입니다.");
            return;
        }

        if (!memberDao.isMember(memberDto.getMemId())) {
            System.out.println("로그인 실패: 등록되지 않은 ID입니다.");
            return;
        }

        MemberDto searchedMemberDto = memberDao.searchMemberByMemIdAndMemPw(memberDto);
        if (searchedMemberDto != null) {
            memberSession.setLoginMemId(searchedMemberDto.getMemId());
            System.out.println("로그인 성공!!");
        } else {
            System.out.println("로그인 실패: 비밀번호가 일치하지 않습니다.");
        }
    }

    @Override
    public void signOut() {
        if (!memberSession.isLogin()) {
            System.out.println("로그인한 회원이 없습니다.");
            return;
        }

        memberSession.logOut();
        System.out.println("로그아웃되었습니다.");
    }

    @Override
    public void modify(MemberDto memberDto) {
        if (!memberSession.isLogin()) {
            System.out.println("회원정보 수정 실패: 로그인이 필요합니다.");
            return;
        }

        if (!memberSession.getLoginMemId().equals(memberDto.getMemId())) {
            System.out.println("회원정보 수정 실패: 다른 회원의 정보는 수정할 수 없습니다.");
            return;
        }

        if (memberDto.getMemPw().length() < 4) {
            System.out.println("회원정보 수정 실패: 비밀번호는 4자리 이상이어야 합니다.");
            return;
        }

        MemberDto updatedMemberDto = memberDao.updateMemberByMemId(memberDto);
        if (updatedMemberDto != null) {
            System.out.println("회원정보 수정 성공!!");
        } else {
            System.out.println("회원정보 수정 실패!!");
        }
    }

    @Override
    public void delete(MemberDto memberDto) {
        if (!memberSession.isLogin()) {
            System.out.println("회원탈퇴 실패: 로그인이 필요합니다.");
            return;
        }

        if (!memberSession.getLoginMemId().equals(memberDto.getMemId())) {
            System.out.println("회원탈퇴 실패: 다른 회원을 탈퇴시킬 수 없습니다.");
            return;
        }

        MemberDto deletedMemberDto = memberDao.deleteMemberByMemIdAndMemPw(memberDto);
        if (deletedMemberDto != null) {
            // 회원의 모든 일기를 함께 삭제합니다.
            diaryDao.deleteDiariesByMemId(memberDto.getMemId());
            memberSession.logOut();
            System.out.println("회원탈퇴 완료!! 회원의 일기도 모두 삭제되었습니다.");
        } else {
            System.out.println("회원탈퇴 실패: 비밀번호가 일치하지 않습니다.");
        }
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

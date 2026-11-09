package com.office.member;

import java.util.HashMap;
import com.office.db.DiaryDb;

public class MemberDao {
    private final DiaryDb diaryDb;
    public MemberDao(DiaryDb diaryDb) { this.diaryDb = diaryDb; }
    public boolean isMember(String id) { return diaryDb.getMembers().containsKey(id); }
    public int insertMember(MemberDto member) {
        HashMap<String, MemberDto> members = diaryDb.getMembers();
        if (members.containsKey(member.getMemId())) return MemberService.SIGN_UP_FAIL;
        members.put(member.getMemId(), member);
        return MemberService.SIGN_UP_SUCCESS;
    }
    public MemberDto selectMemberByMemId(String id) { return diaryDb.getMembers().get(id); }
    public int updateMember(MemberDto member) {
        if (!isMember(member.getMemId())) return MemberService.MODIFY_FAIL;
        diaryDb.getMembers().put(member.getMemId(), member);
        return MemberService.MODIFY_SUCCESS;
    }
    public int deleteMember(String id) {
        if (diaryDb.getMembers().remove(id) == null) return MemberService.DELETE_FAIL;
        // 탈퇴한 회원의 일기도 함께 삭제한다.
        diaryDb.getDiaries().remove(id);
        return MemberService.DELETE_SUCCESS;
    }
}

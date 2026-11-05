package com.office.memberDiary;

import java.util.HashMap;

public class MemberDao {

    private HashMap<String, MemberDto> db = new HashMap<String, MemberDto>();

    public boolean isMember(String memId) {
        MemberDto memberDto = db.get(memId);
        return memberDto != null;
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

    public MemberDto updateMemberByMemId(MemberDto memberDto) {
        // 기존 회원만 수정합니다.
        if (!isMember(memberDto.getMemId())) {
            return null;
        }

        db.put(memberDto.getMemId(), memberDto);
        return db.get(memberDto.getMemId());
    }

    public MemberDto deleteMemberByMemIdAndMemPw(MemberDto memberDto) {
        MemberDto dto = searchMemberByMemIdAndMemPw(memberDto);

        if (dto != null) {
            return db.remove(memberDto.getMemId());
        } else {
            return null;
        }
    }
}

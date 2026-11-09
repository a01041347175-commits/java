package com.office.member;

import com.office.config.Config;
import com.office.session.Session;

public class MemberService {
    private final MemberDao memberDao;
    public static final int SIGN_UP_FAIL = 0, SIGN_UP_SUCCESS = 1;
    public static final int MODIFY_FAIL = 0, MODIFY_SUCCESS = 1;
    public static final int DELETE_FAIL = 0, DELETE_SUCCESS = 1;
    public MemberService(MemberDao memberDao) { this.memberDao = memberDao; }
    public int signUp(MemberDto member) {
        if (member == null || isBlank(member.getMemId()) || !validPassword(member.getMemPw())
                || memberDao.isMember(member.getMemId())) return SIGN_UP_FAIL;
        return memberDao.insertMember(member);
    }
    public MemberDto signIn(MemberDto credentials) {
        if (credentials == null) return null;
        MemberDto member = memberDao.selectMemberByMemId(credentials.getMemId());
        return member != null && member.getMemPw().equals(credentials.getMemPw()) ? member : null;
    }
    public int modify(MemberDto member, String currentPassword) {
        if (member == null || !isCurrentMember(member.getMemId()) || !validPassword(member.getMemPw())
                || signIn(new MemberDto(member.getMemId(), currentPassword, null, null)) == null)
            return MODIFY_FAIL;
        return memberDao.updateMember(member);
    }
    public int delete(MemberDto credentials) {
        if (credentials == null || !isCurrentMember(credentials.getMemId())
                || signIn(credentials) == null) return DELETE_FAIL;
        int result = memberDao.deleteMember(credentials.getMemId());
        if (result == DELETE_SUCCESS)
            Session.getInstance().removeAttribute(Config.SIGNINED_MEMBER_ID);
        return result;
    }
    private boolean isCurrentMember(String id) {
        return id != null && id.equals(Session.getInstance().getAttribute(Config.SIGNINED_MEMBER_ID));
    }
    private boolean validPassword(String password) { return !isBlank(password) && password.length() >= 4; }
    private boolean isBlank(String value) { return value == null || value.trim().isEmpty(); }
}

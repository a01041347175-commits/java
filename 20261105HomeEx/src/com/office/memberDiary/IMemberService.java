package com.office.memberDiary;

public interface IMemberService {

    public void signUp(MemberDto memberDto);
    public void signIn(MemberDto memberDto);
    public void logOut();
    public void modify(MemberDto memberDto);
    public void delete(MemberDto memberDto);
}

package com.office.memberDiary;

public interface IMemberService {

	public void signUp(MemberDto memberDto);
	public void logIn(MemberDto memberDto);
	public void logOut(MemberDto memberDto);
	public void modify(MemberDto memberDto);
	public void delete(MemberDto memberDto);
	
}

package com.office.member;

public interface IMemberService {

	public void signUp(MemberDto memberDto);
	
	public void signIn(MemberDto memberDto);
	
	public void modify();
	
	public void delete(MemberDto memberDto);
	
}
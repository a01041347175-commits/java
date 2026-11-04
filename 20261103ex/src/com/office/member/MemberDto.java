package com.office.member;

public class MemberDto {
	
	private String memId;
	private String memPw;
	private String memMail;
	private String memPhone;
	
	public MemberDto() {
		
	}
	
	public MemberDto(String memId, String memPw, String memMail, String memPhone) {
		this.memId = memId;
		this.memPw = memPw;
		this.memMail = memMail;
		this.memPhone = memPhone;
	}
	
	public MemberDto(String memId, String memPw, String memMail) {
		this.memId = memId;
		this.memPw = memPw;
		this.memMail = memMail;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemMail() {
		return memMail;
	}

	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	
}
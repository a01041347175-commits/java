package com.office.memberDiary;

public class DiaryDto {

	private String memId;
	private String diaryTitle;
	private String diaryTxt;
	
	public DiaryDto() {	}
	
	public DiaryDto(String memId, 
			String diaryTitle, 
			String diaryTxt) {
		this.memId = memId;
		this.diaryTitle = diaryTitle;
		this.diaryTxt = diaryTxt;
		
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getDiaryTitle() {
		return diaryTitle;
	}

	public void setDiaryTitle(String diaryTitle) {
		this.diaryTitle = diaryTitle;
	}

	public String getDiaryTxt() {
		return diaryTxt;
	}

	public void setDiaryTxt(String diaryTxt) {
		this.diaryTxt = diaryTxt;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTxt() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

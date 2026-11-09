package com.office.diary;

import java.time.LocalDateTime;

public class DiaryDto {

	private String diaryTitle;
	private String diaryBody;
	private LocalDateTime diaryRegDate;
	
	public DiaryDto(String diaryTitle, String diaryBody, LocalDateTime diaryRegDate) {
		this.diaryTitle = diaryTitle;
		this.diaryBody = diaryBody;
		this.diaryRegDate = diaryRegDate;
	}
	
	public String getDiaryTitle() {
		return diaryTitle;
	}
	public void setDiaryTitle(String diaryTitle) {
		this.diaryTitle = diaryTitle;
	}
	public String getDiaryBody() {
		return diaryBody;
	}
	public void setDiaryBody(String diaryBody) {
		this.diaryBody = diaryBody;
	}
	public LocalDateTime getDiaryRegDate() {
		return diaryRegDate;
	}
	public void setDiaryRegDate(LocalDateTime diaryRegDate) {
		this.diaryRegDate = diaryRegDate;
	}
	
}

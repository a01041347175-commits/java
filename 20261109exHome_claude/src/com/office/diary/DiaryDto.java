package com.office.diary;

import java.time.LocalDateTime;

public class DiaryDto {

	private String memId;			// 작성자 (일기는 작성한 회원에게 귀속)
	private String diaryTitle;
	private String diaryBody;
	private LocalDateTime diaryRegDate;

	public DiaryDto(String memId, String diaryTitle, String diaryBody, LocalDateTime diaryRegDate) {
		this.memId = memId;
		this.diaryTitle = diaryTitle;
		this.diaryBody = diaryBody;
		this.diaryRegDate = diaryRegDate;
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

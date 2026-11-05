package com.office.memberDiary;

public class DiaryDto {

    private String memId;  // 이 일기를 작성한 회원 ID
    private String title;  // 일기 제목
    private String txt;    // 일기 내용

    public DiaryDto() { }

    public DiaryDto(String memId, String title, String txt) {
        this.memId = memId;
        this.title = title;
        this.txt = txt;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}

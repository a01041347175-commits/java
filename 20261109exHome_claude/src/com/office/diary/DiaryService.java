package com.office.diary;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DiaryService {

	final private DiaryDao diaryDao;

	final public static int WRITE_FAIL 					= 0;
	final public static int WRITE_SUCCESS 				= 1;
	final public static int WRITE_FAIL_NOT_SIGNINED 	= 2;
	final public static int WRITE_FAIL_EMPTY_TITLE 		= 3;
	final public static int WRITE_FAIL_EMPTY_BODY 		= 4;

	public DiaryService(DiaryDao diaryDao) {
		this.diaryDao = diaryDao;

	}

	private boolean isEmpty(String str) {
		return str == null || str.trim().isEmpty();

	}

	/*
	 * 일기 작성 (memId : 로그인한 회원 ID)
	 */
	public int write(String memId, String diaryTitle, String diaryBody) {

		if (memId == null)
			return WRITE_FAIL_NOT_SIGNINED;

		// 제목, 내용은 필수 입력 항목
		if (isEmpty(diaryTitle))
			return WRITE_FAIL_EMPTY_TITLE;

		if (isEmpty(diaryBody))
			return WRITE_FAIL_EMPTY_BODY;

		return diaryDao.insertDiary(
				new DiaryDto(memId, diaryTitle.trim(), diaryBody.trim(), LocalDateTime.now()));

	}

	/*
	 * 일기 목록 조회 (로그인한 회원 본인의 일기만)
	 */
	public ArrayList<DiaryDto> getDiaries(String memId) {

		if (memId == null)
			return null;

		return diaryDao.selectDiariesByMemId(memId);

	}

}

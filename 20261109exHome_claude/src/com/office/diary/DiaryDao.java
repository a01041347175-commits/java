package com.office.diary;

import java.util.ArrayList;
import java.util.HashMap;

import com.office.db.DiaryDb;

public class DiaryDao {

	final private DiaryDb diaryDb;

	public DiaryDao(DiaryDb diaryDb) {
		this.diaryDb = diaryDb;

	}

	public int insertDiary(DiaryDto diaryDto) {
		HashMap<String, ArrayList<DiaryDto>> diaries = diaryDb.getDiaries();

		// 회원 ID별로 일기 목록을 관리 (처음 쓰는 회원이면 목록 생성)
		ArrayList<DiaryDto> memberDiaries = diaries.get(diaryDto.getMemId());
		if (memberDiaries == null) {
			memberDiaries = new ArrayList<DiaryDto>();
			diaries.put(diaryDto.getMemId(), memberDiaries);

		}

		return memberDiaries.add(diaryDto)
				?
				DiaryService.WRITE_SUCCESS
				:
				DiaryService.WRITE_FAIL;

	}

	/*
	 * 해당 회원의 일기만 조회 (다른 회원의 일기는 조회되지 않음)
	 */
	public ArrayList<DiaryDto> selectDiariesByMemId(String memId) {
		HashMap<String, ArrayList<DiaryDto>> diaries = diaryDb.getDiaries();

		ArrayList<DiaryDto> memberDiaries = diaries.get(memId);

		// 원본 목록이 외부에서 변경되지 않도록 복사본 반환
		return memberDiaries != null
				?
				new ArrayList<DiaryDto>(memberDiaries)
				:
				new ArrayList<DiaryDto>();

	}

	/*
	 * 회원 탈퇴 시 해당 회원의 일기 전체 삭제
	 */
	public void deleteDiariesByMemId(String memId) {
		diaryDb.getDiaries().remove(memId);

	}

}

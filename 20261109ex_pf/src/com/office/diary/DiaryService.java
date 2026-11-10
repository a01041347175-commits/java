package com.office.diary;

import java.util.ArrayList;

public class DiaryService {

	final private DiaryDao diaryDao;
	
	final static public int DIARY_WRITE_FAIL 		= 0;
	final static public int DIARY_WRITE_SUCCESS 	= 1;
	
	public DiaryService(DiaryDao diaryDao) {
		this.diaryDao = diaryDao;
		
	}

	public int writeDiary(String memId, DiaryDto diaryDto) {
		
		return diaryDao.insertNewDiary(memId, diaryDto);
		
	}

	public ArrayList<DiaryDto> readDiaries(String memId) {
		
		return diaryDao.selectDiariesByMemId(memId);
		
	}
	
}

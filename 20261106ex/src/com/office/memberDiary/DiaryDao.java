package com.office.memberDiary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DiaryDao {

	private HashMap<String, ArrayList<DiaryDao>> db = 
			new HashMap<String, ArrayList<DiaryDao>>();
	
	public boolean insertDiary(DiaryDto diaryDto) {
		String memId = diaryDto.getMemId();
		ArrayList<DiaryDao> diaries = db.get(memId);
		
		if (diaries == null) {
			diaries = new ArrayList();
			db.put(memId, diaries);
		}
		int beforeSize = diaries.size();
		diaries.addAll(0, (Collection<? extends DiaryDao>) diaryDto);
		return diaries.size() > beforeSize;
	}
	
	public ArrayList<DiaryDto> getDiaries(String memId) {
		ArrayList<DiaryDto> diaries = db.get(memId);
		
		if (diaries == null) {
			return new ArrayList<DiaryDto>();
		} return diaries;
	}
	
	public void deleteDiariesByMemId(String memId) {
		db.remove(memId);
	}
	
}

package com.office.diary;

import java.util.ArrayList;

public class DiaryDao {

	// [] java에서 배열은 길이 수정이 어렵다 ==> ArrayList
	
	private ArrayList<String> diaries = new ArrayList<String>();
	
	public boolean insertDiary(DiaryDto diaryDto) {
		
		int beforeSize =  diaries.size();
		
//		diaries.add(diaryDto.getTxt());
		
		diaries.add(0, diaryDto.getTxt());
		
		int afterSize =  diaries.size();
		
		return afterSize > beforeSize ? true : false;
	}

	public ArrayList<String> getDiaries() {
		return diaries;
	}
	
}

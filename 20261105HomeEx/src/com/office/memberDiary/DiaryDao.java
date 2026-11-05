package com.office.memberDiary;

import java.util.ArrayList;
import java.util.HashMap;

public class DiaryDao {

    // 회원 ID별로 해당 회원의 일기 목록을 따로 저장합니다.
    private HashMap<String, ArrayList<DiaryDto>> db =
            new HashMap<String, ArrayList<DiaryDto>>();

    public boolean insertDiary(DiaryDto diaryDto) {
        String memId = diaryDto.getMemId();
        ArrayList<DiaryDto> diaries = db.get(memId);

        // 이 회원이 처음 일기를 쓰는 경우, 새로운 목록을 만듭니다.
        if (diaries == null) {
            diaries = new ArrayList<DiaryDto>();
            db.put(memId, diaries);
        }

        int beforeSize = diaries.size();
        diaries.add(0, diaryDto); // 최신 일기가 제일 먼저 나오도록 저장
        return diaries.size() > beforeSize;
    }

    public ArrayList<DiaryDto> getDiaries(String memId) {
        ArrayList<DiaryDto> diaries = db.get(memId);

        if (diaries == null) {
            return new ArrayList<DiaryDto>();
        }
        return diaries;
    }

    public void deleteDiariesByMemId(String memId) {
        db.remove(memId);
    }
}

package com.office.diary;

import java.util.ArrayList;
import java.util.List;
import com.office.db.DiaryDb;

public class DiaryDao {
    private final DiaryDb diaryDb;
    public DiaryDao(DiaryDb diaryDb) { this.diaryDb = diaryDb; }
    public void insertDiary(String memberId, DiaryDto diary) {
        ArrayList<DiaryDto> list = diaryDb.getDiaries().get(memberId);
        if (list == null) {
            list = new ArrayList<DiaryDto>();
            diaryDb.getDiaries().put(memberId, list);
        }
        list.add(diary);
    }
    public List<DiaryDto> selectDiaries(String memberId) {
        List<DiaryDto> list = diaryDb.getDiaries().get(memberId);
        return list == null ? new ArrayList<DiaryDto>() : new ArrayList<DiaryDto>(list);
    }
}

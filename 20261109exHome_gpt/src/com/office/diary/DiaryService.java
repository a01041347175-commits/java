package com.office.diary;

import java.time.LocalDateTime;
import java.util.List;
import com.office.config.Config;
import com.office.session.Session;

public class DiaryService {
    private final DiaryDao diaryDao;
    public DiaryService(DiaryDao diaryDao) { this.diaryDao = diaryDao; }
    public boolean write(String title, String body) {
        String memberId = currentMemberId();
        if (title == null || title.trim().isEmpty() || body == null || body.trim().isEmpty()) return false;
        diaryDao.insertDiary(memberId, new DiaryDto(title.trim(), body.trim(), LocalDateTime.now()));
        return true;
    }
    public List<DiaryDto> readList() { return diaryDao.selectDiaries(currentMemberId()); }
    private String currentMemberId() {
        String id = (String) Session.getInstance().getAttribute(Config.SIGNINED_MEMBER_ID);
        if (id == null) throw new IllegalStateException("로그인이 필요합니다.");
        return id;
    }
}

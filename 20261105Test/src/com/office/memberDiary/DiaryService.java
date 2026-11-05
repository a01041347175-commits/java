package com.office.memberDiary;

import java.util.ArrayList;

public class DiaryService {

    final private DiaryDao diaryDao;
    final private MemberSession memberSession;

    public DiaryService(DiaryDao diaryDao, MemberSession memberSession) {
        this.diaryDao = diaryDao;
        this.memberSession = memberSession;
    }

    public void writeNewDiary(DiaryDto diaryDto) {
        if (!memberSession.isLogin()) {
            System.out.println("일기 작성 실패: 로그인이 필요합니다.");
            return;
        }

        if (!memberSession.getLoginMemId().equals(diaryDto.getMemId())) {
            System.out.println("일기 작성 실패: 현재 로그인한 회원만 작성할 수 있습니다.");
            return;
        }

        if (diaryDto.getTitle().trim().equals("") || diaryDto.getTxt().trim().equals("")) {
            System.out.println("일기 작성 실패: 제목과 내용은 모두 필수 입력입니다.");
            return;
        }

        boolean result = diaryDao.insertDiary(diaryDto);
        if (result) {
            System.out.println("일기 작성 성공!!");
        } else {
            System.out.println("일기 작성 실패!!");
        }
    }

    public void readDiaries() {
        if (!memberSession.isLogin()) {
            System.out.println("일기 조회 실패: 로그인이 필요합니다.");
            return;
        }

        // 현재 로그인한 회원 ID로만 일기 목록을 조회합니다.
        ArrayList<DiaryDto> diaries = diaryDao.getDiaries(memberSession.getLoginMemId());

        if (diaries.size() == 0) {
            System.out.println("작성한 일기가 없습니다.");
            return;
        }

        for (int i = 0; i < diaries.size(); i++) {
            DiaryDto diaryDto = diaries.get(i);
            System.out.println((i + 1) + ". 제목: " + diaryDto.getTitle());
            System.out.println("   내용: " + diaryDto.getTxt());
        }
    }
}

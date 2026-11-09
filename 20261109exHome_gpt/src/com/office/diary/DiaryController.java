package com.office.diary;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import com.office.config.Config;
import com.office.menu.Menu;
import com.office.session.Session;

public class DiaryController {
    private final DiaryService diaryService;
    public DiaryController(DiaryService diaryService) { this.diaryService = diaryService; }
    public void execute(Scanner scanner, int selectedMenu) {
        if (Session.getInstance().getAttribute(Config.SIGNINED_MEMBER_ID) == null) {
            System.out.println("로그인이 필요합니다.");
            return;
        }
        switch (selectedMenu) {
        case Menu.DIARY_WRITE:
            System.out.print("일기 제목: ");
            String title = scanner.nextLine();
            System.out.print("일기 내용: ");
            String body = scanner.nextLine();
            System.out.println(diaryService.write(title, body) ? "일기가 저장되었습니다."
                    : "제목과 내용을 모두 입력하세요. 공백만 입력할 수 없습니다.");
            break;
        case Menu.DIARY_READ:
            List<DiaryDto> diaries = diaryService.readList();
            if (diaries.isEmpty()) System.out.println("작성한 일기가 없습니다.");
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            for (int i = 0; i < diaries.size(); i++) {
                DiaryDto diary = diaries.get(i);
                System.out.println("[" + (i + 1) + "] " + diary.getDiaryTitle()
                        + " (" + diary.getDiaryRegDate().format(format) + ")");
                System.out.println(diary.getDiaryBody());
            }
            break;
        default:
            System.out.println("없는 메뉴입니다.");
        }
    }
}

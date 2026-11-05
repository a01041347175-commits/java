package com.office.memberDiary;

import java.util.Scanner;

public class DiaryController implements IDiaryConfig {

    final private DiaryService diaryService;
    final private MemberSession memberSession;

    public DiaryController(DiaryService diaryService, MemberSession memberSession) {
        this.diaryService = diaryService;
        this.memberSession = memberSession;
    }

    public void execute(Scanner scanner) {
        if (!memberSession.isLogin()) {
            System.out.println("다이어리 이용은 로그인 후 가능합니다.");
            return;
        }

        boolean diaryFlag = true;

        while (diaryFlag) {
            System.out.println("\n=== 다이어리 메뉴 (" + memberSession.getLoginMemId() + ") ===");
            System.out.println("1.일기 작성    2.일기 조회    99.회원 메뉴로 돌아가기");
            System.out.print("메뉴 선택: ");
            int selectedMenuNum = scanner.nextInt();
            scanner.nextLine(); // 숫자 입력 후 남은 줄바꿈 제거

            switch (selectedMenuNum) {
            case DIARY_WRITE:
                System.out.print("일기 제목: ");
                String title = scanner.nextLine();

                System.out.print("일기 내용: ");
                String txt = scanner.nextLine();

                DiaryDto diaryDto = new DiaryDto(memberSession.getLoginMemId(), title, txt);
                diaryService.writeNewDiary(diaryDto);
                break;

            case DIARY_READ:
                diaryService.readDiaries();
                break;

            case DIARY_RETURN:
                diaryFlag = false;
                break;

            default:
                System.out.println("메뉴 번호를 다시 입력해 주세요.");
                break;
            }
        }
    }
}

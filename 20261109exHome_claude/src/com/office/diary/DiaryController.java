package com.office.diary;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.office.menu.Menu;
import com.office.session.Session;

public class DiaryController {

	final private DiaryService diaryService;

	final private static DateTimeFormatter DATE_FORMAT =
			DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public DiaryController(DiaryService diaryService) {
		this.diaryService = diaryService;

	}

	public void execute(Scanner scanner, int selectedMenu) {

		// 작성자/조회 대상은 입력받지 않고 로그인한 회원 ID 사용
		String memId = Session.getInstance().getSignInedMemberId();

		// 로그인한 회원만 다이어리 서비스 이용 가능
		if (memId == null) {
			System.out.println("PLEASE SIGN-IN FIRST!!");
			return;

		}

		switch (selectedMenu) {
		case Menu.DIARY_WRITE:
			// 제목/내용은 띄어쓰기가 포함될 수 있으므로 nextLine() 사용
			System.out.println("Input diary TITLE!!");
			String diaryTitle = scanner.nextLine();

			System.out.println("Input diary BODY!!");
			String diaryBody = scanner.nextLine();

			int resultForWrite = diaryService.write(memId, diaryTitle, diaryBody);

			switch (resultForWrite) {
			case DiaryService.WRITE_SUCCESS:
				System.out.println("DIARY WRITE SUCCESS!!");
				break;
			case DiaryService.WRITE_FAIL_NOT_SIGNINED:
				System.out.println("DIARY WRITE FAIL!! (please sign-in first)");
				break;
			case DiaryService.WRITE_FAIL_EMPTY_TITLE:
				System.out.println("DIARY WRITE FAIL!! (TITLE is required)");
				break;
			case DiaryService.WRITE_FAIL_EMPTY_BODY:
				System.out.println("DIARY WRITE FAIL!! (BODY is required)");
				break;
			default:
				System.out.println("DIARY WRITE FAIL!!");

			}

			break;

		case Menu.DIARY_READ:
			ArrayList<DiaryDto> diaries = diaryService.getDiaries(memId);

			if (diaries == null || diaries.isEmpty()) {
				System.out.println("NO DIARY!!");
				break;

			}

			System.out.println("========== " + memId + "'s DIARY (" + diaries.size() + ") ==========");
			for (int i = 0; i < diaries.size(); i++) {
				DiaryDto diaryDto = diaries.get(i);
				System.out.println((i + 1) + ". " + diaryDto.getDiaryTitle()
						+ "  (" + diaryDto.getDiaryRegDate().format(DATE_FORMAT) + ")");
				System.out.println("   " + diaryDto.getDiaryBody());

			}
			System.out.println("==============================================");

			break;

		}

	}

}

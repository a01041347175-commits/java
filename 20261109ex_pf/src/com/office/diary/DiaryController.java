package com.office.diary;

import java.util.ArrayList;
import java.util.Scanner;

import com.office.config.Config;
import com.office.menu.Menu;
import com.office.session.Session;

public class DiaryController {

	final private DiaryService diaryService;
	
	public DiaryController(DiaryService diaryService) {
		this.diaryService = diaryService;
		
	}

	public void execute(Scanner scanner, int selectedMenu) {
		
		String diaryTitle;
		String diaryBody;
		
		switch (selectedMenu) {
		case Menu.DIARY_WRITE:
			
			scanner.nextLine();
			
			System.out.println("Input new diary TITLE!!");
			diaryTitle = scanner.nextLine();
			
			System.out.println("Input new diary BODY!!");
			diaryBody = scanner.nextLine();
			
			DiaryDto diaryDto = new DiaryDto(diaryTitle, diaryBody);
			
			int resultForWrite = diaryService.writeDiary(
					String.valueOf(Session.getInstance().getAttribute(Config.SIGNINED_MEMBER_ID)),
					diaryDto);
			
			if (resultForWrite == DiaryService.DIARY_WRITE_SUCCESS) {
				System.out.println("DIARY WRITE SUCCESS!!");
				
			} else {
				System.out.println("DIARY WRITE FAIL!!");
				
			}
			
			break;
			
		case Menu.DIARY_READ:
			
			ArrayList<DiaryDto> myDiaries = diaryService.readDiaries(
					String.valueOf(Session.getInstance().getAttribute(Config.SIGNINED_MEMBER_ID))
					);
			
			if (myDiaries != null) {
				
				for (int i = 0; i < myDiaries.size(); i++) {
					DiaryDto dto = myDiaries.get(i);
					System.out.println("--------------------------------------");
					System.out.println("Title: " + dto.getDiaryTitle());
					System.out.println("Body: " + dto.getDiaryBody());
					System.out.println("--------------------------------------");
				}
				
			} else {
				System.out.println("작성된 일기가 없어요~~");
				
			}
			
			break;

		}
		
	}
	
}

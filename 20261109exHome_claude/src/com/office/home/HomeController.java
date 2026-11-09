package com.office.home;

import java.util.Scanner;

import com.office.Container;
import com.office.menu.Menu;

public class HomeController {

	public void execute() {

		Scanner scanner = new Scanner(System.in);
		boolean systemFlag = true;

		while (systemFlag) {
			Menu.generateMenu();

			// nextInt() 대신 nextLine()으로 읽어서
			// 숫자가 아닌 값 입력 시 프로그램이 종료되지 않도록 처리
			int selectedMenu;
			try {
				selectedMenu = Integer.parseInt(scanner.nextLine().trim());

			} catch (NumberFormatException e) {
				System.out.println("PLEASE INPUT A NUMBER!!");
				continue;

			}

			// 로그인 상태에 맞지 않는 메뉴는 실행하지 않음
			if (!Menu.isAvailable(selectedMenu)) {
				System.out.println("INVALID MENU!!");
				continue;

			}

			switch (selectedMenu) {
			case Menu.MEMBER_SIGN_UP:
			case Menu.MEMBER_SIGN_IN:
			case Menu.MEMBER_SIGN_OUT:
			case Menu.MEMBER_MODIFY:
			case Menu.MEMBER_DELETE:
				Container.getInstance().getMemberController().execute(scanner, selectedMenu);
				break;

			case Menu.DIARY_WRITE:
			case Menu.DIARY_READ:
				Container.getInstance().getDiaryController().execute(scanner, selectedMenu);
				break;

			case Menu.SYSTEM_OUT:
				systemFlag = false;
				System.out.println("Good bye~");
				break;

			}

		}

		scanner.close();

	}

}

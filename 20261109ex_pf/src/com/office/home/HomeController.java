package com.office.home;

import java.util.HashMap;
import java.util.Scanner;

import com.office.Container;
import com.office.menu.Menu;
import com.office.session.Session;

public class HomeController {

	public void execute() {
	
		Scanner scanner = new Scanner(System.in);
		boolean systemFlag = true;
		
		while (systemFlag) {
			
			Menu.generateMenu();
			
			int selectedMenu = scanner.nextInt();
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
				System.out.println("Good bye~~");
				break;

			}
			
		}
		
		scanner.close();
		
	}

}

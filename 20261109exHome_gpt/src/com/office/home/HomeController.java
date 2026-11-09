package com.office.home;

import java.util.NoSuchElementException;
import java.util.Scanner;
import com.office.Container;
import com.office.menu.Menu;

public class HomeController {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        boolean systemFlag = true;
        try {
            while (systemFlag) {
                Menu.generateMenu();
                if (!scanner.hasNextLine()) break;
                int selectedMenu;
                try {
                    selectedMenu = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("메뉴 번호를 숫자로 입력하세요.");
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
                    break;
                default:
                    System.out.println("없는 메뉴입니다.");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("입력이 종료되었습니다.");
        } finally {
            scanner.close();
        }
        System.out.println("프로그램을 종료합니다.");
    }
}

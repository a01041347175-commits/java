package com.office.memberDiary;

import java.util.Scanner;

// 하나의 메인 메뉴에서 회원관리와 다이어리 기능을 연결합니다.
public class MainController implements MemberConfig {

    final private MemberController memberController;
    final private DiaryController diaryController;
    final private MemberSession memberSession;

    public MainController(MemberController memberController,
                          DiaryController diaryController,
                          MemberSession memberSession) {
        this.memberController = memberController;
        this.diaryController = diaryController;
        this.memberSession = memberSession;
    }

    public void execute() {
        // 두 프로그램에서 한 개의 Scanner를 함께 사용합니다.
        Scanner scanner = new Scanner(System.in);
        boolean systemFlag = true;

        while (systemFlag) {
            if (memberSession.isLogin()) {
                System.out.println("\n=== 회원 메뉴 (로그인: " + memberSession.getLoginMemId() + ") ===");
                System.out.println("3.로그아웃    4.정보수정    5.회원탈퇴    6.다이어리    99.종료");
            } else {
                System.out.println("\n=== 회원 메뉴 (로그아웃 상태) ===");
                System.out.println("1.회원가입    2.로그인    99.종료");
            }

            System.out.print("메뉴 선택: ");
            int selectedMenuNum = scanner.nextInt();
            scanner.nextLine(); // 뒤이어 nextLine()을 쓸 수 있도록 줄바꿈 제거

            switch (selectedMenuNum) {
            case SIGN_UP:
                if (!memberSession.isLogin()) {
                    memberController.signUp(scanner);
                } else {
                    System.out.println("로그아웃 후 회원가입할 수 있습니다.");
                }
                break;

            case SIGN_IN:
                if (!memberSession.isLogin()) {
                    memberController.signIn(scanner);
                } else {
                    System.out.println("이미 로그인한 상태입니다.");
                }
                break;

            case LOG_OUT:
                if (memberSession.isLogin()) {
                    memberController.logOut();
                } else {
                    System.out.println("로그인이 필요합니다.");
                }
                break;

            case MODIFY:
                if (memberSession.isLogin()) {
                    memberController.modify(scanner);
                } else {
                    System.out.println("회원정보 수정은 로그인 후 가능합니다.");
                }
                break;

            case DELETE:
                if (memberSession.isLogin()) {
                    memberController.delete(scanner);
                } else {
                    System.out.println("회원탈퇴는 로그인 후 가능합니다.");
                }
                break;

            case DIARY:
                if (memberSession.isLogin()) {
                    diaryController.execute(scanner);
                } else {
                    System.out.println("다이어리는 로그인 후 이용할 수 있습니다.");
                }
                break;

            case SYSTEM_OUT:
                systemFlag = false;
                memberSession.logOut();
                System.out.println("프로그램을 종료합니다.");
                break;

            default:
                System.out.println("메뉴 번호를 다시 입력해 주세요.");
                break;
            }
        }

        scanner.close();
    }
}

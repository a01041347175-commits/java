package com.office.member;

import java.util.Scanner;
import com.office.config.Config;
import com.office.menu.Menu;
import com.office.session.Session;

public class MemberController {
    private final MemberService memberService;
    public MemberController(MemberService memberService) { this.memberService = memberService; }
    public void execute(Scanner scanner, int selectedMenu) {
        String currentId = (String) Session.getInstance().getAttribute(Config.SIGNINED_MEMBER_ID);
        boolean guestMenu = selectedMenu == Menu.MEMBER_SIGN_UP || selectedMenu == Menu.MEMBER_SIGN_IN;
        if (guestMenu && currentId != null) {
            System.out.println("이미 로그인되어 있습니다. 먼저 로그아웃해 주세요.");
            return;
        }
        if (!guestMenu && currentId == null) {
            System.out.println("로그인이 필요합니다.");
            return;
        }
        switch (selectedMenu) {
        case Menu.MEMBER_SIGN_UP: {
            String id = input(scanner, "새 아이디: ").trim();
            String password = input(scanner, "비밀번호(4자리 이상): ");
            String mail = input(scanner, "이메일: ").trim();
            String phone = input(scanner, "전화번호: ").trim();
            int result = memberService.signUp(new MemberDto(id, password, mail, phone));
            System.out.println(result == MemberService.SIGN_UP_SUCCESS ? "회원가입 성공!"
                    : "회원가입 실패: 아이디 중복/빈 아이디/비밀번호 4자리 이상 여부를 확인하세요.");
            break;
        }
        case Menu.MEMBER_SIGN_IN: {
            String id = input(scanner, "아이디: ").trim();
            String password = input(scanner, "비밀번호: ");
            MemberDto member = memberService.signIn(new MemberDto(id, password, null, null));
            if (member == null) System.out.println("로그인 실패: 아이디 또는 비밀번호를 확인하세요.");
            else {
                Session.getInstance().setAttribute(Config.SIGNINED_MEMBER_ID, member.getMemId());
                System.out.println("로그인 성공!");
            }
            break;
        }
        case Menu.MEMBER_SIGN_OUT:
            Session.getInstance().removeAttribute(Config.SIGNINED_MEMBER_ID);
            System.out.println("로그아웃되었습니다.");
            break;
        case Menu.MEMBER_MODIFY: {
            String currentPassword = input(scanner, "현재 비밀번호: ");
            String newPassword = input(scanner, "새 비밀번호(4자리 이상): ");
            String mail = input(scanner, "새 이메일: ").trim();
            String phone = input(scanner, "새 전화번호: ").trim();
            int result = memberService.modify(new MemberDto(currentId, newPassword, mail, phone), currentPassword);
            System.out.println(result == MemberService.MODIFY_SUCCESS ? "회원정보 수정 성공!"
                    : "수정 실패: 현재 비밀번호와 새 비밀번호 길이를 확인하세요.");
            break;
        }
        case Menu.MEMBER_DELETE: {
            String password = input(scanner, "탈퇴 확인 비밀번호: ");
            int result = memberService.delete(new MemberDto(currentId, password, null, null));
            System.out.println(result == MemberService.DELETE_SUCCESS ? "회원과 일기가 삭제되었습니다."
                    : "탈퇴 실패: 비밀번호를 확인하세요.");
            break;
        }
        default:
            System.out.println("없는 메뉴입니다.");
        }
    }
    private String input(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}

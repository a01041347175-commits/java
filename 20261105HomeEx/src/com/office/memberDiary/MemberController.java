package com.office.memberDiary;

import java.util.Scanner;

public class MemberController {

    final private MemberService memberService;
    final private MemberSession memberSession;

    public MemberController(MemberService memberService, MemberSession memberSession) {
        this.memberService = memberService;
        this.memberSession = memberSession;
    }

    public void signUp(Scanner scanner) {
        System.out.print("새 회원 ID: ");
        String memId = scanner.nextLine();

        System.out.print("새 회원 PW(4자리 이상): ");
        String memPw = scanner.nextLine();

        System.out.print("새 회원 MAIL: ");
        String memMail = scanner.nextLine();

        System.out.print("새 회원 PHONE: ");
        String memPhone = scanner.nextLine();

        MemberDto memberDto = new MemberDto(memId, memPw, memMail, memPhone);
        memberService.signUp(memberDto);
    }

    public void signIn(Scanner scanner) {
        System.out.print("회원 ID: ");
        String memId = scanner.nextLine();

        System.out.print("회원 PW: ");
        String memPw = scanner.nextLine();

        MemberDto memberDto = new MemberDto(memId, memPw, null);
        memberService.signIn(memberDto);
    }

    public void logOut() {
        memberService.logOut();
    }

    public void modify(Scanner scanner) {
        if (!memberSession.isLogin()) {
            System.out.println("로그인 후 수정할 수 있습니다.");
            return;
        }

        String memId = memberSession.getLoginMemId();
        System.out.print("현재 PW(본인 확인): ");
        String oldPw = scanner.nextLine();

        MemberDto authDto = new MemberDto(memId, oldPw, null);
        if (!memberService.doAuthenticationByMemIdAndMemPw(authDto)) {
            System.out.println("본인 인증 실패: 비밀번호가 일치하지 않습니다.");
            return;
        }

        System.out.print("변경할 PW(4자리 이상): ");
        String newPw = scanner.nextLine();

        System.out.print("변경할 MAIL: ");
        String memMail = scanner.nextLine();

        System.out.print("변경할 PHONE: ");
        String memPhone = scanner.nextLine();

        MemberDto memberDto = new MemberDto(memId, newPw, memMail, memPhone);
        memberService.modify(memberDto);
    }

    public void delete(Scanner scanner) {
        if (!memberSession.isLogin()) {
            System.out.println("로그인 후 탈퇴할 수 있습니다.");
            return;
        }

        String memId = memberSession.getLoginMemId();
        System.out.print("탈퇴할 회원의 현재 PW: ");
        String memPw = scanner.nextLine();

        MemberDto memberDto = new MemberDto(memId, memPw, null);
        memberService.delete(memberDto);
    }
}

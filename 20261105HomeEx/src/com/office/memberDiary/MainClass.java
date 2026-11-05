package com.office.memberDiary;

public class MainClass {

    public static void main(String[] args) {
        // 회원관리와 다이어리를 하나의 프로그램으로 실행합니다.
        MemberContainer.getInstance().getMainController().execute();
    }
}

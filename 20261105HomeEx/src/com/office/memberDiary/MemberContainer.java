package com.office.memberDiary;

// 기존 MemberContainer와 DiaryAssembler의 역할을 하나로 합친 객체 관리 클래스입니다.
public class MemberContainer {

    private static MemberContainer memberContainer;

    final private MemberSession MEMBER_SESSION = MemberSession.getInstance();
    final private MemberDao MEMBER_DAO = new MemberDao();
    final private DiaryDao DIARY_DAO = new DiaryDao();

    final private MemberService MEMBER_SERVICE =
            new MemberService(MEMBER_DAO, DIARY_DAO, MEMBER_SESSION);
    final private DiaryService DIARY_SERVICE =
            new DiaryService(DIARY_DAO, MEMBER_SESSION);

    final private MemberController MEMBER_CONTROLLER =
            new MemberController(MEMBER_SERVICE, MEMBER_SESSION);
    final private DiaryController DIARY_CONTROLLER =
            new DiaryController(DIARY_SERVICE, MEMBER_SESSION);

    final private MainController MAIN_CONTROLLER =
            new MainController(MEMBER_CONTROLLER, DIARY_CONTROLLER, MEMBER_SESSION);

    private MemberContainer() {
        // 싱글턴 객체가 처음 생성될 때 기본 회원 2명을 회원가입합니다.
        new MemberDumy().signUpForDumy(MEMBER_SERVICE);
    }

    public static MemberContainer getInstance() {
        if (memberContainer == null) {
            memberContainer = new MemberContainer();
        }
        return memberContainer;
    }

    public MainController getMainController() {
        return MAIN_CONTROLLER;
    }

    public MemberController getMemberController() {
        return MEMBER_CONTROLLER;
    }

    public DiaryController getDiaryController() {
        return DIARY_CONTROLLER;
    }

    public MemberService getMemberService() {
        return MEMBER_SERVICE;
    }

    public DiaryService getDiaryService() {
        return DIARY_SERVICE;
    }

    public MemberDao getMemberDao() {
        return MEMBER_DAO;
    }

    public DiaryDao getDiaryDao() {
        return DIARY_DAO;
    }
}

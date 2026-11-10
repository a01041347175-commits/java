package com.office;

import com.office.db.DiaryDb;
import com.office.diary.DiaryController;
import com.office.diary.DiaryDao;
import com.office.diary.DiaryService;
import com.office.home.HomeController;
import com.office.member.MemberController;
import com.office.member.MemberDao;
import com.office.member.MemberService;

public class Container {

	private static Container container;
	
	final private HomeController homeController;
	
	final private MemberController memberController;
	final private MemberService memberService;
	final private MemberDao memberDao;
	
	final private DiaryController diaryController;
	final private DiaryService diaryService;
	final private DiaryDao diaryDao;
	
	private Container() {
		
		homeController = new HomeController();
		
		memberDao = new MemberDao(DiaryDb.getInstance());
		memberService = new MemberService(this.memberDao);
		memberController = new MemberController(this.memberService);
		
		this.diaryDao = new DiaryDao(DiaryDb.getInstance());
		this.diaryService = new DiaryService(this.diaryDao);
		this.diaryController = new DiaryController(this.diaryService);
		
	}
	
	public static Container getInstance() {
		if (container == null)
			container = new Container();
		
		return container;
		
	}

	
	/*
	 * Getters
	 */
	public HomeController getHomeController() {
		return homeController;
	}

	public MemberController getMemberController() {
		return memberController;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public DiaryController getDiaryController() {
		return diaryController;
	}

	public DiaryService getDiaryService() {
		return diaryService;
	}

	public DiaryDao getDiaryDao() {
		return diaryDao;
	}
	
}

package com.office.member;

import java.util.Scanner;

public class MemberService {
	
	// 속성
	MemberDB db;
	
	// 생성자
	public MemberService(MemberDB memberDB) {
		this.db = memberDB;
	}
	
	// 메서드
	// 회원가입
	public void doSignUp(Scanner scanner) {
		
		System.out.println("Input new memeber ID");
		String memberId = scanner.next();
		
		// 교수님 
//		while (true) {
//			Member member = db.memberDB.get(memberId);
//			if (member != null) {
//				System.out.println("Input new memeber ID");
//				memberId = scanner.next();
//			} else {
//				break;
//			}
//		}
		
		// 과제 4
		if (db.memberDB.get(memberId) != null) {
			System.out.println("아이디 중복, 다른 아이디를 입력하세요.");
			return;
		} 
		
		System.out.println("Input new memeber PW(8~12자리 입력)");
		String memberPw = scanner.next();
		
		// 교수님
//		while (true) {
//			if (memberPw.length() < 8 || memberPw.length() > 12) {
//				System.out.println("Input new memeber PW(8~12자리 입력)");
//				memberPw = scanner.next();
//			} else {
//				break;
//			}
//		}
		
		// 과제 5
		if (memberPw.length() < 8 || memberPw.length() > 12) {
			System.out.println("비밀번호 입력 오류, 8~12자리를 입력하세요.");
			return;
		}
		
		
		System.out.println("Input new memeber MAIL");
		String memberMail = scanner.next();
		
		System.out.println("Input new memeber PHONE");
		String memberPhone = scanner.next();
		
		Member member = new Member(memberId, memberPw, memberMail, memberPhone);
		// MemberDB db = new MemberDB();
		
		db.memberDB.put(memberId, member);
		
		db.memberDB.get(memberId).printInfo();
		
		/*
		 * 과제4 : ID 중복체크 기능추가 (해결)
		 * 과제5 : 비밀번호는 8~12자리 문자로 표현 (해결)
		 */
	}
	
	// 로그인
	int signInFailCount = 0;
	
	public void doSignIn(Scanner scanner) {
		System.out.println("Input memeber ID");
		String memberId = scanner.next();
		
		System.out.println("Input memeber PW");
		String memberPw = scanner.next();
		
		// MemberDB db = new MemberDB();
		Member searchedMember = db.memberDB.get(memberId);
		
		if (searchedMember != null && searchedMember.memberPw.equals(memberPw)) {
			System.out.println("SIGN-IN SUCCESS");
			signInFailCount = 0;
		
		} else {
			signInFailCount++;
			System.out.println("SIGN-IN FAIL(" + signInFailCount + " FAIL)");
			
			if (signInFailCount > 3) {
				System.out.println("PW ERROR");
			}
		}
		
		// 교수님
		
		
		/*
		 * 과제6 : 로그인 실패가 3회 초과시 시스템 종료(해결)
		 */
		
	}
	
	
	// 정보수정
	public void doModify(Scanner scanner) {
		
		System.out.println("Input memeber ID");
		String memberId = scanner.next();
		
		System.out.println("Input memeber PW");
		String memberPw = scanner.next();
		
		Member searchedMember = db.memberDB.get(memberId);
		
		if (searchedMember != null && searchedMember.memberPw.equals(memberPw)) {
			System.out.println("ID CHECK SUCCESS");
			
		
		System.out.println("Input new member PW");
		String newPw = scanner.next();
		
		System.out.println("Input new memeber MAIL");
		String newMail = scanner.next();
		
		System.out.println("Input new memeber PHONE");
		String newPhone = scanner.next();
		
		searchedMember = db.memberDB.get(memberId);
		searchedMember.memberPw = newPw;
		searchedMember.memberMail = newMail;
		searchedMember.memberPhone = newPhone;
		
		System.out.println("MODIFY SUCCESS");
		searchedMember = db.memberDB.get(memberId);
		searchedMember.printInfo();
		} else {
			System.out.println("ID CEHCK FAIL");
		}
//		System.out.println(searchedMember.memberId);
//		System.out.println(searchedMember.memberPw);
//		System.out.println(searchedMember.memberMail);
//		System.out.println(searchedMember.memberPhone);
		
		/*
		 * 과제7 : ID, PW 인증 -> 인증완료 -> 정보수정 (해결)
		 */
		
	}
	
	// 삭제
	public void doDelete(Scanner scanner) {
		
		System.out.println("Input memeber ID");
		String memberId = scanner.next();
		
		System.out.println("Input memeber PW");
		String memberPw = scanner.next();
		
		Member searchedMember =  db.memberDB.get(memberId);
		
		if (searchedMember != null && searchedMember.memberPw.equals(memberPw)) {
			db.memberDB.remove(memberId);
		}
		
	}
	
}

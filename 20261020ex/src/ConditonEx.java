import java.util.Scanner;

public class ConditonEx {

	public static void main(String[] args) {
		
		// if문: 단일 선택
		/*
		 * 문법 구조
		 * if (조건식) {
		 *     실행문
		 * }
		 */
		
		Scanner scanner = new Scanner(System.in);
		
//		int userInputData = scanner.nextInt();
//		
//		if (userInputData > 10) {
//			System.out.println("userInputData는 10보다 크다.");
//		}
//		
//		if (userInputData == 10) {
//			System.out.println("userInputData는 10이다.");
//		}
//		
//		if (userInputData < 10) {
//			System.out.println("userInputData는 10보다 작다.");
//		}
		
		// if ~ else문: 양자 택일
		/*
		 * 시험점수가 70이상이면 '합격', 그렇지 않으면 '불합격'
		 */
//		int myScore = scanner.nextInt();
		/*
		if (myScore >= 70) {
			System.out.println("합격");
		}
		
		if (myScore < 70) {
			System.out.println("불합격");
		}
		*/
		
//		if (myScore >= 70) {
//			System.out.println("합격");
//		} else {
//			System.out.println("불합격");
//		}
		
		// if ~ else if문 : 다중 비교
		/*
		 * 점수가 90점 이상이면 '수'
		 * 80점 이상 90전 미만 '우'
		 * 70점 이상 80점 미만 '미'
		 * 60점 이상 70점 미만 '양'
		 * 60점 미만 '가'
		 */
		int myScore = scanner.nextInt();
		if (myScore >= 90) {
			System.out.println("수");
		} else if(myScore >=80) {
			System.out.println("우");
		} else if(myScore >= 70) {
			System.out.println("미");
		} else if(myScore >= 60) {
			System.out.println("양");
		} else {
			System.out.println("가");
		}
		
		scanner.close();
		// 시퀀스 다이어그램
				
	}

}

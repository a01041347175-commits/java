import java.util.Scanner;

public final class PrintFClass {

	public static void main(String[] args) {
		
		// 형식 문자열 출력
		/*
		 * 형식 문자열 출력이란, 데이터를 출력할 때 특정 형식에 맞춰 출력해야 하는 경우에 사용
		 * System.out.printf();
		 */
		
		String name = "Mr. Hong";
		//이름: Mr. Hong
		System.out.println("이름: " + name);
		System.out.printf("이름: %s", name);
		System.out.println();
		
		/*
		 * "이름: %s" --> 형식
		 * %s --> 지정자
		 * name --> 데이터
		 */
		
		// 이름: 홍길동, 주소: 대전
		String uName = "홍길동";
		String uAddr = "대전";
		System.out.printf("이름: %s, 주소: %s", uName, uAddr);
		
		/*
		 * 지정자 종류
		 * %d		정수형 출력
		 * %f		실수형 출력
		 * %c		문자형 출력
		 * %s		문자열 출력
		 * %b		논리형 출력
		 * %o		8진수 출력(잘 사용 안함)
		 * %x		16진수 출력(잘 사용 안함)
		 * %n		개행
		 */
		
		System.out.printf("이름: %s, 나이: %d", "홍길동", 20);
		System.out.println();
		System.out.printf("결혼유무: %b", false);
		System.out.println();
		System.out.printf("10진수 123 ---> 8진수 %o%n", 123);
		System.out.println("++++++");
		
		// Q 사용자에게 이름과 나이와 몸무게와 신장을 입력받아 출력하는 코드를 작성하자
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름입력 : ");
		String mName = scanner.nextLine();
		
		System.out.println("나이입력 : ");
		int mAge = scanner.nextInt();
		
		System.out.println("몸무게입력 : ");
		float mWeight = scanner.nextFloat();
		
		System.out.println("신장입력 : ");
		double mHeight = scanner.nextDouble();
		
		System.out.printf("이름: %s, 나이: %d, 몸무게: %f, 신장: %f", 
							mName, mAge, mWeight, mHeight);
		
		scanner.close();  
		
		
	}

}


public class MainClass {

	public static void main(String[] args) {
		
	
//		// 변수 
//		/*
//		 * 변수란, 메모리의 특정 공간을 의미한다. 이곳에 데이터가 들어간다.
//		 * 변수 선언 & 변수 초기화
//		 * 변수 선언 : 메모리의 특정 공간을 청소하고 변수명을 달아주는 작업
//		 * 변수 초기화 : 변수에 특정 데이터를 저장하는 작업
//		 * 변수 선언 + 변수 초기화 = 변수 정의
//		 */
//		// 정수를 이용한 변수 선언과 초기화
//		// javascript : let 변수명 = 데이터;
//		// java : 데이터 타입 변수명 = 데이터;
//		int num = 10; // 변수 선언 & 초기화
//		int num2; // 변수 선언
//		num2 = 20; // 변수 초기화
//		System.out.println("num : " + num); // 10
//		System.out.println("num2 : " + num2); //20
//		
//		int address = System.identityHashCode(num);
//		System.out.println("address : " + address);
//		
//		// 변수명 작명 가이드
//		// 1. 변수명의 시작은 일반적으로 소문자로 시작
//		int money = 1000; // 권장
//		int Money = 1000; // 비권장
//		
//		// 2. 변수명은 일반적으로 영문자를 사용
//		int myMoney = 1000; // 권장
//		int 나의자산 = 1000; // 비권장
//		
//		// 3. 변수명은 데이터의 의미를 쉽게 파악하도록 장명
//		int score = 80; // 권장
//		String player = "홍길동"; // 권장
//		String map = "지도"; // 권장
//		
//		// 4. 2개이상의 단어가 조합된 경우 낙타표기법 사용
//		int myScore = 90; // 권장
//		int totalScore = 200; // 권장
//		int highScore = 100; // 권장
//		int averageScore = 80; // 권장
//		String newItem = "칼"; // 권장
//		
//		// 5. 키워든 변수명으로 사용 불가
//		/*
//		 * public, class, void, for, it, switch, case...
//		 */
//		
//		// 6. '_' 를 제외한 특수문자는 변수명으로 사용 불가
//		int my_score = 100; // 가능
//		int my-score = 100; // 불가
//		int my^score = 100; // 불가
//		
//		// 7. 변수명에 공백문자 사용 불가
//		int my number = 80; // 불가
//		
//		// 8. 변수명에 숫자를 사용하는 경우 첫 글자를 제외한 나머지 글자에 사용 가능
//		int 1number = 10; // 불가
//		int num1ber = 10; // 가능
//		int number1 = 10; // 가능
		
		/*
		  ㆍ 변수명은 영문으로 하고, 첫 글자는 소문자로 한다.
          ㆍ 2개 이상의 단어가 조합된 경우 낙타표기법을 따른다. 
          ㆍ 특수문자, 예약어 그리고 공백문자는 사용하지 않는다.
          ㆍ 숫자를 사용해야하는 경우 중간 또는 뒤에 사용한다.
		 */
	
		
		// 데이터 변경
		int number = 10;
		System.out.println("number: " + number);
		number = 20;
		System.out.println("number: " + number);
		// 동일한 이름으로 변수를 선언하면 안된다.
		
		// 데이터 복사
		int num1 = 10;
		System.out.println("num1; " + num1);
		
		int num2 = num1;
		System.out.println("num2: " + num2);
		
		int n1 = 10;
		int n2 = 20;
		
		// Q n1과 n2의 값을 교환
		int n0 = 0;
		n0 = n1;
		n1 = n2;
		n2 = n0;
		System.out.println("n1: " + n1);
		System.out.println("n2: " + n2);
		
		// Q 가로와 세로 변수를 각각 만들고 방의 넓이를 구하시오
		int width;
		int height;
		width = 100;
		height = 50;
		System.out.println("방의넓이: " + (width * height));
				
	}

}

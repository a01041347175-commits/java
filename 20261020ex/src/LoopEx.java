import java.util.Scanner;

public class LoopEx {

	public static void main(String[] args) {
		
		/*
		 * 안녕하세요를 9회 출력
		 */
		// for (초기화; 조건식; 단계)
		// for (시작; 끝; 단계)
		
//		for (int i = 1; i < 10; i++) {			// i for문 안에서만 사용가능
//			System.out.println("안녕하세요.");
//		}
//		
//		int i = 1;								// i global
//		for (; i < 10; i++) {
//			System.out.println("HELLO.");
//		}
//		
//		int j = 0;								
//		for (j = 5; j < 10; j++) {
//			System.out.println("HI.");
//		}
//		
//		for (int k = 0; k < 10; ++k) {
//			System.out.println("O");
//		}
		
		// 1부터 사용자가 입력한 정수까지의 합을 구하는 프로그램을 만드시오
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("정수를 입력하시오.");
//		int inputData = scanner.nextInt();
//		
//		int sum = 0;
//		for (int i = 1; i <= inputData; i++) {
//			sum += i;
//		}
//		
//		System.out.println("sum: " + sum);
		
		//3단 구구단 출력
		//for (int i = 1; i < 10; i++) {
			//System.out.println("3 * " + i + " = " + (3 * i));
			//System.out.printf("3 * %d = %d%n", i, (3 * i));
			//String str = String.format("3 * %d = %d%n", i, (3 * i));
			//System.out.println(str);
			//System.out.println(String.format("3 * %d = %d%n", i, (3 * i)));
		//}
		
		// 전체 구구단 (가로모드, 세로모드) 출력
		int j = 1;
		for (; j < 10; j++) {
			for (int i = 1; i < 10; i++) {
				System.out.println(String.format("%d * %d = %d%n", j, i, (j * i)));
			
			}
		}
		
		
				
		//scanner.close();
		
		
	}

}

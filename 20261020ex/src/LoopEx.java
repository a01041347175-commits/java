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
		
//		for (int j = 2; j < 10; j++) {
//			for (int i = 1; i < 10; i++) {
//				System.out.println(String.format("%d * %d = %d%n", j, i, (j * i)));
//			
//			}
//		}
		
//		for (int j = 1; j < 10; j++) {
//			for (int i = 2; i < 10; i++) {
//				if (i == 9) {
//					System.out.printf("%d * %d = %d%n", i, j, (i * j));
//				} else {
//					System.out.printf("%d * %d = %d\t", i, j, (i * j));
//				}
//			}
//		}
		

		
//		for (double d = 0.0; d < 1; d += 0.1) {
//			System.out.printf("d: %f \n", d);
//		}
		
		// (중요) 중첩 for문을 이용할때 절대 3단계 이상은 사용하지 말자
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				for (int k = 0; k < 10; k ++) {
//					
//				}
//			}
//		}
		
		/*
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 */
//		for (int i = 1; i <= 5; i++) {
//			
//			for (int j = 0; j < i; j++) {
//				System.out.print("*");
//			}
//			
//			System.out.println();		
//		}
//		
//		for (int i = 1; i <= 5; i++) {
//			
//			for (int j = 0; j <= 5 - i; j++) {
//				System.out.print("*");
//			
//			}
//			System.out.println();
//		}
//		
//		for (int i = 1; i <= 5; i++) {
//			
//			for (int j = 0; j < 5 -i; j++) {
//				System.out.print(" ");
//				
//			}
//			for (int k = 0; k < i; k++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		// (심화)사용자가 정수를 입력하면 수만큼의 줄수의 트리모양 * 출력하라
		
		// 달력 만들기
		System.out.println("MON\tTUE\tWED\tTHU\tFRI\tSAT\tSUN");
		int offset = 3;
		int day = 1;
		for (int i = 0; i < 5; i++) {
			
			for (int j = 0; j < offset; j++) {
				System.out.print(String.format("%3c\t", '-'));
			}
			
			for (int j = 0; j < 7 - offset; j++) {
				
				if (day <= 30) {
						System.out.print(String.format("%3d\t", day));
					day++;
					
				} else {
					System.out.print(String.format("%3c\t", '-'));	
				}
			}
			offset = 0;
			System.out.println();
			
			
			
		}
		
		
		//scanner.close();
		
		
	}

}

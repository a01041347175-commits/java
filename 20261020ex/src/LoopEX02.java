
public class LoopEX02 {

	public static void main(String[] args) {
		
		/*
		 * 반복 흐름 제어
		 * break, continue
		 * 
		 * break : 프로그램 실행중 break를 만나면 즉시 중단
		 * continue : 반복 실행시 continue를 만나면 다음 반복으로 넘어감
		 */
		
		// 1 ~ 10까지의 정수의 합을 구하되, 합이 30을 넘으면 중단
		/*
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
			if (sum > 30)
				break;
		}
		System.out.println("sum: " + sum);
		
		// 1 ~ 10까지의 정수를 출려하되, 짝수만 출력한다.
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0)
				continue;
			
			System.out.println("i: " + i);
			
		}
		*/
		
		/*
		 * 반복문 이름 부여
		 * 반복문에 이름을 부여한다는 것은 for문 또는 while문에 명찰(Label)을 달아주는 것
		 * 명찰뒤에 콜론(:)을 붙인다.
		 * 사용하지는 않는다.
		 */
		
		/*
		 * 요구사항
		 * 1. 구구단 출력
		 * 2. 구구단을 출력할 때 짝수 곱셉은 생략하라.
		 * 3. 모든 구구단 곱셈 결과값을 덧셈하고, 합이 200을 초과하면 출력을 중단
		 */
		int sum = 0;
		loopLabel1:
		for (int i = 2; i < 10; i++) {
			
			loopLabel2:
			for (int k = 1; k < 10; k++) {
				
				if (k % 2 == 0)
					continue loopLabel2;
				
				sum += i * k;
				if (sum > 200)
					break loopLabel1;
				
				System.out.printf("%d * %d = %d \n", i, k, sum);
				
			}
			
		}
		
		
	}

}

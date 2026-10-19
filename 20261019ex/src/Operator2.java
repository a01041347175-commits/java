
public class Operator2 {

	public static void main(String[] args) {
		/*
		 * 1. 대입 연산자
		 */
		
		int no = 10; // = <- 대입(할당) 연산자
		// 대입(할당) 연산자란, 오른쪽의 값을 왼쪽에 대입(할당)하는 연산자
		
		// 2. 복합 대입 연산자
		/*
		 * += : 덧셈 후 할당
		 * -+ : 뺼셈 후 할당
		 * *= : 곱셈 후 할당
		 * /= : 나눗셈 후 할당
		 * %= : 나머지 연산 후 할당
		 */
		
		/*
	     * +=   no += 10;   no에 10을 더한 결괏값을 no에 대입한다.
	       -=   no -= 10;   no에 10을 뺀 결괏값을 no에 대입한다.
	       *=   no *= 10;   no에 10을 곱한 결괏값을 no에 대입한다.
	       /=   no /= 10;   no를 10으로 나눈 결괏값을 no에 대입한다.
	       %=   no %= 10;   no를 10으로 나눈 나머지를 no에 대입한다.
	     */
		
		// 3. 증감 연산자
		// ++, --
		no = 10;
		no++;
		System.out.println("no: " + no);
		no--;
		System.out.println("no: " + no);
		
		// 3-1. 전위 or 후위 연산자
		int num1 = 10;
		int result1 = 0;
		result1 = ++num1;
		System.out.println("result1: " + result1);
		System.out.println("num1: " + num1);
		
		int num2 = 10;
		int result2 = 0;
		result2 = num2++;
		System.out.println("result2: " + result2);
		System.out.println("num2: " + num2);
		
		int num3 = 10;
		int result3 = 0;
		result3 = (num3++);
		System.out.println("result3: " + result3);
		System.out.println("num3: " + (num3));
		
		
	}

}

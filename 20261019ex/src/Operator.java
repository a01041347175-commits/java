
public class Operator {

	public static void main(String[] args) {
		/*
		 * 연산자(Operator)
		 * 산술연산자, 대입(복합)연산자, 비교연산자, 논리연산자, 조건식연산자 ... 
		 */
		
		/*
	     * 산술 연산자   +, -, *, /, %, ++, --
	       할당 연산자   =, +=, -=, *=, /=, %=, &=, |=
	       비교 연산자   ==, !=, >, <, >=, <=
	       논리 연산자   &&, ||, !
	     */
		
		// 1. 덧셈 연산자
		// 1-1. 숫자 덧셈
		int num1 = 10;
		int num2 = 20;
		System.out.println("num1 + num2: " + (num1 + num2));
		
		float num3 = 0.1f;
		float num4 = 0.2f;
		System.out.println("num3 + num4: " + (num3 + num4));
		
		// 1-2. 문자열 덧셈(연결 연산자)
		String str1 = "Hello ";
		String str2 = "World";
		System.out.println("str1 + str2: " + (str1 + str2));
		
		//1-3 숫자 + 문자열 = 문자열 + 문자열
		System.out.println(10 + "Hello");
		System.out.println(3.14f + "Hello");
		
		// 참고 : 문자 덧셈 (unicode화)
		System.out.println('A' + 'B');
		System.out.println('가' + '나');
		
		// 2. 뺄셈 연산자
		// 2-1. 숫자 뺄셈
		num1 = 10; num2 = 20;
		System.out.println("num1 - num2: " + (num1 - num2));
		
		num3 = 0.1f; num4 = 0.2f;
		System.out.println("num3 - num4: " + (num3 - num4));
		
		// 2-2. 문자열 뺄셈
		str1 = "Hello"; str2 = "World";
//		System.out.println("str1 - str2:" + (str1 - str2));  에러 발생
		
		// 참고 : 문자 뺄셈
		System.out.println('A' - 'B');
		System.out.println('가' - '나');
		
		// 3. 곱셈 연산자
		num1 = 10; num2 = 20;
		System.out.println("num1 * num2: " +(num1 * num2));
		
		num3 = 0.1f; num4 = 0.2f;
		System.out.println("num3 * num4: " + (num3 * num4));
		
		System.out.println('A' * 'B');
		System.out.println('가' * '나');
		
		// 4. 나눗셈 연산자
		num1 = 10; num2 = 20;
		System.out.println("num1 / num2: " + (num1 / (float)num2));
		
		num3 = 0.8f; num4 = 0.2f;
		System.out.println("num3 / num4: " + (num3 / num4));
		
		System.out.println((int)'a');
		System.out.println((int)'A');
		System.out.println('a' / (float)'A');
		
		System.out.println(0/100);
//		System.out.println(100/0); 에러 발생
		
		// 5. 나머지 연산자
		num1 = 10; num2 = 3;
		System.out.println("num1 % num2: " + (num1 % num2));
		System.out.println('a' % 'A');
				
		
	}

}


public class Operator3 {

	public static void main(String[] args) {
		/*
		 * 비교 연산자
		 * 크고 작음을 나타내는 연산자
		 * <, >, <=, >=, ==, !=
		 */
		
		System.out.println(10 < 20);
		System.out.println(10 > 20);
		
		System.out.println(10 <= 20);
		System.out.println(10 >= 20);
		
		System.out.println(10 == 20);
		System.out.println(10 != 20);
		
		float num5 = 0.1f;
		double num6 = 0.1;
		System.out.println("num5: " + num5);
		System.out.println("num6: " + num6);
		System.out.println("num5 + num6: " + (num5 + num6));
		
		System.out.println("num5 == num6: " + (num5 == num6));
		System.out.println("num5 == num6: " + (num5 != num6));
		
		System.out.println("num5 > num6: " + (num5 > num6));
		System.out.println("num5 < num6: " + (num5 < num6));
		
		int num7 = 10;
		float num8 = 10.0f;
		// int + float = float + float -> num7 : 10.0f, num8 : 10.0f
		System.out.println("num7 > num8: " + (num7 > num8));
		System.out.println("num7 >= num8: " + (num7 >= num8));
		System.out.println("num7 < num8: " + (num7 < num8));
		System.out.println("num7 <= num8: " + (num7 <= num8));
		System.out.println("num7 == num8: " + (num7 == num8));
		System.out.println("num7 != num8: " + (num7 != num8));
		
		// 중요*
		// 문자열 비교
		// 1.비권장
		String str1 = "Hello";
		String str2 = "Hello";
		System.out.println("str1 == str2: " + (str1 == str2)); // 비권장
		
		// 2. 권장
		String str3 = new String("Hello");
		String str4 = new String("Hello");
		System.out.println("str3 == str4: " +(str3 == str4)); // 비권장
		System.out.println(str3.equals(str4)); // 문자열 비교 권장 사용법

	}

}

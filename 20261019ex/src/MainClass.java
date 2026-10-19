
public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 지정자에 사용할수 있는 옵션들
		 */
		
		// 1. [.precision] : 소수점 아래 자리수를 지정한다.
		float rate = 3.141592f;
		System.out.printf("rate: %f %n", rate);
		System.out.printf("rate: %.2f %n", rate);
		System.out.printf("rate: %.4f %n", rate);
		
		// 2. [width] : 전체 출력 자리수를 지정하고, 오른쪽 정렬한다.
		int num1 = 1;
		int num2 = 12;
		int num3 = 123;
		System.out.printf("num1: %d %n", num1);
		System.out.printf("num2: %d %n", num2);
		System.out.printf("num3: %d %n", num3);
		
		System.out.printf("num1: %3d %n", num1);
		System.out.printf("num2: %3d %n", num2);
		System.out.printf("num3: %3d %n", num3);
		
		System.out.printf("num1: %-3d %n", num1);
		System.out.printf("num2: %-3d %n", num2);
		System.out.printf("num3: %-3d %n", num3);
		
		// 3. [flags] : 전체 출력 자리수가 지정된 경우 빈칸을 0으로 채운다.
		int num4 = 1;
		int num5 = 12;
		int num6 = 123;
		System.out.printf("num4: %04d %n", num4);
		System.out.printf("num5: %04d %n", num5);
		System.out.printf("num6: %04d %n", num6);
		
		// 4. [argument_index$] : 데이터 적용 위치를 지정한다.
		int num7 = 1;
		int num8 = 2;
		int num9 = 3;
		int num10 = -1;
		System.out.printf("num7: %d, num8: %d, num9: %d, num10: %d %n", num7, num8, num9, num10);
		System.out.printf("num7: %2$d, num8: %4$d, num9: %3$d, num10: %1$d %n", num10, num7, num9, num8);
		
		/*
		 * 형식 문자열 반환하기 : String.format() === (javascript: ``)
		 */
		String res = String.format("이름은 %s이고, 나이는 %d살 입니다.%n", "홍길동", 20);
		System.out.println("res: " + res);
		// javascript
		// let str = "홍길동";
		// let age = 20;
		// let res = `이름은 ${str}이고, 나이는 ${age}살 입니다.`
		// console.log('res: ', res);

	}

}

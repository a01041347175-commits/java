import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 데이터 타입
		 * 메모리에 저장 할 데이터의 종류에 따라 할당 받는 메모리 크기가 다르게 된다.
		 * 각각의 메모리 크기 따라 데이터 종류를 구분하는 것을 말한다.
		 * 
		 * 메모리 단위
		 * bit - byte(8bit) - mega byte(1024byte) - giga byte(1024MB) - terra byte(1024GB)
		 * 
		 */
		
		// 정수 데이터 타입
		/*
		 * byte		 1byte(공간 차지)		-128 ~ 127
		 * short	 2byte(공간 차지)		-32,768 ~ 32,767
		 * int		 4byte(공간 차지)		-2,147,483,648 ~ 2,147,483,647
		 * long		 8byte(공간 차지)		-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
		 */
		
		byte byteNum = 117;
		System.out.println("byteNum: " + byteNum);
		
		byte byteNum01 = -128;
		System.out.println("byteNum01: " + byteNum01);
		
		byteNum01 = (byte)(byteNum01 - 1);
		System.out.println("byteNum01: " + byteNum01);
		
		short shortNum = 22768;
		System.out.println("shortNum: " + shortNum);
		int intNum = 1457544441;
		System.out.println("intNum: " + intNum);
		
		int intNum01 = -2147483648;
		System.out.println("intNum01: " + intNum01);
		
		intNum01 = intNum01 -1;
		System.out.println("intNum01: " + intNum01);
		
		long longNum = 723372036854775808L; // long 타입 사용시 l or L 을 마지막에 사용(보통 대문자)
		System.out.println("longNum: " + longNum);
		
		System.out.println("byte 최소값: " + Byte.MIN_VALUE);
		System.out.println("byte 최대값: " + Byte.MAX_VALUE);
		
		System.out.println("byte 최소값: " + Short.MIN_VALUE);
		System.out.println("byte 최대값: " + Short.MAX_VALUE);
		
		System.out.println("byte 최소값: " + Integer.MIN_VALUE);
		System.out.println("byte 최대값: " + Integer.MAX_VALUE);
		
		System.out.println("byte 최소값: " + Long.MIN_VALUE);
		System.out.println("byte 최대값: " + Long.MAX_VALUE);
		
		// 실수(부동소수점)
		/*
		 * float		4byte
		 * double		8byte
		 */
		
		float floatNum = 3.14f;
		System.out.println("floatNum: " + floatNum);
		
		double doubleNum = 3.14159265358979;
		System.out.println("doubleNum: " + doubleNum);
		
		System.out.println("float 최소값: " + Float.MIN_VALUE);
		System.out.println("float 최대값: " + Float.MAX_VALUE);
		
		System.out.println("double 최소값: " + Double.MIN_VALUE);
		System.out.println("double 최소값: " + Double.MAX_VALUE);
		
		float num1 = 3.14159265358979323846264338327950288f;
	    double num2 = 3.14159265358979323846264338327950288d;
	    
	    System.out.println("num1: " + num1);
	    System.out.println("num2: " + num2);
	    
	    // 논리 데이터 타입
	    /*
	     * 참(ture)과 거짓(false)
	     * boolean 	1byte	(true, false)
	     */
	    boolean flag = true;
	    System.out.println("flag: " + flag);
	    
	    // 문자와 문자열 데이터 타입
	    // 문자
	    /*
	     * 메모리에 문자 데이터를 저장하기 위해서 사용하는 데이터 타입
	     * char		2byte
	     */
	    char ch = 'a'; // 문자는 작은 따옴표 사용
	    System.out.println("ch: " + ch);
	    ch = 'b';
	    System.out.println("ch: " + ch);
	    // 빈문자(empty), 공백문자(space)
//	    char char1 = '';	//empty 불가
//	    char char2 = ' ';	//space 가능
//	    System.out.println("char2: " + char2);
	    
	    // 문자는 메모리에 저장될 때 정수(유니코드)로 저장이 된다.
	    char char1 = 'A';
	    System.out.println("char1: " + char1);
	    
	    int unicode = char1;
	    System.out.println("unicode: " + unicode);
	    
	    char char2 = 'ㄱ';
	    System.out.println("char2: " + char2);
	    
	    unicode = char2;
	    System.out.println("unicode: " + unicode);
	    
	    char char3 = 65;
	    System.out.println("char3: " + char3);
	    
	    char3 = 12593;
	    System.out.println("char3: " + char3);
	    
	    // 문자열
	    // String(문자열만 대문자로 시작)
	    String str1 = "Hello";
	    System.out.println("str1: " + str1);
	    
	    str1 = ""; // 가능
	    System.out.println("str1: " + str1);
	    str1 = " "; // 가능
	    System.out.println("str1: " + str1);
	    
	    // 콘솔을 이용한 데이터 입력, 출력
	    // 데이터 출력
	    System.out.print("hello java");  // ln : line의 약자
	    System.out.println("hello python");  
	    System.out.print("hello java\n");
	    System.out.println("hello python");
	    
	    String str = "hello~";
	    System.out.println(str);
	    /*
	     * 특수문자 정리
	     * \n : 개행
	     * \t : 탭(4칸 공백)
	     * \' : 작은 따옴표(')
	     * \" : 큰 따옴표(")
	     * \\ : 역 슬래시(\)
	     */
	    
	    System.out.print("이름\t학번\n");
	    System.out.println("Mr. H\t2020_000123");
	    System.out.println("Mr. K\t2020_000123");
	    
	    System.out.println("어머님께서는 \"밥 먹고 설거지 해놔라.\" 라고 하셨습니다.");
	    System.out.println("그래서 나는 \"네\" 라고 했습니다.");
	    
	    System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
	    System.out.println("\\\\\\2020-08-01\\\\\\");
	    
	    // 데이터 입력
	    Scanner scanner = new Scanner(System.in); // Scanner 외부로부터 데이터를 입력을 받는다.
	    
//	    String inputStr = scanner.nextLine();
//	    System.out.println("inputStr: " + inputStr);
	    
	    /*
	     * nextByte()	: 정수 입력
	     * nextInt()	: 정수 입력
	     * nextLong()	: 정수 입력
	     * nextFloat()	: 실수 입력
	     * nextDouble()	: 실수 입력
	     * nextLine()	: 문자열 입력
	     * nextBoolean(): 논리 입력
	     */
	    
	    /*
	    int inputInt = scanner.nextInt();
	    System.out.println("inputData: " + inputInt);
	    
	    scanner.nextLine();
	    
	    String inputString = scanner.nextLine();
	    System.out.println("inputString: " + inputString);
	    
	    scanner.close();
	    */
	    
	    String inputString = scanner.next();
	    System.out.println("inputString: " + inputString);
	    
	    inputString = scanner.nextLine();
	    System.out.println("inputString: " + inputString);
	    
	    scanner.close();
	    
	    
	    
	}

}

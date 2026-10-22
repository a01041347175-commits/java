package com.office.arrayex;

public class ArrayEX {

	public static void main(String[] args) {
		
		/*
		 * 배열 선언 방법 3가지
		 */
		// 1. 데이터타입 [] 배열변수명  - 권장
		int[] numbers1 = {1, 2, 3, 4, 5};
		
		// 2. 데이터타입 [] 배열변수명 = new 데이터타입[배열길이]  - 비권장
		int[] numbers2 = new int[5];
		numbers2[0] = 1;
		numbers2[1] = 2;
		numbers2[2] = 3;
		numbers2[3] = 4;
		numbers2[4] = 5;
		
		// 3. 데이터타입 [] 배열변수명 = new 데이터타입[]{1....}
		int[] numbers3 = new int[] {1, 2, 3, 4, 5};
		
		// 배열 데이터 조회: 인덱스를 이용한 데이터 조회
		int[] scores = {80, 90, 100, 75, 60};
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		System.out.println(scores[3]);
		System.out.println(scores[4]);
		
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("scores[%d]: %d\n", i, scores[i]);
		}
		
		/*
		 * 배열 데이터 수정 : 인덱스(index)를 이용한 데이터 수정
		 */
		int[] points = {80, 70, 100, 60, 90};
		for(int i = 0; i < points.length; i++) {
			System.out.printf("points[%d]: %d\n", i, points[i]);
		}
		
		// for each
		for (int point : points) {
			System.out.println("point: " + point);
		}
		
		points[0] = 800;
		System.out.println("points[0]: " + points[0]);
		
		/*
		 * java의 배열 특징
		 * 1. 배열은 단일 데이터타입만 저장 가능
		 * ex javascript) let nums = [1, 2, 3, 'hello'] - 가능
		 * ex java) int [] nums = [1, 2, 3, 4, 'hello'] - 불가능
		 * 2. 최초 선언된 배열의 길이는 변경 불가
		 * 3. 존재하지 않는 인덱스를 이용하게 되면 에러 발생
		 */
		// 2. ex
		int [] ns = {1, 2, 3}; // lenth : 3
//		ns = new int[5];  // 가능 
		
		// 3. ex
		System.out.println(ns[2]);
//		System.out.println(ns[3]); // 에러 발생
		
		
		
		/*
		 * 배열을 이용해서 학급 학생의 시험 성적, 총점, 평균을 출력
		 */
		int[] studentScores = {80, 95, 100, 70, 68, 74, 88, 98, 100, 76};
		int total = 0;
		float average = 0.0f;
		for (int i = 0; i < studentScores.length; i++) {
			// 학생 개인 점수 출력
			System.out.printf("studentScores[%d] score: %d\n", i, studentScores[i]);
			//총점
			total += studentScores[i];
			
		}
		// 총합 출력
		System.out.println("Total Score: " + total);
		// 평균 출력
		average = total / studentScores.length;
		System.out.println("Average: " + average);
		
		// 값이 없는 배열의 초기값은?
		int[] classes = new int[5];
		for (int i = 0; i < classes.length; i++) {
			System.out.println(classes[i]);
		}
		float[] averages = new float[5];
		for (int i = 0; i < averages.length; i++) {
			System.out.println(averages[i]);
		}
		
		// 배열 복사
		int number1 = 10;
		int number2 = 20;
		System.out.println("number1: " + number1);
		System.out.println("number2: " + number2);
		
		number2 = number1;
		System.out.println("number1: " + number1);
		System.out.println("number2: " + number2);
		
		number1 = 100;
		System.out.println("number1: " + number1);
		System.out.println("number2: " + number2);
		
		int[] numbers = {1, 2, 3};
		int[] numbersCopy = numbers;
		
		System.out.println("numbers: " + numbers);
		System.out.println("numbersCopy: " + numbersCopy);
		
		for(int i = 0; i < numbers.length; i++) {
			System.out.printf("numbers[%d]: %d\n", i, numbers[i]);
		}
		for(int i = 0; i < numbersCopy.length; i++) {
			System.out.printf("numbersCopy[%d]: %d\n", i, numbersCopy[i]);
		}
		numbers[0] = 100;
		System.out.println(numbersCopy[0]);
		
		// 깊은 복사
		// int[] numbers = {1, 2, 3}; --> int[] numbersDeepCopy
		int[] numbersDeepCopy = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numbersDeepCopy[i] = numbers[i];
		}
		for (int i = 0; i < numbersDeepCopy.length; i++) {
			System.out.printf("numberDeepCopy[%d]: %d\n", i, numbersDeepCopy[i]);
		}
		for(int i = 0; i < numbers.length; i++) {
			System.out.printf("numbers[%d]: %d\n", i, numbers[i]);
		}
		numbersDeepCopy[2] = 3000;
		System.out.println("numbersDeepCopy[2]: " + numbersDeepCopy[2]);
		System.out.println("numbers[2]: " + numbers[2]);
		
		// 배열 삭제
		int[] myScores = {80, 90, 100};
		System.out.println("myScores: " + myScores);
		
		myScores = null;
		System.out.println("myScores: " + myScores);
		
		// 2차원 배열
//		int [][] mns = new int [3][2];
//		System.out.println("mns: " + mns);
		/*
		 * int[] myScores == int myScores[] 후자는 잘 사용하지는 않는다.
		 * int [][] mns == int mns[][] 역시 후자는 잘 사용하지 않는다.
		 */
		// 2차원 배열 선언 1.
//		int[][] mns = {{1,2}, {10, 20}, {100, 200}};
		
		// 2차원 배열 선언 2.
		/*
		int[][] mns = new int[3][2];
		mns[0][0] = 1;
		mns[0][1] = 2;
		mns[1][0] = 10;
		mns[1][1] = 20;
		mns[2][0] = 100;
		mns[2][1] = 200;
		*/
		
		// 2차원 배열 선언 3.
		int [][] mns = new int[][] {{1,2}, {10, 20}, {100, 200}};
		
		// 2차원 배열 데이터 조회
		System.out.println(mns[0]);  // 2차원 배열의 주소값이 출력
		System.out.println(mns[0][0]);  // 2차원 배열의 값 출력
//		System.out.println(mns[0][2]);  // 에러 발생
		
		mns[0][0] = 1000;
		System.out.println(mns[0][0]);
		
		
		
	}

}

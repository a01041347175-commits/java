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
	}

}

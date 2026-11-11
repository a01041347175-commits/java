package com.office.exception;

public class StringBuilderEx {

	public static void main(String[] args) {
		
		String str = "";
		
		long beforeCurrentTime = System.currentTimeMillis();
		
		for (int i = 0; i < 400000; i++) {
			str += "s";
			
		}
		
		long afterCurrentTime = System.currentTimeMillis();
		
		System.out.println("1. 경과 시간: " + (afterCurrentTime - beforeCurrentTime));
		
		
		System.out.println("-------------------------------------");
		
		StringBuilder stringBuilder = new StringBuilder();
		
		beforeCurrentTime = System.currentTimeMillis();
		
		for (int i = 0; i < 400000; i++) {
			stringBuilder.append("s");
		}
		
		afterCurrentTime = System.currentTimeMillis();
		
		System.out.println("2. 경과 시간: " + (afterCurrentTime - beforeCurrentTime));
		
	}
	
}

package com.office.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class CollectionEx {

	public static void main(String[] args) {
		
		// ArrayList : 배열을 업그레이드
		
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		nums.add(40);
		nums.add(50);
		
		nums.remove(4);
		nums.remove(3);
		
		nums.add(2, 100);
		
		nums.clear();		// [] 내부데이터 전체 삭제
		
		// String -> StringBuffer -> StringBuilder
		// Array -> Vector -> ArrayList
		
		List<Integer> nums2 = new Vector<Integer>();
		nums2.add(10);
		nums2.add(20);
		nums2.add(30);
		nums2.add(40);
		nums2.add(50);
		
		nums2.remove(4);
		nums2.remove(3);
		
		nums2.add(2, 100);
		
		nums2.clear();
		
		Map<String, String> hashMap = new HashMap<String, String>();
		
		
	}
	
}

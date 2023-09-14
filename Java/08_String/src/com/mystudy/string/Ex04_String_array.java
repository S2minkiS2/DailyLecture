package com.mystudy.string;

public class Ex04_String_array {

	public static void main(String[] args) {
		int[] nums = {10, 20, 30, 40, 50};
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(i + " : " + nums[i]);
		}
		
		System.out.println("=== 개선된(향상된) for문 ===");
		// for (타입 변수명 : 집합객체) {}
		
		for (int num : nums) { //여러개가 있는 집합객체의 것을 알아서 변수에 꺼내담아준다
			System.out.println(num);
		}
		//알아서
		
		System.out.println("=====================");
		String[] names = {"홍길동1", "홍길동2", "홍길동3", "홍길동4"};
		for (int i = 0; i < names.length; i++) {
			System.out.println(i + " : " + names[i] + " - " 
					+ names[i].length());
			//꺼낸 값이 string 타입이므로 string메소드 사용 가능
		}
		System.out.println("=====================");
		
		for (String name : names) {
			System.out.println(name);
		}
	}

}

package com.mystudy.array;

public class Ex04_array_swap {

	public static void main(String[] args) {
		//변수값 서로 교환하기
		int a = 300;
		int b = 100;
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("---- 바 꿔 ----");
		
		
		int temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("=========================");
		
		int[] nums = {100, 200, 300, 400, 500};
		System.out.println("배열의 크기 : " + nums.length);
		
		//배열 전체 데이터 화면출력
		
		temp = nums[0];
		nums[0] = nums[4];
		nums[4] = temp;
		
		temp = nums[1];
		nums[1] = nums[3];
		nums[3] = temp;
		for (int i = 0; i < nums.length; i++) {
			System.out.print(" "+ nums[i]);
		}
		
		System.out.println();
		System.out.println("=========================");
		
		int[] nums2 = {100, 200, 300, 400, 500, 600, 700, 800, 900};
		
		for (int i = 0; i < nums2.length/2; i++) {
			temp = nums2[i];
			nums2[i] = nums2[nums2.length - (1 + i)]; // -1 -i 보다 -(1+i)로 해주면 가독성이 더 좋다.
			nums2[nums2.length - (1 + i)] = temp; // -1 -i 보다 -(1+i)로 해주면 가독성이 더 좋다.
		}
		
		for (int i = 0; i < nums2.length; i++) {
			System.out.print(" " + nums2[i]);
		}
		
		
	}

}

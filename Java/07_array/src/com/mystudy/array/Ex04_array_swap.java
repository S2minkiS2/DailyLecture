package com.mystudy.array;

import java.util.Arrays;

public class Ex04_array_swap {

	public static void main(String[] args) {
		//변수값 서로 교환하기
		int a = 100;
		int b = 200;
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
//		a 200
//		b  
//		c 100
		
		System.out.println(" -- 바꾼 후 결과 --");
		int c = a; // a 값을 복사후
		a = b; //a가 값을 받는다
		b = c; ///
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("=================");
		System.out.println(c);

		
		
		
		System.out.println("=======데이터뒤집기==========");
		//             0    1 	 2	  3    4   
		int[] nums = {100, 200, 300, 400, 500, 600 ,700 ,800 ,900};
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i] + " ");
		}
		System.out.println("배열의 크기 : " + nums.length);
		

//		=================내 식=====================
		for (int i = 1 ; i <= nums.length/2 ; i++) {
			int temp = nums[nums.length/2-i]; 
			nums[nums.length/2-i] = nums[nums.length/2+i];
			nums[nums.length/2+i] = temp;
		}
		System.out.println(Arrays.toString(nums));
//		=================선생님 식==================
		for (int i = 0 ; i < 3 ; i++) {
			int temp = nums[i]; 
			nums[i] = nums[nums.length - (i + 1)];
			nums[nums.length - (i + 1)] = temp;
		}
		System.out.println(Arrays.toString(nums));
//		===========================================
		}
		
//		reverse어쩌구
		static void reverse(int[] nums) {
		
		
		
		//배열 전체 데이터 화면출력
		printArray(nums);
	}
				
		static void printArray(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		

//		2 - 2
//		2 + 2
//		2 - 1
//		2 + 1
//		
//		2 - 2
//		2 - 1
//		2 + 1
//		2 + 2
	
		
		
		
		// 배열길이 / 배열 인덱스 
		//2번 바꾸기
		
				
//		temp[]
//		0 6
//		1 5
//		2 4
//		int temp = nums[0];
//		nums[0] = nums[4];
//		nums[4] = temp;
//		
////		nums[2-2]
////		nums[2+2]
//		
//		temp = nums[1];
//		nums[1] = nums[3];
//		nums[3] = temp;
//		nums[2-1]
//		nums[2+1]
		
		
		
//		1, 5 교환 2,4 교환
	
		//배열 전체 데이터 화면출력
		// nums : {500 200 300 400 100}
		//배열 데이터를 뒤집기 
		//위치 변경된 배열 전체 데이터 화면 출력
		
		
	
		
	}



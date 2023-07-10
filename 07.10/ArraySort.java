package com.mystudy.array2;

import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {
		///배열 숫자 데이터 정렬(Sort) - 오름차순ASC, 내림차순DESC
		
		int[] num = {100, 90, 80, 70, 60, 50, 40, 20, 10, 1};
		System.out.println("numbers : " + num + " 그리고 길이 : " + num.length);
		
		printData(num);
		
		System.out.println("=== 위 배열 정렬시작 ===");
		
		printArray(num);
		
	}
		
	
	static void printArray(int[] nums) {
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = 0; j < nums.length-1; j++) { //밑의 식에서 nums[j+1]이 배열의 끝 인덱스인 nums[9]를 넘으면 안되므로
				if (nums[j] > nums[j+1]){
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
			System.out.println(i+1 + " 번째 정렬 시도 ");
			System.out.println(Arrays.toString(nums));
		}
	}
	
	
	
	
	
	static void printData(int[] nums) {
		for(int i =0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
	
	
}

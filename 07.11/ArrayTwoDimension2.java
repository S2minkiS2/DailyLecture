package com.mystudy.array4_2dim;

public class ArrayTwoDimension2 {

	public static void main(String[] args) {
		
		int[][] nums = new int[3][]; //2차원 배열 크기값은 반드시 지정. 대괄호를 비울 거면 아래처럼 중괄호로 값 생성
		int[][] nums2 = new int[][] {};  //이런 방식도 가능
		
		//방법1. new int[2] - new 사용 1차원 배열 생성 선언.
		nums[0]= new int[2]; //nums[0]은 데이터 두개를 가리키는 주소값. 
		nums[0][0] = 10;
		nums[0][1] = 20;
		
		//방법2. new int[] {30, 40} - new 사용 1차원 배열과 데이터 동시 입력.
		nums[1] = new int[] {30, 40};
		
		//방법3.(x) {30, 40} //컴파일 오류
//		nums[3] = {30, 40};
		nums[2] = new int[] {50, 60, 70, 80};
		
		
		
	}

}

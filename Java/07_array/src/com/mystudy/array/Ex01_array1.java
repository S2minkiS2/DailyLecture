package com.mystudy.array;

import java.util.Arrays;

public class Ex01_array1 {

	public static void main(String[] args) {
		// 배열(array) : 동일한 데이터 타입들의 연속된 저장 공간
//		                                  =>인덱스 번호만 알면 값을 알 수 있다
		//배열의 선언 : 자료형[] 변수명
		//           type
		//변수에 값을 저장 : 배열변수명[인덱스번호] = 값;
		/* 배열의 선언 및 생성
		1. 자료형[] 변수명 = new 자료형[갯수];	
		   자료형 변수명[] = new 자료형[갯수];
		2. 자료형[] 변수명 = new 자료형[] {값1,값2,...,값n};
		3. 자료형[] 변수명 = {값1,값2,...,값n};
		 -----------------*/
		int[] arr = new int[5]; 
		// int값 5개를 저장할 수 있는 연속된 5개의 저장공간 생성
		System.out.println("arr : " + arr); 
		// arr에 저장하는 것은 주소값. 배열 : 참조형 데이터
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("arr[4] : " + arr[4]); //초기값은 0
		System.out.println("----");
		
		for (int i = 0; i < 5; i++) { //for문으로 인덱스 번호 처리할 때 0부터 시작
			System.out.println(i + ": " + arr[i]);
		}
		
		arr[0] = 10; // 배열의 첫번째 위치 (인덱스 번호 0번)에 10 설정(저장)
		System.out.println("arr[0] : " + arr[0]);
		arr[1] = 11; // 
		System.out.println("arr[1] : " + arr[1]);
		arr[2] = 12;
		arr[3] = 13;
		arr[4] = 14; // 마지막데이터((크기/길이/갯수)-1)
//		arr[5] = 15; // ArrayIndexOutOfBoundsException
		
		System.out.println("-------------------------");
		for (int i = 0; i < 5; i++) {  //반복인자 사용
			System.out.println(i + ": " + arr[i]); 
		}

		System.out.println("--------배열 length 속성---------");
		// 배열의 크기(길이)를 확인할 수 있는 속성값
		System.out.println("arr.length : " + arr.length);
	
		for (int i = 0; i < arr.length; i++) {  
			//변수를 쓰면 배열의 크기 변화에 대응하기 좋음
			System.out.println(i + ": " + arr[i]);
		}
		System.out.println("----배열 선언 형태 2번-----");
		//2. 자료형[] 변수명 = new 자료형[] {값1,값2,...,값n};
		// : 저장공간을 만들면서 바로 데이터를 넣어줄 수 있다.
		// 중괄호 이용해서 배열값 지정
		//						0,   1 	  2		3    4	
		int[] arr2 = new int[] {100, 101, 102, 103, 104};
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

		System.out.println("----배열 선언 형태 3번-----");
		//3. 자료형[] 변수명 = {값1,값2,...,값n};
		int[] arr3 = {10, 11, 12, 13, 14, 15};
		for (int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		
		System.out.println("=====================");
		int[] nums = new int[10];
		//초기값 설정 : 1~10 숫자를 저장
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1; // i값을 바꾸는게 아님
		}
		
		//배열값 확인
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " "); // i값을 바꾸는게 아님
		}
		System.out.println();
		
		System.out.println("========================");
		System.out.println("==== 영어 알파벳 문자 저장/출력 (A~Z)====");
		
		char[] ch = new char[26];
		System.out.println(Arrays.toString(ch)); //문자열로 만들어서 리턴해준다
		System.out.println("-" + ch[0] + "-");
		System.out.println("-" + '\u0000' + "-");
		ch[0] = 'A'; //65
		ch[1] = 'B'; 
		ch[2] = 'C'; 
		System.out.println("-------");
		System.out.println(Arrays.toString(ch)); //문자열로 만들어서 리턴해준다
		
//		ch[0] = 'A'+ 0;  //A
//		ch[0] = 'A'+ 1;  //B
//		ch[0] = 'A'+ 2;  //C // 숫자는 char로 자동형변환
//		ch[0] = 'A'+ 3;  //D
		System.out.println("-------");
		
		//(실습)데이터 A~Z 일괄입력 (반복문 사용)
		 //문자열로 만들어서 리턴해준다
//		65 66 67 68 ~ 65+26
		
//		char[] ch = new char[26];
		for (int i = 0; i < ch.length; i++) {
			ch[i] = (char) (65 + i); //연산 값이 int였기 때문에 char로 형변환
		}
		
		for (int i = 0; i <ch.length; i++) {
			System.out.print(ch[i] + ", ");
		}
		
		
		//(실습)배열 데이터 화면 출력 (반복문 사용)
		
	}

}

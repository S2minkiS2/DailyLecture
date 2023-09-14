package com.mystudy.array3_copy;

import java.util.Arrays;

public class ArrayCopy2_exam {

	public static void main(String[] args) {
		/* 문제1 : int 타입의 데이터 4개를 저장하 수 있는 배열(num1)에
		   1. 10, 20, 30, 40 숫자를 입력하고 화면 출력 (반복문)
		   2. 세번째 데이터를 100으로 바꾸고 화면 출력 (위치를 알고있을 때 데이터 바꾸기)
		   3. 20 숫자를 찾아서 99로 변경 (데이터를 찾아 바꾸기 - 어디에 있는지 모르니까 20이냐? 20이냐? 하고나서 20이라고 대답하면 바꿔주삼)
		   -------------------------*/
//		int[] num1 = new int[4];
		
		int[] num1 = {10, 20, 30, 40};
		
		//printData("num1", num1)
		for (int i = 0; i < num1.length; i++) {
			System.out.print(num1[i] + " "); 
		}
		
		System.out.println();
		System.out.println("1-2.");
		num1[2] = 100;
		System.out.println(num1[2]);
		System.out.println();
		

		System.out.println("1-3.");
		
		for (int i = 0; i < num1.length; i++) {
			if (num1[i] == 20) {
				num1[i] = 99;
			} else {
			}
		}
		
		for (int i = 0; i < num1.length; i++) {
			System.out.print(num1[i] + " "); 
		}
		
		
		/* 문제2 : num1과 크기가 같은 배열 num1Copy를 만들고
		 num1Copy에 num1 데이터를 복사하고 화면 출력
		 주소값 복사인지 깊은복사(물리적복사)여부확인
		 */
		
		
		//num1과 크기가 같은 배열
		int[] num1Copy = new int[num1.length];  
		
		//num1을 num1Copy에 데이터 복사
		for (int i = 0; i < num1.length; i++) {
			num1Copy[i] = num1[i];
		}
		System.out.println();
		
		for (int i = 0; i < num1Copy.length; i++) {
			System.out.print(num1Copy[i] + " "); 
		}
		
		System.out.println();
		System.out.println("num1 == num1Copy : " + (num1 == num1Copy));
		//주소 값이 같냐? 동일객체냐?
		
		System.out.println(" \n=== 1차원 배열 clone() 처리 === ");
		num1Copy = num1.clone();
		printData("num1Copy", num1Copy);
		System.out.println("num1 == num1Copy : " + (num1 == num1Copy));
		
		System.out.println(" \n=== 1차원 배열 Arrays.copyOf() 처리 === ");
		num1Copy = Arrays.copyOf(num1, num1.length);
		printData("num1Copy", num1Copy);
		System.out.println("num1 == num1Copy : " + (num1 == num1Copy));
		
		
		
		
		 
	}

	private static void printData(String string, int[] num1Copy) {
		// TODO Auto-generated method stub
		
	}

}

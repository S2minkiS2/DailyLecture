package com.mystudy.array3_copy;

import java.util.Arrays;

public class ArrayCopy2_exam {
	public static void main(String[] args) {
		/* 	문제1: int 타입의 데이터 4개를 저장할 수 있는 배열을 만들어라
		 	1. 10, 20, 30, 40 숫자를 입력하고 화면 출력 (반복문으로)Arrays.String 쓰지말고.
		 	2. 세번째 데이터를 100으로 바꾸고 화면 출력, [2]
		 	3. 20 숫자를 찾아서 99로 변경후 화면출력
		 	----------------------------------------------------------------------
		 */
		
		//문제1
		int[] array = new int[4];
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		for (int i = 0; i < 4; i++) {
			System.out.print("array["+ i + "]: " + array[i] + " ");
		}
		
		System.out.println();
		
		// 3번째 데이터 100으로 바꿈
		array[2] = 100;
		for (int i = 0; i < 4; i++) {
			System.out.print("array["+ i + "]: " + array[i] + " ");
		}
		
		System.out.println();
		
		// 20을 찾아 99로 바꿈
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 20) {
				array[i] = 99;
			} // 만약 break; 들어가면 한번만 수행하고 끝
		}
		for (int i = 0; i < 4; i++) {
			System.out.print("array["+ i + "]: " + array[i] + " ");
		}
		
		System.out.println();
		System.out.println("==== 문제 1 끝 ====");
	
		
		/*문제2: num1 과 크기가 같은 배열을 num1copy 를 만들고 
	 	num1copy 에다가 num1 데이터를 복사하고 화면 출력
	 	주소값 복사인지, 물리적 복사인지 여부 확인도 해봐라 (인스턴스값 출력과 == 비교)
	 	----------------------------------------------------------------------
		*/
		System.out.println("==== 문제 2 시작 ====");
		//첫번째 복사 방법
		System.out.println("----- 복사 첫번째 방법 -----");
		
		int[] arrayCopy01 = new int[array.length];
		System.arraycopy(array, 0, arrayCopy01, 0, arrayCopy01.length);
		
		for (int i = 0; i < 4; i++) {
			System.out.print("arrayCopy["+ i + "]: " + arrayCopy01[i] + " ");
		}
		
		System.out.println();
		System.out.println("array == arrayCopy01? : " + (array == arrayCopy01));
		
	
		//두번째 복사 방법 
		System.out.println("----- 복사 두번째 방법 -----");
		
		int[] arrayCopy02 = array.clone(); //= 목표를 통째로 복사한다
		
		for (int i = 0; i < 4; i++) {
			System.out.print("arrayCopy02["+ i + "]: " + arrayCopy02[i] + " ");
		}
		
		System.out.println();
		System.out.println("array == arrayCopy02? : " + (array == arrayCopy02));
		
		
		//세번째 복사 방법
		System.out.println("----- 복사 세번째 방법 -----");
		
		int[] arrayCopy03 = Arrays.copyOf(array, array.length); // 목표를 정하고, 복사할 길이를 정한다.
		
		for (int i = 0; i < 4; i++) {
			System.out.print("arrayCopy03["+ i + "]: " + arrayCopy03[i] + " ");
		}
		
		System.out.println();
		System.out.println("array == arrayCopy03? : " + (array == arrayCopy03));
		
		
		//네번째 복사 방법
		System.out.println("----- 복사 네번째 방법 -----");
		
		int[] arrayCopy04 = Arrays.copyOfRange(array, 0, array.length); //= 목표를 정하고, 복사할 초기 인덱스와 끝 인덱스를 정한다.
		
		for (int i = 0; i < 4; i++) {
			System.out.print("arrayCopy04["+ i + "]: " + arrayCopy04[i] + " ");
		}
		
		System.out.println();
		System.out.println("array == arrayCopy04? : " + (array == arrayCopy04));
		
	}
	
}

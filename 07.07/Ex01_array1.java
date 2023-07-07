package com.mystudy.array;

import java.util.Arrays;

public class Ex01_array1 {

	public static void main(String[] args) {
		// 배열(array) : 동일한 데이터 타입들의 연속된 저장 공간
		// 배열의 선언 : 자료형[] 변수명
		// 변수에 값을 저장 : 배열변수명[인덱스번호] = 값;
		/*
		 * 배열의 선언 및 생성 1. 자료형[] 변수명 = new 자료형[갯수]; 자료형 변수명[] = new 자료형[갯수]; 2. 자료형[] 변수명
		 * = new 자료형[] {값1, 값2, 값3, ... , 값n}; //갯수가 정해지지 않았을 때? 3. 자료형[] 변수명 = {값1, 값2,
		 * 값3, ... , 값n}; ----------------
		 */
		int[] arr = new int[5];
		System.out.println("arr : " + arr); // [I@15db9742 = 주소값에'[' 대괄호는 배열이라는 의미
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("------------------");

		for (int i = 0; i < 5; i++) { // 배열 사용할 때, 0부터 시작해서 갯수에 해당하는 숫자로 가독성이 좋게함이 정석. <= 안쓰고 < 쓴다.
			System.out.println(i + " : " + arr[i]);
		}

		System.out.println("---------값 대입 후 --------------");
		arr[0] = 10; // 배열의 첫번째 위치(인덱스 번호 0번)에 10 설정(저장)
		arr[1] = 11;
		arr[2] = 12;
		arr[3] = 13;
		arr[4] = 14; // 마지막 데이터

		for (int i = 0; i < 5; i++) { // 배열 사용할 때, 0부터 시작해서 갯수에 해당하는 숫자로 가독성이 좋게함이 정석. <= 안쓰고, < 쓴다.
			System.out.println(i + " : " + arr[i]);
		}
		System.out.println("--- 배열 length 속성 ---");
		// 배열의 크기를 확인할 수 있는 속성값 == arr.length
		System.out.println("arr.length : " + arr.length);

		System.out.println("========= 배열선언 형태 2번 ========");
		// 2. 자료형[] 변수명 = new 자료형[] {값1, 값2, 값3, ... , 값n}; //갯수가 정해지지 않았을 때?
		// index번호 : 0 1 2 3 4
		int[] arr2 = new int[] { 100, 101, 102, 103, 104 };
		for (int i = 0; i < 5; i++) {
			System.out.println("인덱스" + i + " : " + arr2[i]);
		}

		System.out.println("========= 배열선언 형태 3번 ========");
		// 자료형[] 변수명 = {값1, 값2, 값3, ... , 값n};
		int[] arr3 = { 10, 11, 12, 13, 14, 15 };
		for (int i = 0; i < arr3.length; i++) {
			System.out.println("인덱스" + i + " : " + arr3[i]);
		}

		System.out.println("================================");
		int[] nums = new int[10];
		// 반복문으로 초기값 설정: 1~10 숫자를 저장
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
			System.out.print("nums[" + i + "]" + " : " + nums[i] + ", ");
		}

		System.out.println();
		System.out.println("================================");

		System.out.println("==== 영어 알파벳 문자 저장/출력(A~Z) ====");

		char[] ch = new char[26];
		System.out.println(Arrays.toString(ch));

		ch[0] = 'A'; // 65라는 숫자값
		ch[1] = 'B'; // 66 <--- 65 + 1
		ch[2] = 'C'; // 67 <--- 65 + 2
		ch[3] = 'A' + 3; // 65 + 3
		System.out.println(Arrays.toString(ch));

		for (int i = 0; i < ch.length; i++) {
			ch[i] = (char) ('A' + i); // int 자료형과 char 자료형의 연산 결과는 int형으로 나온다. ch 배열이 char 형식이므로, int형 결과를 char로 명시적
										// 형변환 해줘야 한다.
		}
		System.out.println(Arrays.toString(ch)); // 이 메서드는 배열의 요소를 문자열로 변환하여 반환하는 역할을 합니다.

		System.out.println("================================");

		// (실습) 데이터 A~Z 일괄입력(반복문 사용)
		// (실습) 배열 데이터 화면 출력 (반복문 사용)
		
		char[] alph = new char[26];
		for (int i = 0; i < alph.length; i++) {
			alph[i] = (char) ('A' + i);
			System.out.print(alph[i] + " ");
		}

		
		
		
		
	}

}

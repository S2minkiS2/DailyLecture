package com.mystudy.string;

import java.util.Arrays;

public class Ex04_String_array_exam {

	public static void main(String[] args) {
		/*
		 * String[]과 String 메소드 사용 실습 문자열 :
		 * "홍길동","이순신","이순신","을지문덕","김유신","연개소문","Tom","TOM" 1. 위의 문자열 값을 저장할 수 있는 문자열
		 * 배열(names) 변수를 선언하고 입력 2. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력 출력 예)
		 * 홍길동,이순신,이순신,을지문덕.... 3. 배열에 있는 데이터의 첫 글자만 출력-구분자 콤마(,) 사용 한 라인에 출력 출력 예)
		 * 홍,이,이,을,김,연,T,T... 4. 이름의 글자수가 4글자 이상인 이름을 검색해서 "인덱스번호:이름" 형태로 출력 예) 3:을지문덕
		 * 5. 이름이 같은 데이터를 "인덱스번호:이름=인덱스번호:이름" 형태로 출력 예) 1:이순신=2:이순신 (기타) 이름 비교시에는 대소문자
		 * 구분 없이 비교처리(Tom, TOM 은 같다)
		 * =========================================================
		 */

		// 문제1
		String[] names = { "홍길동", "이순신", "이순신", "을지문덕", "김유신", "연개소문", "Tom", "TOM"};

		// 문제2
		for (String charNames : names) {
			System.out.print(charNames);
		}
		System.out.println();

		// 문제2-2
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i]);
			if (i < names.length - 1) {
				System.out.print(", ");
			}
		}

		System.out.println("-------------------------");// 좋은 아이디어다. 본 받자
		for (int i = 0; i < names.length; i++) {
			if (i >= 1) {
				System.out.print(", ");
			}
			System.out.print(names[i]);
		}

		System.out.println();

		// 패턴: 이름, / 이름(마지막)
		for (int i = 0; i < names.length; i++) {
			// 마지막 데이터니?
			if (i == names.length - 1) {
				System.out.print(names[i]);
			} else {
				System.out.print(names[i] + ", ");
			}
		}
		System.out.println();

		// 또 다른 방법
		boolean isFirst = true;
		for (String name : names) {
			if (isFirst) {
				System.out.print(name);
				isFirst = false;
			} else {
				System.out.print(", " + name);
			}
		}
		System.out.println();

		// 문제3
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i].substring(0, 1));
			if (i < names.length - 1) {
				System.out.print(", ");
			}
		}

		System.out.println();

		// 문제4
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() >= 4) {
				System.out.print(i + names[i] + "  ");
			}
		}
		System.out.println();

		// 문제5

//		System.out.println(names[6].equalsIgnoreCase(names[7])); //equalsIgnoreCase() 한글도 된다.

		for (int i = 0; i < names.length - 1; i++) { // -1은 마지막 인덱스 전까지 수를 비교기준으로 하기 위함
			for (int j = (i + 1); j < names.length; j++) {
				if (names[i].equalsIgnoreCase(names[j])) {
					System.out.println(i + ":" + names[i] + " = " + j + ":" + names[j]);
				}
			}
		}
		

	}

}

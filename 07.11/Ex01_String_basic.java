package com.mystudy.string;

public class Ex01_String_basic {

	public static void main(String[] args) {
		// String 클래스 : 문자열 저장, 처리하기 위한 클래스(참조형)		
		// String 데이터는 불변이다 == final
		// -----------------------------------------------
		// 사용형식 2가지
		// String str = "신민기 최고"; //기본 데이터 타입처럼 사용 가능
		// String str = new String("신민기 최고"); //인스턴스 생성
		//------------------------------------------------
		String str1 = "신민기";
		String str2 = "신민기";
		
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		// == : 객체(인스턴스, 주소값) 비교(동일 객체 여부 확인)
		System.out.println("str1 == str2 : " + (str1 == str2)); //같은 주소값 == 동일 인스턴스
		System.out.println("str1 == str2 : " + str1.equals(str2)); //같은 글자인가요?
		
		System.out.println("-----------------------------------");
		
		String strObj1 = new String("신민기");
		System.out.println("str1 == strObj1 : " + (str1 == strObj1)); // 다른 주소값, 다른 인스턴스
		System.out.println("str1 == strObj1 : " + str1.equals(strObj1)); //같은 글자
		
		System.out.println("-----------------------------------");
		
		String strObj2 = new String("신민기");
		System.out.println("strObj1 == strObj2 : " + (strObj1 == strObj2)); // 다른 주소값, 다른 인스턴스
		System.out.println("strObj1 == strObj2 : " + strObj1.equals(strObj2)); //같은 글자
		
		//문자열 값 비교는 반드시 equals() 사용하세요
		
		
	}

}

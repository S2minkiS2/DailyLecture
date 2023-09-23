package com.mystudy.string;

public class Ex01_String_basic {

	public static void main(String[] args) {
		// String 클래스 : 문자열 저장, 처리하기 위한 클래스 (참조형 데이터 타입) 
		// String 클래스 : 참조형 데이터 타입 
		// 		- 모든 참조형 데이터는 객체 생성 후 접근한다
		// String 데이터는 불변이다.(immutable) 
		// 		-변수의 데이터는 바꿀 수 있지만 객체에 저장된 String 데이터는 불변
		// ---------------------------------------
		// 사용 형식 2가지
		// 1. String str = "홍길동"; //"홍길동"은 리터럴 값
		// 		- 변수 선언 후 데이터 저장 (기본 데이터 타입처럼 사용 가능)
		// 2. String str = new String ("홍길동"); 
		// 		- 객체(인스턴스) 생성
		
		String str1 = "홍길동";
		String str2 = "홍길동";
		//하나의 객체를 가리키는 형태 : 같은 주소 공유, 저장된 문자 같음, 동일객체
		
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("str1 == str2 : " + str1 == str2);
		//   ㄴ 문자열 붙이기 처리가 되어 앞의 값과 맨뒤의 값 하나 비교// false
		System.out.println("str1 == str2 : " + (str1 == str2));
		// == : 객체(인스턴스, 주소값) 비교
		System.out.println("str1.equals(str2) : " + (str1.equals(str2)));
		
		String strObj1 = new String("홍길동");
		String strObj2 = new String("홍길동");
		System.out.println("strObj1 : " + strObj1);
		System.out.println("strObj2 : " + strObj2);
		System.out.println("str1 == strObj1 : " + (str1 == strObj1));
		System.out.println("str1 == strObj1 : " + (str1.equals(strObj1)));
		System.out.println("strObj1 == strObj2 : " + (strObj1 == strObj2));
		System.out.println("str2.equals(strObj2) : " + str2.equals(strObj2));
		
		System.out.println("== 문자열값 비교 equals() 사용 ==== ");
		// equals() : 문자열 값을 비교할 때는 반드시 equals()사용
		System.out.println("str1.equals(str2) : " + (str1.equals(str2)));
		System.out.println("str1 == strObj1 : " + (str1.equals(strObj1)));
		System.out.println("str2.equals(strObj2) : " + str2.equals(strObj2));

		
		
	}

}

package com.mystudy.list4_list_exam;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayList_String_Exam {

	public static void main(String[] args) {
		/* List 중 ArrayList<String> 사용 실습
		문자열 : "홍길동","이순신","이순신","을지문덕"
		1. ArrayList 타입 names 변수를 선언하고 데이터 입력
		2. List에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
		   출력 예) 홍길동,이순신,이순신,을지문덕
		3. List에 있는 데이터의 첫 글자만 출력
		   출력 예) 홍,이,이,을
		4. 이름이 을지문덕 찾아서 "인덱스번호:이름" 형태로 출력
		   예) 3:을지문덕
		5. 이름이 "이순신" 데이터 모두 삭제
		============================================ */
		System.out.println("1.===========");
		ArrayList<String> names = new ArrayList<>();
		names.add("홍길동");
		names.add("이순신");
		names.add("이순신");
		names.add("을지문덕");
		
		//List<String> names = new ArrayList<String>();
		String[] str = {"홍길동","이순신","이순신","을지문덕"};
		for (int i = 0; i < names.size(); i++) {
			names.add(str[i]);
		}
		
		System.out.println("2.===========");
//		 StringBuilder names1 = name
//		StringBuilder strNames = new StringBuilder();
//		strNames = "홍길동"
		for (int i = 0; i < names.size(); i++) {
			if (i == 0) {
				System.out.print(names.get(i));
			} else { 
				System.out.print("," + names.get(i));
			}
		}
//		for (int i = 0; i < names.size(); i++) {
//			System.out.print(names.get(i) + ", ");
//		}
		
		System.out.println("\n3.===========");
		//3-과정
//		System.out.println(names.get(0));
//		String first = names.get(0); //0번째 저장
//		System.out.println(first); //0번째 출력
//		System.out.println(first.charAt(0));
		//3-과정 끝
		for (int i = 0; i < names.size(); i++) {
			String first = names.get(i);
			System.out.print(first.charAt(0) + ", ");
		}
		
		//선생님
		boolean isFirst = true;
		for (String name : names) {
			if (isFirst) {
				System.out.println(name.charAt(0));
			} else {
				System.out.println("," + name.charAt(0));
			}
		}
		
		System.out.println("\n4.===========");
//		4. 이름이 을지문덕 찾아서 "인덱스번호:이름" 형태로 출력
//		   예) 3:을지문덕
		
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equals("을지문덕")) {
				System.out.print("인덱스번호 " + names.indexOf("을지문덕") 
					+ " : " + names.get(i));
			}
		}
		//4-과정
//		System.out.println(names.get(3).equals("을지문덕"));
//		System.out.println(names.indexOf("을지문덕"));
//		System.out.println(names.get(3));
		//과정 끝
		
		System.out.println("\n5.===========");
		for (int i = names.size() - 1 ; i >= 0 ; i--) {
			if (names.get(i).equals("이순신")) {
				names.remove(i);
			}
		}
		System.out.println(names);
		
	
		
		
		
		
		
	}

}

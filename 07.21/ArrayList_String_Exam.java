package com.mystudy.list4_list_exam;

import java.util.ArrayList;

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
		
		//문제 1
		
		ArrayList<String> names = new ArrayList<>();
		String str = "홍길동,이순신,이순신,을지문덕";
		String[] strArr = str.split(",");
		
		//문제 2
		for (int i = 0; i < strArr.length; i++) {
			names.add(strArr[i]);
		}
		
		System.out.println("ArrayList<String> names : "+names);
		System.out.println("names.size() : " + names.size());
//-------------------------------------------------------------------------------------------
		ArrayList<String> names2 = new ArrayList<>();
		String[] str2  = {"홍길동","이순신","이순신","을지문덕"};
		names2.add(str2[0]);
		names2.add(str2[1]);
		names2.add(str2[2]);
		names2.add(str2[3]);
		System.out.println("ArrayList<String> names2 : "+ names2);
		
		//문제 3
		int size = names.size();
		
		for (int i = 0; i < size; i++) {
			char letter = names.get(i).charAt(0);
			System.out.print(letter);
			if (i < size-1) {
				System.out.print(",");
			}
		}
		System.out.println();
		
		//문제 3-2
		boolean isFirst = true;
		for (String name : names) {
			if (isFirst) {
				System.out.println(name.charAt(0));
				isFirst = false;
			} else {
				System.out.println("," + name.charAt(0));
			}
		}
		System.out.println();
		
		
		//-----------------------------------StringBuilder 사용-------------------
		
		StringBuilder sb = new StringBuilder("홍길동,이순신,이순신,을지문덕");
		String sbStr = sb.toString();
		String[] sbArray = sbStr.split(",");
		for (int i = 0; i < sbArray.length; i++) {
			System.out.print(sbArray[i].charAt(0));
			if (i < sbArray.length-1) {
				System.out.print(",");
			}
		}
		
		
		System.out.println();
		
		
		//문제 4
		for (int i = 0; i < size; i++) {
			if ("을지문덕".equals(names.get(i))) {
				System.out.println(i + " : " + names.get(i));
				//break; 하나만 찾고 끝낼거면
			}
		}
		
		//문제 5 // 이순신 모두 삭제
		while (names.remove("이순신")) {}
		
		//방법2
//		while (true) { //무한 반복
//			boolean removeSuccess = names.remove("이순신");  //remove 결과값이 boolean 값으로 나온다.
//			if (!removeSuccess) { //삭제 실패시
//				break;
//			}
//		}
//		
		//방법3
//		// int size = names.size();
//		for (int i = size -1; i >= 0; i--) {
//			if (names.get(i).equals("이순신")) {
//				names.remove(i);
//			}
//		}
//		System.out.println(names);
//		
//		//방법4
//		for (int i = 0; i < names.size(); i++) { // size 고정해놓으면 오류발생. 데이터 삭제시 리스트의 size가 줄어들기 때문.
//			if (names.get(i).equals("이순신")) {
//				names.remove(i);
//				i--; //데이터 삭제시 리스트 데이터가 앞당겨오기 때문에 제자리 검색을 한번 더 실행하기 위해서 i--
//			}
//		}
		
		System.out.println(names);
		
	}

}

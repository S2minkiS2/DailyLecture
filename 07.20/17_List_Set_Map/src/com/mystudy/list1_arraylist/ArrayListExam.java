package com.mystudy.list1_arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExam {

	public static void main(String[] args) {
		
		// ArrayList : Array(배열)의 속성을 가진 List(목록)
//		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list1 = new ArrayList<>();
		System.out.println("list1.size() : " + list1.size());
		System.out.println("list1.isEmpty() : " + list1.isEmpty());
		
		
		System.out.println("------- 입력(add) --------");
		//입력(C) : 맨 뒤에 추가
		list1.add(new Integer(5)); // Integer 저장
		list1.add(1); //위 처럼 해도 되나, int --> Integer 자동형변환 되어 입력된다.
		list1.add(5); //데이터 중복 가능
		list1.add(6); 
		boolean isSuccess = list1.add(7); 
		
		System.out.println("isSuccess : " + isSuccess);
		System.out.println(list1.toString());
		System.out.println("list1.size() : " + list1.size());
		System.out.println("list1.isEmpty() : " + list1.isEmpty());
		
		
		//입력(C) : 지정된 특정 위치에 데이터 추가, 끼워넣기
		list1.add(0, 100);
		System.out.println("0번 인덱스에 100 add 후 : " + list1);
		System.out.println("list1.size() : " + list1.size());
		
//		(주의) add, get, set, remove 사용시 인덱스 사용에 주의 
//		list1.add(100, 99); // IndexOutOfBoundsException: Index: 100, Size: 6
		
		
		System.out.println("------- 검색(get) --------");
		//검색, 조회(R) : 특정 위치의 데이터 읽기(조회, 검색, 확인, 선택)
		int firstData = list1.get(0);
		System.out.println("list1.get(0) : " + firstData);
		System.out.println(list1);
		
		//데이터 존재 여부 
		list1.contains(999);
		System.out.println("999숫자가 있니? 실행 : " + list1.contains(999));
		System.out.println("100숫자가 있니? 실행 : " + list1.contains(100));
		
		
		System.out.println("------- 수정(set) --------");
		int returnValue = list1.set(1, 888); // 바꾸기 전 데이터를 return 한다.
		System.out.println("list1.set(1, 888) : " + returnValue); 
		System.out.println(list1);
		
		
		System.out.println("------- 삭제(remove) --------");
		returnValue = list1.remove(0);
		System.out.println("list1.remove(0) 리턴값 : " + returnValue);
		System.out.println(list1);
		
		
//		list1.remove(5); //remove(Int), 5번 인덱스를 찾아서 삭제. 여기서는 배열이 인덱스 4번까지 있어서 오류발생함
		isSuccess = list1.remove(new Integer(5)); //remove(Object), 이거는 동일데이타 숫자 5를 찾아서 삭제
		System.out.println(list1);
		System.out.println("list1.remove(new Integer(5)) 의 리턴값 : " + isSuccess);
		
		isSuccess = list1.remove(new Integer(1000)); //1000은 없음
		System.out.println(list1);
		System.out.println("list1.remove(new Integer(1000)) 의 리턴값 : " + isSuccess); //없어서 false
		
		
		System.out.println("========================================================");
		System.out.println("reverse 전 : " + list1);
		Collections.reverse(list1);
		System.out.println("reverse 후 : " + list1);
		
		System.out.println("--------------------------------------------------------");
		//[7, 6, 1, 888]
		System.out.println("list1.subList(1, 3) : " + list1.subList(1, 3)); // 맨끝 인덱스 이전까지 발췌
		
		ArrayList<Integer> list3 = new ArrayList<Integer>(list1.subList(1, 3));
		System.out.println(list3);
		
		System.out.println("--------------------------------------------------------");
		System.out.println("정렬전 litst1 : " + list1);
		Collections.sort(list1); //정렬하기 Collections.sort();
		System.out.println("정렬후 litst1 : " + list1);
		
		
		System.out.println("========================================================");
		System.out.println("list1 : " + list1);
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(i + " : " + list1.get(i)); //배열이 아니라서 get메서드를 써야합니다.
		}
		
		//(실습)개선된(향상된) for문 -------------------------------------
		int no = 0;
		for (int num : list1) {
			System.out.println((no++) + " : "+ num);
		}
		
		
		
		
	}

}

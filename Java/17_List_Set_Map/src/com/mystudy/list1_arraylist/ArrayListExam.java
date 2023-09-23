package com.mystudy.list1_arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExam {

	public static void main(String[] args) {
		// ArrayList : Array(배열)의 속성 (배열 성격) List(목록)
//		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list1 = new ArrayList<>();
		System.out.println("list1.size() : " + list1.size());
		System.out.println("list1.isEmpty()  : " + list1.isEmpty());
		
		System.out.println("----입력(add)----");
		// 입력<C> : 맨 뒤에 추가
		list1.add(new Integer(5)); //Integer 저장 
		list1.add(1); //int --> Integer 자동형변환 되어 입력
		list1.add(5); //같은 데이터도 들어감
		list1.add(6);
		boolean isSuccess = list1.add(6);
		System.out.println("isSuccess : " + isSuccess);
		System.out.println(list1.toString());
		System.out.println("list1.size() : " + list1.size());
		System.out.println("list1.isEmpty()  : " + list1.isEmpty());
		//데이터 크기만큼 알아서 확장됨. add로 계속 넣어줄 수 있다.
	
		//입력(C) : 지정된 특정 위치에 데이터를 추가
		list1.add(0,  100);
		System.out.println("0번 인덱스에 100 add 후 : " + list1.toString());
		System.out.println("list1.size() : " + list1.size());

//		list1.add(100, 999); size가 6개 뿐이라 outofboundsException이다
		//인덱스 범위를 벗어나지 않도록 처리하는 것이 중요하다
		//(주의) add, set, get, remove
		
		System.out.println("----검색(get)----");
		//검색, 조회(R) : 특정 위치 데이터 읽기(조회, 검색, 확인, 선택 Read)
		int firstData = list1.get(0);
		System.out.println("list1.get(0) : " + firstData);
		System.out.println(list1);
		
		// 데이터 존재 여부
		boolean isExist = list1.contains(999);
		System.out.println("list1.contains(999) : " + isExist);
		System.out.println("list1.contains(100) : " + isExist);
		
		System.out.println("----수정(set)----");
		int returnValue = list1.set(1,  888);
		System.out.println("list1.set(1,  888) : " + returnValue);
		System.out.println(list1);
		
		System.out.println("----삭제(remove)----");
		returnValue = list1.remove(0);
		System.out.println("list1.remove(0) 리턴값 : " + returnValue);
		System.out.println(list1);
		
//		list1.remove(5); // remove(int) // 인텍스 찾아서 삭제
		isSuccess = list1.remove(new Integer(5)); //remove(Object) //동일데이터 찾아 삭제 
		System.out.println(list1);
		System.out.println("list1.remove(new Integer(5) 리턴값 : " + isSuccess);  	
		
		System.out.println("==================");
		System.out.println("reverse 전 list : " + list1);
		Collections.reverse(list1); //list만 쓸 수 있다.
		System.out.println("reverse 후 list : " + list1);
		
		System.out.println("-----------------");
		//[6, 6, 1, 888]
		System.out.println("list1.subList(1, 3) : " + list1.subList(1, 3)); //1부터 3이전까지
		//subString과 같다.
		List<Integer> list2 = list1.subList(1, 3);
		ArrayList<Integer> list3 = new ArrayList<Integer>(list2);
		
		System.out.println("------Collections.sort------");
		//Collections의 sort
		System.out.println("정렬전 list1 : " + list1);
		//Collection은 인터페이스 , Collections는 클래스
		Collections.sort(list1); 
		System.out.println("Collections.sort(list1)사용후 : " + list1);
		//오름차순 <-> reverse하면 내림차순
		
		System.out.println("=====================");
		System.out.println("list1 : " + list1);
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(i + " : " + list1.get(i)); //배열이 아니니까 get메소드 사용
		}
		
		//개선된(향상된) for문 -----------
		System.out.println("=====================");

		int j = 0;
		for (int i : list1) {
			System.out.println(j + " : " + i);
			j++;
		}
		
		
		//		데이터 가지고 처리할 때 문자열보다는
//		대부분 인덱스 번호를 가지고 데이터를 처리함.
	}

}

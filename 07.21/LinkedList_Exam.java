package com.mystudy.list3_linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class LinkedList_Exam {

	public static void main(String[] args) {
		// LinkedList : List 속성(List 인터페이스 구현체)
		LinkedList<String> list = new LinkedList<String>();
		list.add("신민기"); // 0번 인덱스
		list.add("신민기"); // 1번 인덱스
		list.add("손석구"); // 2번 인덱스
		System.out.println("list : " + list);
		System.out.println("list.get(0) : " + list.get(0));

		list.remove("손석구");
		System.out.println("list.remove(\"손석구\") 실행 후 : " + list);

		// ---------------------------------------------------------------------------
		String str = "아이유, 아이유, 유재석, 트와이스, 카리나, 카리나, 뉴진스, 아이유";
		String[] names = str.split(",");
		System.out.println("names : " + Arrays.toString(names));

		// 배열에 있는 데이터를 리스트에 추가
		for (int i = 0; i < names.length; i++) {
			list.add(names[i]);
		}
		System.out.println("list : " + list);

		System.out.println("---------------------------------------------------------");
		// ---------------------------------------------------------------------------
		// list : "아이유, 아이유, 유재석, 트와이스, 카리나, 카리나, 뉴진스, 아이유"
		// (실습) 리스트에 있는 데이터 변경하기
		// 아이유: 모두 삭제 // 리스트는 삭제시 인덱스 번호와 사이즈가 변한다. 주의
		// 카리나: 카리나2로 모두 수정(Update)
		// ---------------------------------------------------------------------------
//		System.out.println("list.remove(\"아이유\") : " + list.remove("아이유"));
//		System.out.println("list.remove(\"ABC\") : " + list.remove("ABC"));

		//찾아서 삭제할 수 없을 때까지 삭제 반복처리	
//		while (list.remove("아이유")) {}
		while (true) { //무한 반복
			boolean removeSuccess = list.remove("아이유");
			if (!removeSuccess) { //삭제 실패시
				break;
			}
		}
		
		System.out.println(list.contains(""));
		
		System.out.println("아이유 삭제후" + list);

	}

}

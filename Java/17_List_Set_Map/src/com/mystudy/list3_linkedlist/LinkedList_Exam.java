package com.mystudy.list3_linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedList_Exam {

	public static void main(String[] args) {
		// LinkedList : List속성(List인터페이스구현체)
		LinkedList<String> list = new LinkedList<String>();
		list.add("홍길동"); // 0번 인덱스
		list.add("홍길동"); // 1번 인덱스
		list.add("김유신");
		System.out.println("list : " + 1);
		System.out.println("list.get(0)" + list.get(0));

		list.remove("홍길동");
		System.out.println("list : " + 1);

//		String str = "홍길동,김유신,강감찬,을지무덕,홍경래,김유신,홍길동";
		String str = "홍길동,김유신,홍길동,홍길동,김유신,강감찬,을지문덕,홍경래,김유신,홍길동";
		String[] names = str.split(","); // ,구분자로 잘라서 배열에 담아라
		System.out.println("names : " + Arrays.toString(names));

		// 배열에 있는 데이터를 리스트에 추가
		for (int i = 0; i < names.length; i++) {
			list.add(names[i]);
		}
		System.out.println("list : " + list);

		// list : [홍길동, 김유신, 홍길동, 홍길동, 김유신, 강감찬, 을지문덕, 홍경래, 김유신, 홍길동]
		// -----------------------------
		// (실습) 리스트에 있는 데이터 변경하기
		// 1. 홍길동 : 모두 삭제 (Delete)
		// 2. 김유신 ---> 김유신2 모두 수정(Update)
		// 인덱스 번호가 바뀌나봐....
		// 한번 지우면 지워지니까 인덱스 번호가 바뀌어버림
		// 문자열 비교는 .equals()
		System.out.println("=== 김유신 ---> 김유신2 모두 수정 =====");
		for (int i = 0; i < list.size(); i++) {
			if ("김유신".equals(list.get(i))) {
				System.out.println(i + " : " + list.get(i));
				list.set(i, "김유신2");
			}
		}
		System.out.println("김유신 수정후 : " + list);
		
		//홍길동 뒤에서부터
		System.out.println("홍길동 뒤에서부터 검색 후 찾으면 삭제");
		System.out.println("홍길동 삭제전 : " + list);
		System.out.println("삭제전 size : " + list.size());
		int lastIdx = list.size() -1;
		for (int i = lastIdx; 0 <= i ; i--) {
			System.out.println(( i + " : size : " + list.size()));
			if ((list.get(i)).equals("홍길동")) {
				System.out.println(list.get(i));
				 list.remove(i);
			}
		}
		System.out.println("홍길동 삭제 후 : " + list);
		System.out.println("==============");
		
		
		//찾아서 삭제할 수 없을 때까지 삭제 반복처리
		System.out.println("홍길동 객체를 가지고 있을 때");
		while (list.remove("홍길동")) {}
		while (true) { //무한반복해라
			boolean removeSuccess = list.remove("홍길동");
			if (!removeSuccess) { //삭제 실패시
				break;
			}
		}
		//----------------------------------
		System.out.println("홍길동 삭제 후 : " + list);
		System.out.println("==============");
		
		System.out.println("list.contains 홍길동 : " + list.contains("홍길동"));
		while (true) {
			if (list.contains("홍길동")) { //데이터가있냐?
					list.remove("홍길동");
			} else {
				System.out.println(">> 삭제 완료(작업끝)");
				break;
			}
		}
		
		
//	
		// String.equal()로 찾아지는 같은 값은
		// 찾아낸 같은 값만 계속 가리키게 된다.
//	for (int i = 0; i < list.size(); i++) {
//		if (list.get(i).equals("김유신")) {
//			list.set(i, "김유신2");
//		}
//	}
//	System.out.println(list);
//		
//	System.out.println(list.get(0));
//	System.out.println(list.contains("홍길동"));
//	list.get(i) == "홍길동"
//	list.contains("홍길동"
	}

}

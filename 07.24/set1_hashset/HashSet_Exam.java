package com.mystudy.set1_hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.mystudy.list5_list_vo.StudentVO;

public class HashSet_Exam {

	public static void main(String[] args) {
		// HashSet : Set 인터페이스를 구현한 구현체(클래스)
		// 중복데이터가 없다(동일데이터 1개만 저장), 순서가 없다.
		//-------------------------------------------
		// Set에서 동일데이터 여부 확인 hashCode(), equals() 값 확인. 사용되어진다.
		// 1. 해시코드 값 확인 : hashCode()
		// 2. equals() 메소드 결과값이 모두 일치하면 동일데이터 처리
		
		HashSet<String> set = new HashSet<>();
		set.add("홍길동");
		set.add("김유신"); //순서개념은 없습니다.
		set.add("홍길동");
		set.add(new String("홍길동"));
		
		System.out.println("set : " + set);
		System.out.println("set.size() : " + set.size());
		System.out.println("\"홍길동\".hashCode() : " + "홍길동".hashCode());
		System.out.println("new String(\"홍길동\").hashCode() : " + new String("홍길동").hashCode());
		// 둘이 실제로는 다른 객체지만, hashCode는 같다 == 데이터를 처리할 때, 똑같은 데이터냐 판별할 때 사용
		
		System.out.println("set.contains(\"홍길동\") : " + set.contains("홍길동"));
		System.out.println("set.contains(\"을지문덕\") : " + set.contains("을지문덕"));
		
		set.add("을지문덕");
		set.add("홍경래");
		
		System.out.println("set : " + set);
		
		
		System.out.println("--- Set 전체 데이터 조회 1---");
		// 1
		for (String name : set) {
			System.out.println(name);
		}
		
		// 2
		System.out.println("--- Set 전체 데이터 조회 2. (Iterator) 사용 ---");
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) { //갖고있냐?
			String name = ite.next(); //여러번 쓸거면 변수에 저장해놓고 호출
			System.out.println(name);
//			System.out.println(ite.next()); //개수가 줄어든다.
//			System.out.println(ite.next());
		}
		
		System.out.println("==== 김유신 ---> 강감찬 (수정/변경) =====");
		// 수정(변경) : 김유신 --> 강감찬
		// 일단 김유신있는지 확인 해보고.. 있으며 변경, 없으면 진행하지 않는다.
		// 김유신 삭제 and 강감찬 입력
		// or 강감찬 입력하고 and 김유신을 삭제
		System.out.println("수정 전 : " + set);
		
		// 있는지 확인하고 있으면 수정작업, 없으면 작업중단
		if (set.contains("김유신")) { //set은 수정기능이 없어요. 새로운 데이터를 추가하고 삭제하는 방법밖에.
			System.out.println(">> 데이터 있음 : 수정처리");
			set.remove("김유신");
			set.add("강감찬");
		} else {
			System.out.println(">> 데이터 없음 : 작업처리 안함");
			//return; //생략가능
		}
		System.out.println("수정 후 : " + set);
		
		System.out.println("===== 전체데이터 출력 =====");
		for (String name : set) {
			System.out.print(name + "\t");
		}
		
		
		
		
		
	}

}

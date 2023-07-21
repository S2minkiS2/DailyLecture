package com.mystudy.list2_vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Vector_Exam {

	public static void main(String[] args) {
		// Vector 클래스 : List 인터스페이스 구현체
		 Vector<String> v = new Vector<String>(); //List 구현한 Vector 
		//List<String> v = new Vector<String>(); //List 구현한 Vector 
		v.add("1");
		v.add("2");
		v.add("3");
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity()); //기본 활용가능 공간 크기 
		//capacity 는 부모인 List의 메서드가 아니라, Vector클래스의 고유 메서드다. 따라서 List자료형 변수에 담으면 접근 불가하다. Java:11.
		
		System.out.println(v);
		// == 
		String temp = v.toString();
		System.out.println(temp);
		
		v.remove(2);
		System.out.println("v.remove(2) 실행 후 : "+ v);
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		
		System.out.println("------------ v.trimToSize 실행 후 --------");
		v.trimToSize();
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity()); // 여유공간이 삭제됐다
		
		System.out.println("------------ v.addElement 실행 후 --------");
		v.addElement("4문자열"); //Vector 고유의 기능이다. add와 같은 기능이다.  capacity 두개 차지???????
		System.out.println(v);
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		
		v.add("AAA"); //맨뒤에 추가
		System.out.println(v);
		
		v.add(2, "BBB"); //원하는 위치에 추가
		System.out.println(v); 
		
		
		System.out.println("------------ v.clone() 실행 후 --------");
		Vector<String> v2 = (Vector)v.clone(); // 형변환이 필수이다. Object --> Vector 타입으로.
		System.out.println("v값 : "+v);
		System.out.println("v2값 : "+v2);
		
		//(개인별)주소값 복사인지 물리적으로 분리된 복사본인지 확인하기 . 실습
		
		
		
		
		System.out.println("================= Enumeration 객체 사용 ==================");
		
		// Enumeration 인터페이스의 고유 메서드로 리스트 값 순차적 출력하기.
		Enumeration<String> enu = v.elements(); // elements() => Enumeration 데이터 타입?
		while(enu.hasMoreElements()) { // Enumeration 인터페이스의 고유 메서드 두개 중 하나
			System.out.println(enu.nextElement());
		}
		
		System.out.println("-------------------------------------------------------");
		
		//============================================================================
		
		System.out.println("--------------------- Iterator 객체 쓰기 -----------------");
		Iterator<String> ite = v.iterator(); //데이터를 순차적으로 순회하면서 조회할 수 있는 메서드. iterable Interface에 있는 메서드
		System.out.println("ite.hasNext() : " + ite.hasNext()); //boolean값 반환
		while(ite.hasNext()) {
			System.out.println("ite.next() : " + ite.next());
		} //물어보고 꺼내쓰고, 또 물어보고 꺼내쓰고.
		System.out.println("ite.hasNext() : " + ite.hasNext()); //뽑고 다 썼다. false == 없다.
//		ite.next(); //NoSuchElementException, 다 썼기 때문에 없어서 오류 발생
		
		
		// == Iterator 객체를 사용한 데이터 조회 방법과 개선된 for문을 사용한 데이터 조회 방법
		System.out.println("========== 개선된 for 사용 데이터 조회 ============");
		for (String str : v) {
			System.out.println(str);
		}
		
		
		
		
		
		
		
		
		
	}

}

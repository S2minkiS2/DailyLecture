package com.mystudy.set1_hashset;

import java.util.HashSet;

class Person {
	String jumin; //주민번호 , 변경불가
	String name; //변경가능
	String address; //변경가능
	
	public Person(String jumin, String name, String address) {
		super();
		this.jumin = jumin;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() { //데이터 확인 용도
		return "person [jumin=" + jumin + ", name=" + name + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		System.out.println(":: hashCode()가 실행되었따");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jumin == null) ? 0 : jumin.hashCode());
		return result;
	}

	@Override  //주민번호만 같으면 같은 데이터 처리를 하겠다. 라고 설정함.
	public boolean equals(Object obj) {
		System.out.println(":: equals()가 실행되었따");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (jumin == null) {
			if (other.jumin != null)
				return false;
		} else if (!jumin.equals(other.jumin))
			return false;
		return true;
	}
}

public class HashSet_Exam2_equals {

	public static void main(String[] args) {
		// HashSet : Set 인터페이스를 구현한 구현체(클래스)
		// 중복데이터가 없다(동일데이터 1개만 저장), 순서가 없다.
		//-----------------------------------------------------------------
		// Set에서 동일데이터 여부 확인 hashCode(), equals() 값 확인. 사용되어진다.
		// 1. 해시코드 값 확인 : hashCode()
		// 2. equals() 메소드 결과값이 모두 일치하면 동일데이터 처리
		//-----------------------------------------------------------------
		
		Person p1 = new Person("950101-1234567", "지수", "서울");
		Person p2 = new Person("950101-1234567", "시오노 아키히사", "부산");
		
		System.out.println("p1.hashCode() : " + p1.hashCode());
		System.out.println("p1.jumin.hashCode() : " + p1.jumin.hashCode());
		System.out.println("p2.hashCode() : " + p2.hashCode()); //해쉬코드가 같다는건.. 같은 문자열이란 뜻이다??
		System.out.println("p1.equals(p2) : " + p1.equals(p2));
		System.out.println("===================================");
		HashSet<Person> set = new HashSet<Person>();
		System.out.println("--- p1 입력");
		set.add(p1); //:: hashCode()가 실행되었따 == p1의 해쉬코드값이 있는지 확인한다.
		System.out.println("--- p2 입력");
		set.add(p2); // p2의 해쉬코드값 비교 확인한다. 다르면 그냥 넣는다. 근데! 해쉬코드값이 기존데이터와 일치한다? 그럼 equals를 실행, 비교한다.
		System.out.println("set : " + set);
		
		System.out.println("---- 똠양꿍 입력 (동일주민번호 값 입력) ---------");
		set.add(new Person("950101-1234567", "똠양꿍", "태국"));
		System.out.println("set : " + set);
		//해쉬코드와 이퀄스가 같으니 새로운 데이터가 들어가지 않았따.
		
		System.out.println("---- 북경오리 입력 (주민번호 다름) ---------");
		Person kim = new Person("990101-1234567", "북경오리", "베이징");
		System.out.println(kim.hashCode());
		set.add(kim);
		System.out.println("set : " + set); 
		
		//해쉬코드만 실행 == 해쉬코드값 비교. 데이터 비교.
		System.out.println("================================================");
		for (Person vo : set) {
			System.out.println(vo.jumin + ", " + vo.name + ", " + vo.address);
		}
		
		System.out.println("-------- contains() 사용 -----------");
		if (set.contains(p2)) { // hashCode(), equals() 실행됨
			System.out.println("동일데이터가 존재한다.");
		} else {
			System.out.println("동일데이터가 없다");
		}
		
		
	}

}

package com.mystudy.map1_hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMap_Exam {

	public static void main(String[] args) {
		// Map<K,V> 인터페이스 : 키(key)-값(value) 쌍으로 데이터 저장 관리
		// - 특징 : 키-밸류 쌍으로 데이터 저장, 순서는 없음
		// - 키(key) : 중복 안됨(중복값 없이 유일한 데이터)
		// - 값(value) : 중복데이터 저장 가능
		//---------------------------------
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//key는 문자열타입, value는 인티저
		//입력 - Create, Insert
		System.out.println("\n=====입력(추가)===============");
		map.put("홍길동", 100);
		map.put("김유신", 95);
		map.put("강감찬", 88);
		System.out.println("map : " + map);
		System.out.println("-----");
		
		Integer returnObj = map.put("계백", 88);
		//int가 아니라 integer에 저장한 이유. 리턴값이 "null"이어서.
		//왜 null이 리턴값이지? -> 새로운 데이터를 넣으면 리턴값이 null이다.
		System.out.println("map.put(\"계백\", 88) 리턴값 : " + returnObj);
		//value값 88이 중복으로 들어갔지만 들어갈 수 있다. key가 중복이 아니므로.
		
		returnObj = map.put("홍길동", 95); //동일 key값이 있으면 수정처리됨
		System.out.println("map : " + map);
		System.out.println("map.put(\"홍길동\", 95) 리턴값 : " + returnObj);
		//수정 처리되기 전 기존 key값이 리턴됨
	
		System.out.println("\n=====조회(검색)===============");
		// 조회(검색) - Read
		map.get("홍길동"); //value에 해당하는 타입으로 리턴값이 나온다.
		int returnValue = map.get("홍길동"); //value에 해당하는 타입으로 리턴값이 나온다.
		System.out.println("map.get(\"홍길동\") : " + returnValue);
		
		System.out.println("\n===== 수정 ==========");
		map.replace("홍길동", 99);
		System.out.println("map.replace(\"홍길동\", 99) 리턴값 : " 
		+ map.replace("홍길동", 99));
		
		System.out.println("map.replace(\"을지문덕\", 99) 리턴값 : " 
				+ map.replace("을지문덕", 99));
		//작업을 하려해도 없어서 못찾았다. 리턴값 : null 이면 수정안된것.
		
		System.out.println("\n===== 삭제 ==========");
		System.out.println("map.remove(\"홍길동\", 100) : " + map.remove("홍길동", 100));
		System.out.println("map : " + map);
		
		System.out.println("map.remove(\"홍길동\") : " + map.remove("홍길동"));
		System.out.println("map : " + map);
		
		System.out.println("\n=====전체 데이터 처리========");
		System.out.println("==== keySet() 사용 ========");
		Set<String> keySet = map.keySet();
		System.out.println("keySet : " + keySet);
		
		for (String key : keySet) {
			System.out.println(key + "-" + map.get(key)); 
			//map에 key값 전달하면 밸류값 얻음
		}
		System.out.println("----");
		//(개인적으로 실습) iterator() 사용방식

		
		System.out.println("==============");
		Collection<Integer> values = map.values(); //value가 담겨있는데 Collection타입이다
		System.out.println("values : " + values);
		
		for (Integer value : values) {
			System.out.println("점수 : " + value);
		}
		System.out.println("----");
		//value만 받아서 어따써먹냐?
		int sum = 0;
		for (Integer value : values) {
			sum += value;
		}
		System.out.println(":::점수합계 : " + sum);
		
		System.out.println("=============");
		map.entrySet(); //안써도되긴하는데 한번해보세용
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		System.out.println("entrySet : " + entrySet);
		
		System.out.println("----entrySet.iterator() -----");
		Iterator<Entry<String, Integer>> ite = entrySet.iterator();
		//순차적으로 데이터에 접근하는 iterator타입에 저장됨
		while (ite.hasNext()) {
			Entry<String, Integer> entry = ite.next();
			System.out.println("key : " + entry.getKey() + ", " 
				+ "value : " + entry.getValue());
		}
		System.out.println("\n----개선된 for문 사용-----------");
//		//(개인적으로 실습) entrySet 데이터 개선된(향상된) for문 사용 화면출력
//		
//		for (Entry<String, Integer> entry : entrySet) {
//			System.out.println(entrySet);
//		}
		
		
	}

}

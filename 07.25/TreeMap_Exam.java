package com.mystudy.map1_hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap_Exam {

	public static void main(String[] args) {
		// Map<K,V> 인터페이스 : key - value 쌍으로 데이터 저장 관리
		// - 특징 : 키key- 값value, 순서는 없음
		// - 키 중복안됨, 유일한 데이터.
		// - 벨류, 중복 데이터 저장 가능
		//---------------------------------------------------------
		TreeMap<String, Integer> map = new TreeMap<>();
		System.out.println("\n====== 입력(추가) ==========");
		System.out.println(map.isEmpty());
		// 입력 - Creat, Insert
		map.put("홍길동", 100); //TreeMap 클래스일 경우, String을 기준으로 가나다 순으로 정렬된다.
		map.put("강감찬", 80);
		map.put("김유신", 60);
		map.put("박혁거세", 90);
		map.put("황기동", 70);
		System.out.println("map : " + map);
		System.out.println("데이터 갯수 : " + map.size());
		System.out.println(map.isEmpty());
		System.out.println("-------------");
		
		Integer returnObj = map.put("계백", 88);
		System.out.println("map.put(\"계백\", 88) 리턴값 : " + returnObj); //기존 Value 가 없어서 null이다.
		
		returnObj = map.put("홍길동", 95); // 키값에 벨류가 이미 있다면 수정처리된다.
		System.out.println("map.put(\"홍길동\", 95) 리턴값 : " + returnObj); //기존 Value 가 return되어서 나온다.
		System.out.println("map : " + map);
		
		
		System.out.println("\n====== 조회(검색) ==========");
		// 조회(검색) - Read
		int i = map.get("홍길동");
		System.out.println("map.get(\"홍길동\") 리턴값 : " + i);
		
		System.out.println("\n====== 수정 ==========");
		System.out.println("map.replace(\"을지문덕\", 99) 리턴값 : " 
				+ map.replace("을지문덕", 99)); // 만약 key가 없으면 null이 return 된다.
		
		System.out.println("map.replace(\"홍길동\", 99) 리턴값 : " 
				+ map.replace("홍길동", 99)); // 수정 후 기존 Value 가 return된다. 
		
		System.out.println(map);
		
		System.out.println("\n====== 삭제 ==========");
		System.out.println("map.remove(\"홍길동\", 100) : " + map.remove("홍길동", 100));
		System.out.println("map : " + map);
		
		System.out.println("map.remove(\"홍길동\") : " + map.remove("홍길동"));
		System.out.println("map : " + map);
		
		System.out.println("\n====== 전체 데이터 처리 ==========");
		System.out.println("=== keySet() 사용 ====");
		Set<String> keySet = map.keySet();
		System.out.println("keySet : " + keySet);
		
		for (String key : keySet) {
			System.out.println(key + "-" + map.get(key));
		}
		
		System.out.println("-----(개인실습) iterator() 사용-----");
		//(개인실습) iterator() 사용방식
		Iterator<String> keySetite = keySet.iterator();
		while (keySetite.hasNext()) {
			System.out.println(keySetite.next());
		}
		
		System.out.println("============================");
		Collection<Integer> values = map.values();
		System.out.println("values : " + values);
		
		for(Integer value : values) {
			System.out.println("점수 : " + value);
		}
		
		System.out.println("--------");
		int sum = 0;
		for (Integer value : values) {
			sum += value;
		}
		System.out.println("::: 점수합계 : " + sum);
		
		System.out.println("=========== entrySet() 사용 =========");
//		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		System.out.println("entrySet : " + entrySet);
		
		System.out.println("------------ entrySet.iterator() -------------");
		Iterator<Entry<String, Integer>> ite = entrySet.iterator();
		while (ite.hasNext()) {
			Entry<String, Integer> entry = ite.next();
			System.out.println("key : " + entry.getKey() + ", "
					+ "value : " + entry.getValue());
		}
		
		System.out.println("\n------ 개선된 for문 사용 ----------");
		//(개인실습) entrySet 데이터 개선된 for문 사용.
		for (Entry<String, Integer> ent : entrySet) {
//			System.out.println(ent);
			System.out.println("[key] : " + ent.getKey() + ", "
							+ "[value] : "+ ent.getValue());
		}
		
		
//		TreeMap 고유기능 사용은 TreeMap 타입일 때만 사용 가능 --> .descendingKeySet();
//		NavigableSet<String> mapReverse = map.descendingKeySet();
//		System.out.println("로꾸꺼 : " + mapReverse);
		
	}

}

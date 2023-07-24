package com.mystudy.set1_hashset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

class nums {
	int[] nums = new int[6];

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(nums);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		nums other = (nums) obj;
		if (!Arrays.equals(nums, other.nums))
			return false;
		return true;
	}

}

public class HashSet_Lotto {

	public static void main(String[] args) {
		// Set을 이용한 로또 만들기 : 1 ~ 45 랜덤한 숫자 6개를 set에 저장.
		// 1. 로또번호 6개를 추첨해서 Set에 저장하고 화면 출력
		// Math.random() : 0.0 ~ 0.999999.. 실수형 데이터를 생성(0 <= ran < 1)
		// Math.random() 사용 : (int)(Math.random() * 45 +1)
		// 2. 출력은 작은 숫자부터 큰 숫자형태로 출력
		// 예시) 금주의 로또번호 : 5, 8, 10, 25, 33, 41

		HashSet<Integer> set = new HashSet<>();
		System.out.println("로또번호 : " + set);

		System.out.println("--------------- while문 사용 ---------------");
		while (set.size() < 6) { // set은 중복저장이 안되므로. 갯수로 기준
			set.add(((int) (Math.random() * 45 + 1)));
		}
		for (Integer nums : set) {
			System.out.print(nums + "\t");
		}

		System.out.println();
		System.out.println("---------------- for문 사용 ---------------");
		for (; set.size() < 6;) {
			int ranNum = (int) (Math.random() * 45 + 1);
			set.add(ranNum);
		}
		System.out.println(set);

		set.clear();

		for (; set.size() < 6;) {
			int ranNum = (int) (Math.random() * 45 + 1);
			set.add(ranNum);
		}
		System.out.println(set);
		
		
		System.out.println("------------- 오름차순 정렬 후 출력---------------");
		// sort 메서드, list값...
		// 와 이게 뭐여 ??
		ArrayList<Integer> lottoList = new ArrayList<Integer>(set);
		
		System.out.println("정렬 전 lottoList : " + lottoList);
		Collections.sort(lottoList);
		System.out.println("정렬 후 lottoList : " + lottoList);
		
		System.out.println("==============금주의 로또번호 발표============= ");
		boolean isFirst = true;
		for (Integer num : lottoList) {
			if (isFirst) {
				System.out.print(num);
				isFirst = false;
			} else {
				System.out.print(", " + num);
			}
		}
	}

}

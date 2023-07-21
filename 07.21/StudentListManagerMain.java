package com.mystudy.list5_list_vo;

import java.util.ArrayList;

public class StudentListManagerMain {

	public static void main(String[] args) {
		/* (실습) List를 사용한 성적 처리
		사용클래스명 : StudentVO, StudentListManager - main() 메소드
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		   "홍길동", 100, 90, 81
		   "이순신", 95, 88, 92
		   "김유신", 90, 87, 77
		2. ArrayList 타입의 변수(list)에 저장하고
		3. list에 있는 전체 데이터 화면출력
		   성명   국어  영어  수학  총점  평균
		   ---------------------------------
		   홍길동  100  90  81   270  90.33
		   ...
		4. 김유신 국어 점수를 95 점으로 수정 후 김유신 데이터만 출력
		5. 전체 데이터 화면 출력
		========================================== */
		System.out.println("------------문제1---------------");
		StudentVO one = new StudentVO("신민기", 100, 90, 81);
		one.computeTotAvg();
		StudentVO two = new StudentVO("미카엘", 95, 88, 92);
		two.computeTotAvg();
		StudentVO three = new StudentVO("가브리엘", 90, 87, 77);
		three.computeTotAvg();
		
		System.out.println("------------문제2---------------");
		ArrayList<StudentVO> list = new ArrayList<>();
		list.add(one);
		list.add(two);
		list.add(three);
		
		System.out.println("------------문제3---------------");
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName() + "\t"+ list.get(i).getKor() +"\t"+ list.get(i).getEng() 
								+"\t"+ list.get(i).getMath() +"\t"+ list.get(i).getTot() +"\t"+ list.get(i).getAvg());
		}
		
		
		System.out.println("------------문제4---------------"); // 김유신 대신 가브리엘.
		System.out.println("가브리엘 Kor점수 수정 전 : " + three.getKor());
		
		for (int i =0; i < list.size(); i++) {
			if ("가브리엘".equals(list.get(i).getName())) {
				list.get(i).setKor(95);
				System.out.println(list.get(i).getKor());
			}
		}
		
		System.out.println("가브리엘 Kor점수 수정 후 : " + three.getKor());
		System.out.println("가브리엘 성적 : " + list.get(2));
		
		System.out.println("------------문제5---------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

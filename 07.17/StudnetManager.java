package com.mystudy.bean_vo;

public class StudnetManager {

	public static void main(String[] args) {
		//3명의 성적처리, StudentVO 사용
		//"김유신", 100, 90, 81
		//"이순신", ~
		//"홍길동", ~
		//==========================
		
		//김유신\t100\t90\t81\t총점\t평균 식으로 출력
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-----------------------------------------------");
		StudentVO one = new StudentVO("신민기", 95, 80, 70);
		StudentVO two = new StudentVO("차은우", 87, 70, 65);
		StudentVO three = new StudentVO("아이유", 100, 55, 100);

		
		StudentVO test = new StudentVO();
		
		
	}

}

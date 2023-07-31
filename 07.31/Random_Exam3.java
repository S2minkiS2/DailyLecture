package com.mystudy.ex01_random;

import java.util.Calendar;
import java.util.Random;

public class Random_Exam3 {

	public static void main(String[] args) {
		// 오늘 당신의 행운지수? 알아보기 (0~100)
		// Math.random(), Random 클래스?  사용해서 행운지수 값 만들기
		// 실행결과 출력
		// 예) 2023년 7월 31일 당신의 행운지수(0~100) 77입니다.
		//----------------------------------------------------
		
		Random ran = new Random();
		
		int luckyNo01 = ran.nextInt(101);
		int luckyNo02 = (int)(Math.random()*100);
		
		System.out.println("2023년 7월 31일 당신의 행운 지수(0~100) " + luckyNo01 +"입니다.");
		System.out.println("2023년 7월 31일 당신의 행운 지수(0~100) " + luckyNo02 +"입니다.");
		
		
		
		
	}

}

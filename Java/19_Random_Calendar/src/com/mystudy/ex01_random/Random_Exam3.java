package com.mystudy.ex01_random;

import java.util.Calendar;
import java.util.Random;

public class Random_Exam3 {

	public static void main(String[] args) {
		// 오늘 당신의 행운지수 알아보기 (0~100)
		// Math.random(), Random 사용해서 행운지수 값 만들기
		// 실행결과 출력
		// 예제) 2023년 7월 31일 당신의 행운지수(0~100)는 77입니다
		//----------------------------------------------
		
		Random ran = new Random();
		int luck = ran.nextInt(101); //1~101까지의 랜덤값
		System.out.println("2023년 7월 31일 당신의 행운지수는 " + luck + "입니다.");
		
		luck = (int)(Math.random() * (100 + 1)); // 1~ 101 까지의 랜덤값
		System.out.println("2023년 7월 31일 당신의 행운지수는 " + luck + "입니다.");
		
		Calendar calendar  = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1; //0~11 // 0이 1월
		int date = calendar.get(Calendar.DATE);
		
		System.out.println("year : " + year);
		System.out.println("month : " + month);
		System.out.println("date : " + date);
		System.out.println(year + "년 " + month + "월 " + date + "일");
		String yyyymmdd = year + "년 " + month + "월 " + date + "일";
		
		System.out.println("---------------");
		
		//방법1 : Random nextInt(숫자)
		Random ran1 = new Random();
		int result = ran.nextInt(101);
		System.out.println(yyyymmdd + " 당신의 행운지수(0~100)는 " + result + "입니다");
		
		System.out.println("------");
		//방법2 : Math.random()
		result = (int) (Math.random() * 101);
		System.out.println("당신의 행운지수(0~100) : " + result);
		
	

		
		

	}

}

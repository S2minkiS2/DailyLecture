package com.mystudy.ex02_calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Calendar_Exam {

	public static void main(String[] args) {
		
		//Date타입은 권장하지 않는다. Deprecated
		Date date = new Date();
		System.out.println("new Date() : " + date);

		// 월 : 0~11 - 0:1월, 1:2월, 2:3월...
		// 연 : 1900이 기준
		date = new Date(2023 - 1900, 6, 31); //6을 줘야 7월로 표기
		System.out.println(date);
		System.out.println("==============");
		
		System.out.println("----Calnendar---------");
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		System.out.println("년도 : " + cal.get(Calendar.YEAR));
		//cal에 있는 Calendar.YEAR를 get
		System.out.println("월 : " + (cal.get(Calendar.MONTH) + 1));
		System.out.println("일 : " + cal.get(Calendar.DATE));
		
		System.out.println("오전오후 : " + cal.get(Calendar.AM_PM));
		System.out.println("시(12시간) : " + cal.get(Calendar.HOUR));
		System.out.println("시(12시간) : " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("분 : " + cal.get(Calendar.MINUTE));
		System.out.println("초 : " + cal.get(Calendar.SECOND));
		System.out.println("밀리초 : " + cal.get(Calendar.MILLISECOND));
		System.out.println("---------------------");
		
		//년-월-일 시:분:초 또는 
		String dateTime = cal.get(Calendar.YEAR)
				+ "-" + (cal.get(Calendar.MONTH) + 1)
				+ "-" + cal.get(Calendar.DATE)
				+ " " + cal.get(Calendar.HOUR_OF_DAY)
				+ ":" + cal.get(Calendar.MINUTE)
				+ ":" + cal.get(Calendar.SECOND);
				
		System.out.println(">>년-월-일 시:분:초: " + dateTime);
		System.out.println();
		
		//캘린더 데이터 자체 수정 가능. 중간변경가능
		cal.add(Calendar.YEAR, 2); //기존 년도에 2년 추가
		cal.add(Calendar.MONTH, 2); //기존 월에 2개월 추가
		cal.add(Calendar.DATE, -2); //기존 일에 2일 빼기
		cal.add(Calendar.HOUR_OF_DAY, 2); //기존 월에 2개월 추가
		cal.add(Calendar.MINUTE, 2); //기존 월에 2개월 추가
		cal.add(Calendar.SECOND, 2); //기존 월에 2개월 추가
		
		dateTime = cal.get(Calendar.YEAR)
				+ "-" + (cal.get(Calendar.MONTH) + 1)
				+ "-" + cal.get(Calendar.DATE)
				+ " " + cal.get(Calendar.HOUR_OF_DAY)
				+ ":" + cal.get(Calendar.MINUTE)
				+ ":" + cal.get(Calendar.SECOND);
		System.out.println(">>년-월-일 시:분:초: " + dateTime);
		System.out.println();
		System.out.println("====================");
		
		SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m:s");
		//연도 y 소문자 월 M 대문자 day d 소문자
		// 시 H 대문자  
		//한자리로 표기
		date = new Date();
		System.out.println("new Date() : " + date);
		System.out.println("y-M-d H:m:s" + sdf.format(date));
		System.out.println("------------");
		
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("yyyy-MM-dd HH:mm:ss : " + sdf.format(date));
	
		System.out.println("==========");
		cal.set(Calendar.YEAR, 2000);
		date = cal.getTime();
		System.out.println("yyyy-MM-dd HH:mm:ss : " + sdf.format(date));
		
		
		
	}

}

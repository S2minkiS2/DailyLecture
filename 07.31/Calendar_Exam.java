package com.mystudy.ex02_calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import sun.util.resources.CalendarData;

public class Calendar_Exam {

	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println("new Date() : " + date);
		
		date = new Date(123, 6, 31); //잘 안씀
		System.out.println("new Date(123, 6, 31) : " + date);
		System.out.println("====================================================");
		
		
		System.out.println("--------- Calendar ----------------");
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		System.out.println(year);
		int month = cal.get(Calendar.MONTH) + 1; // 0 ~ 11까지 숫자를 리턴하기에 +1을 해줘야 한다.
		System.out.println(month);
		int dd = cal.get(Calendar.DATE);
		System.out.println(dd);
		
		String yymmdd = (year + "년 " + month + "월 " + dd + "일");
		System.out.println("오늘은 " + yymmdd);
		
		// 시,분,초
		System.out.println("오전오후 : " + cal.get(Calendar.AM_PM));
		System.out.println("시(12시간) : " + cal.get(Calendar.HOUR));
		System.out.println("시(24시간) : " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("분 : " + cal.get(Calendar.MINUTE));
		System.out.println("초 : " + cal.get(Calendar.SECOND));
		System.out.println("밀리초 : " + cal.get(Calendar.MILLISECOND));
		System.out.println("------------------------------");
		
		//년-월-일 시:분:초
		System.out.println(yymmdd 
				+ " " + cal.get(Calendar.HOUR_OF_DAY) + "시"
				+ " " + cal.get(Calendar.MINUTE) + "분"
				+ " " + cal.get(Calendar.SECOND) + "초");
		
		String dateTime = (cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
		System.out.println(yymmdd + " " + dateTime);
		
		System.out.println("====================================================");
		
		SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m:s");
		date = new Date();
		System.out.println("new Date() : " + date);
		System.out.println("y-M-d H:m:s : " + sdf.format(date));
		System.out.println("------------------------------------------------------");
		
		cal.set(Calendar.YEAR, 2000); //set으로 Canlendar.YEAR 값을 내맘대로 수정
		date = cal.getTime();
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //두자리씩 표기하기
		System.out.println("yyyy-MM-dd HH:mm:ss : " + sdf.format(date));
		
		
	}

}

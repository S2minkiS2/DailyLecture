package com.mystudy.ex02_calendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

public class LocalDateTime_Exam {

	public static void main(String[] args) {
		// Calendar : 값이 변경됨(mutable)
		Calendar cal = Calendar.getInstance();
		System.out.println("cal : " + cal.get(Calendar.DATE));
		cal.add(Calendar.DATE, -3); //3일을 더한다.
		System.out.println("cal 3일 전 : " + cal.get(Calendar.DATE));
		cal.add(Calendar.DATE, 3); //다시 3일을 더한다. == 원본값
		System.out.println("cal 3일 후(원본값) : " + cal.get(Calendar.DATE));
		
		
		System.out.println("============================================================");
		// LocalDate, LocalTime, LocalDateTime : 날짜/ 시간/ 날짜와시간 - 데이터 불변(immutable)
		System.out.println("========= LocalDate =============");
		LocalDate nowDate = LocalDate.now();
		System.out.println("nowDate : " + nowDate);
		System.out.println("년도 뽑아내기: " + nowDate.getYear());
		System.out.println("월 뽑아내기: " + nowDate.getMonth());
		System.out.println("일 뽑아내기: " + nowDate.getDayOfMonth());
		
		LocalDate newLocalDate = nowDate.plusYears(2).plusDays(10);
		System.out.println("nowDate : " + nowDate); 
		System.out.println("newLocalDate : " + newLocalDate); 
		
		
		System.out.println("========= LocalTime =============");
		LocalTime nowTime = LocalTime.now();
		System.out.println("LocalTime : " + nowTime);
		System.out.println("시간 뽑아내기 : " + nowTime.getHour());
		System.out.println("분 뽑아내기 : " + nowTime.getMinute());
		System.out.println("초 뽑아내기 : " + nowTime.getSecond());
		System.out.println("밀리초 뽑아내기 : " + nowTime.getNano());
		
		
		System.out.println("========= LocalDateTime ============="); //Date + Time 메서드 모두 호출 가능
		LocalDateTime nowDT = LocalDateTime.now();
		System.out.println(nowDT);
		System.out.println("년도 줘봐 : " + nowDT.getYear());
		System.out.println("월 줘봐 : " + nowDT.getMonth());
		System.out.println("DayOfYear() 일 줘봐 : " + nowDT.getDayOfYear());
		System.out.println("DayOfWeek() 일 줘봐 : " + nowDT.getDayOfWeek());
		System.out.println("DayOfMonth() 일 줘봐 : " + nowDT.getDayOfMonth());
		
		
		
	}

}

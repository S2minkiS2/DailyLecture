package com.mystudy.ex02_calendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

public class LocalDateTime_Exam {

	public static void main(String[] args) {
		// Calendar : 값이 변경됨 (mutable)
		Calendar cal = Calendar.getInstance();
		System.out.println("cal : " + cal);
		System.out.println("cal date : " + cal.get(Calendar.DATE));
		cal.add(Calendar.DATE, - 3);
		System.out.println("cal 3일 전 : " + cal);
		System.out.println("cal date 3일 전: " + cal.get(Calendar.DATE));
		
		System.out.println("================");
		// LocalDate, LocalTime, LocalDateTime: 
		// : 데이터 불변 (immutable)
		System.out.println("=======LocalDate========");
		LocalDate nowDate = LocalDate.now();
		System.out.println("LocalDate.now() : " +  nowDate.toString());
		System.out.println("년 : " + nowDate.getYear());
		System.out.println("월 : " + nowDate.getMonthValue()); // 1~12 숫자값. 그냥 가져다 쓰면 됨
		System.out.println("일 : " + nowDate.getDayOfMonth()); // DATE와 DayOfMonth 같은값
		
		LocalDate newLocalDate = nowDate.plusYears(2).plusMonths(2).plusDays(1);
				//불변의 데이터 만든다.
				// plus 혹은 minus
		System.out.println("nowDate : " + nowDate);
		System.out.println("newLocalDate : " + newLocalDate);
		//nowDate는 변하지 않고 newLocalDate라는 새로운 데이터가 만들어질 뿐
		
		System.out.println("=======LocalTime=========");
		LocalTime nowTime = LocalTime.now();
		System.out.println("LocalTime.now() : " + nowTime.toString());
		System.out.println("시 : " + nowTime.getHour());
		System.out.println("분 : " + nowTime.getMinute());
		System.out.println("초 : " + nowTime.getSecond());
		
		System.out.println("======LocalDateTime======");
		LocalDateTime nowDT = LocalDateTime.now();
		System.out.println("LocalDateTIme.now()" + nowDT);
		//subString으로 잘라낼 수 있다. replace로 T 잘라낸 후 써도됨
		System.out.println("년 : " + nowDT.getYear());
		System.out.println("월" + nowDT.getMonthValue());
		System.out.println("일 : " + nowDT.getDayOfMonth());
		System.out.println("시 : " + nowDT.getHour());
		System.out.println("분 : " + nowDT.getMinute());
		System.out.println("초 : " + nowDT.getSecond());
		//마찬가지로 plus, minus 사용가능 
		
		

		
	}

}

package com.mystudy.string;

public class Ex03_StringExam0711 {

	public static void main(String[] args) {
		// String str = "901012-1234567"; //주민번호
		// 1. 전체자리수 14개 여부확인, '-'위치: 7번째 여부 확인
		// 2. 생년월일 출력(1-2:년도, 3-4:월, 5-6:일)
		// 예) 90년 10월 12일 또는 1990년 10월 12일
		// 3. 성별 확인하고 출력(1,3: 남성, 2,4: 여성)
		// 4. 데이터 값 검증(월: 1~12, 일: 1~31)
		// 참고) int num = Integer.parseInt("10"); //"10" -> 10
		// ---------------------------------------------------

		// 14자리수 여부 확인
		String str = "901012-1234567";

		char[] charArray = str.toCharArray();
		
		if (charArray.length == 14) {
			System.out.println("정상, 14개 입니다");
		} else {
			System.out.println("입력이 잘못 되었습니다.");
		}

//		System.out.println(str.length()); // 쉬운 방법s도 있다. 생각하자.

		// -위치: 7번째 여부 확인
		System.out.println("'-'의 위치는 7번째가 맞는가? : " + (str.indexOf('-') + 1 == 7));

		// 생년월일 출력하기
		int year = Integer.parseInt(str.substring(0, 2));
		int month = Integer.parseInt(str.substring(2, 4));
		int day = Integer.parseInt(str.substring(4, 6));
		System.out.println("생년월일 : 19" + year + "년 " + month + "월 " + day + "일");

		// 성별 확인하고 출력
//		System.out.println(str.substring(7, 8));
		int sex = Integer.parseInt(str.substring(7, 8));

		if (sex == 1 || sex == 3) {
			System.out.println("성별 : 남성");
		} else if (sex == 2 || sex == 4) {
			System.out.println("성별 : 여성");
		}

		// 검증
		if ((1 <= month) && (12 >= month)) {
			System.out.println("월 단위 입력이 정상입니다.");
		} else {
			System.out.println("월 단위 입력이 정상범위 밖입니다.");
		}

		if ((1 <= day) && (31 >= day)) {
			System.out.println("일 단위 입력이 정상입니다.");
		} else {
			System.out.println("일 단위 입력이 정상범위 밖입니다.");
		}
		
		System.out.println("==============================================================");
		
		
		checkStatus("라파엘라", "900621-12345678");
		
	}
		
		static void checkStatus(String name, String birthday) { //객체를 만들 필요가 없기에, 지역변수를 그대로 쓸 수 있다.
		int year = Integer.parseInt(birthday.substring(0, 2));
		int month = Integer.parseInt(birthday.substring(2, 4));
		int day = Integer.parseInt(birthday.substring(4, 6));
		int sex = Integer.parseInt(birthday.substring(7, 8));
		
		
		System.out.println("성함은 " + name + "입니다.");
		System.out.println(birthday.length() == 14 ? "14자리 숫자가 정상입력 되었습니다" : "14자리 숫자 입력이 잘못되었음");
		System.out.println("'-'의 위치는 7번째가 맞는가? : " + (birthday.indexOf('-') + 1 == 7));
		System.out.println("생년월일 : 19" + year + "년 " + month + "월 " + day + "일");
		if (sex == 1 || sex == 3) {
			System.out.println("성별 : 남성");
		} else if (sex == 2 || sex == 4) {
			System.out.println("성별 : 여성");
		}
		if ((1 <= month) && (12 >= month)) {
			System.out.println("월 단위 입력이 정상입니다.");
		} else {
			System.out.println("오류! 월 단위 입력이 정상범위 밖입니다.");
		}
		if ((1 <= day) && (31 >= day)) {
			System.out.println("일 단위 입력이 정상입니다.");
		} else {
			System.out.println("오류! 일 단위 입력이 정상범위 밖입니다.");
		}
		
		
		
	}

}

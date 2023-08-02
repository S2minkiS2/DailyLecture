package com.mystudy.ex04_printwriter;

import java.util.Calendar;

public class Printf_Exam {

	public static void main(String[] args) {
		// printf() 메소드 사용시 형식문자 사용
		int a = 20;
		long b = 300_000_000_000L;
		float c = 34.95f;
		double d = 234.234;
		char e = 'A';
		String f = "Hello~~~";
		boolean g = false;
		
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		System.out.printf("%tF", today); // "%tF" -> 날짜를 "년-월-일" 형식으로 출력하는 지정자
		System.out.println();
		
		System.out.println(">>"+ a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g);
		System.out.println();
		
		/* [] : 생략가능
		 * %[인덱스$][-][크기]형식문자 : %, 형식문자는 필수요소
		 * - 기본은 우측정렬
		 * 마이너스 부호[-] 는 좌측정렬 사용 예) %-10d == %는 형식문자다 라는 구분의 뜻, - 좌측정렬, 10은 크기
		 * 
		 */
		System.out.printf("%d %d %c %s%n", 100, 12345, 'A', "Hello"); // d=Decimal 정수, c = Character, s = String
		
		System.out.println("---- 인덱스 (파라미터위치값) 사용 --------");
		//[인덱스%] 파라미터 위치값 $부호와 함께 사용된다.
		//[주의] 인덱스 사용하면 데이터 매칭에서 제외된다. 아래의 내 주석과 같은 의미.
		System.out.printf("%1$d %1$d %c %s%n", 65, 'T', "Hello~"); 
		// 매칭해야 되는 갯수와 전달 갯수 불일치 = 오류발생
		// 중간에 1$ 를 붙이면 첫번째 데이터를 이자리에 넣겠다. 라는 뜻으로 오류 없음. 다만 1$가 안붙은 %c부터 첫번째 데이터를 가져가며 시작.
		// %c가 A가 나오는 이유는? 65가 'A'의 아나키코드이기 때문에.
		
		System.out.println("------------- 실수형 데이터 표시 ------------- ");
		System.out.printf("%f %1$a %1$e %1$g %n", 65.812345678);
		System.out.printf("%10.3f %n", 65.567890); // 전체자리수 10자리, 소수점 이하 3자리 표시하라 == '    65.568'
		System.out.printf("%-10.3f %n", 65.567890); // 좌측정렬, 전체자리수 10자리, 소수점 이하 3자리 표시하라 == '65.568     '
		System.out.printf("%15.5f %n", 65.567890); // 전체자리수 10자리, 소수점 이하 3자리 표시하라 == '       65.56789 '
		
		System.out.println("------------- 날짜 관련 -------------");
		System.out.printf("%tF %n", today);
		System.out.printf("%tT %n", today);
		System.out.printf("%ta %n", today); //요일 얻기
		System.out.printf("%1$tY/%1tm/%1$td %n", today);
		System.out.printf("%1$tY/%1tm/%1$td(%1$ta) %n", today);
		System.out.printf("%1$tH:%1tM:%1$tS %n", today);
		
		System.out.println("===================================");
		
		String name = "홍길동";
		int kor = 100, eng = 90, math = 81;
		
		System.out.printf("%s은 국어 %d, 영어 %d, 수학 %d 입니다.%n", 
						name, kor, eng, math);
		
		
	}

}

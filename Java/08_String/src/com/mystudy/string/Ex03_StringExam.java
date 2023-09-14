package com.mystudy.string;

public class Ex03_StringExam {

	public static void main(String[] args) {
					//01234567890123
		String str = "901012-1234567"; //주민번호 
		
		//1. 전체자리수 14개 여부확인, '-'위치: 7번째 여부 확인
		System.out.println(str.charAt(6)); // 7번째 : -
	
		if (str.length() == 14) {
			System.out.println("전체 자리수는 14 입니다.");
		} else {
			System.out.println("[비정상] 전체길이 " + str.length());
		}

		if (str.indexOf('-') == 6) {
			System.out.println("'-'는 7번째에 위치해있습니다.");
		} else {
			System.out.println("'-'는 " + str.indexOf('-') + "에 위치해있습니다.");
		}
		System.out.println();
		
		
		//선생님 풀이------------------------------
		System.out.println("//선생님 풀이-----------------");
		if ("-".equals(str.substring(6,7))) {
			System.out.println("[정상] 위치값은" + str.substring(6,7) + "입니다.");
		} else {
			System.out.println("'-'는 " + str.indexOf('-') + "에 위치해있습니다.");
		}
		
			if (!"-".equals(str.substring(6,7))) {
			System.out.println("[비정상] 위치 값은 " + str.substring(6,7));
		} else {
			System.out.println("'-'는 " + str.indexOf('-') + "에 위치해있습니다.");
		}
			
			if(str.charAt(6) != '-') {
				System.out.println("[비정상] 7번째 문자 - 아님");
			}
			
			System.out.println("선생님 풀이------------------//");
		System.out.println();
			
		//2. 생년월일 출력(1-2:년도, 3-4:월, 5-6:일)
		//str = "901012-1234567"
		System.out.print(str.substring(0, 2) + "년 ");
		System.out.print(str.substring(2, 4) + "월 ");
		System.out.print(str.substring(4, 6) + "일 ");
		//   예) 90년 10월 12일 또는 1990년 10월 12일
		System.out.println();
		
		System.out.println();
		//---------선생님풀이--------
		System.out.println("//선생님 풀이---------");
		
		String yymmdd = str.substring(0, 6);
		System.out.println("yymmdd : " + yymmdd);
		String yy = str.substring(0, 2);
		String mm = str.substring(2, 4);
		String dd = str.substring(4, 6);
		System.out.println(yy + "년 " + mm + "월 " + dd + "일");
		
		System.out.println("선생님 풀이---------//");
		System.out.println("//선생님 풀이---------");
		char charFlag = str.charAt(7);
		String yyyy = "";
		if (charFlag == '1' || charFlag == '2') {
//			System.out.println("19" + yy + "년 " + mm + "월 " + dd + "일");
			yyyy = "19" + yy;
		} else if (charFlag == '3' || charFlag == '4')
//			System.out.println("20" + yy + "년 " + mm + "월 " + dd + "일");
			yyyy = "20" + yy;
		System.out.println(yy + "년 " + mm + "월 " + dd + "일");
		System.out.println("선생님 풀이---------//");
		System.out.println();
		
		//3. 성별 확인하고 출력(1,3: 남성, 2,4: 여성)
		if (str.contains("1") || str.contains("3")) {
			System.out.println("성별은 남성");
			} else if (str.contains("3") || (str.contains("4"))) {
				System.out.println("성별은 여성");
			} 
		System.out.println();
		
		System.out.println("//선생님 풀이---------");
		char gender = str.charAt(7);
		if (gender == '1' || gender == '3') {
			System.out.println("주민번호 뒷자리(첫글자) : " + gender + "남성");
		} else if (gender == '2' || gender == '4') {
			System.out.println("주민번호 뒷자리(첫글자) : " + gender + "여성");
		} else {
			System.out.println("외국인입니다.");
		}
		switch (gender) {
		case '1' : case '3' : 
			System.out.println("주민번호 뒷자리(첫글자) : " + gender + "남성");
			break;
		case '2' : 
		case '4' : 
			System.out.println("주민번호 뒷자리(첫글자) : " + gender + "여성");
			break;
		default : 
			System.out.println("외국인입니다.");
		}
		System.out.println("선생님 풀이---------//");
		System.out.println();
		
		//4. 데이터 값 검증(월: 1~12, 일: 1~31)
		//참고) int num = Integer.parseInt("10"); //"10" -> 10
		//---------------------------------------------------
		int num1 = Integer.parseInt(str.substring(2, 4));
//		System.out.println(num1);
		if (1 <= num1 && num1 <= 12) {
			System.out.println("월 데이터가 올바른 값입니다.");
		} else {
			System.out.println("월 데이터가 비정상 값입니다." + num1);
		}
		
		int num2 = Integer.parseInt(str.substring(4, 6));
		if (1 <= num2 && num2 <= 31) {
			System.out.println("일 데이터가 올바른 값입니다.");
		} else {
			System.out.println("월 데이터가 비정상 값입니다. " + num2);
		}

	}


	}


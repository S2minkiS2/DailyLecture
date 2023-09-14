package com.mystudy.string;

public class Ex04_String_array_exam {

	public static void main(String[] args) {
		/* String[]과 String 메소드 사용 실습
		문자열 : "홍길동","이순신","이순신","을지문덕","김유신","연개소문","Tom","TOM"
		1. 위의 문자열 값을 저장할 수 있는 문자열 배열(names) 변수를 선언하고 입력
		// 중괄호 써서 넣기~
		2. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
		   출력 예) 홍길동,이순신,이순신,을지문덕....
		// 한줄로출력 첫번째 가져와서 콤마 붙이고 하나하나 데이터컨트롤
 		3. 배열에 있는 데이터의 첫 글자만 출력-구분자 콤마(,) 사용 한 라인에 출력
		   출력 예) 홍,이,이,을,김,연,T,T...
		// 스트링메서드 사용 substring()
		4. 이름의 글자수가 4글자 이상인 이름을 검색해서 "인덱스번호:이름" 형태로 출력
		   예) 3:을지문덕
		// 4글자 이상이면 출력해라 if로 물어봐서 대상 찾고 위치값 출력
		5. 이름이 같은 데이터를 "인덱스번호:이름=인덱스번호:이름" 형태로 출력
		   예) 1:이순신=2:이순신
		(기타) 이름 비교시에는 대소문자 구분 없이 비교처리(Tom, TOM 은 같다)
		// ignore케이스 equals() 홍길동 기준으로 두고 비교 for문 equals
		 같으면 출력 if-for
		========================================================= */

//		String[]과 String 메소드 사용 실습
//		문자열 : "홍길동","이순신","이순신","을지문덕","김유신","연개소문","Tom","TOM"
		
//		1. 위의 문자열 값을 저장할 수 있는 문자열 배열(names) 변수를 선언하고 입력
		String[] names = {"홍길동","이순신","이순신","을지문덕","김유신","연개소문","Tom","TOM"};
		
//		2. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
//		   출력 예) 홍길동,이순신,이순신,을지문덕....
		System.out.println("2.-------------------");
		//개선된 for 문
		boolean isFirst = true; //boolean 이용 인덱스 번호처럼 사용
		for (String name : names) {
			if (isFirst) {
				System.out.print(name);
				isFirst = false;
			} else {
			System.out.print(", " +  name);
			}
		}
		System.out.println();
		
		//패턴 : "이름, " / 마지막 데이터 따로
		for (int i = 0; i < names.length; i++) {
			if (i == names.length - 1) {
				System.out.print(names[i]);
			} else {
				System.out.print(names[i] + ",");
			}
		}
		System.out.println();
		
		//		", 이름" / 첫 데이터 따로 처리
		for (int i = 0; i < names.length; i++) {
			if (i == 0) {
				System.out.print(names[i]);
			} else {
				System.out.print("," + names[i] );
			}
		}
		System.out.println();
	
		
		
//		3. 배열에 있는 데이터의 첫 글자만 출력-구분자 콤마(,) 사용 한 라인에 출력
//		   출력 예) 홍,이,이,을,김,연,T,T...		
		System.out.println("3.-------------------");
		for (int i = 0; i < names.length - 1; i++) {
			System.out.print(names[i].substring(0, 1) + ", ");
		}
		System.out.print(names[7].substring(0, 1));
		System.out.println();
		
//		for (int i = 0; i < names.length; i++) {
//			System.out.print(names[i].charAt(0) + ", ");
//		}
		
//		4. 이름의 글자수가 4글자 이상인 이름을 검색해서 "인덱스번호:이름" 형태로 출력
//		   예) 3:을지문덕 indexOf()
		System.out.println("4.-------------------");
		
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() >=4) {
				System.out.println("[" + i + "] : " + names[i]);
			}
		}
		
		
//		5. 이름이 같은 데이터를 "인덱스번호:이름=인덱스번호:이름" 형태로 출력
//		   예) 1:이순신=2:이순신
//		(기타) 이름 비교시에는 대소문자 구분 없이 비교처리(Tom, TOM 은 같다)
//		문자열 : "홍길동","이순신","이순신","을지문덕","김유신","연개소문","Tom","TOM"	
		System.out.println("5.-------------------");
		for (int i = 0; i < names.length; i++) {
			for (int j = i + 1; j < names.length; j++) {
				 if (names[i].equalsIgnoreCase(names[j])) {
					 System.out.println(i + " : " + names[i] + " " + j + " : " + names[j]);
				 }
				 
				 
				 
				 
			}
		}
		
		
//		0 1
//		0 2
//		0 3
//		0 4
//		  7
//		  
//		  name[0].equals(name[1])
//		  name[0].equals(name[2])
//		  name[0].equals(name[3])
//		  length
		
		

		
	
		System.out.println(">>> main() 끝 -------");
	}

}
package com.mystudy.stringbuilder;

public class Ex04_01_String_controls_exam {

	public static void main(String[] args) {
		/* 문자열 다루기
		0.문자열 데이터
		  String str1 = "홍길동 이순신  이순신 Tom 홍길동";
		  String str2 = "    TOM   을지문덕 김유신 연개소문";
		1. 위의 문자열을 StringBuilder 변수 sb를 이용해서 하나의 문자열로 만들고,
		2-1. sb의 문자열을 빈칸 1개(" ")를 구분자로 잘라서(이름만 추출) 화면 출력(데이터확인)
		     (String split() 또는 StringTokenizer 클래스 사용)
		      예) 홍길동 이순신 이순신 Tom 홍길동 TOM...
		2-2. 문자열을 저장할 수 있는 배열변수(names)에 저장
		3. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
		      예) 홍길동,이순신,이순신,Tom,홍길동,TOM...   
		4. 데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
		      예) 홍,이,이,T,홍,T,을... 
		5. 배열의 문자열중 이름의 글자수가 4 이상인 값을 "인덱스번호:이름" 출력
		      예) 인덱스번호:을지문덕
		********************************/

		
//		0.문자열 데이터
		String str1 = "홍길동 이순신  이순신 Tom 홍길동";
		String str2 = "    TOM   을지문덕 김유신 연개소문";
		 
//		1. 위의 문자열을 StringBuilder 변수 sb를 이용해서 하나의 문자열로 만들고,
		StringBuilder sb = new StringBuilder(str1 + str2);
//		sb.append(str1).append(str2);
		System.out.println("sb = " + sb);

//		2-1. sb의 문자열을 빈칸 1개(" ")를 구분자로 잘라서(이름만 추출) 화면 출력(데이터확인)
//		     (String split() 또는 StringTokenizer 클래스 사용)
//		      예) 홍길동 이순신 이순신 Tom 홍길동 TOM...
//		2-2. 문자열을 저장할 수 있는 배열변수(names)에 저장
//		---------------------
		// String str = sb.toString(); //문자열로 반환
		// String[] names = str.split(" "); //반환하여 쪼갠 값을 배열에 저장
		String[] names = sb.toString().split(" "); //한 문장으로
		//저장된 배열 데이터 갯수 확인ㄱ
		System.out.println("names.length : " + names.length);
		//
		for (int i = 0; i < names.length; i++) {			
			System.out.println(i + " : -" + names[i] + "-");
		}
		
		
		System.out.println("문제2 ===========");
		System.out.println("---equals사용---");
		//화면에 출력 >> 홍길동 이순신 이순신 Tom 홍길동 TOM...
		for (int i = 0; i < names.length; i++) {	
			if (!"".equals(names[i])) 
				//equals 처리할 땐 괄호 안에 메소드 내부에서 null 처리가 되어 정상처리된다.
//***			equals  null 앞뒤 검색해보기
			System.out.print(names[i] + ",");
		} 
		System.out.println();
		
		
		System.out.println("---length값 사용---");
		for (int i = 0; i < names.length; i++) {	
			if (0 < names[i].length()) {
				System.out.print(names[i] + ",");
			}
		}
		System.out.println();
		 //빈 문자열 안 쓸 땐 .trim() 처리
		//names[i].trim().length()
		System.out.println("===============");
		
//		3. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
//		      예) 홍길동,이순신,이순신,Tom,홍길동,TOM...  
		
		System.out.println("문제3 ===========");
		StringBuilder sb3 = new StringBuilder();
		
		for (int i = 0; i < names.length; i++) {	
			if (names[i].length() < 1) continue;
			if (i == 0) {
				sb3.append(names[i]);
			} else {
				sb3.append(",").append(names[i]);
			}
		}
		System.out.println("sb3 : " + sb3.toString());
		System.out.println();

//		4. 데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
//		      예) 홍,이,이,T,홍,T,을... 
		System.out.println("문제4 ===========");
	StringBuilder sb4 = new StringBuilder();
		for (int i = 0; i < names.length; i++) {	
			if (names[i].length() < 1) continue;
			sb4.append(names[i].charAt(0)).append(","); //첫글짜 charAt
			}
		sb4.delete(sb4.length() - 1, sb4.length()); // 콤마 떼기
//		sb4.deleteCharAt(sb4.length())
		System.out.println("sb4 : " + sb4);
		System.out.println();
		

//		5. 배열의 문자열중 이름의 글자수가 4 이상인 값을 "인덱스번호:이름" 출력
//		      예) 인덱스번호:을지문덕
	
	}

}

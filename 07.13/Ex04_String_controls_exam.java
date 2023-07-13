package com.mystudy.stringbuilder;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex04_String_controls_exam {

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
		
		String str1 = "홍길동 이순신  이순신 Tom 홍길동";
		String str2 = "    TOM   을지문덕 김유신 연개소문";
		
		// 문제 1번
		StringBuilder sb = new StringBuilder();
		sb.append(str1).append(str2);
		System.out.println(sb);
		
		//문제 2번
		String sb01 = sb.toString();
		String[] names = sb01.split(" ");
		//String[] names = sb.toString().split(" ");
		
		//저장된 배열 데이터를 확인
		for (int i = 0; i < names.length; i++) {
			System.out.println(i + " : "+ names[i] + "=길이: " + names[i].length());
		}
		
		System.out.println("---------------------------");
		
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() == 0) { // !"".equals(names[i]))
				continue;
			} else {
				System.out.print(names[i] + ", ");
			}
		}
		System.out.println();
		
		//더 좋은 방법(정석)
		System.out.println("--- length() > 0 사용 ---");
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null && names[i].trim().length() > 0) { 
				System.out.print(names[i] + ", ");
			}
		}
		
		System.out.println();
		System.out.println("---------------------------");
		
		//문제 2번_ StringTokenizer 사용
		System.out.println("===== StringTokenizer 사용 ====="); //빈문자열은 데이터처리 무시.
		System.out.println("StringBuilder sb : " + sb);
		StringTokenizer tokens = new StringTokenizer(sb.toString(), " ");
		System.out.println("토큰 개수 : "+tokens.countTokens());
		
		while (tokens.hasMoreTokens()) {
			System.out.println(tokens.nextToken());
			System.out.println("토큰 개수 : "+tokens.countTokens());
		}
		
		System.out.println("----------토큰 다시 만들기----------");
		tokens = new StringTokenizer(sb.toString(), " "); //토큰을 다 쓰면 다시 만들어줘야 한다.
		System.out.println("토큰 개수 : "+tokens.countTokens());
		
		String[] names2 = new String[tokens.countTokens()];
		System.out.println(names2.length);
		System.out.println(Arrays.toString(names2));
		
		int idx = 0;
		while (tokens.hasMoreTokens()) {
			//배열에 저장
			names2[idx++] = tokens.nextToken();
		}
		System.out.println(Arrays.toString(names2));
		
		
		
		//문제 3번 (StringBuilder 사용).
		
		StringBuilder namessb = new StringBuilder();
		System.out.println(namessb.length());
		System.out.println(names.length);
		System.out.println(names[0]);
//		namessb.append(names[0].toString());
//		namessb.append(names[1].toString());
//		namessb.append(names[2].toString());
//		namessb.append(names[3].toString());
//		namessb.append(names[4].toString());
//		namessb.append(names[5].toString());
		
		System.out.println(namessb);
		
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() == 0) {
				continue;
			} else if (i < names.length-1) {
				namessb.append(names[i].toString() + ",");
			} else {
				namessb.append(names[i].toString());
			}
		}
		System.out.println(namessb);
		
		//문제 3정석 정답
		StringBuilder sb3 = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) continue;
			if (names[i].trim().length() < 1) continue;
			if (i == 0) {
				sb3.append(names[i]);
			} else {
				sb3.append(",").append(names[i]);
			}
		}
		
		System.out.println("----- 문제4 -----");
		//문제 4
		StringBuilder sb4 = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) continue;
			if (names[i].trim().length() < 1) continue;
			sb4.append(names[i].charAt(0)).append(",");
		}
		sb4.delete(sb4.length() - 1, sb4.length()); // 맨끝 , 지우기.
		System.out.println(sb4);
		
		
	}
}

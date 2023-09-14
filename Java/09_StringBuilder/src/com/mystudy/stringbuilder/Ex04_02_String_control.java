package com.mystudy.stringbuilder;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex04_02_String_control {

	public static void main(String[] args) {
		// 
		String str1 = "홍길동 이순신  이순신 Tom 홍길동";
		String str2 = "    TOM   을지문덕 김유신 연개소문";
		StringBuilder sb = new StringBuilder(str1 + str2);
		
		System.out.println("======StringTokenzier 사용=======");
		System.out.println("StringBuilder sb : " + sb);
		StringTokenizer tokens = new StringTokenizer(sb.toString(), " ");
		System.out.println("토큰 갯수: " + tokens.countTokens());
		//StringTokenizer에선 문자 하나 이상 있어야 유의미한 처리를 함
		//빈 문자열은 토큰으로 만들지 않는다.
		System.out.println("------");
		
		while (tokens.hasMoreTokens()) {
			System.out.println(tokens.nextToken());
		}
		System.out.println("토큰 갯수: " + tokens.countTokens());
		//확인차 갯수를 확인하다간 데이터가 사라져버림
		tokens = new StringTokenizer(sb.toString(), " ");
		System.out.println("토큰갯수 : " + tokens.countTokens());
		
		//새 배열에 담자~
		
		String[] names2 = new String[tokens.countTokens()];
		//데이터 토큰 갯수만큼 만들자. 배열 만들기~
		System.out.println("데이터몇개? " + names2.length); //몇개의 데이터가 만들어졌니
		System.out.println(Arrays.toString(names2)); //아직은 null. 데이터 안넣어서
		
		int idx = 0; //인덱스값 역할을 할 변수 생성
		while (tokens.hasMoreTokens()) {
			//배열에 저장
			names2[idx++] = tokens.nextToken(); // names2에 담아주자.
		//위치값 필요한데. -> 증가하는걸 계속 꺼내쓰자 while문으로
		}
		System.out.println(Arrays.toString(names2)); //아직은 null. 데이터 안넣어서
		
		
		
		
	}

}

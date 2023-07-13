package com.mystudy.stringbuilder;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex03_StringTokenizer {

	public static void main(String[] args) {
		// String 클래스의 split() vs StringTokenizer 클래스
		System.out.println("---- Stirng split() ----");
		
		String str = "사과,배,복숭아,,포도"; //빈문자열, 스페이스 한칸도 문자열
		System.out.println("str : " + str.toString());
		
		String[] strSplit = str.split(","); // 컴마 구분자로 잘라라. 
		System.out.println("strSplit 배열 갯수 : " + strSplit.length); //배열 갯수
		
		System.out.println("--- str.split(\",\") 실행 결과");
		for (int i = 0; i < strSplit.length; i++) {
			System.out.println(i + " : " + strSplit[i] + "-");
		}
		System.out.println();
		
		System.out.println("--- 개선된 for문으로(=forEach문) 출력 ---");
		for(String s : strSplit) {
			System.out.println("-" + s + "-");
		}
		//or
		System.out.println(Arrays.toString(strSplit));
		
		System.out.println("-----------------------------------------");
		
		int idx = 0;
		for (String str2 : strSplit) {
			System.out.println(idx + " : " + str2);
			idx++;
		}
		
		System.out.println("\n=== StringTokenizer ===");
		str = "사과,배,복숭아, ,포도"; //토큰은 빈문자열을 취급하지 않는다. 스페이스바는 취급한다.
		System.out.println("str : " + str);
		
		StringTokenizer strToken = new StringTokenizer(str, ",");
		System.out.println("strToken.countTokens() : "+ strToken.countTokens()); //토큰개수 체크에는 빈문자열이 제외된다.
		
		System.out.println("-----------------------------------");
		
		while (strToken.hasMoreTokens()) { //boolean 값, == Tokens이 있으면 사용.
			String token = strToken.nextToken(); //여러번 쓸 거면 변수에 저장하자.
			System.out.println("-" + token + "-");
		}
		System.out.println("strToken.countTokens() : " + strToken.countTokens()); //토큰을(데이터) 다 꺼내 썼기 때문에 0
//(주의)	StrToken.nextToken(); //데이터가 있는지 없는지 물어보고 countTokens()로, 써라. 토큰이 없을때 쓰면 예외발생( NoSuchElementException )
// 		또 쓰고 싶다면 다시 new로 만들어 써야한다.		
		
		System.out.println("-----------------------------------------");
		
		
		
		
		System.out.println("--- (실습) 토큰데이터 for문으로 화면 출력 ---");
		
		
		//String 클래스의 split() 메서드 활용
		String str01 = "핸드폰,,선풍기,지갑,커피,립밤"; //빈문자열이 하나 추가되어 있음.
		
		String[] str01Array = str01.split(",");
		
		for (int i = 0; i < str01Array.length; i++) {
			System.out.println(i + " : " + str01Array[i] + "-");
		}
		for (String s : str01Array) {
			System.out.print(s + "-");
		}
		System.out.println();
		
		//StringTokenizer 클래스 활용 (split과 달리 빈문자열은 데이터로 취급하지 않는다.)
		//String str01 = "핸드폰,, 선풍기, 지갑, 커피, 립밤";
		StringTokenizer str01Token = new StringTokenizer(str01, ",");
		System.out.println("str01Token.countTokens() : " + str01Token.countTokens());
		
		int idx01 = 0;
		while (str01Token.hasMoreTokens()) {
			String testToken = str01Token.nextToken();
			System.out.println(idx01 + " : " + testToken);
			idx01++;
		}
		System.out.println("str01Token.countTokens() : " + str01Token.countTokens());
//(주의) 토큰이 없을 때 nextToken() 사용하면, NoSuchElementException 예외발생
		
		
		System.out.println("=========== while문 대신 for문으로 토큰데이터 출력 비교해보기. =========");
		String str02 = "핸드크림,마우스,키보드,컴퓨터,티슈";
		StringTokenizer str02Token = new StringTokenizer(str02, ",");
		System.out.println(str02Token.countTokens());
		
		int tokencnt = str02Token.countTokens();
		for (int i = 0; i < tokencnt; i++) {
			String token = str02Token.nextToken();
			System.out.println("-" + token + "-");
			System.out.println("남은 토큰 : " + str02Token.countTokens());
		}
		
		//StringTokenizer 클래스; 토큰데이터 출력은 for보다 while이 쓰기 편하다.
		//Split은 빈문자열과 스페이스바 모두 데이터로 처리, StringTokenizer는 빈문자열을 무시.
		
	}

}

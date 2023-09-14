package com.mystudy.stringbuilder;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex03_StringTokenizer {

	public static void main(String[] args) {
		// Stirng 클래스의 split() vs StringTokenizer 클래스
		System.out.println("---- String split() ---");
		String str = "사과,배,복숭아,,포도";
		System.out.println("str : " + str.toString());
		
		String[] strSplit = str.split(","); //String배열타입으로 받겠다
		System.out.println("strSplit.length" + strSplit.length);
		System.out.println(Arrays.toString(strSplit));
		
		System.out.println("---- str.split(\",\") 실행결과 배열---");
		for (int i = 0; i < strSplit.length; i++) { //데이터 사이즈는 5개
			System.out.println(i + " : " + strSplit[i]);
		} //빈 문자열도 split은 데이터 값으로 가지고 있는다.
		System.out.println();
		
		System.out.println("--- 개선된 for문으로 (또는 forEach) ---");
		for (String str2 : strSplit) {
			System.out.println("-" + str2 + "-");
		}
		System.out.println("----");
		
		int idx = 0;
		for (String str2 : strSplit) {
			System.out.println(idx + ": -" + str2 + "-");
			idx++;
		}
		
//		StringTokenizer
		System.out.println("\n===== StringTokenizer =====");
		str = "사과,배,복숭아, ,포도";
		System.out.println("str : " + str);
		
		StringTokenizer strToken = new StringTokenizer(str, ",");
		System.out.println("strToken.countTokens() : " + strToken.countTokens());
		//Split과 갯수가 다름
		
//		hasMoreTokens 
		//토큰이 있으면 꺼내 쓴다 생각/ 다음에 사용할 데이터가 있냐? 
		//-> 있으면 작업, 없을 때까지 (while문 사용)
		//true/false // 있으면 커서가 가서 저장된 데이터를 쓴다.
		//nextToken으로도 바로 다음데이터를 쓸 수 있지만, 없으면 오류가 생긴다.
		// 있는지 없는지 확인 후 사용하기 위해 
		
		while (strToken.hasMoreTokens()) { //true면 작업, false면 빠져나감
			String token = strToken.nextToken();
			System.out.println("-" + token + "-");//다음 토큰을 가져다 쓴다 (문자열 리턴)
		}
		//데이터를 두세번 작업처리를 해야하면 저장해두고 사용하는게 좋다.
		
		System.out.println("strToken.countTokens() : " + strToken.countTokens());
		//꺼내 쓰면 없어지기 때문에 토큰 데이터 갯수가 4개에서 0개가 되었다.
		//토큰이 들어있던 박스가 비었다. 재사용 의미 x -> 다시 tokening을 해야함
		//(주의) 토큰이 없을 때 nextToken() 사용하면
		// NoSuchElementException 예외 발생하므로 꼭 물어보고 사용해야한다.
		//한번 hasMoreTokens 물어보면 한번 nextToken꺼낸다 
		// -> 만약 1번 물어보고 2개 쓰면 다음 데이터가 없을 가능성이 있어 오류 위험
		
		System.out.println("===================");
		
		//space 한 칸은 유의미한 데이터.
		//split에서는 공백도 나눠줘야 할 유의미한 데이터
		
		
		
		System.out.println("---(실습) 토큰데이터 for문으로 화면 출력 ---");
//		데이터갯수 countTokens() space도 하나로 체크
		StringTokenizer strToken1 = new StringTokenizer(str, ",");
		System.out.println("토큰의 데이터 갯수 = " + strToken1.countTokens());
		
		
		int TokenCnt = strToken1.countTokens();
		//내가 갖고있는 토큰갯수가 계속 줄어들면 안됨. 
		//토큰 특성상 가져다가 쓰면 사라져 갯수가 달라짐.
		//그래서 따로 변수에 갯수를 저장해서 줄어들지 않게 해야함
		for (int i = 0; i <= TokenCnt; i++) {
			if (strToken1.hasMoreTokens()) {
				String token1 = strToken1.nextToken();				
				System.out.println(i + " : " + token1);	
			}
		}
				
		
		// split-----------------
		// split은 배열에 저장해서 재사용이 가능하지만
		// 빈 문자열도 데이터처리, 하나의 데이터처리
		// StringTokenizer-------
		// space는 데이터 처리하나 빈 문자열은 처리하지않음.***
		// token은 사용하면 사라지기 때문에 재사용 불가하고 토크닝을 새로 해줘야한다.
		// ex) new StringTokenizer
	}

}





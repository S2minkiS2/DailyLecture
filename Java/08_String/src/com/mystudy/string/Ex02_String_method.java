package com.mystudy.string;

import java.util.Arrays;

public class Ex02_String_method {

	public static void main(String[] args) {
		// String 클래스 메소드를 사용 문자열 처리 (단, 원본문자열 불변)
		//			  0123456789
		String str = "Java World";
		System.out.println("str : " + str);
		
		System.out.println("-----CharAt 인덱스번호 -----");
		char ch = str.charAt(0); //몇번째글자인지글자알아내기
		System.out.println("str.charAt(0) = " + ch);
		//ㄴ첫번째글자
		System.out.println("str.charAt(1) = " + str.charAt(1));
		//ㄴ두번째글자
		
		
		char[] ch2 = new char[4];
		
		for (int i = 0; i < ch2.length; i++ ) {
			ch2[i] = str.charAt(i);
		}
		
		ch2[0] = str.charAt(0);
		ch2[1] = str.charAt(1);
		ch2[2] = str.charAt(2);
		ch2[3] = str.charAt(3);
		System.out.println(Arrays.toString(ch2));
		
//		------------------------------------------
		System.out.println(" ----- compareTo() : 문자열비교(결과값 : 음수, 0, 양수)");
		System.out.println("\"java\".compareTo(\"java\") : " + "java".compareTo("java")); //같은 문자열인 경우 0
//		\" 단순문자처리
		System.out.println("aaa vs aaa : " + "aaa".compareTo("aaa")); //같음
		System.out.println("bbb vs aaa : " + "bbb".compareTo("aaa")); //b가 a보다 하나 뒤
		System.out.println("aaa vs bbb : " + "aaa".compareTo("bbb")); //a가 하나 작은 위치
		//앞쪽부터 비교 // 갯수는 상관없다 // 위치값 비교
		// 위치값차이 +면 뒷쪽(오른쪽),  -면 왼쪽
		System.out.println("--------");
//			   0123456789
		str = "Java World";
		System.out.println("str : ' + str");
		
		System.out.println("----indexOf() : 문자(문자열) 위치값 확인----");
		System.out.println("str.indexOf('X') : " + str.indexOf('X'));
		//없다 : 마이너스값
		//있다(위치) : 양수값
		System.out.println("str.indexOf('J') : " + str.indexOf('J'));
		System.out.println("str.indexOf(\"Java\") : " + str.indexOf("Java"));
		System.out.println("str.indexOf('a', 2) : " + str.indexOf('a', 2)); // 2번인덱스에서부터 찾아라
			//ex:J는 Java에서 첫번째 값 => 0 // a는 두번째 값 => 1
		
		System.out.println("--- lastIndexOf() : 문자(문자열) 찾기 - 뒤에서부터---");
		System.out.println("str.lastIndexOf('a')" + str.lastIndexOf('a'));
//	-------------------------------------------

		System.out.println("---str.startsWith(), endsWith() 여부만 확인---------");
		System.out.println("str.startsWith(\"Java\") : " + str.startsWith("Java"));
		// ㄴ "Java"로 시작하냐? 
		System.out.println("str.endsWith(\"Java\") : " + str.endsWith("Java"));
		System.out.println();
		
		System.out.println("--- isEmpty() ----"); //true or false
		System.out.println("str : -" + str + "-");
		System.out.println("str.isEmpty : " + str.isEmpty());
		
		str = ""; // 빈문자열
		System.out.println("str : -" + str + "-");
		System.out.println("str.isEmpty : " + str.isEmpty());
		System.out.println("str.length() : " + str.length());
		System.out.println();
		
		System.out.println("---- replace() : 문자, 문자열 변경----");
	//		   0123456789
		str = "Java World";
		System.out.println("str : " + str);
		System.out.println("str.replace(\"java\", Hello) : " + str.replace("java", "Hello"));
		System.out.println("str.replace(\"a\", \"m\") : " + str.replace("a", "m"));
		System.out.println("------");
		
		str = "Java Java";
		System.out.println("str : " + str);
		System.out.println("str.replace(\"Ja\", \"JA\") : " + str.replace("Ja", "JA"));
		System.out.println("str.replaceAll(\"Ja\", \"JA\") : " + str.replaceAll("Ja", "JA"));
		System.out.println("================");
		
		System.out.println("----- substring() : 부분 문자열 추출-----");
		str = "Java World";
		System.out.println("str : " + str);
		System.out.println("str.substring(5) : " + str.substring(5)); //5번 인덱스부터 끝까지
		System.out.println("str.length() : " + str.length()); //5번 인덱스부터 끝까지
	
		//String.substring(int beginIndex, int endIndex)
		//beginIndex : 부터(포함)
		//endIndex : end 이전까지(불포함)
		
		
		System.out.println("str.substring(5, str.length()) : " + str.substring(5, str.length())); //5번 인덱스부터 끝까지
		//5부터 length보다 이전까지
	
		//뒤에서 5개 문자만 사용
		System.out.println("str.substring(str.length() - 5)" 
					+ str.substring(str.length() - 5));
 		System.out.println("---------------");
 		
 		str = "  Java World   ";
 		System.out.println("str : -" + str + "-");
 		System.out.println("str.trim() : -" + str.trim() + "-");
 		System.out.println("str.toUppercase() : " + str.toUpperCase());
 		System.out.println("str.toLowercase() : " + str.toLowerCase());
 		System.out.println("--------");
	
 		System.out.println("---- String.valueOf() : 문자열로 변환 -----");
 		int num = 100;
// 		str = 100; // String <---- int 
 		str = num + ""; //
 		str = String.valueOf(100); //static선언되면 클래스명.____
 		
 		
 		System.out.println("---- toCharArray() : 문자열을 char[]로 변환");
 		str = "Java World";
 		System.out.println("str : " + str);
 		char[] charArray = str.toCharArray();
 		System.out.println(Arrays.toString(charArray));
 		
 		System.out.println(str.contains("Java"));
 		
	}

}

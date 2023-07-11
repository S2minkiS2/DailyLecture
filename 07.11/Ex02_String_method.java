package com.mystudy.string;

import java.util.Arrays;

public class Ex02_String_method {

	public static void main(String[] args) {
		// String 클래스 메소드를 사용 문자열 처리(단, 원본 문자열 불변)
		//            0123456789
		String str = "Java World";
		
		System.out.println("str : " + str);
		
		System.out.println("--- charAt(인덱스 번호) ---");
		char ch = str.charAt(0);
		System.out.println("str.charAt(0): " + ch );
		System.out.println("str.charAt(1): " + str.charAt(1) );
		
		System.out.println("---- compareTo() : 문자열비교 (결과: 음수, 0, 양수)");
		System.out.println("\"java\".compareTo(\"java\")" + "java".compareTo("java"));
		System.out.println("aaa vs aaa : " + "aaa".compareTo("aaa")); //0
		System.out.println("bbb vs aaa : " + "bbb".compareTo("aaa")); //1
		System.out.println("ccc vs aaa : " + "ccc".compareTo("aaa")); //2
		System.out.println("aaa vs bbb : " + "aaa".compareTo("bbb")); //-1
		System.out.println("----------------------------");
		
		//     0123456789
		str = "Java World";
		System.out.println("str : " + str);
		
		System.out.println("--- indexOf() : 문자(문자열) 위치값 확인");
		System.out.println("str.indexOf('x') : " + str.indexOf('x')); //-1 : 없다
		System.out.println("str.indexOf('J') : " + str.indexOf('J')); // 0 : 첫번째
		System.out.println("str.indexOf('a') : " + str.indexOf('a')); // 1 : 두번째 위치
		System.out.println("str.indexOf('a', 2) : " + str.indexOf('a', 2)); // 3 : 2번 인덱스부터 찾아라.
		
		System.out.println("---- lastIndexOf() : 문자(문자열) 찾기(뒤에서부터) ----");
		System.out.println("str.lastindexOf('a') : " + str.lastIndexOf('a')); //뒤에서부터 찾는다
		
		System.out.println("--------satrsWith (), endsWith() 여부확인-------");
		System.out.println("str.startsWith(\"Java\") : " + str.startsWith("Java")); //true, false
		System.out.println("str.endsWith(\"Java\") : " + str.endsWith("World")); //true, false
		System.out.println();
		
		System.out.println("--- isEmpty() 데이터가 있냐없냐. 여부확인---");
		System.out.println("str : -" + str + "-");
		System.out.println("str.isEmpty() : " + str.isEmpty()); //비었냐
		System.out.println("str.length() : " + str.length()); //비었냐2
		
		str = "";//빈문자열
		System.out.println("str : -" + str + "-");
		System.out.println("str.isEmpty() : " + str.isEmpty());
		System.out.println("str.length() : " + str.length());
		System.out.println();
		
		System.out.println("-------- replace() : 문자, 문자열 변경된 문자열 받기-------");
		//	   0123456789
		str = "Java World";
		System.out.println("str : " + str);
		System.out.println("str.replace(\"Java\", \"Hello\") : " + str.replace("Java", "Hello"));
		System.out.println("str.replace(\"a\", \"m\") : " + str.replace('a', 'm'));
		System.out.println(str); //메소드 써도 원본값은 변하지 않는다. 불변이다.
		System.out.println("------------------------");
		
		str = "Java World";
		System.out.println("str : " + str);
		System.out.println("str.replace(\"Ja\", \"JA\") : " + str.replace("Ja", "JA"));
		System.out.println("=========================");
		
		System.out.println("---- substring() : 부분 문자열 추출 ----");
		//	   0123456789
		str = "Java World";
		System.out.println("str : " + str);
		System.out.println("str.substring(5) : " + str.substring(5)); // index[5] 글자부터 끝까지 출력
		System.out.println("str.length() : " + str.length());
		System.out.println("str.substring(0, str.length()) : " + str.substring(0, str.length())); // 
		
		//뒤에서 5개 문자만 사용
		System.out.println("str.substring(str.length() - 5) : " 
				+ str.substring(str.length() - 5));
		
		str = "  Java World  ";
		System.out.println("str : -" + str + "-");
		System.out.println("str.trim() : -" + str.trim() + "-"); //앞뒤 빈 공백 삭제
		System.out.println("str.toUpperCase() : " + str.toUpperCase());
		System.out.println("str.toLowerCase() : " + str.toLowerCase());
		System.out.println("------------------------");
		
		System.out.println("---- String.valueOf() : 문자열로 변환 ----");
		int num = 100;
		str = num + ""; // String <--- int, 자동형변환
		str = String.valueOf(100); //"100" 문자열로 형변환
		str = String.valueOf(num); //"100" 문자열로 형변환
		
		System.out.println("----- toCharArray() : 문자열을 char[] 배열로 변환 -----");
		str = "Java World";
		System.out.println("str : " + str);
		char[] charArray = str.toCharArray();
		System.out.println(Arrays.toString(charArray));
		System.out.println("charArray[0] : " + charArray[0]);
		
		
		
	}

}

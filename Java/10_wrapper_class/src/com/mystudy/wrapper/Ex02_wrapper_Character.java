package com.mystudy.wrapper;

public class Ex02_wrapper_Character {

	public static void main(String[] args) {
		// Character 클래스
		// "a" : String
		char ch = 'a'; 
		String str = "a"; // 문자가 하나라도 쌍따옴표면 String
		System.out.println(Character.isAlphabetic(ch)); //true
		System.out.println(Character.isAlphabetic('한')); //true
		//알파벳이냐, 문자 하나냐. 
		System.out.println(Character.isLetter('0')); //false
		System.out.println(Character.isDigit('0')); //true
		System.out.println(Character.isLetter('A')); //true
		System.out.println(Character.isUpperCase('A')); //true
		System.out.println(Character.isLowerCase('A')); //false
		//대문자냐
		//is로 시작하는 메소드는 결과값이 boolean이다
		System.out.println(Character.isWhitespace(' ')); //true
		System.out.println(Character.isWhitespace('\t')); //true
		System.out.println(Character.isWhitespace('A')); //false
		//시각적으로 안보이는 것들 whitespace냐?
		
		System.out.println("---------");
		char[] chs = {'한', 'a', ' ', 'A', '+', '0'};
		for (int i = 0; i < chs.length; i++) {
			System.out.print(chs[i] + " : ");
			if (Character.isDigit(chs[i])) {
				System.out.println("숫자"); 
			}
			if (Character.isWhitespace(chs[i])) {
				System.out.print("공백(제어문자)");
			}
			if (Character.isUpperCase(chs[i])) {
				System.out.print("대 ");
			}
			if (Character.isLowerCase(chs[i])) {
				System.out.print("소 ");
			}
			if (Character.isLetter(chs[i])) {
				System.out.print("문자 ");
			}
			if (Character.isDefined(chs[i])) {
				System.out.print("유니코드문자 ");
			} //유니코드 상에 디파인 된 문자냐
			System.out.println();
		}
		
	}

}

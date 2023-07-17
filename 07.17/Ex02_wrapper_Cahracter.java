package com.mystudy.wrapper;

public class Ex02_wrapper_Cahracter {

	public static void main(String[] args) {
		// Character 클래스
		// "a" : 쌍따음표 == String
		// 'a' : 홑따음표 == char
		char ch = '1';
		System.out.println(Character.isAlphabetic(ch));
		System.out.println(Character.isAlphabetic('신')); // 영문 알파벳만을 의미하는 것은 아니다.
		System.out.println(Character.isLetter('a'));
		System.out.println(Character.isLetter('A'));
		System.out.println(Character.isDigit('0'));
		System.out.println(Character.isUpperCase('B'));
		System.out.println(Character.isLowerCase('B'));
		System.out.println(Character.isWhitespace(' ')); // 띄어쓰기가 있냐? 안보이는
		System.out.println(Character.isWhitespace('\t')); // 탭도 안보이니?
		System.out.println(Character.isWhitespace('A')); // A도 안보이니?
		
		System.out.println("--------------------------------");
		char[] chs = {'한', 'a', ' ', 'A', '+', '0'};
		for (int i = 0; i < chs.length; i++) {
			System.out.print(chs[i] + " : ");
			if (Character.isDigit(chs[i])) {
				System.out.print("숫자");
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
				System.out.print("문자");
			}	
			if (Character.isDefined(chs[i])) {
				System.out.print("유니코드문자");
			}
			
			
			
		}
		
		
		
	}

}

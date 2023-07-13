package com.mystudy.stringbuilder;

public class Ex01_StringBuffer {

	public static void main(String[] args) {
//		StringBuffer 클래스
		StringBuffer sb = new StringBuffer("Hello Java!!!");
		System.out.println(sb);

		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity()); // 배열 char[] 의 크기,길이를 알려주는 메서드

		System.out.println("--- String : 데이터 불변(immutable) ---");
		String str1 = sb.toString();
		System.out.println("str1 : " + str1);
		String str2 = str1.concat(" 반갑습니다"); // = concat 처리해서 새로운 변수에 주소값 저장, 새로운 인스턴스임.
		System.out.println(str2);
		System.out.println(str1 == str2); // 같지않다.
		System.out.println("-------------------------------------");

		System.out.println("--- StringBuffer : 데이터 변경 가능 ---");
		System.out.println("sb : " + sb.toString());
		sb.append(" 반갑습니다").append("~~~").append("ㅋㅋㅋ"); // append: 내용추가후에 StringBuffer타입의 참조값을 반환. 동일한 객체임
		System.out.println(sb);
		System.out.println("append 후 sb : " + sb.toString()); // 내부적으로 변경이 된다.
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());

		sb.reverse();
		System.out.println("reverse 후 sb : " + sb.toString());
		sb.reverse();
		System.out.println("reverse 후 sb : " + sb.toString());

		System.out.println("=== delete(), insert(), replace() ===");
		// Hello Java!!! 반갑습니다~~~ㅋㅋㅋ
		StringBuffer sb2 = sb.delete(0, 6);
		System.out.println("sb.delete(0, 6) : " + sb.delete(0, 6));
		System.out.println("sb : " + sb.toString());
		System.out.println("sb == sb2 : " + (sb == sb2)); // concat이 다른 객체인 것에 반해, 이것은 동일 객체이다.

		System.out.println("-----------------------------------------------");

		sb2 = new StringBuffer(100);
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());

		sb2.append("안녕하세요").append(" 반갑습니다");
		System.out.println("sb2 : " + sb2);
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());

		System.out.println("--- trimToSize() 실행하면 ---");
		sb2.trimToSize(); // rturn값 x, 크기를 줄이기만 하는 메서드
		System.out.println("sb2.capacity() : " + sb2.capacity()); // trimToSize메서드가 빈 공간을 삭제했음

		
		System.out.println("--- setLength() 실행하면 ---");
		sb2.setLength(5); // 데이터 크기 설정 (length = 작게 설정하면 delete 효과 발생)
//		== sb2.delete(5, sb2.length());
		System.out.println(sb2); //length가 5로 줄어들어, 뒤의 ' 반갑습니다' 문구가 삭제됨.
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());

		sb2.setLength(0); // 전체데이터가 모두 삭제처리된다.
		System.out.println("sb2 : -" + sb2.toString() + "-");
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		
		
		
		
		
	}

}

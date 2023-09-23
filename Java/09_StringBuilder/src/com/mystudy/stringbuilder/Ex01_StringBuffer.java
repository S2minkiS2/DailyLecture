package com.mystudy.stringbuilder;

public class Ex01_StringBuffer {

	public static void main(String[] args) {
		// StringBuffer 클래스
		StringBuffer sb = new StringBuffer("Hello Java!!!");
		System.out.println(sb);
		String str = sb.toString(); 
		// -> SbringBuffer의 저장 문자열 확인, String타입을 리턴해준다
		System.out.println("sb.length() : " + sb.length());
		// -> 길이
		System.out.println("sb.capacity() : " + sb.capacity());
		// -> 저장용량, 자동으로 알아서 여유공간 가짐. 지금은 기본 확보 16개
	
		System.out.println("--- String : 데이터 불변 (immutable) ---");
		String str1 = sb.toString();
		System.out.println("str1 : " + str1);
		// str1은 변경할 수 없다.
		String str2 = str1.concat(" 반갑습니다."); 
		//concat으로 문자열 붙이기는 가능하나 데이터가 수정된 것이 아님. 
		//새로운 객체를 만들어 두 값 모두 입력된 데이터 새로 저장
		System.out.println("str1 == str2 : " + (str1 == str2));
		System.out.println("------------");
		
		System.out.println("--- StringBuffer : 데이터 변경 가능 ---");
		System.out.println("sb : " + sb.toString());
		sb.append(" 반갑습니다");
		sb.append(" 반갑습니다").append("~~~"); 
		//-> 고리를 연결하는 듯 하다 해서 체이닝chaining 방식이라고 함
		//-> 호출 후 리턴 값을 또 호출하고 또 호출하고...
		System.out.println("append 후 sb : " + sb.toString());
		//-> concat처럼 새 객체 생성이 아닌 수정, 데이터가 달라진다.
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());
		// -> 6글자 추가가 되어 길이가 19로 변경되었다.
		
		sb.reverse();
		System.out.println("reverse 후 sb : " + sb.toString());
		sb.reverse();
		System.out.println("reverse 후 sb : " + sb.toString());

		System.out.println("=== delete(), insert(), replace() ===");
		//Hello Java!!! 반갑습니다 반갑습니다~~~
		StringBuffer sb2 = sb.delete(0,  6);
		System.out.println("sb.delete(0, 6) : " + sb.toString());
		// -> Hello 지워짐 H의 인덱스 0부터 6번째까지 지움.
		// -> 동일객체에서 작업을 진행함
		System.out.println("sb : " + sb.toString());
		System.out.println("sb == sb2 : " + (sb == sb2));
		// -> 리턴도 같은 객체. 
		//동일 객체 하나로 수정, 삭제 등 할 수 있음. 효율적. 
		// 불필요한 데이터 낭비 없음

		
		sb.insert(0,  "Hello");
		System.out.println("sb.insert(0,  \"Hello\") : " + sb.toString());
		sb.replace(0, 5, "Hi,");
		System.out.println("sb.replace(0, 5, \"Hi,\")" + sb.toString());
		
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());
		System.out.println("---------------");

		sb2 = new StringBuffer(100);  
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		System.out.println("---------------");
		
		sb2.append("안녕하세요").append("반갑습니다!!!");
		System.out.println("sb2 : " + sb2.toString());
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		System.out.println("--- trimToSize() 실행하면----");
		sb2.trimToSize();
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());

		System.out.println(">> sb2.setLength(5) 실행하면----");
//		sb2.setLength(5); //데이터 크기 설정 (작게 설정하면 delete효과)
		sb2.delete(5, sb.length()); // ㄴ위와 같음. 앞에 5개 남기고 모두 삭제
		System.out.println("sb : " + sb.toString());
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
//		sb2.setLength(0);
		sb2.delete(0, sb.length()); // 전체 데이터 삭제
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		System.out.println("---------------");
	}	

}

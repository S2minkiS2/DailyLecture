package com.mystudy.wrapper;

public class Ex01_wrapper_class {

	public static void main(String[] args) {
		// wrapper class : 기본 데이터 타입의 기능확장한 클래스(들) 총칭
		// 기본 데이터 타입 : 전체소문자 
		//  boolean, char, byte, short, int(21억 이하), long, float, double(특별한거 아니면 더블쓰기)
		// wrapper class : 기본 데이터 타입의 첫글자는 대문자로
		// 		예외: char -> Character, int -> Integer
		// 		Boolean, Character, Byte, Short, Integer, Long, Float, Double
		//------------------------------------------------------------------------------------------
		
		int num = 100;
		System.out.println("num = " + num);
		
		Integer intNum = new Integer("100"); 
//		Integer intNum = new Integer(100); // but 굳이 new쓰며 만들필요 없다.
		System.out.println("Intger inNum : " + intNum);
		
		String strNum = intNum.toString();
		System.out.println("String strNum : " + strNum);
		
		intNum = 900; // Integer <-- int : 서로간 자동형변환
		num = intNum; // int <-- Integer : 서로간 자동형변환

		//toString값은 null값에 오류, valueOf()를 쓰자. 기능은 동일하다.
		
		num = Integer.parseInt("999"); // String 타입을 int 타입으로 형변환
		intNum = Integer.valueOf("999"); //String 타입을 Integer 타입으로 형변환
		String str = String .valueOf(9999); // int타입을 String 타입으로 형변환

		System.out.println("int 타입의 최대값 : " + Integer.MAX_VALUE);
		System.out.println("int 타입의 최소값 : " + Integer.MIN_VALUE);
		
		
		System.out.println("---- Boolean ----");
		Boolean bool = true; 
		bool = new Boolean(true); //굳이;
		bool = new Boolean("true"); //굳이2;
		bool = new Boolean("TRUE"); //굳이3;
		bool = new Boolean("True"); //굳이4; 문자열 "true", "TRUE", "TRue" 철자만 맞으면 대소문자 구분없이 모두 true 처리
		System.out.println("Boolean true : " + bool);
		
		bool = new Boolean("false");
		bool = new Boolean("FALSE");
		bool = new Boolean("FAlse");
		bool = new Boolean("true1"); //true가 아닌 다른 문자열은 false로 처리된다.
		bool = new Boolean("ABCDefg"); //true가 아닌 다른 문자열은 false로 처리된다.
		System.out.println("Boolean true : " + bool);
		
		System.out.println("==== String 을 Boolean으로 형변환 ====");
		Boolean bool2 = Boolean.valueOf("true"); //String 타입의 문자열을 Boolean 타입으로 형변환
		boolean bool3 = Boolean.parseBoolean("true"); //Boolean 타입의 문자열을 boolean 타입으로 형변환
		
		System.out.println("==== Float, Double ====");
		//Float 클래스는 다양한 기본타입을 float타입에 저장해서 쓸 수 있게 해준다.
		Float f = 10.5f; // float <-- float
		f = new Float(12.5); // float <-- double
		f = new Float("12.5f"); 
		f = new Float("12.5"); //Float 클래스는 문자열을 float로 자동형변환
		System.out.println("Float f : " + f);
		
//		f = "12.5f"; //안됨
		String str2 = String.valueOf(f); // String <-- float
		System.out.println("String str2 : " + str2);
		
		f = Float.valueOf("12.5f"); // float <-- String
		System.out.println("Float f : " + f);
		//Float 클래스는 다양한 기본타입을 float타입에 저장해서 쓸 수 있게 해준다.
		System.out.println("--------------------------------------");
		
		Double d = 10.5D; //Double <-- double
		d = new Double(12.5d);
		d = new Double("12.5d");
		System.out.println("Double d : " + d);

		Double.valueOf("12.5d"); // new생성자 안쓰고 바로 사용 가능한 방법
		Double.valueOf("12.5"); // d안붙여도 됨
		Double.valueOf("10.5f"); 
		System.out.println("Double d : " + d);
		
		
		
	}

}

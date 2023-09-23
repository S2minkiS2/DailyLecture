package com.mystudy.wrapper;

public class Ex1_wrapper_class {

	public static void main(String[] args) {
		// wrapper class : 기본 데이터 타입의 기능 확장한 클래스 총징
		// 기본 데이터 타입 : 전체 소문자
		// boolean, char, byte, short, int, long, float, double
		// wrapper class : 기본 데이터 타입의 첫글자를 대분자로 
		// 예외 : char - Character, int - integer
		// Boolean, Character, Byte, Short, Integer, Long, Float, Double
		
		int num = 100;
		System.out.println("num : " + num);
		
//		Integer intNum = new Integer(100);
		Integer intNum = new Integer("100");
		// 이렇게 만들 수는 있지만 굳이.. 숫자 100을 별도의 객체에 저장할 필요x
		System.out.println("integer intNum : " + intNum);
		
		String strNum = intNum.toString(); //저장된 숫자 데이터를 문자열로 변경
		System.out.println("String intNum : " + strNum);
		
		intNum = 900; // Integer <---- int : 자동형변환 // 그냥 넣어쓰면됨
		num = intNum ; //int <--- Integer : 자동형변환
		
		num = Integer.parseInt("999"); // int <--- Integer 
//		문자열 데이터타입이 int로
		intNum = Integer.valueOf("999"); // Integer ---> String 
//		전달받은 String 데이터를 해당 해당 데이터타입으로
		
		String str = String.valueOf(9999); //String <--- int
		// 전달받은 데이터를 해당 데이터 타입으로 변환
		
		System.out.println("int 최대값 : " + Integer.MAX_VALUE);
		System.out.println("int 최소값 : " + Integer.MIN_VALUE);
		
		System.out.println("--- Boolean ---");
		Boolean bool = true; //이렇게 넣으면 됨
		bool = new Boolean(true); //이렇게 할 필욘 없다
		bool = new Boolean("true");
		bool = new Boolean("TRUE"); //대소문자 상관없이 철자만 맞으면 true
		bool = new Boolean("TRue"); // "true", "TRUE", "TRue" 전부 true 
		
		System.out.println("boolean true : " + bool);
		
		bool = new Boolean("false");
		bool = new Boolean("FALSE");
		bool = new Boolean("FAlse");
		bool = new Boolean("true1"); // 오류는 안났으나 false
		// true가 아닌 문자열은 false다.
		bool = new Boolean("abcd"); // 오류는 안났으나 false
		System.out.println("boolean false : " + bool);
		
		System.out.println("--- String ---> Boolean ---");
		Boolean bool2 = Boolean.valueOf("true"); //Boolean <--- String
		//Boolean 타입으로도 형변환 가능하다.
		boolean bool3 = Boolean.parseBoolean("true");
		
		System.out.println("==== Float, Double ====");
		Float f = 10.5f; // Float <--- float 
		//기본 타입과 wrapper클래스 타입간에는 자동형변환 된다.
		f = new Float(23.6f);
		System.out.println(12.5);
		System.out.println("Float, f : " + f);
		
		//f = "12.5f"; // Type mismatch : cannot conver from String
		String str2 = String.valueOf(f); //String ---> float
		System.out.println("String str2 : " + str2);
		
//		f = "23.5f"; //string타입을 float 넣고싶어요
		System.out.println("Float f : " + f);
		f = Float.valueOf("23.6f"); // Float <-- String
		
		Double d = 10.5D; // Double <-- double
		d = new Double(12.5d);
		d = new Double(12.5);
		d = new Double(12.5f);
		System.out.println("Double d : " + d);
		
		d = Double.valueOf("12.5d") ;
		
		
		
		
	}

}


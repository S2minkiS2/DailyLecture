package com.mystudy_ex01_exception;

public class ExceptionEx {

	public static void main(String[] args) {
		System.out.println("---- main() 시작 ----");
		int num1 = 100;
		int num2 = 10;
		int result = 0;
		System.out.println(">> 연산 시작");
		
		//result = num1 / num2; //ArithmeticException: / by zero
		
		//예외처리 해보기-------------
		if (num2 == 0) {
			System.out.println("[예외 발생] num2가 0입니다. 삐옹삐옹");
		} else {
			result = num1 / num2;
			System.out.println("연산결과 result : " + result);
		}
		System.out.println();
		
		//예외처리 문법 해보기-----------
		System.out.println("==== Try ~ catch 예외처리 해보기 ====");
		try {
			System.out.println("-- try 시작 --");
			result = num1 / num2;
			System.out.println("연산결과 result : " + result);
			System.out.println("-- try 끝 --");
			//return; //메소드 종료
		} catch (ArithmeticException e) { // 순서가 바뀌면 안된다.  Arith > Runtime > Exception 순으로 촘촘하다.
			System.out.println("[예외 발생] num2가 0입니다. 뿌웅뿌웅");
			System.out.println("[예외 발생 - ArithmeticException]" + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("[예외 발생 - RuntimeException]" + e.getMessage());
		} catch (Exception e) {
			System.out.println("[예외 발생 - Exception]" + e.getMessage());
		} finally {
			System.out.println(">> finally : 항상(무조건) 실행"); //위에서 return을 만나도 무조건 실행한다
		}
		
		System.out.println("test : try~catch~finally 이후 문장");
		
		System.out.println("---- main() 끝 ----");
		

	}

}

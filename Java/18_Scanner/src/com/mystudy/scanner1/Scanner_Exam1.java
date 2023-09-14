package com.mystudy.scanner1;

import java.util.Scanner;

public class Scanner_Exam1 {

	public static void main(String[] args) {
		// Scanner 클래스 : 콘솔(화면)에서 데이터 읽어오기
		Scanner scan = new Scanner(System.in);
		//in은 스태틱이다. Static변수 in이고 System에 있다.
		
//		System.out.println("Hello World!!!");
		//.은 기본데이터 타입에선 쓸 수 없다. out은 참조형 데이터
		//out은 변수이면서 참조형데이터
		//println은 소문자로 시작 -> 변수/메소드 but 뒤에 소괄호 -> 메서드
		//필드변수이나 System으로 시작 -> static (대문자)
		//System 클래스에 있는 out이라는 변수에 저장된 객체에 있는 println메서드
		
		
		System.out.print("문자열 입력1 : ");
		String str1 = scan.nextLine(); 
		//줄바꿈 문자까지 읽어들여야 실행정지됨.
		//줄 끝까지 읽어서 처리
		//읽어들인 문자열을 String타입으로 만들어 str1에 전달
		System.out.println(">>> " + str1);
		// 프린트 하지 않으면 출력이 안된다. 
		System.out.println("-----");
		
		System.out.print("문자열 입력2 : ");
		String str2 = scan.nextLine();
		System.out.println(">>> " + str2);
	
		System.out.println("=============");
		System.out.println("정수값 2개를 입력하면 더한 결과 출력");
		//int num1 = 10;
		//int num2 = 20;
		int sum = 0;
		
		//(주의) nextXxx 메소드 사용 후 nextLine() 사용시 문제가 발생할 수 있다
		//해결책은 nextInt를 쓰지않고 라인단위로 읽어오면 원천차단 (parseInt로 숫자타입 형변환)
		// nextLine써서 문자열 읽어와야하면 nextLine을 한번 더 써서 읽고 버린다
		
		System.out.print("숫자 입력 1 : ");
		int num1 = scan.nextInt(); //int값을 리턴해준다
		//입력한 int값을 num1에 저장한다
		
		System.out.print("숫자 입력 2 : ");
		int num2 = Integer.parseInt(scan.nextLine()); //int값을 리턴해준다
		//입력한 int값을 num2에 저장한다
		
		scan.nextLine(); //줄바꿈문자(엔터)까지의 값을 읽어서 처리
		//우리는 이걸 사용하지 않지만 얘가 이걸 처리했으므로
		//아래에 올 scan에서 새로 입력할 수가 있다
		
		sum = num1 + num2;
		//입력 받은 num1과 num2를 합한 값을 sum에 저장
		System.out.println("합계 : " + sum);
		
		System.out.print("문자열(nextLine) : ");
		//nextline을 사용해서 문자열 읽어오기
		String temp = scan.nextLine();
		//전달받은 문자열을 String타입 temp에 저장
		//그런데 이렇게 쓰면 nextLine이 이미 실행처리가 되어버림
		// 숫자입력 20하고 엔터를 치는 순간 줄바꿈 문자까지 nextInt가 읽어버린다.
		// next메서드 뒤에 nextLine이 오게되면 발생하는 문제
		
		System.out.println("입력문자열 출력 : " + temp);
		
		System.out.println("==============");
		System.out.print("문자열 1개와 정수 숫자3개 연속 입력 : ");
		String strTemp = scan.next();
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int n3 = scan.nextInt();
		System.out.println("첫번째문자열 : " + strTemp);
		System.out.println(n1 + ", " + n2 + ", " + n3);
	
	
	}

}

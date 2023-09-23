	/* pakage 선언문 : Java 파일의 맨 첫번째에 위치하며 한 번만 작성
	 * 자바(class)파일의 위치를 나타낸다.
	 * 일반적으로 회사의 도메인 명을 반대로 적용해서 사용한다.//클래스를 구분하기 위해
	 * 작성예) com.naver.project, com.itwill.mystudy 
	 */
	
	package edu.class1.basic;
	
	// import 선언문 : 선택항목이지만 일반적으로 사용
	// (java.lang 패키지에 있는 것은 자동으로 컴파일-빈번하게 사용하는 것들)
	
	// java.lang 패키지 이외의 패키지에 있는 타입 사용시 사용 (import)
	import java.util.Scanner;
	//import java.util.*; //java.util에 있는 모든것 // 
	//대표문자 (wild card) * 사용가능
	
	//class 선언문 :  필수 항목
	public class Ex01_package_import_class {
	
		public static void main(String[] args) {
			// java.unil.Scanner scan; new java.util.Scanner(System.in);
			// 이 유틸에 있는. 스캐너...... //너무 길다. 그래서 import문 씀
			Scanner scan = new Scanner(System.in); // 콘솔로부터 데이터 읽어들임
			System.out.print(">> 인사말 : ");
			
			String hello = scan.nextLine(); //scanner 객체에 있ㄴ는 nextLine() 이란 메서드
			System.out.println("인사말 출력 : " + hello);
			
			
		}
	}

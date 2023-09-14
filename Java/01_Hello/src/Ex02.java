//클래스
public class Ex02 {
	//메서드
	public static void main(String[] args) {
		// 한 줄 주석문 : 주석부호(//)부터 문장의 끝까지를 주석(설명문)처리한다.
		/*
		 여러줄 주석 처리시 사용
		 */
		System.out.println("Hello World!!!"); //문장의 끝 세미콜론
		//문자열 (String) 좌우측 + 연산자는 문자열 붙이기 처리됨
		System.out.println("1234567" + "1");  
		System.out.println("1234567" + 1);  
		System.out.println(1 + "1234567");  
		System.out.println(2 + 2);
		
		System.out.println("================="); // ctrl+space => sysout
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("****");
		System.out.println("*****");
		System.out.println("=================");
		System.out.println("    *");
		System.out.println("   **");
		System.out.println("  ***");
		System.out.println(" ****");
		System.out.println("*****");
		System.out.println("=================");   
		 /* 화면에 구구단 출력 2단
		 2 * 1 = 2 // 2*1 결과값
		 2 * 2 = 4
		 2 * 3 = 6
		 ...
		 2 * 9 = 18
		  */
		System.out.println("구구단 2단");
		System.out.println("2 * 1 = 2");
		System.out.println("2 * 2 = 4");
		System.out.println("2 * 3 = " + 2 * 3);
		System.out.println("2 * 4 = " + (2 * 4));
		System.out.println("...");
		System.out.println("2 * 9 = " + 2 * 9);
		System.out.println("=========");
		
		//97단 출력
		System.out.println("97 * 1 = " + 97);
		System.out.println("97 * 2 = " + (97 * 2));
		System.out.println("97 * 3 = " + (97 * 3));
		System.out.println("97 * 4 = " + (97 * 4));
		System.out.println("...");
		System.out.println("97 * 9 = " + (97 * 9));
		
	
	}

}

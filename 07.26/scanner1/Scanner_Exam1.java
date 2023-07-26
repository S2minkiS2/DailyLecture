package com.mystudy.scanner1;

import java.util.Scanner;

public class Scanner_Exam1 {

	public static void main(String[] args) {
		// Scanner 클래스 : 콘솔(화면)에서 데이터 읽어오기
		
		Scanner scan = new Scanner(System.in);
		
//		System.out.print("문자열 입력1 : ");
//		String str1 = scan.nextLine().trim();
//		System.out.println(">>> str1 : " + str1);
//		System.out.println("-----------------------------------------------");
//		
//		System.out.print("문자열 입력2 : ");
//		String str2 = scan.nextLine().trim();
//		System.out.println(">>> str2 : " + str2);
//		
//		System.out.println("===============================================");
//		System.out.println("정수값 2개를 입력하면 합한 결과를 출력하겠다");
//		
//		int sum = 0;
//		//(주의) nextXxx() 사용 후 nextLine() 사용시 문제 발생.
//		System.out.print("숫자 입력1 : ");
//		int num1 = scan.nextInt();
//		
//		System.out.print("숫자 입력2 : ");
//		int num2 = scan.nextInt();
//		
//		sum = num1 + num2;
//		System.out.println("합계출력 : " + sum);
/*		
사용자가 nextInt()를 호출하여 정수를 입력한 후 엔터를 누르면 입력 버퍼에 개행 문자('\n')가 남아 있게 됩니다.
문제는 이후에 nextLine()을 호출할 때 발생합니다. 
nextLine()은 입력 버퍼에서 개행 문자를 만날 때까지 입력을 읽어들이기 때문에, 
남아있는 개행 문자를 만나게 되면 바로 그 다음 라인으로 인식하고 입력을 받지 않게 됩니다. 
즉, nextInt() 다음에 nextLine()을 사용하면 nextInt()에서 입력받은 값 뒤에 아무런 입력을 받지 않고 그냥 넘어가게 됩니다.	
*/		
		// 해결방법1
//		System.out.println("scan.nextLine() 실행합니다.");
//		scan.nextLine(); // 남아있는 개행 문자를 소비하기 위해 호출, nextLine()을 쓰기 위해서 nextXxx(); 다음에 쓰는 것을 추천한다.
		
		// 해결방법2
		//Scanner scanner = new Scanner(System.in);
		//String numberStr = scanner.nextLine();
		//int number = Integer.parseInt(numberStr); // 문자열을 정수로 변환
		//String line = scanner.nextLine(); // 이후에 추가적인 입력을 받을 수 있습니다.

//		System.out.print("문자열(nextLine) : ");
//		String temp = scan.nextLine().trim(); 
//		System.out.println("입력문자열 출력 : " + temp);
		
		System.out.println("===============================================================");
		System.out.print("문자열 1개와 정수 3개 연속입력 : ");
		String strTemp = scan.next(); // nextLine과의 차이점 알것
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int n3 = scan.nextInt();
		System.out.println("첫번째 문자열 : " + strTemp);
		System.out.println(n1 + ", " + n2 + ", " + n3);
		
		
	}

}

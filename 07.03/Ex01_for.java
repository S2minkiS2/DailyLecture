
public class Ex01_for {

	public static void main(String[] args) {
		//제어문 - 반복문(for, while, do ~ while)
		//-----------------------------------------------
		int member = 3;
		for (int i = 1; i <= member; i++) { // i는 지역변수
			System.out.println("*");
		}
		System.out.println("=============================");
		
		for (int j = 0; j <= 10; j+=2) {
			System.out.println("* = "+ j +"번째 별");
		}
		System.out.println("=============================");
		
		//-----------------------------------------------
		
		System.out.println("----------------1부터 5까지 출력");
		
		//반복인자 값을 사용해서 출력
		for(int k = 1; k <= 5; k++) {
			System.out.println(k + " = " + k + "번째 숫자");
		}
		System.out.println("=============================");
		
	}
	
}

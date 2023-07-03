
public class Ex04_break_continue {

	public static void main(String[] args) {
		//반복 제어문 : break, continue
		//break : 중단 (반복을 중단하고 현재 실행중인 반복문 종료) 
		//continue : back해서 다음 반복을 처리
		//-----------------------------------------------
		
		//1~10 출력하되 8은 출력하지 말 것
		for (int i = 1; i <= 10; i++) {
			if (i!=8) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println("----------continue 사용----------");
		
		for (int i = 1; i<= 10; i++) {
			if (i == 8) continue; //중괄호 쓰지 않는게 좀더 직관적
			System.out.print(i + " "); //continue를 만나면 다시 위로 간다.
		}
		System.out.println("\n==============================="); // \n : 줄바꿈
		
		//1~10 출력중 8을 만나면 처리 중단
		for (int i = 1; i <= 10; i++) {
			if (i == 8) break;
			System.out.print(i + " ");//메서드와 break문의 위치에 따라 결과가 다르다.
		}
		System.out.println();
		System.out.println(">>반복문 종료 후~~");
		
		
	}

}

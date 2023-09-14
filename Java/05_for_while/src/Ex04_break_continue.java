
public class Ex04_break_continue {

	public static void main(String[] args) {
		// 반복 제어문 : break, continue
		// break : 중단 (반복을 중단하고 현재 실행중인 반복문 빠져나감)
		// continue : 스킵하고 이어서 다음 반복처리
		//--------------------------------------
		
		//1부터 10까지 출력하되 8은 출력하지 말 것
		for(int i = 1; i <=10; i++) {
			if (i != 8) { //보통은 if문에 긍정문을 넣지 않지만 코드를 비워두는 것 보단 부정문이 나음
			System.out.print(i + " ");	
			}
		}
		System.out.println();
		System.out.println("----- continue 사용 -----");
		
		//1부터 10까지 출력하되 8은 출력하지 말고 다음 반복 처리
		for (int i = 1; i <= 10; i++) {
			if (i == 8)	continue; // continue문 만나면 다음 반복 실행
			System.out.print(i + " ");
		}
		System.out.println();// 줄바꿈
		// \n : 줄바꿈 (new line)
		System.out.println("\n====== break 문 ======");
		
	
		//1~10까지 출력 중 8을 만나면 처리 중단
		for (int i = 1; i <= 10; i++) {
			if (i == 8) break; 
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(">> 반복문 종료 후~~~");
	
	}
}

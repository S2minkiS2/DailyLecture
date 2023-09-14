
public class Ex06_for_star {

	public static void main(String[] args) {
		// 쪼개서 생각하는 연습!
		
		// ***** 화면 출력

		System.out.println("*****");
		System.out.println("----------");
		
		System.out.print("*****");
		System.out.println(); //줄바꿈
		System.out.println("----------");
		
		System.out.print("*");
		System.out.print("*");
		System.out.print("*");
		System.out.print("*");
		System.out.print("*");
		System.out.println();
		System.out.println("----반복문 print 별찍기 반복------");
		
		for (int i = 1; i <= 5; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println("======================");
		
		// 별 다섯개씩 네 줄 찍기

		for (int i = 1; i <= 4; i++) { //별다섯개 찍은걸 4번 반복
			for (int j = 1; j <= 5; j++) { //별 다섯개 찍기
				System.out.print("*"); // 이 문장은 다섯번 실행
			} // 해석 순서는 안쪽에서부터 바깥쪽으로
			System.out.println(); //줄바꿈
		}
		
		System.out.println("====================");
		for (int i = 1; i <=3; i++) {
			System.out.print("*****");
			System.out.println();
		}
		System.out.println("----------");
			
		for (int i = 1; i <=3; i++) {
			for (int star = 1; star <=5; star++)
			System.out.print("*");			
			System.out.println();
		} // 내가 할 수 있는 범위 내에서 계속 쪼개들어가기
		
		
		System.out.println("====삼각형 형태의 * 찍기======");
		/* 화면(콘솔창)에 삼각형 모양을 출력
		*		1라인 : * 1개 + 줄바꿈
		**		2라인 : * 2개
		***		3		*3
		****	4		*4
		*****	5		*5
		--------------- */
		
		for(int i = 1; i<=5; i++ ) {
			for (int j = 1; j <=i; j++) {
				System.out.print("*");
			} 
			System.out.println();
		}	
		
		int cnt = 1; //외부에 별도의 변수 
		for (int line = 1; line <= 5; line++) {
			for (int star = 1; star <= cnt; star++) {
			System.out.print("*");
			}
			System.out.println();
			cnt++; // 서로 종속되지 않음, 
			// for문 밖에서 변수 cnt를 1씩 증가
			//내부 인자를 가져다 쓰려는 강박xxx
			
		}
		System.out.println("===================");
		
		
	
	
	
	}

}

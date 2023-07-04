
public class Ex06_for_drawingStar {

	public static void main(String[] args) {
		//***** 화면 출력

		System.out.println("-------for문 두번 적용// 아래의 형태를 실무에서 많이 사용한다-------");
		
		for (int line = 1; line <= 4; line++) { //4개의 줄에 반복
			for(int star = 1; star <= 6; star++) { //한 줄에 별 6개 찍기 반복
				System.out.print("*");
			}
			System.out.println(); //줄마다 별 찍고 line숫자 넘어가는 것
		}
		
		System.out.println("------- 삼각형 별찍기--------");
		for (int li = 1; li <= 5; li++) {
			for (int star = 1; star <= li; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}

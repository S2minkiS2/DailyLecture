
public class Ex09_for_gugudan2 {

	public static void main(String[] args) {
		/* 구구단 2~9단 출력
		 * 2*1 = 2 	3*1 = 3		... 9*1 = 9
		 * 2*2 = 4 	3*2 = 6		... 9*2 = 18
		 * ...     	...			... 
		 * 2*9 = 18 3*9 = 27    ... 9*9 = 81
		 * */
		
		
		int dan;
		int gop;
		
		for (dan = 2; dan <= 9; dan++) {
			System.out.print("구구단 " + dan + "단 시작 : ");
			for (gop = 1; gop <= 9; gop++) {
				System.out.print(dan + " * " + gop + " = " + (dan * gop) + "\t"); // 숨겨진, 고정된 탭위치로 가는 키워드 \t 그래서 1단 뒤에가
																					// 연달아 붙어있는 거임
			}
			System.out.println();
		}
		
		System.out.println("----------- 위와 아래는 다른 결과 ----------");
		
		int a;
		int b;
		
		for (a = 1; a <= 9; a++) {
			for (b = 2; b <= 9; b++) {
				System.out.print(b + " * " + a + " = " + (b * a) + "\t");
			}
			System.out.println();
		}
		
	}

}

// ctrl + shift + f == 자동들여쓰기 기능

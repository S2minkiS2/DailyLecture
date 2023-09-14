
public class Ex09_for_gugudan2 {

	public static void main(String[] args) {
		// 2~9단 출력
		// 2*1=2   3*1=3  ... 9*1=9
		// 2*3=6   3*2=6
		// ...
		// 2*9=18  3*9=27     9*9=81

		System.out.println("=====================");
		
		for (int i = 1; i <= 9; i++) {
			for (int dan = 2; dan <= 9; dan++) { //8개 단
				System.out.print(dan + "*"+ i + "=" + (dan * i)  + "\t");	
			}
			System.out.println();
		}
		
		//2에서부터 9까지 달라짐. dan으로 변수화

		System.out.println("=====================");
		
		
//		System.out.print(2 + "*" + 1 + "=" + (2*1)+"\t");
//		System.out.print(3 + "*" + 1 + "=" + (3*1)+"\t");
//		(따로 떼서 변수 사용여부 확인)
			
		for (int dan = 2; dan <= 9; dan++) {
			System.out.print(dan + "*" + 1 + "=" + (dan*1)+"\t");
		}
		System.out.println();
		
		for (int dan = 2; dan <= 9; dan++) {
			System.out.print(dan + "*" + 2 + "=" + (dan*2)+"\t");
		}
		System.out.println();

//		위 문장을 전체 반복처리한다.
		
		System.out.println("========완성========");
	
		for (int i = 1; i <= 9; i++) {
			for (int dan = 2; dan <= 9; dan++) {
				System.out.print(dan + "*" + i + "=" + (dan*i)+"\t");
			}
			System.out.println();
		}
		
//		
//		
//		
//		
//		
//		
//		
//		for (int a = 1 ; a <= i; a++) {
//			for (int b = 1; b <= j; b++) {
//				System.out.print(i + "*" + j + "=" + i*j + "\t");
//			}
//			
//			
//		}
//			
//			
//			
//	
//		
//		
		
		
		
		
		
		
		
	}

}

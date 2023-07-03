
public class Ex02_for_if_exam {

	public static void main(String[] args) {
		
		//for와 if문의 합성
		
		//(실습) 1~5까지 숫자 화면에 출력하라
		for (int i = 1; i <= 5; i++) {
			System.out.print(i);
			if (i < 5) {
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.println("-------------------");
		
		//(실습) 11, 12, 13, 14, 15 화면에 출력하라
		for (int j = 11; j <= 15; j++) {
			System.out.print(j);
			if (j < 15) {
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.println("-------------------");
		
		//(실습) 1,3,5,7,9 화면에 출력하라
		for (int k = 1; k <= 9; k += 2) {
			System.out.print(k);
			if (k < 9) {
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.println("-------------------");
		
		//(실습) 2,4,6,8,10 화면에 출력하라
		for (int p = 2; p <= 10; p += 2) {
			System.out.print(p);
			if (p < 10) {
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.println("-------------------");
		
		//(실습) 5,4,3,2,1 화면에 출력하라
		for (int r = 5; r >= 1; r--) {
				System.out.print(r);
				if (r > 1) {
					System.out.print(", ");
				}
		}
		System.out.println();
		System.out.println("-------------------");
		
		
	}

}

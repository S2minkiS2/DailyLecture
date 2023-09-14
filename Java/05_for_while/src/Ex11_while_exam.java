
public class Ex11_while_exam {

	public static void main(String[] args) {
		//  while문 사용해서 처리
		// (실습) 문제1 : 1~10까지의 합을 구하고 화면에 출력
		

		System.out.println("--------문제1--------");
		 
		int i = 1;
		int sum = 0;
		while(i <= 10) {	//i값을 증감처리 하지 않으면 문장을 벗어날 수 없다
			sum = sum + i;			
			i++;
		}
		System.out.println("1~10 합계 : " + sum);
		
		System.out.println("--------문제1 for--------");
		
		sum = 0;
		for (i = 1; i <= 10; i++) {
			sum = sum + i; 
		}
		System.out.println("1~10 합계 : " + sum);

		/* (실습) 문제2 ----------
		*****
		*****
		*****
		 -------------------*/
		
		System.out.println("--------문제2--------");
		int line = 1; 		
		while (line <= 3) {
			int star = 1; 
			while (star <= 5) {
				star++;
				System.out.print("*");
			}
			line++;
			System.out.println();		
		}

		System.out.println("--------문제3 for--------");
		
		for (line = 1; line <=3; line++) {
			for (int star = 1; star <=5; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		/* (실습) 문제3 ----------
		*
		**
		***
		****
		 ------------------*/
		
		System.out.println("--------문제3--------");
		
		line = 1; 
		while (line <= 4) {
			int star = 1;
			while (star <= line) {	
				System.out.print("*");
				star++;
			}
			line++;
			System.out.println();
		}
		
		System.out.println("--------문제3 for--------");
		
		for (line = 1; line <= 4; line++) {
			for (int star = 1; star <= line; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
			
//		1부터 100까지의 정수 중에서 3의 배수 총합
		
		
		

	}
}

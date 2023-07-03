
public class Ex05_max_number {

	public static void main(String[] args) {
		/* 숫자 3개 중 가장 큰 수를 구하시오 
		a: 30, b: 60, c: 20
		<결과>
		가장 큰수: 60
		*/
		int a2 = 1000;
		int b2 = 900;
		int c2 = 780;
	
		
		if ( a2 > b2) {
			if (a2 > c2) {
				System.out.println("가장 큰 수 :" + a2);
			} else {
				System.out.println("가장 큰 수 :" + c2);
		    }	
		}else {
			if (b2 > c2) {
				System.out.println("가장 큰 수:" + b2);
			} else {
				System.out.println("가장 큰 수:" + c2);
			}
		}
		/*
		 * (실습) 숫자 5개 중 가장 큰 수
		 * a, b, c, d, e*/
		int a = -50;
		int b = -40;
		int c = -100;
		int d = -20;
		int e = -10;
//		int max = 0; //가장 큰 값 
		int max = Integer.MIN_VALUE; //다른 비교할 변수들이 음수일 때.
		
		if (a > max) {
			max = a;
		} 
		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		if (d > max) {
			max = d;
		}
		if (e > max) {
			max = c;
		}
		System.out.println("가장 큰 수:" + max);
	
	}
}

/*
 * int max = Integer.MIN_VALUE; 
 * 활용법 숙지.
 * */
 
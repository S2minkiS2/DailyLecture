
public class Ex05_max_number {

	public static void main(String[] args) {
		/* 숫자 3개 중 가장 큰 수를 구하시오.
		a : 30, b : 60, c : 20
		<결과>
		가장 큰 수 : 60
		 ----------------------*/
//		int a = 60;
//		int b = 60;
//		int c = 80;
//		
//		if (a > b) { // a가 큰 경우
//			if (a > c) {
//				System.out.println("가장 큰 수 : " + a);
//			} else {
//				System.out.println("가장 큰 수 : " + c);
//			}
//		} else { //b가 큰 경우
//			if (b > c) {
//				System.out.println("가장 큰 수 " + b);
//			} else { 
//				System.out.println("가장 큰 수 :" + c);
//			}
//		}
//		
//	
//		a와 b를 비교 
//		둘 중 큰 수와 c를 비교
//		가장 큰 수 : 
		
//		int bigger = 0;
//		int max = 0;
//		
//		if (a > b) {
//			bigger = a ;
//		} else if ( b > a) {
//			bigger = b; 
//		}	
//		if (bigger > c) {
//			max = bigger;
//	  	} else {
//			max = c;
//		}
//		
//		System.out.println("최대 값은 " + max);
		
//		----------------------------------------
		
		/* 숫자 5개 중 가장 큰 수를 구하시오.
		a : 30, b : 60, c : 20 , d:15, e:70
		<결과>
		가장 큰 수 : 70
		 ----------------------*/
		// ab와 cd를 비교 후 큰 수 끼리 비교
		// 그 중 큰 수와 e를 비교
		
		int max2 = 0;
		int bigger1 = 0;
		int bigger2 = 0;
		int a = 30; int b = 60; int c = 20; int d = 15; int e = 70;
		
		if (a > b) {
			bigger1 = a;
		} else if (b > a) {
			bigger1 = b;
		if (c > d) {
			bigger2 = c;
		} else if (d > c) {
			bigger2 = d;
		}
		if (bigger1 > e) {
			max2 = bigger1;
		} else if (bigger2 > e) {
			max2 = bigger2;
		} else {
			max2 = e;
		}
		
		System.out.println("최대값 : " + max2);
		}
		
		
		
		
		
		
		
		
		
//		int max = Integer.MAX_VALUE; //가장 작은 정수 : 0으로 초기화 시 음수일 때 문제 생길 수 있음
//		int a = 60;
//		int b = 60;
//		int c = 80;
//		
//		if (a > max) {
//			max = a;
//		} 
//		if (b > max) {
//			max = b;
//		}
//		if (c > max) {
//			max = c;
//		} 
//		System.out.println("가장큰수(max) : " + max);
//		
		
		
		
		
		}	
		

	}



	

	



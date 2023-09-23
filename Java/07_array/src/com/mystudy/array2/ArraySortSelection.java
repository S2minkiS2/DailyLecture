package com.mystudy.array2;

public class ArraySortSelection {
	
	public static void main(String[] args) {
		// 배열 숫자 데이터 정렬<sort) - 오름차순(ASC), 내림차순(DESC)
		int[] num = {30, 20, 50, 40, 10};
		System.out.println("num : " + num);
		
//		for (int i = 0; i < num.length; i++) {
//			System.out.print(num[i] + " ");
//		}
//		System.out.println();
		
//		1. 기준값(첫번째)이 크면 서로 교환해라 - 첫번째 자리에 작은 값이 오도록
//		2. 기준값(두번째)이 크면 서로 교환해라 - 두번째 자리에 작은 값 => 자신 이후자리부터 교환
//		3. 기준값이 작으면 서로 교환해라 - > 자신 이후 자리 교환
//		4. 기준값이 작으면 서로 교환해라 - > 자신 이후 자리 교환
		
		//데이터 확인
		System.out.println("원본데이터(num : )" );
		printData(num);
		
		
		System.out.println();
		System.out.println("=====정렬 시작=====");
//		//첫번째값(인덱스0) vs 두번째값(인덱스1)
//		if (num[0] > num[1]) {
//			int temp = num[0];
//			num[0] = num[1];
//			num[1] = temp;
//		}
//		printData(num);
//		System.out.println();
//	
//		//첫번째값(기준인덱스0) vs 세번째값(인덱스2)
//		if (num[0] > num[2]) {
//			int temp = num[0];
//			num[0] = num[2];
//			num[2] = temp;
//		}
//		printData(num);
//		System.out.println();
//		
//		//첫번째값(기준인덱스0) vs 네번째값(인덱스3)
//		if (num[0] > num[3]) {
//			int temp = num[0];
//			num[0] = num[3];
//			num[3] = temp;
//		}
//			printData(num);
//			System.out.println();
//			
//			//첫번째값(기준인덱스0) vs 다섯번째값(인덱스4)
//			if (num[0] > num[4]) {
//				int temp = num[0];
//				num[0] = num[4];
//				num[4] = temp;
//			}
//			printData(num);
//			System.out.println();
//			========반복문 처리하기=============
//			System.out.println("--- 반복문으로 변경 적용 ===");
//			System.out.println("배열데이터(num : )" );
//			printData(num);
//			System.out.println("---기준 인덱스 0---");	
//			//첫번째 값 기준 비교작업 ( 인덱스 0 기준 )
//			for (int i = 1; i < num.length; i++) {
//				if (num[0] > num[i]) {
//					int temp = num[0];
//					num[0] = num[i];
//					num[i] = temp;
//				}
//				printData(num);
//			}
//
//			System.out.println("배열데이터(num) : " );
//			printData(num);
//			//두번째 값 기준 비교작업 ( 인덱스 1 기준 )
//			System.out.println("---기준 인덱스 1---");	
//			for (int i = 2; i < num.length; i++) {
//				if (num[1] > num[i]) {
//					int temp = num[1];
//					num[1] = num[i];
//					num[i] = temp;
//				}
//				printData(num);
//			}
//				
//			System.out.println("배열데이터(num) : " );
//			printData(num);
//			//세번째 값 기준 비교작업 ( 인덱스 2 기준 )
//			System.out.println("---기준 인덱스 2---");	
//			for (int i = 3; i < num.length; i++) {
//				if (num[2] > num[i]) {
//					int temp = num[2];
//					num[2] = num[i];
//					num[i] = temp;
//				}
//				printData(num);
//			}
//				
//			System.out.println("배열데이터(num) : " );
//			printData(num);
//			//네번째 값 기준 비교작업 ( 인덱스 3 기준 )
//			System.out.println("---기준 인덱스 3---");	
//			for (int i = 4; i < num.length; i++) {
//				if (num[3] > num[i]) {
//					int temp = num[3];
//					num[3] = num[i];
//					num[i] = temp;
//				}
//				printData(num);
//			}
			
		System.out.println(" ===== 이중(중첩) for문으로 작성 =====");
			
		
		for (int gijun = 0; gijun < num.length - 1; gijun++) {
			
			
			for (int i = gijun + 1; i < num.length; i++) {
				if (num[gijun] > num[i]) { //비교 후 교환
					int temp = num[gijun];
					num[gijun] = num[i];
					num[i] = temp;
				}
//				printData(num);
			}
		}
		System.out.println("정렬 후 배열데이터 : " );
		printData(num);
		
			
		}
	
	
	
	static void printData(int[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		
		
	}

}

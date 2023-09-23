package com.mystudy.array;

import java.util.Arrays;

public class Ex05_array_lotto {

	public static void main(String[] args) {
		// 로또 번호 생성기
		
		//1. int 타입의 숫자 45개를 저장할 수 있는 배열 선언(balls)
		//2. 초기화 : 1~45 까지의 숫자(번호)를 입력
		//3. 충분히 많이 섞고 - Math.random() 사용
		//   3-1. 0~44 랜덤한 숫자를 만든다(Math.random() 사용)
		//   3-2. 첫번째 데이터와 랜덤숫자 인덱스 번호와 교환
		//   3-3. 위의 3-1, 3-2 작업을 계속 반복(충분히 많이)
		//4. 6개 번호를 추출(앞에서 부터 6개 사용)
		
		//-------------------------------------
		//랜덤한 값(숫자) 만들기 - Math.random() : 0 <= double < 1
		// (int)(Math.random() * 45) : 0~44 까지의 랜덤한 값 생성
		//-----------------------------
		
		//1. 
		int[] balls = new int[45];
		System.out.println(Arrays.toString(balls));
		
		//2. 
		System.out.println("2.-------설정된 초기값 확인---------");
		for (int i = 0; i < 45; i++) { //balls.length로 사용하기
			balls[i] = i+1;
			System.out.print(balls[i] + " ");
		} // 설정된 초기값 확인
		System.out.println();
		
		System.out.println("3-1.----------------------");
		//3-1.
		
		int random = (int)(Math.random() * 45);
//		random = 5;
		System.out.println("랜덤값 : " + random);
		
		
		//3-2.
		System.out.println("3-2.----------------------");
		int idx = (int)(Math.random() * 45) - 1;
//		int tmp = balls[0];
//		balls[0] = idx;
//		idx = balls[0];
		
		//1번째 교환
		int tmp = balls[0];
		balls[0] = balls[random];
		balls[random] = tmp;
		System.out.println("맞교환테스트 = " + Arrays.toString(balls));
		
		//2번째교환
		random = (int)(Math.random() * 45);
		System.out.println("랜덤값 : " + random);
		tmp = balls[0];
		balls[0] = balls[random];
		balls[random] = tmp;
		System.out.println("맞교환테스트 = " + Arrays.toString(balls));
		
		//랜덤 값의 인덱스번호
//		(int)(Math.random() * 45)	
//		3-3.
//		for (int i = 0; i <12345; i++) {
//			random = (int)(Math.random() * 45);
//			tmp = balls[0];
//			balls[0] = random; //random 값이 계속 새로 저장되니까
//			random = tmp;
//		}
//		System.out.println(tmp);
		
		for (int i = 0; i <4567; i++) {
			random = (int)(Math.random() * 45);
			tmp = balls[0];
			balls[0] = balls[random];
			balls[random] = tmp;
		}
		System.out.println("출력테스트 " + Arrays.toString(balls));
		
				
		//4.
//		System.out.println("4.------------------------");
//		for (int i = 0; i < 6; i++ ) {
//			for (int ij = 0; ij < 12345; ij++) {
//				idx = (int)(Math.random() * 45)-1;
//				tmp = idx;
//				idx = balls[0];
//				balls[0] = tmp;
//			}
//			System.out.println("로또번호 : " + balls[i]);
//		}
		
		for (int i = 0; i < 6; i++ ) {
			System.out.println("로또번호 : " + balls[i]);		
			}
		
		//=======================
		System.out.println(" ---- 당첨번호 별도 저장 ====");
		int[] lottoNums = new int[6];
		for (int i = 0; i < 6; i++ ) {
			lottoNums[i] = balls[i]; 	
			}
		System.out.println("balls : " + Arrays.toString(balls));
		System.out.println("lottoNums : " + Arrays.toString(lottoNums));
		
		//로또번호 오름차순 정렬 => Arrays.sort() 정렬 처리
		Arrays.sort(lottoNums);
		System.out.println("Sort lottoNums : " + Arrays.toString(lottoNums));
		

	}

}

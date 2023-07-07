package com.mystudy.array;

public class Ex05_array_lotto {

	public static void main(String[] args) {
		// 로또 번호 생성기
		// 1. int타입의 숫자 45개를 저장할 수 있는 배열을 선언하자 == balls
		// 2. 초기화 : 1~45 까지의 숫자를 차곡차곡 넣어(번호)
		// 3. 충분히 많이 섞고
		// 4. 6개 번호를 추출 (앞에서 부터 6개 사용 : index[0]~[5])
		//--------------------------------------------------------
		
		//랜덤으로 뽑은 숫자(인덱스)를 맨 처음 숫자와 맞교환 한다. 많이 반복하면 충분히 많이 섞인다
		
		//랜덤한 값(숫자) 만들기 - Math.random() : 0 <= double < 1
		// (int)(Math.random()*45) : 0부터 44까지의 랜덤한 값 생성
		//--------------------------------------------------------
		
		
		
		//1. 배열선언
		int[] balls = new int[45]; 
		
		//2. 초기화 작업
		for (int i = 0; i < 45; i++) {
			balls[i] = i + 1;
		}
		
		//3. 충분히 많이 섞기
		int temp;
		int n;
		for (int i = 1; i <= 100; i++) {
			n = (int)(Math.random()*45);
			temp = balls[0];
			balls[0] = balls[n];
			balls[(int)(Math.random()*45)] = temp;
		}
		//temp 사용 기억해라
		
		
		//4. 맨앞 6개 번호 추출
		for (int i = 0; i < 6; i++) {
			System.out.println((i+1) + "번째 당첨번호: " + balls[i]);
		}
		
	}

}

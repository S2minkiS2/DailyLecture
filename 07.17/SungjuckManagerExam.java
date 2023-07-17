package com.mystudy.bean;

public class SungjuckManagerExam {

	public static void main(String[] args) {
		// 2차원 배열을 사용한 성적 처리
		// 국어, 영어, 수학, 점수 3개를 저장한 2차원 배열(sungjuk)을 만들고
		// 3명의 성적을 입력하고 개인별 총점과 평균을 계산 후 화면에 출력해라
		// ------------------------------------------------------
		/*
		 * 국어 \t 영어 \t 수학 \t 총점 \t 평균 100 90 60 250 ??? 90 80 40 210 70 60 100 230
		 */

		// [0][1]~ [0][2] = 국 영 수 점수저장.
		// 타입[][] 변수명 = new 타입[크기값][크기값];
		// 타입[][] 변수명 = {{..}, {..}, {..}, {..}, {..}};

		int[][] sungjuk = { { 80, 70, 60 }, { 85, 90, 60 }, { 80, 100, 40 } };
		String[] names = { "김유신", "카리나", "아이유" };
		int[] tots = new int[sungjuk.length];
		double[] avgs = new double[sungjuk.length];

		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println("-----------------------");
		// 1번째 사람 데이터 처리
		for (int i = 0; i < sungjuk.length; i++) {
			int kor = sungjuk[i][0];
			int eng = sungjuk[i][1];
			int math = sungjuk[i][2];

			// 계산처리
			int tot = kor + eng + math;

			double avg = tot * 100 / 3 / 100.0;
			// 출력
			System.out.println(kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + avg);
		}
		
		System.out.println("=== 김유신 화면 출력 ===");

	}
}
		
		
	

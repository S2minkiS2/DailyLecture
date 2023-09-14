package com.mystudy.scanner2_sungjuk;

import java.util.Scanner;

public class Scanner_Exam2 {

	public static void main(String[] args) {
		/* (실습) Scanner 사용 성적처리
		입력 : 성명, 국어, 영어, 수학 점수를 입력받아
		처리 : 총점, 평균 계산한다
		출력 : 결과를 화면 출력
		===(처리결과 출력예시)===
		성명 : 홍길동
		국어 : 100
		영어 : 90
		수학 : 81
		------------
		총점 : 271
		평균 : 90.33
		================= */
		
		
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("성명, 국어, 영어, 수학 순차입력 : " );
//		String name = scan.next();
//		int kor = scan.nextInt();
//		int eng = scan.nextInt();
//		int math = scan.nextInt();
//		System.out.println("성명 : " + name);
//		System.out.println("국어 : " + kor + "\n" + "영어 : " + eng + "\n" 
//				+ "수학 : " + math);
//		
//		System.out.println("--------------");
//		int sum = kor + eng + math;
//		System.out.println("총점 : " + sum);
//		double avg = (sum / 3 ) * 100 / 100 ;
//		System.out.println("평균 : " + avg);
//		System.out.println("===============");
//		
//		=======================================

		Scanner scan = new Scanner(System.in);
		//반복처리 하고싶으면 전체 반복처리시키기
		//while(true) 하면 무한반복
		while(true) {
		
		
		System.out.println("성명을 입력하시오 >> ");
		String names = scan.nextLine(); //문자열 값 읽기
		System.out.println("국어점수를 입력하시오 >> ");
		int kors = scan.nextInt();
		System.out.println("영어점수를 입력하시오 >> ");
		int engs = scan.nextInt();
		scan.nextLine();
		System.out.println("수학점수를 입력하시오 >> ");
//		int maths = scan.nextInt();
		int maths = Integer.parseInt(scan.nextLine());
		
		int tot = kors + engs + maths;
		double avg = tot * 100 / 3 / 100.0;
		avg = Math.round(tot * 100 / 3.0) / 100.0;

		System.out.println("성명 : " + names);
		System.out.println("국어 : " + kors);
		System.out.println("영어 : " + engs);
		System.out.println("수학 : " + maths);
		System.out.println("-----------");
		System.out.println("총점 : " + tot);
		System.out.println("평균 : " + avg);
		System.out.println();
		
		System.out.print(">> 끝내려면 n을 누르시오. ");
		String answer = scan.nextLine();
		if (answer.equalsIgnoreCase("n")) {
			System.out.println(":: 작업을 중단합니다.");
			break;
		}
		}
	
	}
}

package com.mystudy.scanner2_chengji;

import java.util.Scanner;

public class Scanner_Exam2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("------ 성적 입력 -------");
			System.out.print("성명 : ");
			String name = scan.nextLine();
			System.out.print("국어 : ");
			int kor = scan.nextInt();
			System.out.print("영어 : ");
			int eng = scan.nextInt();
			System.out.print("수학 : ");
			int math = scan.nextInt();

			System.out.println("---- 성적 처리 결과 ----");
			System.out.println("국어 점수 : " + kor);
			System.out.println("영어 점수 : " + eng);
			System.out.println("수학 점수 : " + math);
			int total = kor + eng + math;
			System.out.print("총점 : " + total + "\n");
			double avg = Math.round(total * 100 / 3.0) / 100.0;
			System.out.print("평균 : " + avg);
			scan.nextLine();
			System.out.println("\n============");

			System.out.print(">> 계속 입력하시겠습니까? (yes/no) : ");
			String onOff = scan.nextLine();

			if (onOff.equalsIgnoreCase("no")) {
				System.out.println("성적처리 끝");
				break;
			} else if (onOff.equalsIgnoreCase("yes")) {
				System.out.println("이어서 작업합니다");
				continue;
			}

		}
	}

}

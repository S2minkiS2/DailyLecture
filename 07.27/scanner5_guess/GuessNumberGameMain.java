package com.mystudy.scanner5_guess;

import java.util.Scanner;

public class GuessNumberGameMain {
	static int chanceNum;
	static int myNum;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		GuessNumberGameVO test = new GuessNumberGameVO();

		while (true) {
			System.out.println("1부터 100까지 스무고개! 게임!");
			System.out.println("--------------------------------");
			System.out.print("첫번째 기회를 드립니다. 당신의 선택은? : ");
			myNum = scan.nextInt();
			test.upDown();

			System.out.print("두번째 기회를 드립니다. 당신의 선택은? : ");
			myNum = scan.nextInt();
			test.upDown();

			System.out.print("세번째 기회를 드립니다. 당신의 선택은? : ");
			myNum = scan.nextInt();
			test.upDown();

			System.out.print("네번째 기회를 드립니다. 당신의 선택은? : ");
			myNum = scan.nextInt();
			test.upDown();

			System.out.print("너 기회 한번남았는데, 당신의 선택은? : "); // 5번째
			myNum = scan.nextInt();
			test.upDownLast();

			chanceNum = 0;
			System.out.println("=================================");

			System.out.println("0.종료\t1.시작");
			System.out.print(">> 계속 하시겠습니까? : ");
			int reStart = scan.nextInt();

			if (reStart != 1) {
				System.out.println("감사합니다. 다음에 또 오세요");
				break;
			} else {
				System.out.println("재시작 합니다.");
				System.out.println("=================================");
				continue;
			}

		}
	}
}

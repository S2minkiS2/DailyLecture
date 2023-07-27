package com.mystudy.scanner4_scissors;

import java.util.Scanner;
import java.util.Set;

public class Scanner_Exam4_scissors {
	public final static String sc = "가위";
	public final static String ro = "바위";
	public final static String pa = "보";
	public static String computer;
	public static int myHand;
	public static int comWinCount;
	public static int myWinCount;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println(":: 가위,바위,보 게임 시작~");
		while (true) {
			// 0
			int comSelect = (int) (Math.random() * 3) + 1; // 숫자를 랜덤생성. +1을 한 이유는? 1~3이 나오게 하기 위해서.

			switch (comSelect) {
			case 1:
				computer = "가위";
				break;

			case 2:
				computer = "바위";
				break;

			case 3:
				computer = "보";
				break;

			default:
				System.out.println("오류 발생:: 게임을 종료합니다.");
			}

			// 1
			System.out.println("1.가위\t2.바위\t3.보\t0.종료");

			// 2
			System.out.print("번호를 선택해 주세요 : ");
			myHand = scan.nextInt();
			if (myHand == 0) {
				System.out.println("게임을 종료합니다.");
				winCount();
				return;
			} else if (myHand > 3) {
				System.out.println("잘못된 입력입니다. Game Over");
				return;
			}
			scan.nextLine();
			System.out.println("=================================");

			// 3

			System.out.println("컴퓨터 : " + (comSelect == 1 ? "가위" : (comSelect == 2 ? "바위" : "보")));
			System.out.println("당신 : " + (myHand == 1 ? "가위" : (myHand == 2 ? "바위" : "보")));

			if (myHand == 1 && comSelect == 1) {
				System.out.println("비겻습니다");
			} else if (myHand == 1 && comSelect == 2) {
				System.out.println("컴퓨터가 이겼습니다람쥐!"); // 언제적거야!!!!!!
				comWinCount++;
			} else if (myHand == 1 && comSelect == 3) {
				System.out.println("네가 이겼네?");
				myWinCount++;
			}

			if (myHand == 2 && comSelect == 2) {
				System.out.println("비겻습니다");
			} else if (myHand == 2 && comSelect == 3) {
				System.out.println("컴퓨터가 이겼습니다람쥐!");
				comWinCount++;
			} else if (myHand == 2 && comSelect == 1) {
				System.out.println("네가 이겼네?");
				myWinCount++;
			}
			
			
			if (myHand == 3 && comSelect == 3) {
				System.out.println("비겼습니다");
			} else if (myHand == 3 && comSelect == 1) {
				System.out.println("컴퓨터가 이겼습니다람쥐!");
				comWinCount++;
			} else if (myHand == 3 && comSelect == 2) {
				System.out.println("네가 이겼네?");
				myWinCount++;
			}

			System.out.println("=================================");

			// 4
			System.out.println("0.종료\t1.시작");
			System.out.print(">> 계속 하시겠습니까? : ");
			int reStart = scan.nextInt();

			if (reStart != 1) {
				System.out.println("감사합니다. 다음에 또 오세요");
				winCount();
				break;
			} else if (reStart == 1) {
				System.out.println("재시작 합니다.");
				winCount();
				System.out.println("=================================");
				continue;
			}

		}

	}

	// 5 컴퓨터와 나의 총 이긴 횟수 메서드
	public static void winCount() {
		System.out.println("컴퓨터가 이긴 횟수 : " + comWinCount);
		System.out.println("당신이 이긴 횟수 : " + myWinCount);
	}

}

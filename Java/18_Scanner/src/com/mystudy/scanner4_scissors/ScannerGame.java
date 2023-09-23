package com.mystudy.scanner4_scissors;

import java.util.Scanner;

/* Scanner를 이용한 가위, 바위 , 보 게임 *******
// scissors, rock, paper
// draw : 무승부, person_win, computer_win
컴퓨터와 함께하는 가위,바위,보 게임
0. 컴퓨터가 가위(1),바위(2),보(3) 선택(Math.random())
1. 1.가위   2.바위   3.보   0.종료   선택 메뉴 출력 
2. 선택값 입력
3. 결과 비교 후 승자, 패자 결정
(반복) 게임 반복 진행 - 0 선택시 종료 처리
=============================== */
public class ScannerGame { 
	private Scanner scan = new Scanner(System.in);
	private static final String PAPER = "보";
	private static final String MENU = "1.가위   2.바위   3. 보   0.종료";
	private static final String COMPUTER_WIN = "내가 졌습니다. 컴퓨터가 이겼네~~~";

	public void gameStart() {
		System.out.println("::: 가위,바위,보 게임 시작~~~");
		while (true) {
			boolean isContinue  = isContinueGame();
			if (! isContinue) break;
		}
		System.out.println("::: 가위,바위,보 게임 끝~~~");
	}	
	
	private boolean isContinueGame() {
		boolean isContinue = true; //게임 계속
		
		//1. 컴퓨터가 선택
		int comSelect = (int)(Math.random() * 3 + 1);
		//comSelect = 3; //테스트용

		System.out.println("컴퓨터는 가위,바위,보 중에 하나를 선택했습니다");
		
		//2. 메뉴표시
		System.out.println(MENU);
		
		//3-1. 사람이 선택
		int select = selectPerson();
		
		if (select == 0) {
			return false;
		}
		
		//3-2. 선택숫자 ---> 가위, 바위, 보 문자열 변경
		String strComputer = changeNumberToString(comSelect);
		String strPerson = changeNumberToString(select);
		
		//4. 결과 비교 후 승자, 패자 결정
		String result = compareResult(strComputer, strPerson);
		
		//5. 승패 결과 출력
		System.out.println("--- 판정 결과 ---");
		System.out.println(">>> " + result + " - 컴퓨터: " + strComputer);
		System.out.println();
		
		return isContinue;
	}

	private int selectPerson() {
		int select = -1;
		while (true) {
			try {
				System.out.print(">> 당신의 선택은(1~3)? ");
				select = Integer.parseInt(scan.nextLine());
				if (select >= 0 && select <=3 ) {
					break;
				} else {
					System.out.println("잘못된 선택 0~3중에 선택하세요!");
				}
				break; //ㄴ 숫자로 형변환이 되어야함
			} catch (Exception e) {
				System.out.println("::: 잘못된 선택 0~3 중에 선택하세요!!!");
			}
		}
		return select;
	}
	
	private String compareResult(String strComputer, String strPerson) {
		String result = "판정안됨";
		if (strComputer.equals(strPerson)) {
			result = "비겼다";
		}
		
		if (strComputer.equals("가위")) {
			if (strPerson.equals("바위")) {
				result = "사람 승";
			}
			if (strPerson.equals(PAPER)) {
				result = COMPUTER_WIN;
			}
		}
		
		if (strComputer.equals("바위")) {
			if (strPerson.equals("가위")) {
				result = COMPUTER_WIN;
			}
			if (strPerson.equals(PAPER)) {
				result = "사람 승";
			}
		}
		
		if (strComputer.equals(PAPER)) {
			if (strPerson.equals("가위")) {
				result = "사람 승";
			}
			if (strPerson.equals("바위")) {
				result = COMPUTER_WIN;
			}
		}
		return result;
	}

	private String changeNumberToString(int select) {
		String str = "변환안됨";
		switch (select) {
			case 1 : str = "가위"; break;
			case 2 : str = "바위"; break;
			case 3 : str = PAPER; break;
		}
		return str;
	}
	


}



		


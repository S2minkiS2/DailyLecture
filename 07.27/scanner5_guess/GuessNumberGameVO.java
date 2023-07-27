package com.mystudy.scanner5_guess;

import java.util.Scanner;

/* 숫자 추측 게임
컴퓨터가 1~100 사이의 숫자를 정하면 사람이 맞추는 게임
선택 기회 5회
---------------------
Math.random() : 0 <= random값 < 1 범위의 실수값 
컴숫자 : 70 인 경우 
  사람이 선택한 숫자(80)가 크면 : 생각한 숫자보다 작다는 메시지 출력
  사람이 선택한 숫자(50)가 작으면 : 생각한 숫자보다 크다는 메시지 출력
5번 이내에 맞추면 : 성공!!! n번 만에 맞췄습니다.(화면출력)
5번을 넘기면 : 실패~~ 내가 생각한 숫자는 70입니다.(화면출력)
-----
다시 도전하시겠습니까?(y,n) 
---------------------------
*/

public class GuessNumberGameVO {
	 ///필드
	private int comNum;
    private int myNum;
    private int chanceNum;

	 //생성자
	public GuessNumberGameVO() {
        comNum = (int) (Math.random() * 99) + 1;
        myNum = 0;
        chanceNum = 0;
	}
	
	// Getter 메서드
    public int getComNum() {
        return comNum;
    }

    public int getMyNum() {
        return myNum;
    }

    public int getChanceNum() {
        return chanceNum;
    }

	 //메서드
	public void upDown() {
		if (myNum > comNum) {
			System.out.println("더 낮은 숫자를 불러보세요.");
			chanceNum++;
		} else if (myNum < comNum) {
			System.out.println("더 높은 숫자를 불러보세요.");
			chanceNum++;
		} else {
			System.out.println("정답입니다!");
			System.out.println(chanceNum + "번 만에 정답을 맞췄습니다.");
		}

	}
	public void upDownLast() {
		if (myNum == comNum) {
			System.out.println("정답입니다!");
			chanceNum++;
			System.out.println(chanceNum + "번 만에 정답을 맞췄습니다.");
		} else {
			System.out.println("기회를 모두 소진하였습니다. 게임을 종료합니다.");
			System.out.println("제가 생각했던 숫자는 " + comNum + "이었습니다.");
		}

	

//	public void gameStart() {
//		System.out.println("1부터 100까지 스무고개! 게임!~");
//		while (true) {
//			System.out.println("--------------------------------");
//			System.out.print("첫번째 기회를 드립니다. 당신의 선택은? : ");
//			int myNum = scan.nextInt();
//
//			if (myNum > comNum) {
//				System.out.println("더 낮은 숫자를 불러보세요.");
//				chanceNum++;
//			} else if (myNum < comNum) {
//				System.out.println("더 높은 숫자를 불러보세요.");
//				chanceNum++;
//			} else {
//				System.out.println("정답입니다!");
//				System.out.println(chanceNum + "번 만에 정답을 맞췄습니다.");
//			}
//
//			System.out.print("두번째 기회를 드립니다. 당신의 선택은? : ");
//			myNum = scan.nextInt();
//			if (myNum > comNum) {
//				System.out.println("더 낮은 숫자를 불러보세요.");
//				chanceNum++;
//			} else if (myNum < comNum) {
//				System.out.println("더 높은 숫자를 불러보세요.");
//				chanceNum++;
//			} else {
//				System.out.println("정답입니다!");
//				System.out.println(chanceNum + "번 만에 정답을 맞췄습니다.");
//			}
//			System.out.print("세번째 기회를 드립니다. 당신의 선택은? : ");
//			myNum = scan.nextInt();
//			if (myNum > comNum) {
//				System.out.println("더 낮은 숫자를 불러보세요.");
//				chanceNum++;
//			} else if (myNum < comNum) {
//				System.out.println("더 높은 숫자를 불러보세요.");
//				chanceNum++;
//			} else {
//				System.out.println("정답입니다!");
//				System.out.println(chanceNum + "번 만에 정답을 맞췄습니다.");
//			}
//			System.out.print("네번째 기회를 드립니다. 당신의 선택은? : ");
//			myNum = scan.nextInt();
//			if (myNum > comNum) {
//				System.out.println("더 낮은 숫자를 불러보세요.");
//				chanceNum++;
//			} else if (myNum < comNum) {
//				System.out.println("더 높은 숫자를 불러보세요.");
//				chanceNum++;
//			} else {
//				System.out.println("정답입니다!");
//				System.out.println(chanceNum + "번 만에 정답을 맞췄습니다.");
//			}
//			System.out.print("너 기회 한번남았는데, 당신의 선택은? : ");  //5번째
//			myNum = scan.nextInt();
//			if (myNum == comNum) {
//				System.out.println("정답입니다!");
//				chanceNum++;
//				System.out.println(chanceNum + "번 만에 정답을 맞췄습니다.");
//			} else {
//				System.out.println("기회를 모두 소진하였습니다. 게임을 종료합니다.");
//				System.out.println("제가 생각했던 숫자는 " + comNum + "이었습니다.");
//			}
//
//			chanceNum = 0;
//			System.out.println("=================================");
//
//			System.out.println("0.종료\t1.시작");
//			System.out.print(">> 계속 하시겠습니까? : ");
////			int reStart = scan.nextInt();
//
//			if (reStart != 1) {
//				System.out.println("감사합니다. 다음에 또 오세요");
//				return;
//			} else {
//				System.out.println("재시작 합니다.");
//				System.out.println("=================================");
//				continue;
//			}

//		}  //while 끝

	}
}
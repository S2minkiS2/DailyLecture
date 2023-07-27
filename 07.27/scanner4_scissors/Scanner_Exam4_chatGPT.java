package com.mystudy.scanner4_scissors;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Scanner_Exam4_chatGPT {
	
    public static final String SCISSORS = "가위";
    public static final String ROCK = "바위";
    public static final String PAPER = "보";

    public static Map<Integer, String> computerChoices = new HashMap<>();
    public static int comWinCount;
    public static int myWinCount;

    public static void main(String[] args) {
        initComputerChoices();

        Scanner scan = new Scanner(System.in);
        System.out.println(":: 가위, 바위, 보 게임 시작~");

        while (true) {
            int comSelect = (int) (Math.random() * 3) + 1;

            String computer = computerChoices.get(comSelect);

            if (computer == null) {
                System.out.println("오류 발생:: 게임을 종료합니다.");
                winCount();
                return;
            }

            System.out.println("1.가위\t2.바위\t3.보\t0.종료");
            System.out.print("번호를 선택해 주세요 : ");
            int myHand = scan.nextInt();

            if (myHand == 0) {
                System.out.println("게임을 종료합니다.");
                winCount();
                return;
            } else if (myHand < 1 || myHand > 3) {
                System.out.println("잘못된 입력입니다. Game Over");
                return;
            }

            scan.nextLine(); // Consume the newline character left by scan.nextInt()

            System.out.println("=================================");
            System.out.println("컴퓨터 : " + computer);
            System.out.println("당신 : " + (myHand == 1 ? SCISSORS : (myHand == 2 ? ROCK : PAPER)));

            if (myHand == comSelect) {
                System.out.println("비겼습니다");
            } else if ((myHand == 1 && comSelect == 2) || (myHand == 2 && comSelect == 3) || (myHand == 3 && comSelect == 1)) {
                System.out.println("컴퓨터가 이겼습니다람쥐!");
                comWinCount++;
            } else {
                System.out.println("네가 이겼네?");
                myWinCount++;
            }

            System.out.println("=================================");
            System.out.println("0.종료\t1.시작");
            System.out.print(">> 계속 하시겠습니까? : ");
            int reStart = scan.nextInt();

            if (reStart != 1) {
                System.out.println("감사합니다. 다음에 또 오세요");
                winCount();
                break;
            } else {
                System.out.println("재시작 합니다.");
                winCount();
                System.out.println("=================================");
            }
        }
    }

    public static void initComputerChoices() {
        computerChoices.put(1, SCISSORS);
        computerChoices.put(2, ROCK);
        computerChoices.put(3, PAPER);
    }

    public static void winCount() {
        System.out.println("컴퓨터가 이긴 횟수 : " + comWinCount);
        System.out.println("당신이 이긴 횟수 : " + myWinCount);
    }
}

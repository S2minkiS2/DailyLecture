package com.mystudy.scanner5_guess;

import java.util.Scanner;

public class GptTest {

	public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        GptVO game = new GptVO();

        while (true) {
            System.out.println("1부터 100까지 스무고개! 게임!");
            while (game.getChanceNum() < 5) {
                System.out.println("--------------------------------");
                System.out.print("기회를 드립니다. 당신의 선택은? : ");
                int myNum = scan.nextInt();
                if (game.guessMyNum(myNum)) {
                    System.out.println(game.getChanceNum() + "번 만에 정답을 맞췄습니다.");
                    break;
                }
            }

            if (game.getChanceNum() == 5) {
                System.out.println("기회를 모두 소진하였습니다. 게임을 종료합니다.");
                System.out.println("제가 생각했던 숫자는 " + game.getComNum() + "이었습니다.");
            }

            game = new GptVO(); // 새로운 게임을 위해 초기화
            System.out.println("=================================");
            System.out.println("0.종료\t1.재시작");
            System.out.print(">> 계속 하시겠습니까? : ");
            int reStart = scan.nextInt();

            if (reStart != 1) {
                System.out.println("감사합니다. 다음에 또 오세요");
                break;
            } else {
                System.out.println("재시작 합니다.");
                System.out.println("=================================");
            }
        }
    
	}

}



package com.mystudy.scanner5_guess;

import java.util.Scanner;

public class GuessNumberGame {
	Scanner scan = new Scanner(System.in);
	
		
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
	public void startGame() {
		//여기서만 쓸 거니까 private 붙여줌
		
	//컴퓨터가 정한 숫자
	int cpu = (int)(Math.random() * 100) + 1;
//	System.out.println("컴퓨터가 정한 숫자" + cpu);
	
	//입력받기
	System.out.println("0~100 사이의 숫자를 맞춰보세요");
	
	
	int min = 1;
	int max = 100;
	int i = 0;
	while (i < 5) {
		int per = 0;
		for (i = 0; i < 5; i++) {
			System.out.println("정답을 입력해주세요 >>");
			per = per();
			
//			int selectNumber = Integer.parseInt(scan.nextLine());
			//nextLine은 string값으로 불러오므로 integer.parseInt로 인트타입 변
			per = scan.nextInt();
			if (cpu == per) {
				System.out.println("정답입니다!" + (i + 1) + "번 만에 맞췄습니다!"); 
				break;
			} else if (cpu > per) {
				System.out.println("정답보다 입력한 숫자가 작습니다.");
				min = per + 1; //
			} else if (cpu < per) {
				System.out.println("정답보다 입력한 숫자가 큽니다.");
				max = per - 1; //
			}
		}
		System.out.println("다음 선택값 범위 : " + min + "~" + max);
		
		if (cpu != per && i >= 5) {
			System.out.println("실패! 내가 생각한 숫자는 " + cpu + "입니다.");
		}	
	break;
	}
	
		
	System.out.println("다시 도전하시겠습니까? y/n");
	String yesOrNo = scan.next();
	if (yesOrNo.equalsIgnoreCase("y")) {
		startGame();
	} else if (!yesOrNo.equals("n")) {
		System.out.println("종료합니다.");
	}

}
	// per 메서드 밖으로 뻄
	int per() {
		int result = -1;
		while (true) {
			try {
				result = scan.nextInt();
				break;
			} catch (NumberFormatException e) {
				System.out.println("[주의] 숫자값을 입력하세요");
			}
		}
		return result;
	}
}

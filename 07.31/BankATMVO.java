package com.mystudy.scanner6_bank;

import java.util.InputMismatchException;
import java.util.Scanner;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

// 은행ATM
// 1.입금 2.출금 3.통장확인  0.종료 
public class BankATMVO {
	private int money; // 통장계좌 금액
	Scanner scan = new Scanner(System.in);

	public void startBank() {
		System.out.println("ATM시작");
		
		int min = 1;
		int max = 3;
		int end = 0;
		
		while (true) {
//			int selectNo = selectNo(end, min, max);
			showMenu();

			int selectNo = Integer.parseInt(scan.nextLine()); // 얘는 왜 에러가 날까?
//			selectNo = scan.nextInt();

			if (1 == selectNo) {
				System.out.print(">입금액 : "); // 이것도 메소드로 만들어 주세요.
				
				
				// 1. 메뉴표시 예외처리
				try {
					selectNo = scan.nextInt(); // 안에서 선언하면 중괄호 안에서만 쓰이게됨
				} catch (NumberFormatException e) {
					System.out.println("[예외발생] 잘못된 값이 입력되었습니다." + "메뉴 (0~3) 숫자만 입력하세요.");
				} finally {
					scan.nextLine();
					/*		
					사용자가 nextInt()를 호출하여 정수를 입력한 후 엔터를 누르면 입력 버퍼에 개행 문자('\n')가 남아 있게 됩니다.
					문제는 이후에 nextLine()을 호출할 때 발생합니다. 
					nextLine()은 입력 버퍼에서 개행 문자를 만날 때까지 입력을 읽어들이기 때문에, 
					남아있는 개행 문자를 만나게 되면 바로 그 다음 라인으로 인식하고 입력을 받지 않게 됩니다. 
					즉, nextInt() 다음에 nextLine()을 사용하면 nextInt()에서 입력받은 값 뒤에 아무런 입력을 받지 않고 그냥 넘어가게 됩니다.	
					*/
				}
				
				
				// 2. 금액표시 예외처리
				money += Integer.parseInt(scan.nextLine()); // 이것도.
				
				try {
					money = scan.nextInt(); // 안에서 선언하면 중괄호 안에서만 쓰이게됨
				} catch (NumberFormatException e) {
					System.out.println("[예외발생] 돈 값이 잘못되었습니다.");
				}
				scan.nextLine();
				
				inPutMoney();
			}
			if (2 == selectNo) {
				int select = -1; //초기값 넣어주기
				try {
					select = scan.nextInt(); // 안에서 선언하면 중괄호 안에서만 쓰이게됨
				} catch (NumberFormatException e) {
					System.out.println("[예외발생] 잘못된 값이 입력되었습니다." + "메뉴 (0~3) 숫자만 입력하세요.");
				}
				scan.nextLine();
				
				System.out.println(">출금금액 : ");
				money -= Integer.parseInt(scan.nextLine());
				outPutMoney();
			}
			if (3 == selectNo) {
				System.out.println("잔액 확인 : " + money);
			}

			if (0 == selectNo) {
				System.out.println(":: 작업을 종료합니다.");
				break;
			}
			if (selectNo < min || selectNo > max) {
	            System.out.println("컴) 범위 확인하고 다시 입력하세요~~");
	            continue;
	         }
		}

	}

	private void outPutMoney() {
		
	}
	private void inPutMoney() {
		
	}
	private void runningATM() {
		
	}
	
	public void showMenu() {
		System.out.println("-------------------------------------");
		System.out.println("1.입금 2.출금 3.통장확인  0.종료 ");
		System.out.println("-------------------------------------");
		System.out.print("작업선택 : ");
	}

	
	// 예외처리 하기 - ()메서드 안에다 넣어주기.
//	int select = -1; //초기값 넣어주기
//	try {
//		select = scan.nextInt(); // 안에서 선언하면 중괄호 안에서만 쓰이게됨
//	} catch (NumberFormatException e) {
//		System.out.println("[예외발생] 잘못된 값이 입력되었습니다." + "메뉴 (0~3) 숫자만 입력하세요.");
//	}
//	scan.nextLine();
	
	
	

}

package com.mystudy.scanner6_bank;

import java.util.InputMismatchException;
import java.util.Scanner;

//은행의 ATM기
	//1. 입금
	//2. 출금
	//3. 통장확인
	//4. 종료
public class BankATM { 
	Scanner scan = new Scanner(System.in);
	
	private int money = 0; //통장 계좌 금액
	int moneyIn;
	int moneyOut;
	int menu;


	public BankATM() {
		// TODO Auto-generated constructor stub
	}

	public void startBank() {
		System.out.println(">>> 어서오세요!");
		
		while (true) {
			//메뉴 표시, 선택
			getMenu();
			moneyIn();
			moneyOut();
			money();
			if (menu == 4) {
				System.out.println("> 작업선택 " + menu);
				System.out.println("atm 사용을 종료했습니다.");
				break;
			}
			
		}	
	}
	
	
	//메뉴 선택, 표시
	void getMenu() {
		System.out.println("------실행할 메뉴를 선택하세요.------");
		System.out.println(" 1. 입금 2. 출금 3. 통장확인 4. 종료");
		System.out.println("------------------------------");
		menu = scan.nextInt();	
		
	}
	
	
	
	//1번 입금
	void moneyIn() {
		if (menu == 1) {
			System.out.println("> 작업선택 " + menu + ". 입금액을 입력하십시오.");
			moneyIn = scan.nextInt();
			scan.nextLine();
			money = moneyIn + money;
			System.out.println(">> 입금액 : " + moneyIn);
		}
	}
	
	
	//2번 출금
	void moneyOut() {
		if (menu == 2) {
			System.out.println("> 작업선택 " + menu + ". 출금액을 입력하십시오.");
			moneyOut = scan.nextInt();
			scan.nextLine();
			if (money < moneyOut) {
				System.out.println(">> 잔고가 부족합니다.");
			} else if (money >= moneyOut) {
				money = money - moneyOut;					
				System.out.println("출금액 : " + moneyOut);
			}
		}
	}
	
	
	//3번 통장확인 : 잔고총액
	int money() {
//		money = (money + moneyIn) - moneyOut;
		
		if (menu == 3) {
			System.out.println("> 작업선택 " + menu + ".통장확인");
			System.out.println(">> 현재 잔고는 " + money + "입니다.");
		}
		return money;
	}
	
}
	


/* 
 * -------------------------
 1. 입금 2. 출금 3. 통장확인 4. 종료
 ---------------------------
 > 작업선택 : 1
 > 입금액 : 10000
 
 * -------------------------
 1. 입금 2. 출금 3. 통장확인 4. 종료
 ---------------------------
 >작업선택 : 3
 : 통장금액 : 10000원
 
 * -------------------------
 1. 입금 2. 출금 3. 통장확인 4. 종료
 ---------------------------
 > 작업 선택 : 2
 > 출금액 : 5000원 
 
  * -------------------------
 1. 입금 2. 출금 3. 통장확인 4. 종료
 ---------------------------
 > 직업 선택 : 3
 :: 통장금액 : 5000원


 * -------------------------
 1. 입금 2. 출금 3. 통장확인 4. 종료
 ---------------------------
> 작업 선택 : 0
// atm 사용을 종료했습니다.
 
 */

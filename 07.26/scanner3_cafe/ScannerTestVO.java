package com.mystudy.scanner3_cafe;

import java.util.Scanner;

public class ScannerTestVO {
	Scanner scan = new Scanner(System.in);
	
	String order1 = "아메리카노";
	String order2 = "카페라떼";
	String order3 = "플랫화이트";
	String order4 = "과일주스";
	public static final int AMERICANO = 3000;
	public static final int CAFELATTE = 3500;
	public static final int FLATWHITE = 4000;
	public static final int JUICE = 5000;
	private int sum = 0;
	private int orderNum; //주문 잔수
	private int inMoney = 0; //입금
	public int inCome = 0;
	
	public void order() {
		while (true) { // 메뉴선택 0 선택시 종료
			System.out.println("1.아메리카노  	2.카페라떼  	3.플랫화이트  	4.과일주스		0.종료");
			System.out.print(">메뉴를 선택하세요 (1~4) : ");
			int menuNum = scan.nextInt();
			switch (menuNum) {
			case 1:
				System.out.println(order1 + "를 선택하셨습니다.");
				break;

			case 2:
				System.out.println(order2 + "를 선택하셨습니다.");
				break;

			case 3:
				System.out.println(order3 + "를 선택하셨습니다.");
				break;

			case 4:
				System.out.println(order4 + "를 선택하셨습니다.");
				break;

			case 0:
				System.out.println("감사합니다. 다음에 또 오세요~");
				return;

			default:
				System.out.println("잘못된 입력입니다. 주문을 취소합니다.");
				return;
			}
			System.out.print("주문수량 : ");
			orderNum = scan.nextInt();
			System.out.println(orderNum + "잔을 선택하셨습니다.");
			
			//계산처리
			if (menuNum == 1) {
				sum += AMERICANO * orderNum;
			} else if (menuNum == 2) {
				sum += CAFELATTE * orderNum;
			} else if (menuNum == 3) {
				sum += FLATWHITE * orderNum;
			} else if (menuNum == 4) {
				sum += JUICE * orderNum;
			}

			System.out.print("입금액 : ");
			inMoney = scan.nextInt();
			System.out.println(inMoney + "원을 입금하셨습니다.");
			
			System.out.println("========================================================계산처리");
			System.out.println("입금액 : " + inMoney);
			if (inMoney < sum) {
				System.out.println("부족 금액 : " + (sum - inMoney));
				System.out.println("금액이 부족하여 주문을 종료합니다.");
				return;
			} else {
				System.out.println(inMoney + "원이 정상적으로 입금되었습니다.");
			}
			System.out.println("판매액 : " + sum);
			int change = inMoney - sum;
			System.out.println("잔액 : " + change);
			System.out.println("================================================================");
			scan.nextLine();

			System.out.print(">> 계속 주문하시겠습니까? (yes/no) : ");
			String onOff = scan.nextLine();
			inCome += sum;
			sum = 0;

			if (onOff.equalsIgnoreCase("no")) {
				System.out.println("주문해 주셔서 감사합니다. 조금만 기다려 주세요");
				break;
			} else if (onOff.equalsIgnoreCase("yes")) {
				System.out.println("메뉴로 돌아갑니다.");
				continue;
			}
		}
	}
	public void inCome() {
		System.out.println("금일 매출총액 : " + inCome + "원");;
	}
	
}

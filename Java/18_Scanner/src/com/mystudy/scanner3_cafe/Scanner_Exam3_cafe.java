package com.mystudy.scanner3_cafe;

import java.util.Scanner;

public class Scanner_Exam3_cafe {

	public static void main(String[] args) {
	//(실습) 카페 음료 주문 처리
	//음료의 종류 : 
	//1.아메리카노(3000)  2.카페라떼(3500)  3.카페모카(4000)  4.과일주스(5000)
	//-------------------------------------
	// 입력값 : 메뉴번호, 주문수량, 입금액(고객이 낸 돈)
	// 출력값 : 입금액, 판매액(단가 * 수량), 잔돈(입금액 - 판매액)
	//----------------------------------------
		
		Scanner scan = new Scanner(System.in);
		
//		final int AMERICANO = 3000;
//		final int CAFE_LATTE = 3500;
//		final int CAFE_MOCHA = 4000;
//		final int JUICE = 5000;
//		//final로 메뉴값을 지정하면 메뉴값을 변동시킬 수 없다.
//		switch (select) {
//		case 1 : totMoney = AMERICANO * count; break;
//		}
		
		
		
		while (true) { 
			System.out.print("메뉴 번호를 입력하세요 >>> \n 1. 아메리카노  "
					+ "2.카페라떼  3.카페모카  4.과일주스  0.종료");
			
			// 입력 - 메뉴번호
			int menu = scan.nextInt(); 
			if (menu == 0) {
				System.out.println(":: 안녕히가세요.");
				break;
			}
			
			// 입력 - 주문수량
			System.out.println("주문 수량을 입력하세요 >>>");
			int num = scan.nextInt();
			
			// 입력 - 입금액
			System.out.println("입금액을 입력해주십시오 >>>");
			int cnt = scan.nextInt();
			
			//계산처리======================
			
			int menuCnt = 0;
			if (menu == 1) {
				menuCnt = 3000;
			} else if (menu == 2) {
				menuCnt = 3500; 
			} else if (menu == 3) {
				menuCnt = 4000; 
			} else if (menu == 4) {
				menuCnt = 5000; 
			} else if (menu == 0) {
				System.out.println("종료되었습니다.");
				break;
			} 
			
			//출력 - 입금액
			System.out.println("입금하신 금액은 " + cnt + "원 입니다.");

			//출력 - 판매액
			int sellCnt = menuCnt * num;
			System.out.println("총 " + sellCnt + "원 입니다.");
			
			//출력 - 잔돈
			System.out.println("거스름 돈은 " + (cnt - sellCnt) + "입니다.\n2");
			
			
//			System.out.print("계속하시려면 a를 눌러주세요.");
//			String ctn = scan.nextLine();
//			if (ctn.equalsIgnoreCase("a")) {
//				System.out.println(":: 안녕히가세요.");
//				break;
//			}
			
			
			
			
			
			
		}

	}
}

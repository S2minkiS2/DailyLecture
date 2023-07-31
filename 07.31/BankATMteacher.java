package com.mystudy.scanner6_bank;

import java.util.InputMismatchException;
import java.util.Scanner;

// 은행의 ATM
// 1. 입금   2. 출금   3. 통장확인   0. 종료
public class BankATMteacher {
   private int money; //통장계좌 금액
   Scanner scan = new Scanner(System.in);

/*
-----------------------------------
1. 입금   2. 출금   3. 통장확인   0. 종료
-----------------------------------
>작업선택 : 1
>입금액 : 10000
-----------------------------------
1. 입금   2. 출금   3. 통장확인   0. 종료
-----------------------------------
>작업선택 : 3
>통장금액 : 10000 원
-----------------------------------
1. 입금   2. 출금   3. 통장확인   0. 종료
-----------------------------------
>작업선택 : 2
>출금금액 : 5000
-----------------------------------
1. 입금   2. 출금   3. 통장확인   0. 종료
-----------------------------------
>작업선택 : 3
>통장금액 : 5000 원
-----------------------------------
1. 입금   2. 출금   3. 통장확인   0. 종료
-----------------------------------
>작업선택 : 0
>작업을 종료합니다.
*/

   public void startBank() {

   System.out.println("===은행===");

   while (true) {

      System.out.println("---------------------------");
      System.out.println("1.입금 2.출금 3.통장확인 0.종료");
      System.out.println("---------------------------");
      System.out.println("작업 선택 : ");

      int number = -1;
      //메뉴선택
      try {
    	  number = scan.nextInt(); // 안에서 선언하면 중괄호 안에서만 쓰이게됨
		} catch (NumberFormatException e) {
			System.out.println("[예외발생] 잘못된 값이 입력되었습니다." + "메뉴 (0~3) 숫자만 입력하세요.");
		} 
      finally {
			scan.nextLine();
		}
      
      if (number == 1) {
         System.out.println("입금금액 : ");
         money += scan.nextInt();   
      }   
      if (number == 2) {
         System.out.println("출금금액 : ");
         money -= scan.nextInt();
      }
      if (number == 3) {
         System.out.println("통장확인 : " + money);
      }
      if (number == 0) {
         System.out.println("작업을 종료합니다.");
         break;
      }
      if (!(number >= 0 && number <= 3)) {
         System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요");
         continue;
      }
      
      System.out.println("서비스를 계속 이용하겠습니까? 1.Yes / 2.NO");
      int a = scan.nextInt();
      if (a == 2) {
         System.out.println("작업을 종료합니다.");
         break;
      }
   
      
   }
   }
   
//   private int startBank1() {
//      int num = -1;
//      while (true) {
//         try {
//            System.out.println("---------------------------");
//            System.out.println("1.입금 2.출금 3.통장확인 0.종료");
//            System.out.println("---------------------------");
//            System.out.println("작업 선택 : ");
//            num = scan.nextInt();
//            break;
//         } catch (InputMismatchException e) {
//            System.out.println("[주의] 숫자값을 입력하세요");
//         }
//      }
//      return num;
//   }
   
   
   
}

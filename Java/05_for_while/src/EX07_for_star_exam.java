
public class EX07_for_star_exam {

	public static void main(String[] args) {
		/*
		 * 문제 1 -------------------- : 5번 + 줄바꿈
		 ****
		 ***
		 **
		 * 
		 * ------------------------
		 */

		for (int line = 5; line > 0; line--) {
			for (int i = line; i > 0; i--) {
				System.out.print("*");
			}
			System.out.println();
		}

//		System.out.println(*****);
//		System.out.println(****);
//		System.out.println(***);
//		System.out.println(**);
//		System.out.println(*);

		System.out.println("문제2------------------");

		/*
		 * 문제2 ---------------------- : 빈칸4 + *1개 + 줄바꿈 : 빈칸3 + *2개 + 줄바꿈 : 빈칸2 + *3개 +
		 * 줄바꿈
		 ****
		 ***** 
		 * ----------------------------
		 */

		for (int space = 1; space <= 4; space++) {
			System.out.print(" ");
		}
		for (int star = 1; star <= 1; star++) {
			System.out.print("*");
		}
		System.out.println();
		// 2번째줄
		for (int space = 1; space <= 3; space++) {
			System.out.print(" ");
		}
		for (int star = 1; star <= 2; star++) {
			System.out.print("*");
		}
		System.out.println();
		// 3번째줄
		for (int space = 1; space <= 2; space++) {
			System.out.print(" ");
		}
		for (int star = 1; star <= 3; star++) {
			System.out.print("*");
		}
		System.out.println();
		//
		System.out.println("------------------");

		int space1Cnt = 4; // 변수처리를 해야 값이 움직인다
		int starcnt = 1;

		for (int line = 1; line <= 5; line++) {
			for (int space = space1Cnt; space <= 4; space++) {
				System.out.println(" ");
			}
			for (int star = starcnt; star <= 5; star++) {
				System.out.print("*");
			}
		}
		space1Cnt--;
		starcnt++;
		System.out.println();

//		System.out.println("    *"); //빈칸4
//		System.out.println("   **"); //빈칸3
//		System.out.println("  ***"); //빈칸2
//		System.out.println(" ****"); //빈칸1
//		System.out.println("*****"); //빈칸0

		System.out.println("=========222=========");

		int spacecnt = 4;
		int starcnt1 = 1;
		for (int line = 1; line <= 5; line++) {
			for (int space = 1; space <= spacecnt; space++) {
				System.out.print(" ");
			}
			for (int star = 1; star <= starcnt1; star++) {
				System.out.print("*");
			}
			System.out.println();
			spacecnt--;
			starcnt1++;
		}
		System.out.println("------------------");

		/* 문제3------------------------ 
		 ***** : 빈칸0, *5개, 줄바꿈 
		  **** : 빈칸1, *4개, 줄바꿈 
		   *** : 빈칸2, *3개, 줄바꿈
		    **
		     *
		 * --------------------------
	
		 */
		System.out.println("===========3다음날=======");
		
		
		int blankcnt = 0;
		starcnt = 5;
		for (int line = 1; line <=5; line++) {
			for (int blank = 1; blank <= 5; blank++) {
				System.out.println(" ");
			}
			for (int star = 1; star <=5; star++) {
				System.out.println("*");
			}
			System.out.println();
			blankcnt++;
			starcnt--;
		}
		
		
		
		
		System.out.println("===========3진짜풀이=======");
		
		int spaceCnt = 0;
		int starCnt = 5;
		
		for (int line = 1; line <=5; line ++ ) {
			//빈칸출력 0,1,2,3,4
			for (int space = 1; space <= spaceCnt; space++) {
				System.out.print(" ");
			} 
			// "*" 출력 5,4,3,2,1
			for (int i = 1; i <=starCnt; i++) { //5번 반복하는동안
				System.out.print("*"); //별 하나 화면출력
			}
			System.out.println();
			spaceCnt++;
			starCnt--;
		}
		
		
		
//		System.out.println("");

//		System.out.println("=====3==========");
//		
//		System.out.print(""); 0
//		System.out.print("*****"); 5
//		System.out.println();

//		System.out.print(" "); 1
//		System.out.print("****"); 4 
//		System.out.println();
//		
//		System.out.print("  "); 2
//		System.out.print("***"); 3
//		System.out.println();
		System.out.println();
		System.out.println("-------33다시-----------");

//		 ***** : 빈칸0, *5개, 줄바꿈 
//		  **** : 빈칸1, *4개, 줄바꿈 
//		   *** : 빈칸2, *3개, 줄바꿈
//		    **
//		     *
		blankcnt = 0;
		int starcntc = 5;

		for (int line = 1; line <= 5; line++) {
			for (int blank = 1; blank <= blankcnt; blank++) {
				System.out.print(" ");
			}
			for (int star = 1; star <= starcntc; star++) {
				System.out.print("*");
			}

			System.out.println();
			blankcnt++;
			starcntc--;
		}
		
		
//		 ***** : 빈칸0, *5개, 줄바꿈 
//		  **** : 빈칸1, *4개, 줄바꿈 
//		   *** : 빈칸2, *3개, 줄바꿈
//		    **
//		     *
		System.out.println("-------33다시-----------");
		
		blankcnt = 0;
		starcntc = 5;
		
		for (int line = 1; line <5; line++) {
			for (int i = 1; i <=blankcnt; i++) {
				System.out.print(" ");
			}
			for (int j = 1; j <=starcntc; j++) {
				System.out.print("*");
			}
			blankcnt++;
			starcntc--;
			System.out.println();
		}
		
		


		System.out.println("-------33-----------");
		
		
		starcnt = 5;
		int blankcntt = 1;
	
		for(int line = 1; line<=5; line++) {
	
		for (int blank = 1; blank <= blankcntt; blank++) {
			System.out.print(" ");
		}
		for (int star = 1; star <= starcnt; star++) {
			System.out.print("*");
		}
		System.out.println();
		starcnt--;
		blankcntt++;
	
	}
	
	//

//	
//			System.out.print("");
//			System.out.print("*****");						
//			System.out.println();
//			
//			System.out.print(" ");
//			System.out.print("****");			
//			System.out.println();
//			
//			System.out.print("  ");
//			System.out.print("***");			
//			System.out.println();
//			
//			System.out.print("   ");
//			System.out.print("**");			
//			System.out.println();
//			
//			System.out.print("    ");
//			System.out.print("*");			
//			System.out.println();

//		
//		for (int star = 5; star >= 1; star--) {
//			System.out.print("*");
//		}
//			for (int blank = 0; blank <=4; blank++) {
//				System.out.print(" ");
//			}
//		System.out.println();
//		
//		
//		
////		System.out.println(" ****");
//		for (int star = 4; star >= 1; star--) {
//			System.out.print("*");
//		}
//		for (int blank = 1; blank <=4; blank ++) {
//			System.out.print(" ");
//		}
//		System.out.println();
//		
//		
////		-----------------------
//		for (int star = 3; star >= 1; star--) {
//			System.out.print("*");
//		}
//		for (int blank = 2; blank <=4; blank ++) {
//			System.out.print(" ");
//		}
//		System.out.println();
////		-----------------------
//		for (int star = 2; star >= 1; star--) {
//			System.out.print("*");
//		}
//		for (int blank = 1; blank <=4; blank ++) {
//			System.out.print(" ");
//		}
//		System.out.println();
////		-----------------------
//		for (int star = 1; star >= 1; star--) {
//			System.out.print("*");
//		}
//		for (int blank = 0; blank <=4; blank ++) {
//			System.out.print(" ");
//		}
//		System.out.println();
//		
//		
////		System.out.println(" ****");
////		System.out.println("  ***");
////		System.out.println("   **");
////		System.out.println("    *");
//		

	/*
	 * 문제4---------------------- 
	 * 1   : (1 + 빈칸1) + 줄바꿈 
	 * 1 2 : (1 + 빈칸1) + (2 + 빈칸1) + 줄바꿈 
	 * 1 2 3 
	 * 1 2 3 4 -------------------------
	 */
	 // 1부터 시작해서 1증가한 값
	
		System.out.println("----------444----------");
		
		
		for (int line = 1; line <=4; line++) {
			for (int j = 1; j <=line; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		
		
	
		
//		System.out.print("1" + " ");
//		System.out.print("1" + " " + "1+1" + " ");
//		System.out.print("1" + " " + "1+1" + " " + "1+1+1" + " ");
//		System.out.print("1" + " " + "1+1" + " " + "1+1+1" + " " + "4" + " ");
		
		
		
		System.out.println("---------4번----------------");
		
		int cnt2 = 1;
		
		for (int line = 1; line <= 4; line++) {
			int num = 1;
			for (int i = 1; i <=cnt2; i++) {
				System.out.print(num + " ");
				num++;
			}
			System.out.println();
			cnt2++;
		}
		
		
		
		
	
	
	

	/*
	 * 문제5---------------------- 
	 * 1 
	 * 2 3 
	 * 4 5 6 
	 * 7 8 9 10 --------------------------
	 */
//		출력하는 숫자가 1씩 계속 증가
		System.out.println("---------5번----------------");
		
		int plus = 1;
		for (int line = 1; line <= 4; line++) {	
			for(int a = 1; a <= line; a++) {		
				System.out.print(plus + " ");
				plus++;
			}
			System.out.println();
			
		}
		
		
		System.out.println("---------5번-연습------------");
		
		System.out.println("1");
		System.out.println("1+1" + "1+2");
		System.out.println("1+3" + "1+4" + "1+5  ");
		
		

		int cnt = 1;
		int num = 1;
		for (int line = 1; line <= 4; line++) {
			for (int i = 1; i <= cnt; i++) {
				System.out.print(num++);
				System.out.print(" ");
			}
			System.out.println();
			cnt++;
		}
		
		
}

}

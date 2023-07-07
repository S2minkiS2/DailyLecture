package com.mystudy.array;

public class Ex03_array_star {

	public static void main(String[] args) {
		/* 별찍기
		 * 
		 ** 
		 ***
		 **** 
		 ***** 
		 -------------------*/
		// char 타입의 데이터를 5개 저장할 수 있는 배열을 만들고, 별(*) 입력
		
		char[] ch = new char[] {'*', '*', '*', '*', '*'};
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(ch[j]);
			}
			
			System.out.println();
		}
		
		//간단하게 할 수 있는 방법을 생각해라. 코드가 길다고 답이 아니다.
		
		
	}

}

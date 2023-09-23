package com.mystudy.array;

public class Ex03_array_star {

	public static void main(String[] args) {

	/* 별 찍기
	 * 
	 ** 
	 ***
	 ****
	 ***** 
	-------- */
		
	// char 타입의 데이터를 5개 저장할 수 있는 배열을 만들고 별(*) 입력
	//char ch = new char[5];
	//char[] ch = {'*', '*', '*', '*', '*'} 
	//char[] ch = {'!', '@', '#', '$', '%'} 
		
		
	char[] ch = {'*', '*', '*', '*', '*'};
	
	//char[] ch = {'*'} 
	//char[] ch = {'*', '*'} 
	//char[] ch = {'*', '*', '*'} 
	//char[] ch = {'*', '*', '*', '*'} 
	//char[] ch = {'*', '*', '*', '*', '*'} 
	
//	System.out.println(ch[0]);
//	System.out.println(ch[1]);
//	System.out.println(ch[2]);
//	System.out.println(ch[3]);
//	System.out.println(ch[4]);
	
	for (int i = 0; i < 5; i++) {
		for(int j = 0; j <= i; j++) {
			System.out.print(ch[i]);
			}
		System.out.println();
	}
	

	}

}

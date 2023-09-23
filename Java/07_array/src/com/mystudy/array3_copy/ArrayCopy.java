package com.mystudy.array3_copy;

import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {
		// 배열복사
		int[] num1 = new int[5];
		int[] num2 = new int[5]; //new에 의해 만들어진 객체 int[5] 각각
		System.out.println("nums1 : " + num1);
		System.out.println("nums2 : " + num2);
		// 참조형데이터 비교 : == (주소값 비교, 동일객체여부 비교)
		System.out.println("num1 == num2 : " + (num1 == num2));
		//객체비교 => (주소값이 다름) 서로 다른 객체다. 
		//num1이 가리키는 객체와 num2가 가리키는 객체는 서로 다르다 (값만 같음)
	
		num1[0] = 10; 
		num1[1] = 20; 
		num1[2] = 30; 
		num1[3] = 40; 
		num1[4] = 50; 
		
		System.out.println("=== 배열 복사 (주소값 복사, 얕은 복사) ===");
 		num2 = num1; //주소값 복사
		
		System.out.println("nums1 : " + num1);
		System.out.println("nums2 : " + num2);
		System.out.println("num1 == num2 : " + (num1 == num2));
		
		num1[0] = 999;
		
		printData("num1", num1);
		printData("num2", num2);
		//같은 값이 나오지만 값이 복사된 것이 아니라 같은 곳을 가리킬 뿐
	
	System.out.println("=== 배열 값 복사 (물리적복사, 깊은복사(deep copy)===)");
	int[] num3 = new int[num1.length]; //num1 배열과 같은 크기
	printData("num3", num3);
	
//	num3 <------ num1 배열 값 복사
	for (int i = 0; i < num3.length; i++) {
		num3[i] = num1[i];
	}
	
	printData("num1", num1);
	printData("num3", num3);
	System.out.println("num1 == num3 : " + (num1 == num3));
	
	num1[0] = 888;
	System.out.println(">> num1[0] = 888 변경 후");
	printData("num1", num1);
	printData("num3", num3);
	System.out.println("===System.arraycopy() 복사하기=========");	
	
	
	int[] num4 = new int[num1.length];
	
	System.arraycopy(num1, 0, num4, 0, num1.length);

	System.out.println("복사후");
	printData("num1", num1);
	printData("num4", num4);
	System.out.println("num1 == num4 : " + (num1 == num4));

	System.out.println("=== 배열객체.clone() 복사(복제)===");
	int[] num5 = num4.clone();
	printData("num4", num4);
	printData("num5", num5);
	System.out.println("num4 == num5 : " + (num4 == num5));
	
	System.out.println("====== Arrays.copyOf() 사용 복사====");
	//Arrays.copyOf(원본데이터, 복사할 갯수)
	int[] num6 = Arrays.copyOf(num4, num4.length);
	printData("num4", num4);
	printData("num6", num6);
	System.out.println("num4 == num6 : " + (num4 == num6));
	
	System.out.println("=== Arrays.copyOfRange(원본, from, to) ===");
	//Arrays.copyOfRange(원본, from, to) : to 이전까지
	num6 = Arrays.copyOfRange(num4, 0, 3); //0부터 세개
	
	}
	static void printData(int[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		
		
		
		
		
		
	}
	
	//똑같은 이름의 메소드를 사용할 수 있다. 
	//전달해주는 것에 따라 다르게 동작
	//메소드 오버로딩 : 하나의 클래스 내에서 동일한 메소드 명으로 서로 다르게 정의 가능
	//전달받는 파라미터의 갯수, 종류 등 다르기 때문에 호출이 가능
	static void printData(String name, int[] num) { 
		//같은 타입은(이름x) 구분할 수 없기 때문에(메소드 호출 시) 사용불가
		System.out.print(name + ": ");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}

}

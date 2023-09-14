package com.mystudy.array4_2dim;

import java.util.Arrays;

public class ArrayExam {

	public static void main(String[] args) {
		/* 문제 : 2차원 배열을 사용하여
		 int[][] num2dim = { {10, 20}, {30, 40}, {50, 60} };
		 1. 2차원 배열 num2dim 값을 화면 출력하라 : 10 20 30 40 ...
		 2. num2dim의 세번째 값인 30을 찾아서 (30이 있는 곳의 위치에 직접 접근) 
		 	100으로 수정 후 화면 출력
		 3. num2dim의 크기만큼 num2Copy 배열을 선언 후 데이터를 복사
		 	num2dim ---> num2Copy 데이터 복사 후 
		 	num2Copy 데이터 화면 출력
		 	*** 데이터 복사 형태 확인 : 주소값복사인지 물리적복사인지 
		 */
		
		System.out.println("문제1--------------------");
		int[][] num2dim = { {10, 20}, {30, 40}, {50, 60} };
		
//		for (int i = 1; i <= 6; i++) {
//			System.out.print(10 * i + " ");
//		}
//		System.out.println();
		
		for (int i = 0; i < num2dim.length; i++) {
			for (int j = 0; j < num2dim[i].length; j++) {
				System.out.print(num2dim[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		
		System.out.println("문제2--------------------");
		num2dim[1][0] = 100;
		System.out.println("num2dim[1][0] = " + num2dim[1][0]);
		
		
		System.out.println("문제3--------------------");
//		int[][] num2Copy = new int[3][2]; //크기
		int[][] num2Copy = new int[num2dim.length][num2dim[0].length];
		
		for (int i = 0; i < num2dim.length; i++) {				
			for (int j = 0; j < num2dim[i].length; j++) {
				num2Copy[i][j] = num2dim[i][j];	
				System.out.print(num2Copy[i][j] + " ");
			}
			System.out.println();
		}
		
		
		System.out.println("num2Copy == num2dim : " + (num2Copy == num2dim));
//		num2Copy = num2dim; //주소값복사
		
//		===========================================
		
		System.out.println("문제4 (서로 길이가 다른 2차원 배열)");
		int[][] num3dim = { {10}, {20, 30}, {40, 50, 60} };
		int[][] num3Copy = new int [num3dim.length][];
		num3Copy[0] = new int[1];
		num3Copy[1] = new int[2];
		num3Copy[2] = new int[3];
		
		for (int i = 0; i < num3dim.length; i++) {				
			for (int j = 0; j < num3dim[i].length; j++) {
				num3Copy[i][j] = num3dim[i][j];	
				System.out.print(num3Copy[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("clone()사용---------");
		//1차원 배열에 가서 clone()를 사용 -> 그래야 주소값이 복사되지 않음
		for (int i = 0; i < num3dim.length; i++) {
			num3Copy[i] = num3dim[i].clone();
			}
		System.out.println(Arrays.deepToString(num3dim));
		
		
		num3Copy[0][0] = num3dim[0][0] ; 
		num3Copy[1][0] = num3dim[1][0] ; 
		num3Copy[1][1] = num3dim[1][1] ; 
		num3Copy[2][0] = num3dim[2][0] ; 
		num3Copy[2][1] = num3dim[2][1] ; 
		num3Copy[2][2] = num3dim[2][2] ; 
		
		num3Copy[0][0] = num3dim[0][0] ; 
		num3Copy[1][0] = num3dim[1][0] ; 
		num3Copy[1][1] = num3dim[1][1] ; 
		num3Copy[2][0] = num3dim[2][0] ; 
		num3Copy[2][1] = num3dim[2][1] ; 
		num3Copy[2][2] = num3dim[2][2] ; 
		
	
		
//		num2Copy[0][0] = num2dim[0][0];
//		num2Copy[0][1] = num2dim[0][1];
//		num2Copy[1][0] = num2dim[1][0];
//		num2Copy[1][1] = num2dim[1][1];
//		num2Copy[2][0] = num2dim[2][0];
//		num2Copy[2][1] = num2dim[2][1];
	
	

	}

}

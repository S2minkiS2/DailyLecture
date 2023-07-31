package com.mystudy.ex01_random;

import java.util.Random;

public class Random_Exam2 {

	public static void main(String[] args) {
		Random ran = new Random();
		
		System.out.println("---- nextInt() ----");
		
		for (int i = 0; i < 30; i++) {
			System.out.print(ran.nextInt(5) + " "); // 0~4 까지 숫자
		}
		System.out.println();
		
		System.out.println("=========================");
		System.out.println(ran.nextDouble() + " - Random.nextDouble()");
		System.out.println(Math.random() + " - Math.random()");
		
		
		
	}

}

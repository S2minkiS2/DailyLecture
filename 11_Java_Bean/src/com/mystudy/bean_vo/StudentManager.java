package com.mystudy.bean_vo;

import java.util.Arrays;

public class StudentManager {

	public static void main(String[] args) {
		/* 3명의 성적 처리 StudentVO 사용
		"김유신", 100, 90, 81
		"이순신", 95, 88, 92
		"홍길동", 90, 87, 77
		======================
		김유신	100  90  81 271  90.33
		이순신	95   88  92 ???  ??.??
		홍길동	90   87  77 ???  ??.??
		***************************/
		//데이터 생성(입력)
		StudentVO stu1 = new StudentVO("김유신", 100, 90, 81);
		System.out.println("stu1 : " + stu1.toString());
		StudentVO stu2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO stu3 = new StudentVO("홍길동", 90, 87, 77);
		
		//화면출력-----------------
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		printData(stu1);
		printData(stu2);
		printData(stu3);
		System.out.println("=================");
		
		StudentVO[] students = new StudentVO[3];
		students[0] = stu1;
		students[1] = stu2;
		students[2] = stu3;
		printData(students);
		
		System.out.println("----------");
		students = new StudentVO[] {stu3, stu2, stu1};
		System.out.println(Arrays.toString(students));
		printData(students);
		
	}
	
	static void printData(StudentVO stu) {
		System.out.println(stu.getName() + "\t" +
				stu.getKor() + "\t" + stu.getEng() + "\t" + stu.getMath() + "\t" + 
				stu.getTot() + "\t" + stu.getAvg());
	}

	static void printData(StudentVO[] students) {
		for (int i = 0; i < students.length; i++) {
			printData(students[i]);
		}
	}
}


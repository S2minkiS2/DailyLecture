package com.mystudy.ex04_printwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PrintWriter_OutputStream_Exam {

	public static void main(String[] args) {
		// PrintWriter <-- FileOutputStream <-- File
		// 최종적으로 PrintWriter 사용한다.
		
		FileOutputStream fos = null;
		PrintWriter pw = null;
		
		try {
			fos = new FileOutputStream(new File("file/pw_out.txt"));
			pw = new PrintWriter(fos);
			pw.write("안녕하세요");
			pw.write("점심시간 후 오후~~~\n");
			
			pw.print("지금 자바 공부중~~");
			pw.print("아직은 안졸린다.");
			pw.println();
			
			pw.println("조금 지나면 졸릴 수도 있다~~");
			pw.println("끝나려면 4시간 남았따....");
			
			pw.printf("%10s %10s %10s %n", "이제", "20분", "남았다");
			//10자 10자 10자 \n(줄바꿈)  기본은 우측정렬
			//s는 String %10은 크기 %는 형식문자
			pw.printf("%-50s", "18분 정도 남았습니다");
			// %뒤에 -부호 붙이면 좌측정렬, 할당된 칸은 여전하다.
			pw.printf("%50s%n", "17분 정도 남았습니다");
			
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) pw.close();
		}

	}

}

package com.mystudy.ex04_printwriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_Writer_Exam {

	public static void main(String[] args) {
		// PrintWriter <-- FileOutputStream <-- File
		// 최종적으로 PrintWriter 사용한다.
		PrintWriter pw = null;
		
	
		try {
			// 방식1 : 생성된 객체를 변수에 모두 저장
			File file = new File("file/pw_out2.txt");
			FileWriter fw = new FileWriter(file);
			pw = new PrintWriter(fw);
			// -> pw 사용
			
			//PrintWriter만 사용한다면?? ㄱ
			// 방식2 : 한번에 처리(최종 사용객체만 저장 사용)
		pw = new PrintWriter(new FileWriter(new File("file/pw_out2.txt")));
		pw = new PrintWriter(new FileWriter("file/pw_out2.txt"));
		
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
		
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) pw.close();
		}

	}

}

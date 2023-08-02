package com.mystudy.ex04_printwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_Writer_Exam {

	public static void main(String[] args) {
		// PrintWriter <-- FileWriter <-- File
		PrintWriter pw = null;
		
		try {
			// 방식 1: 생성된 객체를 변수에 모두 저장, for 클래스 관련 메서드를 재사용하기 위해서.
			File file = new File("File/pw_out2.txt");
			FileWriter fw = new FileWriter(file);
			pw = new PrintWriter(fw);
			
			
			// 방식 2 : 한번에 처리(최종 사용객체만 변수에 저장하여 사용)
			pw = new PrintWriter(new FileWriter("file/pw_out2.txt"));
			pw = new PrintWriter(new FileWriter(new File("file/pw_out2.txt")));
			
			pw.write("안녕하세요 \n");
			pw.write("점심먹고 나면 졸려 죽어\n");
			
			pw.print("지금은 자바 공부중입니다\n");
			pw.println("아이우에오");
			
			pw.println("조금 지나면 졸릴수도 있다");
			
			pw.printf("%10s %10s %10s %n", "이제", "20분", "남았다");
			pw.printf("%-50s%n", "18분 정도 남았습니다");
			pw.printf("%50s%n", "17분 정도 남았습니다");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pw != null) pw.close();
		}
		

	}

}

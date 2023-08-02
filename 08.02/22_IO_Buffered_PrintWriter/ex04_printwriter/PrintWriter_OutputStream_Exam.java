package com.mystudy.ex04_printwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PrintWriter_OutputStream_Exam {

	public static void main(String[] args) {
		// PrintWriter <-- FileOutputStream <-- File
		
		FileOutputStream fos = null;
		PrintWriter pw = null;
		
		try {
			fos = new FileOutputStream(new File("file/pw_out.txt"));
			pw = new PrintWriter(fos);
			
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
		} finally {
			if (pw != null) pw.close();
		}
		

	}

}

package com.mystudy.reader_writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_Exam {

	public static void main(String[] args) {
		// FileWriter : 파일에 문자단위 출력(쓰기) 
		File file = new File("file/test_char_out.txt");
		
		FileWriter fw = null;
		
		try {
			//1. 객체 (인스턴스) 생성
			fw = new FileWriter(file);
			
			//2. 객체 사용(파일에 문자단위 출력)
			fw.write("야 신민기! 너는 진짜 잘났어 :) 할수있어 화이팅! ");
			
			fw.flush(); // 버퍼에 있는 데이터를 강제로 Output 처리, try-catch 안해줘도 됨. 통로도 안끊김. 훨 편함.
			
			fw.write("그니까 시간 아껴쓰거라");
			
			fw.flush();
			
			
			
		} catch (IOException e) { //보통 file 폴더가 없을때 예외가 발생
			e.printStackTrace();
		} finally {
//			try {
//				if (fw != null) fw.close(); //버퍼에 있는 데이터 출력하고 종료. 아예 fw기능을 꺼버려 통로를 끊는 것.
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
		
		
		
	}

}

package com.mystudy.reader_writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Exam2 {

	public static void main(String[] args) {

		File file = new File("file/test_char.txt");
		System.out.println("파일크기 : " + file.length());
		
		FileReader fr = null;
		try {
			//1. 객체(인스턴스) 생성
			fr = new FileReader(file);
			
			//2. 객체 사용 작업처리 (1문자 읽고, 화면에 출력)
			while (true) {
				int readChar = fr.read();
				if (readChar == -1) // 다 읽으면 -1 return되기에.
					break;
				System.out.print((char)readChar);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 사용객체 닫기 (close)
			try {
				if (fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

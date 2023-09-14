package com.mystudy.reader_writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Exam2 {

	public static void main(String[] args) {
		// (실습) FileReader_Exam1 내용을 반복문으로 변경 처리

		//1. 객체생성 fileReader
		// 2. read 읽는다 - 반복문처리 모든 데이터 읽어서 화면출력
		// 3. 인트값 문자 이렇게 출력해도 좋고 
		// 읽은 값만 화면에 출력해도되고~
		
		//파일 객체 불러오기
		FileReader fr = null;
		File file = new File ("file/test_char.txt");
		try {
			fr = new FileReader(file);
			//객체 생성 후 파일 삽입
			
			//2. 읽기! 반복문처리. 모든 데이터 읽어서 화면 출력
			
			while (true) {
				int readChar = fr.read(); //재사용을 위해 변수에 저장
				if (readChar == -1) break;
				System.out.println("문자 : " + readChar + ", char : " + (char)readChar);
//				System.out.print((char)readChar); 문자만출력
			} //계속 읽어내면 계속 새롭게 읽어내야함. 제각각.
			
			
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println(">>[예외] 파일 없음");
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println(">>[예외] 파일을 읽지 못함");
		} finally { //3. 사용객체 닫기 (close)
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}

}

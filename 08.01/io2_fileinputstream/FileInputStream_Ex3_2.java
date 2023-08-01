package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStream_Ex3_2 {

	public static void main(String[] args) {
		// (실습) Ex1을 반복문으로 변경

		// 0. 사용할 파일객체 생성
		File file = new File("File/practice.txt");

		// 1. 파일을 읽어서 작업할 객체 생성(FileInputStream)
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);

			// 2. 객체 사용 파일데이터 읽어서 화면 출력 (하나씩도 해보고, byte[]도 써보고 .. 배운거 다 해봐)
			int readValue = fis.read();
			System.out.println("readValue 값 : " + readValue);
			System.out.println("char 값 : " + (char) readValue);

			// 2-2 while문 반복출력
			/*
			 * while (true) { 			//이렇게 하면 readValue가 -1 무한출력, Returns: the next byte of data, or -1 if the end of the file is reached readValue = fis.read();
			 * System.out.println("readValue 값 : " + readValue);
			 * System.out.println("char 값 : " + (char)readValue); }
			 */
			
			/*
			while (true) {
				readValue = fis.read();
				if (readValue != -1) {
					System.out.println("readValue 값 : " + readValue);
					System.out.println("char 값 : " + (char) readValue);
				} else {
					break;
				}
			}
			*/
			
			//혹은
			
			/*
			while (readValue != -1) {
				System.out.println("readValue 값 : " + readValue);
				System.out.println("char 값 : " + (char) readValue);
			}
			*/
			
			// 2-3 byte[] 배열로 출력해보기
			
			System.out.println("--------byte[] 첫번째-------");
			byte[] bytes = new byte[10];
			int readCnt = fis.read(bytes); 
			System.out.println("읽은 갯수 : " + readCnt); 
			System.out.println("bytes : " + Arrays.toString(bytes));
			for (int i = 0; i < readCnt; i++) { // readCnt 는 유의미한 데이터의 갯수.
				System.out.println("int : " + bytes[i] + ", char : " + (char)bytes[i]);	 // readCnt가 10이므로 10개만 읽어온다.
			}
			
			System.out.println("--------byte[] 두번째-------");
			readCnt = fis.read(bytes); // 변경된 사항을 초기화
			System.out.println("읽은 갯수 : " + readCnt);
			System.out.println("bytes : " + Arrays.toString(bytes)); // 다시 확인하면?
			for (int i = 0; i < readCnt; i++) {
				System.out.println("int : " + bytes[i] + ", char : " + (char) bytes[i]);
			}
			
			System.out.println("--------byte[] 세번째-------");
			readCnt = fis.read(bytes); // 변경된 사항을 초기화
			System.out.println("읽은 갯수 : " + readCnt);
			System.out.println("bytes : " + Arrays.toString(bytes)); // 다시 확인하면?
			for (int i = 0; i < readCnt; i++) {
				System.out.println("int : " + bytes[i] + ", char : " + (char) bytes[i]);
			}
			
			System.out.println("--------byte[] 마지막-------");
			readCnt = fis.read(bytes); // 변경된 사항을 초기화  (끝)
			System.out.println("읽은 갯수 : " + readCnt);
			System.out.println("bytes : " + Arrays.toString(bytes)); // 다시 확인하면?
			for (int i = 0; i < readCnt; i++) {
				System.out.println("int : " + bytes[i] + ", char : " + (char) bytes[i]);
			}
			System.out.println("--------byte[] 종료됨-------");
			

		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("[예외발생] : FileNotFoundException");
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("[예외발생] : IOException");
		} finally { // 3. 객체 닫기(close)
			try {
				fis.close(); // fis를 try밖으로 빼야 호출가능, 또한 fis를 초기화 해줘야(= null) 호출가능
			} catch (IOException e) {
//				e.printStackTrace();
				System.out.println("[예외발생] : IOException");
			}
		}

	}

}

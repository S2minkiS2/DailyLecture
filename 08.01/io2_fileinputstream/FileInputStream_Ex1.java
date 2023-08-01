package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_Ex1 {

	public static void main(String[] args) {
		System.out.println("===== main 시작 =======");
		File file = new File("temp.txt");
		
		//FileInputStream 을 왜쓰지?
		
		// 0. 사용할 객체를 try밖에 생성.
		FileInputStream fis = null; // 초기화 필수
		try {
			// 파일로 부터 읽기 위한 작업 진행
			// 1.사용할 객체 생성
			fis = new FileInputStream(file); // temp.txt와 연결하는 통로, 파일을 못찾으면 발생하는 예외를 try catch
			 	// 자바의 객체는 중괄호 안에서만 생존. 따라서 위 try의 fis는 try안에서 소멸. 따라서 변수 선언을 try구문 밖에서 해야 호출가능.
				// try안의 중복선언은 삭제.

			// 2.객체 사용 작업 처리
			int readValue = fis.read(); //읽어온 값을 int형 변수에 저장
			System.out.println("read() int값 : " + readValue);
			System.out.println("read() int값 : " + (char)readValue);
			
			System.out.println("----- 전체 데이터 읽어서 화면출력, while문 사용 ------");
			// 방법 1
			while (true) {
				readValue = fis.read(); // Returns: the next byte of data, or -1 if the end of the file is reached.
				if (readValue == -1) break; // 따라서 파일의 끝(EOF)에서 읽기 종료
				System.out.println("read() int값 : " + readValue);
				System.out.println(" (char) read() : " + (char) readValue);
			}

		} catch (FileNotFoundException e) {
			//e.printStackTrace(); 
			System.out.println("[예외발생] " + e.getMessage());
		} catch (IOException e) { // == fis.read() 예외처리 부분
			e.printStackTrace();
		} finally {
			// 3.객체 사용후 닫기 (close)
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}
		System.out.println("===== main 끝 =======");

	}

}

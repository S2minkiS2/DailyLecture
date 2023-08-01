package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_Ex2 {

	public static void main(String[] args) {
//		File file = new File("File/test01.txt");
		
		FileInputStream fis = null;
		
		try {
			//1. 사용할 객체 생성
//			fis = new FileInputStream(file); // File 객체를 주입(전달받아) 사용
			 fis = new FileInputStream("File/test01.txt"); // 이 방식도 가능하다. 
			
			//2. 객체를 사용
			// 방법 2
			/*
			int readValue = fis.read();
			while (readValue != -1) { // readValue 값이 -1이 아니면 계속 진행.
				System.out.println("read() int값 : " + readValue);
				System.out.println(">> char : " + (char)readValue);
				readValue = fis.read();
			}
			*/
			
			// 방법 3
			int readValue;
			while ((readValue = fis.read()) != -1) { // 방법 1과 큰 차이 없다. 편한거 쓰세요.
				System.out.println("read() int값 : " + readValue);
				System.out.println(">> char : " + (char)readValue);
			}
			
			
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("[예외발생] FileNotFoundException");
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("[예외발생] IOException");
		} finally {
			//3. 객체닫기(close)
			if (fis != null) {
				try {
					fis.close(); // fis.close();도 try, catch문 필요하다.
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("---- 메인 끝-----");
		
	}

}

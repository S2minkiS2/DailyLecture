package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStream_Ex3_1 {

	public static void main(String[] args) {
		File file = new File("file/test01.txt");
		
		FileInputStream fis = null;
		
		try {
			//1. 파일을 읽기 위한 객체 생성(File 객체 입력(주입)받음)
			fis = new FileInputStream(file);
			
			
			//2. 객체 사용(파일에서 읽고 화면출력)
			byte[] bytes = new byte[10];
			System.out.println("bytes : " + Arrays.toString(bytes));
			
			// read(byte[] b) 메소드 사용
			int readCnt = fis.read(bytes);
			System.out.println("읽은갯수 : " + readCnt);
			System.out.println("bytes : " + Arrays.toString(bytes));
			for (int i = 0; i < readCnt; i++) {
				System.out.println("int: " + bytes[i] 
						+ ", char: " + (char)bytes[i]);
			}
			System.out.println("---------");
			
			readCnt = fis.read(bytes);
			System.out.println("읽은갯수 : " + readCnt);
			System.out.println("bytes : " + Arrays.toString(bytes));
			for (int i = 0; i < readCnt; i++) {
				System.out.println("int: " + bytes[i] 
						+ ", char: " + (char)bytes[i]);
			}
			System.out.println("---------");
			
			readCnt = fis.read(bytes);
			System.out.println("읽은갯수 : " + readCnt);
			System.out.println("bytes : " + Arrays.toString(bytes));
			for (int i = 0; i < readCnt; i++) {
				System.out.println("int: " + bytes[i] 
						+ ", char: " + (char)bytes[i]);
			}
			System.out.println("---------");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 사용객체 닫기(close)
			
		}
		

	}

}





package com.mystudy.io4_filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		//파일 복사 : 원본 파일에서 읽고, 대상 파일에 쓰기
		// --------------------------------------
		File inputFile = new File("temp.txt"); //원본 : source 파일
		File outputFile = new File("TestFile/temp_copy.txt"); // 복사본 : target 파일
		
//		File inputFile = new File("TestFile/cat01.jpg"); //원본 : source 파일
//		File outputFile = new File("TestFile/cat01_copy.jpg"); // 복사본 : target 파일
		
//		File inputFile = new File("src/com/mystudy/io4_filecopy/FileCopy.java"); //원본 : source 파일. 지금 이 파일
//		File outputFile = new File("TestFile/FileCopy_backup.java"); // 복사본 : target 파일
		
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			// 1. 파일을 읽고, 쓰기위한 객체 생성
			fis = new FileInputStream(inputFile);
			fos = new FileOutputStream(outputFile);
			
			System.out.println(">> 파일 복사 시작 -------");
			
			//2. 1byte 읽고, 1byte 쓰기 - read(), write() 반복처리
			while (true) {
				int readValue = fis.read();
				if (readValue == -1) // 다 읽으면 -1 return되기에.
					break;
				fos.write(readValue);
			}
			
			System.out.println(">> 파일 복사 끝 -------");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 3. 사용객체 닫기
			if (fis != null) {
				try {
					if (fos != null)
						fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

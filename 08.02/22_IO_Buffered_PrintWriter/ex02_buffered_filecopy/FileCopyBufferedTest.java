package com.mystudy.ex02_buffered_filecopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyBufferedTest {

	public static void main(String[] args) {
		// BufferedInputStream, BufferedOutputStream 적용
		// 파일복사(binary) : cat01.jpg -> cat01_copy.jpg
		// File --> FileInputStream --> BufferedInputStream
		//--------------------------------------------------------
		
		File inputFile = new File("file/cat01.jpg");
		File outputFile = new File("file/cat01_copy.jpg");
		
		// 파일로 부터 읽고, 쓰기 위한 객체(인스턴스)를 저장하기 위한 변수
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		// 버퍼(buffer) 사용을 위한 변수 선언
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			// 파일 읽고, 쓰기 위한 객체 생성
			fis = new FileInputStream(inputFile);
			fos = new FileOutputStream(outputFile);
			
			System.out.println(">> 파일 복사 시작 (no버퍼)-------------");
			long startTime = System.currentTimeMillis(); // 시간 체크 시작
			// 파일복사 (no 버퍼) : 바이트(byte) 단위로 읽고, 쓰기
			int readValue = fis.read();
			while (readValue != -1) {
				fos.write(readValue); // 쓰고,
				readValue = fis.read(); // 읽고. 
			} 							// 모든 작업이 끝날 때 까지.
			
			long endTime = System.currentTimeMillis(); // 시간 체크 끝
			System.out.println(">> 파일 복사 끝 (no버퍼)-------------");
			System.out.println("startTime : " + startTime);
			System.out.println("endtTime : " + endTime);
			System.out.println("byte 복사 시간: " + (endTime - startTime) + "(ms)");
			
			fis.close();
			fos.close();
			
			System.out.println("==================================");
			// 버퍼 기능이 있는 클래스로 구현. 방법_2
//			bis = new BufferedInputStream(fis);
			bis = new BufferedInputStream(new FileInputStream(inputFile), 1000); // 중간 과정을 재사용할 것이 아니라면, 굳이 변수 선언할 필요가x
//			bos = new BufferedOutputStream(fos);
			bos = new BufferedOutputStream(new FileOutputStream("file/cat02_copy.jpg"), 1000);
			
			System.out.println(">> 파일 복사 시작 (버퍼 on!)-------------");
			startTime = System.currentTimeMillis();
			// 버퍼기능 사용 파일 복사
			readValue = bis.read();
			while (readValue != -1) {
				bos.write(readValue);
				readValue = bis.read();
			}
			endTime = System.currentTimeMillis(); // 시간 체크 끝
			System.out.println(">> 파일 복사 끝 (버퍼 on!)-------------");
			System.out.println("buffer 사용 복사 시간: " + (endTime - startTime) + "(ms)");
			
			bos.close();
			bis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}

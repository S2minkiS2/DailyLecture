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
		// 파일복사(binary) : img102.jpg -> img102_copy.jpg
		// File --> FileInputStream --> BufferedInputStream
		// 최종 BufferedInputStream으로 읽어들인다.
		//--------------------------------------
		
		File inputFile = new File ("file/img102.jpg");
		File outputFile = new File ("file/img102_copy.jpg");
		
		//파일로부터 읽고 쓰기 위한 객체(인스턴스)를 저장하기 위한 변수
		FileInputStream fis = null; //ctrl shift O -> 일괄 import
		FileOutputStream fos = null;
		
		//버퍼(buffer) 사용하기 위한 변수 선언
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			// 파일 읽고, 쓰기 위한 객체 생성
			fis = new FileInputStream(inputFile);
			fos = new FileOutputStream(outputFile);
			
			System.out.println(">> 파일 복사 시작(버퍼없이)--------");
			long startTime = System.currentTimeMillis(); //long타입 데이터 받음.
			//국제 표준시 기준 작업이 이루어진 시간 체크
			
			// 파일복사(버퍼없이) : 바이트(byte) 단위 읽고 쓰기
			int readValue = fis.read();
			while(readValue != -1) {
				fos.write(readValue);
				readValue = fis.read();
			}
			long endTime = System.currentTimeMillis(); //long타입 데이터 받음.
			System.out.println(">> 파일 복사 끝(버퍼없이)--------");
			System.out.println("startTime : " + startTime);
			System.out.println("endTime : " + endTime);
			System.out.println("byte 복사시간 : " + (endTime - startTime) + " (ms)");
			
			fis.close();
			fos.close(); //한 번 사용한 스트림은 재사용 불가
			
			System.out.println("==================");
			// 버퍼 기능 있는 클래스로 구현
//			fis = new FileInputStream(inputFile); //
//			bis = new BufferedInputStream(fis);
			bis = new BufferedInputStream(new FileInputStream(inputFile), 10);
			//, 찍고 나누는 사이즈를 지정할 수 있다. 크게 보낼 수록 속도가 빨라진다.
			bos = new BufferedOutputStream(new FileOutputStream(outputFile), 10);
			//굳이 두번 저장 안하고 괄호 안에서 객체 생성을 해도 된다.
			
			System.out.println(">> 파일 복사 시작(버퍼사용)--------");
			startTime = System.currentTimeMillis();
			//버퍼 기능 사용 파일복사
			readValue = bis.read();
			while(readValue != -1) {
				bos.write(readValue);
				readValue = bis.read();
			}
			endTime = System.currentTimeMillis();
			System.out.println(">> 파일 복사 시작(버퍼사용)--------");
			System.out.println("buffer 복사시간 : " + (endTime - startTime) + " (ms)");

			bos.close();
			bis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}

package com.mystudy.ex03_isr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_Exam {

	public static void main(String[] args) {
		// InputStream ----> Reader
		// byte 처리 계열 --> 문자(Character) 처리 계열 전환
		// InputStreamReader : InputStream --> Reader 전환
		// OutputStreamReader : OutputStream --> Writer 전환 // 잘 안쓰임
		//-----------------------------------------
		File file = new File("file/test_isr.txt");
		
		FileInputStream fis = null;
		
		InputStreamReader isr = null;
		
		BufferedReader br = null; //BufferedReader 는 reader 타입만 받을 수 있다.
		
		try {
			fis = new FileInputStream(file);
			
//			int readValue = fis.read(); // 1byte 읽기
//			System.out.println((char)readValue);
//			
//			readValue = fis.read(); 
//			System.out.println((char)readValue); // 한글 출력 불가
//--------------------------------------------------------------
			//byte단위 처리방식 --> 문자단위 처리방식 전환
			
			isr = new InputStreamReader(fis);
			int readValue = isr.read(); // 1문자 읽기
			System.out.println((char)readValue);
			
			readValue = isr.read();
			System.out.println((char)readValue); // 한글 출력 가능
			
//--------------------------------------------------------------
			// 버퍼기능 사용해서 문자기준으로 라인단위로 읽기 처리
			
			br= new BufferedReader(isr);
			String str = br.readLine(); // 1라인 읽기
			System.out.println(str);
			
			while (true) {
				str = br.readLine(); // EOF 만나면 null 값을 return
				if (str == null) break;
				System.out.println(str);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}

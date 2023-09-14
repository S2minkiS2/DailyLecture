package com.mystudy.ex03.isr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_Exam {

	public static void main(String[] args) {
		// inputStream ---> Reader
		// byte 처리 계열 --> 문자(Character) 처리 계열 전환
		// InputStreamReader : InputStream ---> Reader 전환
		// OutputStreamReader : OutputStream ---> Writer 전환
		
		File file = new File("file/test_isr.txt");
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		
		BufferedReader br = null;
		
		try {
			fis = new FileInputStream(file);
			//전달받은 데이터가 byte로 읽는 InputStream 계열이라서
			//이걸 Reader로 읽는 방식으로 변환해야한다.	
//			int readValue = fis.read(); //1byte 읽기
//			System.out.println((char)readValue);
//
//			readValue = fis.read(); // 1byte 읽기
//			System.out.println((char) readValue); //깨짐
			
			isr = new InputStreamReader(fis); //fis주입
			//byte 단위 처리방식에서 문자단위 처리방식으로 전환
			
			int readValue = isr.read(); //한 문자 읽기
			System.out.println((char)readValue);

			readValue = isr.read(); // 1byte 읽기
			System.out.println((char) readValue);
			
			//버퍼 기능 사용해서 문자 기준으로 라인단위 읽기 처리-----
			br = new BufferedReader(isr);
			//InputStreamReader 처리한 것을 라인 단위로 읽을 수 있다.
			String str = br.readLine(); //한 번 읽음
			System.out.println("br.readLine() : " + str);
			
			while (true) {
				str = br.readLine(); //EOF 만나면 null 리턴
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



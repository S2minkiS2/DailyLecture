package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStream_Ex3 {

	public static void main(String[] args) {
		File file = new File("File/test01.txt");
		
		FileInputStream fis = null;
		
		try {
			//1. 파일을 읽기 위한 객체 생성(File 객체 입력(주입)받음)
			fis = new FileInputStream(file);
			
			
			//2. 객체 사용(파일에서 읽고 화면 출력)
			byte[] bytes = new byte[10];
			System.out.println("bytes : " + Arrays.toString(bytes));
			// read(byte[] b) 메소드 사용
			int readCnt = fis.read(bytes);
			System.out.println("읽은 갯수 : " + readCnt); 
			System.out.println("bytes : " + Arrays.toString(bytes)); //다시 확인하면?
			for (int i = 0; i < readCnt; i++) {
				System.out.println("int : " + bytes[i] + ", char : " + (char)bytes[i]);	 // readCnt가 10이므로 10개만 읽어온다.
			}
			System.out.println("--------------------");
			bytes = new byte[10];
			System.out.println("bytes : " + Arrays.toString(bytes));
			
			
			// 또 사용해보면, readCnt가 달라진걸 볼 수 있다. 최종결산이기 때문에 줄어든다.
			readCnt = fis.read(bytes); // 변경된 사항을 초기화
			System.out.println("읽은 갯수 : " + readCnt);
			System.out.println("bytes : " + Arrays.toString(bytes)); // 다시 확인하면?
			for (int i = 0; i < readCnt; i++) {
				System.out.println("int : " + bytes[i] + ", char : " + (char) bytes[i]);
			}
			System.out.println("--------------------");
			
			// 또 사용해보면, 읽을 데이터가 없어서 readCnt 값이 -1을 return;
			readCnt = fis.read(bytes);
			System.out.println("읽은 갯수 : " + readCnt);
			System.out.println("bytes : " + Arrays.toString(bytes)); // 다시 확인하면?
			for (int i = 0; i < readCnt; i++) {
				System.out.println("int : " + bytes[i] + ", char : " + (char) bytes[i]); 
			}
			System.out.println("--------------------");
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 사용객체 닫기 (close)
			
		}
		
		
		
	}

}

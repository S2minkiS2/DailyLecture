package com.mystudy.reader_writer_filecopy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy_2 {

	public static void main(String[] args) {
		System.out.println("메서드 시작");
		
		// 1-1 FileReader, FileWriter 객체를 저장할 변수 선언
		File file = new File("file/test_char.txt"); //파일 객체 생성, 꼭 소괄호 안에 값을 줘야함. 
		//파일이 있는지 없는지 미리 체크하겠다. 파일사이즈도 확인하겠다.
		
		FileReader fr = null;
		FileWriter fw = null;
		
		try { //1-2. FileReader, FileWriter 객체 생성
			fr = new FileReader(file); //생성한 file객체 읽어오는 객체 생성
			fw = new FileWriter("file/test_char_copy2"); 
			
			//2. 객체 사용 및 반복작업!			
			while(true) { //while(readChar != -1)
				int readChar = fr.read();
				if (readChar == -1) break; //-1이 아닐 때만 반복
				fw.write(readChar);
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { // IOException 으로 한번에 처리 가능
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("메서드 끝");
	}

}

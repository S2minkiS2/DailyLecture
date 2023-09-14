package com.mystudy.reader_writer_filecopy;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyCharacterExam {

	public static void main(String[] args) {
		//FileReader, FileWriter 사용해서 파일복사
		//원본파일 : file/test_char.txt
		//대상파일 : file/test_char_copy.txt
		// 처리 : 원본파일에세ㅓ 읽고, 대상파일에 쓰기/저장(문자단위 처리)
		
		//0. 사용할 파일(File) 객체를 생성
		//1.  FileReader, FileWriter 객체를 생성
		// 변수선언 - trycatch
		//2. 반복작업 (원본파일에서 읽고 - 대상파일에 쓰기) 작업 반복
		//3. 사용객체 닫기 (close)
		
		System.out.println("-------main 시작 -------");
		
		FileWriter fw = null;
		FileReader fr = null;
		File file = new File("file/test_char.txt");
		
		try { //1.객체 생성 (read, write)
			fr = new FileReader(file);
			fw = new FileWriter("file/test_char_copy.txt");
			
			//2. 객체 사용 (입력, 출력)
			while(true) {
				int readChar = fr.read();
				if (readChar == -1) break; 
				//-1이면 더이상 읽어올 값이 없으므로.
				fw.write(readChar); 
				//읽어온 파일을 readChar에 저장, 
				//readChar을 쓴다.
				// write으로 바로 복사하기 때문에 변수에 넣을 필요가 없다.
				//write의 리턴타입은 void다.
//				fw.flush(); //버퍼에 있는 데이터 강제 출력 처리
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("------main() 끝------");
		
	}

}

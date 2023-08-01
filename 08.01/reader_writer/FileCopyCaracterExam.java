package com.mystudy.reader_writer_filecopy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyCaracterExam {

	public static void main(String[] args) {
		// FileReader, FileWriter 사용해서 파일 복사
		// 원본파일 : file/test_char.txt
		// 출력파일 : file/test_char_copy.txt
		// 처리 : 원본파일에서 읽고, 대상파일에 쓰기/저장 (문자단위 처리)
		//------------------------------------------------
		
		//0. 사용할 파일 객체 생성
		File inputFile = new File("file/test_char.txt");
		File outputFile = new File("file/test_char_copy.txt");
		
		//1. FileReader, fileWirter 객체를 생성
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(inputFile);
			fw = new FileWriter(outputFile);
			
			while (true) {
				int readValue = fr.read();
				fw.write(readValue);
				fw.flush();
				if (readValue == -1) break;
				System.out.print((char)readValue);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}

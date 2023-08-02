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
		
		//0. File 타입의 객체를 생성
		File inputFile = new File("file/test_char.txt");
		File outputFile = new File("file/test_char_copy.txt");
		
		//1. FileReader, fileWirter 객체를 저장할 변수 선언
		FileReader fr = null;
		FileWriter fw = null;
		try {
			//1. FileReader, fileWirter 객체를 생성
			fr = new FileReader(inputFile);
			fw = new FileWriter(outputFile);
			
			while (true) {
				int readValue = fr.read();
				fw.write(readValue);
				if (readValue == -1) break;
				System.out.print((char)readValue);
			}
			fw.flush(); // 버퍼에 담겨있는 데이터를 강제 출력 처리
			
			/*
			while (true) {
				fw.write(fr.read());
				fw.flush();
				if (fr.read() == -1) break;
				System.out.print((char)fr.read());
			}
			*/  //얘는 왜 안될까?
			
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println(">>[예외] 파일없음");
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println(">>[예외] 파일을 읽지 못함");
		} finally {
			
			try {
				if (fw != null) fw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if (fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

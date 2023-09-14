package com.mystudy.ex01_buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterExam {

	public static void main(String[] args) {
		// 버퍼(buffer) 기능이 구현되어 있는 클래스
		// 버퍼 : 데이터를 저장하는 공간 (메모리상에)
		// BufferedReader, BufferedReader
		// File --> FileReader --> BufferedReader
		// File객체 생성 후 FileReader에 생성자 통해 주입
		// FileReader를 써서 파일에서 읽어들인 후 BufferedReader에 주입
		// 둘 다 Reader라는 추상클래스를 상속확장한 메서드
		// readline()을 쓰면 하나하나가 아니라 한줄씩 읽어서 문자열 리턴
		//------------------------------------------
		System.out.println("---- main() 시작 -----");
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		//파일로부터 읽기 위한 객체 생성
		try { //try구문 안쪽에 넣어둔다
			File inFile = new File("file/test_buf_rw_in.txt");// file객체 저장
			//파일로부터 읽기 위한 객체(인스턴스) 생성
			fr = new FileReader(inFile);
			bufferedReader = new BufferedReader(fr); //버퍼기능 + 파일읽기 기능
			
			//파일에 쓰기위한 객체 생성
			File outFile = new File("file/test_buf_rw_out.txt");
			fw = new FileWriter(outFile);
			bufferedWriter = new BufferedWriter(fw); //버퍼기능 +파일쓰기 기능
			//파일로부터 읽고, 파일에 쓰기 (버퍼기능 이용)
			// 파일에서 읽기(한번 읽기)
			
			
			bufferedWriter.write("안녕하세요. 자바공부중입니다.");
			
			bufferedWriter.write("\nHello Java!!!");
			//print문과 같이 옆으로 출력됨
			bufferedWriter.newLine(); //줄바꿈 메서드!
			bufferedWriter.write("재미있나요???");
			bufferedWriter.newLine();
			bufferedWriter.write("----------------");
			bufferedWriter.newLine();
			
			String str = bufferedReader.readLine(); //줄단위 읽기
			System.out.println("readLine() 읽은 값 : " + str); //첫번째줄 읽어옴
			
			//파일에 한 번 쓰기
			bufferedWriter.write(str); //리더로 복사해온 값 str 출력
			bufferedWriter.newLine(); // 줄바꿈
			
			//남은 데이터 모두 읽고 쓰기
			str = bufferedReader.readLine(); 
			while (str != null) { //EOF : null 리턴. int가 -1을 리턴하듯. 없다는 소리!
				bufferedWriter.write(str); //문자열출력
				str = bufferedReader.readLine();
				if (str != null) {
				bufferedWriter.newLine(); //줄바꿈처리
				}	
			}
			
//			bufferedWriter.flush(); //강제로 출력
			//buffer는 flash 혹은 close를 해줘야한다.
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) bufferedReader.close();
			} catch (IOException e) {}
			try {
				if (bufferedWriter != null) bufferedWriter.close();
			} catch (IOException e) {}
		}
		
		System.out.println("---- main() 끝 -----");
		
		
	}

}
